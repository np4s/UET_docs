(SELECT c.*,
((SELECT SUM(od.quantityOrdered*od.priceEach)
FROM orderdetails od
WHERE od.orderNumber IN (SELECT orderNumber FROM orders WHERE customerNumber = c.customerNumber))
-
(SELECT SUM(amount)
FROM payments
WHERE customerNumber = c.customerNumber)) totalDebt,
"largest debt" note
FROM customers c
ORDER BY totalDebt DESC
LIMIT 1)

UNION

(SELECT c.*,
((SELECT SUM(od.quantityOrdered*od.priceEach)
FROM orderdetails od
WHERE od.orderNumber IN (SELECT orderNumber FROM orders WHERE customerNumber = c.customerNumber))
-
(SELECT SUM(amount)
FROM payments
WHERE customerNumber = c.customerNumber)) totalDebt,
"smallest debt" note
FROM customers c
HAVING totalDebt > 0
ORDER BY totalDebt ASC
LIMIT 1);