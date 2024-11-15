WITH RECURSIVE ECOLI_DATA_HIERARCHY AS (
    SELECT ID, PARENT_ID, 1 AS GENERATION
    FROM  ECOLI_DATA
    WHERE PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT ED.ID, ED.PARENT_ID, EDH.GENERATION + 1
    FROM ECOLI_DATA AS ED
    INNER JOIN ECOLI_DATA_HIERARCHY EDH ON EDH.ID = ED.PARENT_ID
)

SELECT COUNT(*) AS COUNT, GENERATION AS GENERATION
FROM ECOLI_DATA_HIERARCHY AS EDH
LEFT OUTER JOIN ECOLI_DATA ED
ON EDH.ID = ED.PARENT_ID
WHERE ED.ID IS NULL
GROUP BY GENERATION
ORDER BY GENERATION ASC
;