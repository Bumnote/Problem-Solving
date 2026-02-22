select animal_id, name, case when sex_upon_intake like "%Neutered%" then "O"
                            when sex_upon_intake like "%Spayed%" then "O"
                            else "X"
                        end as "sex_upon_intake"
from ANIMAL_INS
order by animal_id;