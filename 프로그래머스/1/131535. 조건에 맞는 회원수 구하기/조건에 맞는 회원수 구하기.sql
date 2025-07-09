select count(*)
from (
    select age, joined
    from user_info
    where age between 20 and 29
        and joined between date '2021-01-01' and date '2021-12-31'
)