select ai.animal_id, ai.name
from ANIMAL_INS ai
join ANIMAL_OUTS ao on ai.animal_id = ao.animal_id 
order by datediff(ao.datetime, ai.datetime) desc
limit 2;