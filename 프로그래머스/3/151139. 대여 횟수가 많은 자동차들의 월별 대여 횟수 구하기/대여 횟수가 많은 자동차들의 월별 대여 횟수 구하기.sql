-- 코드를 입력하세요
SELECT MONTH(START_DATE) as MONTH, CAR_ID, COUNT(HISTORY_ID) as RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE >= '2022-08-01' and START_DATE < '2022-11-01'
and CAR_ID in (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE >= '2022-08-01' and START_DATE < '2022-11-01'
    GROUP BY CAR_ID
    HAVING COUNT(HISTORY_ID) > 4
)
GROUP BY MONTH, CAR_ID
HAVING COUNT(HISTORY_ID) > 0
ORDER BY MONTH, CAR_ID desc