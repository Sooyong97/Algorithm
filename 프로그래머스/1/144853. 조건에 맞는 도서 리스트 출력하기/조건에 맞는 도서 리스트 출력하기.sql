SELECT book_id, TO_CHAR(published_date, 'YYYY-MM-DD') AS published_date
  FROM book
 WHERE category = '인문'
   AND published_date BETWEEN DATE '2021-01-01' AND DATE '2022-01-01' - 1/86400
 ORDER BY published_date;