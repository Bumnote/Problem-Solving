with max_size_data as (
    select year(DIFFERENTIATION_DATE) as "year", max(size_of_colony) as "max_size"
    from ecoli_data 
    group by year(DIFFERENTIATION_DATE)
)

select msd.year as "year", abs(msd.max_size - ed.size_of_colony) as "year_dev", ed.id as "id"
from ecoli_data ed join max_size_data msd on year(ed.DIFFERENTIATION_DATE) = msd.year
order by msd.year, abs(msd.max_size - ed.size_of_colony);