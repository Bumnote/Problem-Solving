select b.book_id as 'BOOK_ID', a.author_name as 'AUTHOR_NAME', date_format(b.published_date, "%Y-%m-%d") as 'PUBLISHED_DATE'
from book b inner join author a on b.author_id = a.author_id
where b.category like '경제' 
order by PUBLISHED_DATE






































# SELECT B.BOOK_ID, A.AUTHOR_NAME, DATE_FORMAT(B.PUBLISHED_DATE, '%Y-%m-%d') AS 'PUBLISHED_DATE'
# FROM BOOK B JOIN AUTHOR A ON B.AUTHOR_ID = A.AUTHOR_ID
# WHERE B.CATEGORY = '경제' 
# ORDER BY B.PUBLISHED_DATE;