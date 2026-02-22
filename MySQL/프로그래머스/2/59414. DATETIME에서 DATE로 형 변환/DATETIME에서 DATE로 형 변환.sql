select animal_id, name, date_format(datetime, "%Y-%m-%d") as "날짜"
from ANIMAL_INS
order by animal_id;