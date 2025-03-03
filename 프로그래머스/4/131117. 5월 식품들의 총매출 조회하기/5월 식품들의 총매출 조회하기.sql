SELECT o.PRODUCT_ID, p.PRODUCT_NAME, SUM(o.AMOUNT * p.PRICE) AS TOTAL_SALES
FROM FOOD_PRODUCT AS p
JOIN FOOD_ORDER AS o
ON p.PRODUCT_ID = o.PRODUCT_ID
WHERE DATE_FORMAT(PRODUCE_DATE, "%Y-%m") LIKE '%2022-05%'
GROUP BY o.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, o.PRODUCT_ID ASC
;