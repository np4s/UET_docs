SELECT od.productCode, SUM(quantityOrdered) quantitySendBackToStock
FROM orderdetails od
WHERE od.orderNumber IN (SELECT orderNumber FROM orders WHERE status = "Cancelled")
GROUP BY od.productCode
ORDER BY od.productCode;