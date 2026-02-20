select distinct(cc.car_id) as "car_id"
from CAR_RENTAL_COMPANY_CAR cc join CAR_RENTAL_COMPANY_RENTAL_HISTORY ch on cc.car_id = ch.car_id
where cc.car_type like "세단" and month(ch.start_date) = 10
order by cc.car_id desc