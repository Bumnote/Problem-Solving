with cc as (
    select ccc.car_id as "car_id", ccc.car_type as "car_type", ccc.daily_fee as "daily_fee",
            case 
                when (datediff(end_date, start_date) + 1) >= 90 then "90일 이상"
                when (datediff(end_date, start_date) + 1) >= 30 then "30일 이상"
                when (datediff(end_date, start_date) + 1) >= 7 then "7일 이상"
                else null
            end as "duration_type", rh.history_id as "history_id",
            rh.start_date as "start_date", rh.end_date as "end_date"
    from CAR_RENTAL_COMPANY_CAR ccc
    join CAR_RENTAL_COMPANY_RENTAL_HISTORY rh 
    on ccc.car_id = rh.car_id
    where ccc.car_type = "트럭"
)

select cc.history_id as "history_id", 
    case 
        when cc.duration_type is not null 
            then truncate(cc.daily_fee * (datediff(cc.end_date, cc.start_date) + 1) * (1 - (dp.discount_rate / 100)), 0)
        else truncate(cc.daily_fee * (datediff(cc.end_date, cc.start_date) + 1), 0)
    end as "fee"
from cc 
left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN dp 
on cc.duration_type = dp.duration_type and cc.car_type = dp.car_type
order by fee desc, history_id desc;
