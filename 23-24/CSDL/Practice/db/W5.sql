SELECT 
    SUBSTRING(productDescription, 1, 50) AS 'Title of products'
FROM
    products;
    
-- SELECT
-- 	LEFT(productDescription, 50) AS "Title of products"
-- FROM 
-- 	products;

SELECT concat(firstName, ' ', lastName, ', ', jobTitle) as 'Employee description'
FROM employees;

SELECT 
    *, DATEDIFF(requiredDate, shippedDate) AS Days
FROM
    orders
ORDER BY
	Days DESC
LIMIT 5;


-- SELECT 
--     *
-- FROM
--     orders
-- WHERE
--     orderDate BETWEEN '2005-05-01' AND '2005-05-31'
--         AND shippedDate IS NULL;

SELECT 
    *
FROM
    orders
WHERE
    EXTRACT(YEAR FROM orderDATE) = 2005
        AND EXTRACT(MONTH FROM orderDATE) = 5
        AND shippedDate IS NULL;
        
-- SELECT 
--     *
-- FROM
--     orders
-- WHERE
-- 	orderDate BETWEEN '2005-05-01' AND ADDDATE('2005-05-01', INTERVAL 30 DAY) AND shippedDate IS NULL;