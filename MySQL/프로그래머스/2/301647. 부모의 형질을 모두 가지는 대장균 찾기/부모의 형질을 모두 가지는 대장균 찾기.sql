with ecoli as (
    select a.id as 'ID', a.genotype as 'GENOTYPE', b.genotype as 'PARENT_GENOTYPE'
    from ecoli_data a, ecoli_data b
    where a.parent_id = b.id
)

select *
from ecoli e 
where (e.GENOTYPE & e.PARENT_GENOTYPE) >= e.PARENT_GENOTYPE
order by e.ID