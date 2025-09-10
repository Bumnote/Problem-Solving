select d.id as 'ID', d.email as 'EMAIL', d.first_name as 'FIRST_NAME', d.last_name as 'LAST_NAME'
from skillcodes s, developers d
where s.code & d.skill_code != 0 and s.name in ('Python', 'C#')
group by d.id, d.email, d.first_name, d.last_name
order by d.id;