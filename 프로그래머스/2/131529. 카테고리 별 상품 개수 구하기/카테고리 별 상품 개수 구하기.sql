-- 코드를 입력하세요
SELECT LEFT(PRODUCT_CODE, 2) as CATEGORY, COUNT(PRODUCT_ID) as PRODUCTS
FROM PRODUCT
GROUP BY CATEGORY