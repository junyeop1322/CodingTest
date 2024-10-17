SELECT MCDP_CD AS '진료과코드', COUNT(APNT_YMD) AS '5월예약건수'
FROM APPOINTMENT
WHERE DATE_FORMAT(APNT_YMD, "%m") LIKE "05"
GROUP BY MCDP_CD
ORDER BY COUNT(APNT_YMD), MCDP_CD
;