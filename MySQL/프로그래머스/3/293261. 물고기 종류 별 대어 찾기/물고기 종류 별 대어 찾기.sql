select fi.id as "id", fni.fish_name as "fish_name", fi.length as "length"
from fish_info fi join fish_name_info fni on fi.fish_type = fni.fish_type 
where (fi.fish_type, fi.length) in (select fi.fish_type as "fish_type", max(fi.length) as "length"
                                    from fish_info fi join fish_name_info fni on fi.fish_type = fni.fish_type
                                    group by fi.fish_type)