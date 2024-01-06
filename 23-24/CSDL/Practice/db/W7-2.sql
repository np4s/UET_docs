select e.employeeNumber, e.firstName, o.*
from employees e inner JOIN offices o
On e.officeCode = o.officeCode;

SELECT p.*
from products p LEFT JOIN orderdetails od
on p.productCode = od.productCode
WHERE od.orderNumber is NULL;

SELECT o.*, SUM(od.priceEach * od.quantityOrdered) totalAmount
FROM orders o INNER JOIN orderdetails od
ON o.orderNumber = od.orderNumber
WHERE MONTH(o.orderDate) = 3 AND YEAR(o.orderDate) = 2003
GROUP BY od.orderNumber;

SELECT o.*, SUM(od.priceEach * od.quantityOrdered) totalAmount
FROM orders o, orderdetails od
WHERE o.orderNumber = od.orderNumber AND MONTH(o.orderDate) = 3 AND YEAR(o.orderDate) = 2003
GROUP BY od.orderNumber;

SELECT pl.*, COUNT(*) totalNumber
FROM productlines pl INNER JOIN products p
ON pl.productLine = p.productLine
GROUP by pl.productLine
ORDER BY totalNumber DESC;

SELECT c.customerName, SUM(p.amount) as totalAmount
FROM customers c INNER JOIN payments p
ON c.customerNumber = p.customerNumber
GROUP BY c.customerNumber;

