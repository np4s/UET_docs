SELECT e.employeeNumber, e.lastName, e.firstName, e.extension, e.email, e.reportsTo, e.jobTitle, o.*
FROM employees e INNER JOIN offices o
ON e.officeCode = o.officeCode;

SELECT * 
FROM products p LEFT JOIN orderdetails od
ON p.productCode = od.productCode
WHERE od.orderNumber IS NULL;

SELECT orders.orderNumber, orderDate, requiredDate, shippedDate, status, totalValue
FROM orders INNER JOIN (SELECT orderNumber, SUM(priceEach*quantityOrdered) as totalValue
						FROM orderdetails
                        GROUP BY orderNumber) tmp1
ON orders.orderNumber = tmp1.orderNumber
WHERE month(orderDate) = '03';

SELECT o.orderNumber, o.orderDate, o.requiredDate, o.shippedDate, o.status, SUM(od.priceEach*od.quantityOrdered) totalValue
FROM orders o, orderdetails od
WHERE o.orderNumber = od.orderNumber AND month(o.orderDate) = 3
GROUP BY od.orderNumber;

SELECT productLine, textDescription, htmlDescription, image, num
FROM productlines NATURAL JOIN 
(SELECT productLine, COUNT(*) as num
FROM products
GROUP BY productLine) tmp1
ORDER BY num DESC;

SELECT customerName, SUM(sum_each) as total
FROM customers INNER JOIN
(SELECT orderNumber, customerNumber, sum_each
FROM orders NATURAL JOIN
(SELECT orderNumber, SUM(priceEach*quantityOrdered) as sum_each
FROM orderdetails
GROUP BY orderNumber) tmp1) tmp2
ON customers.customerNumber = tmp2.customerNumber
GROUP BY customers.customerNumber;