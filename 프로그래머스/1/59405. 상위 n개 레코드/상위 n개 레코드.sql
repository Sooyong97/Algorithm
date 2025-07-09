select name
from (
    select name, datetime
    from animal_ins
    order by datetime
)
where rownum <= 1