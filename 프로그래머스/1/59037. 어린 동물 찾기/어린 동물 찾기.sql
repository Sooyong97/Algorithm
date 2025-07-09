SELECT animal_id, name
FROM ANIMAL_INS
WHERE not intake_condition = 'Aged'
order by animal_id