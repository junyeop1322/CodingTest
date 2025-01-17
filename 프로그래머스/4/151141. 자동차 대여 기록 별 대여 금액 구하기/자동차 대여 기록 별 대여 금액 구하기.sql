SELECT  D.HISTORY_ID
        , ROUND(IF(D.DISCOUNT_RATE IS NULL, D.DAILY_FEE * D.DATE_DIFF, D.DAILY_FEE * D.DATE_DIFF * (100-D.DISCOUNT_RATE)*0.01),0) AS FEE
  FROM  (
        SELECT  A.*
                , B.HISTORY_ID
                , DATEDIFF(B.END_DATE,B.START_DATE) + 1 AS DATE_DIFF
                , C.DISCOUNT_RATE
          FROM  CAR_RENTAL_COMPANY_CAR A
          LEFT
          JOIN  CAR_RENTAL_COMPANY_RENTAL_HISTORY B
            ON  A.CAR_ID = B.CAR_ID
          LEFT
          JOIN  CAR_RENTAL_COMPANY_DISCOUNT_PLAN C
            ON  CASE WHEN DATEDIFF(B.END_DATE,B.START_DATE) BETWEEN 7 AND 29 THEN C.PLAN_ID = 10
                     WHEN DATEDIFF(B.END_DATE,B.START_DATE) BETWEEN 30 AND 89 THEN C.PLAN_ID = 11
                     WHEN DATEDIFF(B.END_DATE,B.START_DATE) >= 90 THEN C.PLAN_ID = 12 END
         WHERE  A.CAR_TYPE = '트럭'
         ) D 
 ORDER
    BY   FEE DESC 
         , HISTORY_ID DESC