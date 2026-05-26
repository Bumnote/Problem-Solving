select d.id as 'ID', d.email as 'EMAIL', d.first_name as 'FIRST_NAME', d.last_name as 'LAST_NAME'
from developers d join skillcodes s on d.skill_code & s.code != 0 
where category Like 'Front End'
group by d.id, d.email, d.first_name, d.last_name
order by d.id