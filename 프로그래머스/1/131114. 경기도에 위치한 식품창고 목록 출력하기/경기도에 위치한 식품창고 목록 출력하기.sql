select warehouse_id, warehouse_name, address, freezer
from (
    select warehouse_id, warehouse_name, address, nvl(freezer_yn, 'N') as freezer
    from food_warehouse
    where address like '경기도%'
    order by warehouse_id
)