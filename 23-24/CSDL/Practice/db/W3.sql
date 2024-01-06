SELECT 
    *
FROM
    employees
WHERE
    reportsTo IS NULL;

SELECT DISTINCT
    customerNumber
FROM
    orders;

SELECT 
    *
FROM
    orders
WHERE
    shippedDate = '2003/01/18';

SELECT 
    *
FROM
    orders
WHERE
    orderDate >= '2005/04/01'
        AND orderDate < '2005/05/01'
        AND status = 'Shipped';

-- SELECT * FROM orders
-- WHERE orderDate BETWEEN '2005-04-01' and '2005-04-30' AND status = 'Shipped';

SELECT 
    *
FROM
    products
WHERE
    productLine = 'Classic Cars';

-- SELECT * FROM payments;
-- SELECT customerNumber, SUM(amount) AS amount
-- FROM payments
-- GROUP BY customerNumber;
