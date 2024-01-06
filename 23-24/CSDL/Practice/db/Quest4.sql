SELECT c.customerName,
	(SELECT SUM(quantityOrdered*priceEach)
    FROM orderdetails
    WHERE orderNumber IN (SELECT orderNumber
						FROM orders
                        WHERE customerNumber = c.customerNumber)) totalPurchased,
	(SELECT SUM(amount)
    FROM payments
    WHERE customerNumber = c.customerNumber) totalPaid,
    (SELECT totalPurchased - totalPaid) currentDebt, 
	(SELECT SUM(quantityOrdered*priceEach)
    FROM orderdetails
    WHERE orderNumber IN (SELECT orderNumber
						FROM orders
                        WHERE customerNumber = c.customerNumber AND status = 'Cancelled')) totalCancelled,
	(SELECT (currentDebt - IF (totalCancelled IS NULL, 0, totalCancelled))) actualDebt
FROM customers c;