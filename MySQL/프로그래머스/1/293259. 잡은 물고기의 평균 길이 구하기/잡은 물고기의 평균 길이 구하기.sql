with fish_length as (
    select case 
            when length is not null then length
            when length <= 10 or length is null then 10
           end as 'length'
    from fish_info 
)

select round(avg(l.length), 2) as 'AVERAGE_LENGTH'
from fish_length l  