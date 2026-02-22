select substr(product_code, 1, 2) as "category", count(*) as "products"
from PRODUCT
group by substr(product_code, 1, 2)
order by substr(product_code, 1, 2);