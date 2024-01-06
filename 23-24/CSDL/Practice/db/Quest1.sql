SELECT c.customerName,
	(SELECT datediff('2005-06-02', max(orderDate))
    FROM orders
    WHERE customerNumber = c.customerNumber) Recency,
    (SELECT COUNT(*)
    FROM orders
    WHERE customerNumber = c.customerNumber) Frequency,
	(SELECT SUM(quantityOrdered*priceEach)
    FROM orderdetails
    WHERE orderNumber IN (SELECT orderNumber
						FROM orders
                        WHERE customerNumber = c.customerNumber)) Monetary
FROM customers c
HAVING (Recency <= 5 AND Frequency >= 5) OR Monetary >= 500000;