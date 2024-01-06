SELECT c.customerName, c.customerNumber,

(SELECT SUM(od.quantityOrdered * od.priceEach)
FROM orderdetails od
INNER JOIN orders o ON od.orderNumber = o.orderNumber
WHERE c.customerNumber = o.customerNumber
GROUP BY o.customerNumber) AS totalBuy,

(SELECT SUM(p.amount)
FROM payments p
WHERE p.customerNumber = c.customerNumber
GROUP BY p.customerNumber) AS totalPay,

(SELECT SUM(od.quantityOrdered * od.priceEach)
FROM orderdetails od
INNER JOIN orders o ON od.orderNumber = o.orderNumber
WHERE c.customerNumber = o.customerNumber AND o.status = 'Cancelled'
GROUP BY o.customerNumber) AS totalCancelled,

(SELECT (totalBuy - totalPay - IF(totalCancelled IS NULL, 0, totalCancelled))) AS totalDebt,
(SELECT IF(totalDebt = 0, 'Mistake', 0)) AS Note
FROM customers c;