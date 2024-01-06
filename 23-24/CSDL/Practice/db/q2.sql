SELECT c.customerName,
(SELECT SUM(od.quantityOrdered*od.priceEach)
FROM orderdetails od
WHERE od.orderNumber IN (SELECT orderNumber FROM orders WHERE customerNumber = c.customerNumber)) purchasedMoney,
(SELECT SUM(amount)
FROM payments
WHERE customerNumber = c.customerNumber) paidMoney,
(SELECT SUM(od.quantityOrdered*od.priceEach)
FROM orderdetails od
WHERE od.orderNumber IN (SELECT orderNumber FROM orders WHERE customerNumber = c.customerNumber AND status = "Cancelled")) cancelledMoney,
(SELECT purchasedMoney - paidMoney) debt,
IF((SELECT cancelledMoney = debt), "Mistake", "") note
FROM customers c;