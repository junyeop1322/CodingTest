-- 코드를 입력하세요
SELECT b.ANIMAL_ID, b.NAME
from ANIMAL_INS as a
right join ANIMAL_OUTS as b
on a.ANIMAL_ID = b.ANIMAL_ID
where a.ANIMAL_ID is null;