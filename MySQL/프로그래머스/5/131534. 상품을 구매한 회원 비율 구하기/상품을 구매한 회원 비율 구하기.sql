with new_user_info as (
    select *
    from user_info 
    where joined like "2021-%"
)

select year(os.sales_date) as "YEAR", month(os.sales_date) as "MONTH", count(distinct(os.user_id)) as "PURCHASED_USERS", 
    round(count(distinct(os.user_id)) / (select count(*) from new_user_info), 1) as "PUCHASED_RATIO"
from new_user_info nui join online_sale os on nui.user_id = os.user_id
where os.online_sale_id is not null
group by year(os.sales_date), month(os.sales_date)
order by year(os.sales_date), month(os.sales_date);