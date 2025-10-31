with recursive parent as (
    select id, parent_id, 1 depth
    from ecoli_data
    where parent_id is null

    union all 

    select e.id, e.parent_id, p.depth + 1 depth
    from parent p, ecoli_data e
    where p.id = e.parent_id and p.id is not null
)   

select count(*) as 'COUNT', p.depth as 'GENERATION'
from parent p left join parent c on p.id = c.parent_id
where c.id is null
group by p.depth 