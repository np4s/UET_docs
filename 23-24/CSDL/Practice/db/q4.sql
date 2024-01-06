SELECT od.productCode, SUM(od.quantityOrdered)
FROM orderdetails od
WHERE od.orderNumber IN (SELECT o.orderNumber FROM `orders` o WHERE o.status = 'Cancelled')
GROUP BY od.productCode ORDER BY od.productCode ASC;