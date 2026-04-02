select count(*) as 'fish_count', max(case 
                                     when length <= 10 or length is null then 10 
                                        else length 
                                     end) as 'max_length', max(fish_type) as 'fish_type'
from fish_info 
group by fish_type
having avg(case 
            when length <= 10 or length is null then 10
            else length 
           end) >= 33
order by fish_type asc;