-- 코드를 입력하세요
SELECT a.ANIMAL_ID, a.NAME
FROM ANIMAL_INS as a
JOIN ANIMAL_OUTS as b
on a.ANIMAL_ID = b.ANIMAL_ID
WHERE a.ANIMAL_ID = b.ANIMAL_ID and a.DATETIME >= b.DATETIME
ORDER BY a.DATETIME;