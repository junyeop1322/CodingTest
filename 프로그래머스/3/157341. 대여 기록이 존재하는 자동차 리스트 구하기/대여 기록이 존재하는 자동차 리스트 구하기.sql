-- 코드를 입력하세요
SELECT distinct a.CAR_ID
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY as a
join CAR_RENTAL_COMPANY_CAR as b
on a.CAR_ID = b.CAR_ID
WHERE a.START_DATE like "_____10%" and b.CAR_TYPE = "세단"
ORDER BY a.CAR_ID desc
