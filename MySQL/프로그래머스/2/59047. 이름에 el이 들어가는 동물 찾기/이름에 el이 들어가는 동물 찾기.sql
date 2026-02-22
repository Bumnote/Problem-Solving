select animal_id, name
from ANIMAL_INS
where lower(name) like "%el%" and animal_type = "Dog"
order by name;