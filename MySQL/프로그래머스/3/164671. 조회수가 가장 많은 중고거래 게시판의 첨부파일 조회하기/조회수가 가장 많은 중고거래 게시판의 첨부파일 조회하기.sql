select concat("/home/grep/src/", ugf.board_id, "/", ugf.file_id, ugf.file_name, ugf.file_ext) as "file_path"
from used_goods_file ugf 
join (select * from used_goods_board order by views desc limit 1) ugb 
    on ugf.board_id = ugb.board_id
order by ugf.file_id desc