SELECT COUNT(i.FISH_TYPE) AS FISH_COUNT, n.FISH_NAME
FROM FISH_INFO AS i
JOIN FISH_NAME_INFO AS n
ON i.FISH_TYPE = n.FISH_TYPE
GROUP BY n.FISH_NAME
ORDER BY COUNT(i.FISH_TYPE) DESC
;