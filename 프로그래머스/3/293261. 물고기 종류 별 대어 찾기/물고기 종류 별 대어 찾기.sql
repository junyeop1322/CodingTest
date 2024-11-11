SELECT i.ID, n.FISH_NAME, i.LENGTH
FROM FISH_INFO AS i
JOIN FISH_NAME_INFO AS n
ON i.FISH_TYPE = n.FISH_TYPE
WHERE i.FISH_TYPE IN (
    SELECT FISH_TYPE
    FROM FISH_INFO
    GROUP BY FISH_TYPE
    HAVING LENGTH = MAX(LENGTH)
)
ORDER BY i.ID
;