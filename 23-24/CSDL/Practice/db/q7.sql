SELECT *,
(SELECT SUM(quantityOrdered)
FROM orderdetails
WHERE productCode IN (SELECT productCode FROM products WHERE productLine = pl.productLine)
AND orderNumber IN (SELECT orderNumber FROM orders WHERE status = "Cancelled")) cancelledQuantity
FROM productlines pl
ORDER BY cancelledQuantity DESC
LIMIT 3;
