select ii.item_id as 'item_id', ii.item_name as 'item_name', ii.rarity as 'rarity'
from ITEM_INFO ii left join ITEM_TREE it on ii.item_id = it.parent_item_id
where it.item_id is null
order by ii.item_id desc;