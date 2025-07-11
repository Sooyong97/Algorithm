SELECT
    b.title,
    b.board_id,
    r.reply_id,
    r.writer_id,
    r.contents,
    TO_CHAR(r.created_date, 'YYYY-MM-DD') AS created_date 
FROM 
    used_goods_board b
INNER JOIN
    used_goods_reply r
ON
    b.board_id = r.board_id
WHERE
    TO_CHAR(b.created_date, 'YYYY-MM-DD') LIKE '2022-10%'
ORDER BY
    r.created_date,
    b.title ASC