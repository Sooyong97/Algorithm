SELECT f.flavor
  FROM first_half F
  JOIN icecream_info I
    ON F.flavor = I.flavor
   AND f.total_order > 3000
 WHERE I.ingredient_type = 'fruit_based'
 ORDER BY F.total_order desc;