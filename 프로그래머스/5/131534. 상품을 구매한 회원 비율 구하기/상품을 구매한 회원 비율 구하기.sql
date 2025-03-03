SELECT YEAR(o.SALES_DATE) AS YEAR, MONTH(o.SALES_DATE) AS MONTH, COUNT(DISTINCT u.USER_ID) AS PURCHASED_USERS, 
ROUND(COUNT(DISTINCT u.USER_ID)/(
    SELECT COUNT(*)
    FROM USER_INFO
    WHERE YEAR(JOINED) = 2021
), 1) AS PUCHASED_RATIO
FROM USER_INFO AS u
JOIN ONLINE_SALE AS o
ON u.USER_ID = o.USER_ID
WHERE YEAR(u.JOINED) = 2021
GROUP BY YEAR, MONTH
ORDER BY YEAR, MONTH
;