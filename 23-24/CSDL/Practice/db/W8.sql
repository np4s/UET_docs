-- Q1
SELECT DISTINCT p.productName
FROM products p, orders o, orderdetails od
WHERE p.productCode = od.productCode AND o.orderNumber = od.orderNumber AND month(o.orderDate) = 3 AND year(o.orderDate) = 2005;

SELECT productName
FROM products
WHERE productCode IN (SELECT productCode FROM orderdetails WHERE orderNumber IN (SELECT orderNumber FROM orders WHERE year(orderDate) = 2005 AND month(orderDate) = 3));

-- Q2
SELECT o.*
FROM orders o
WHERE year(o.orderDate) = (SELECT year(max(orderDate)) FROM orders) AND month(o.orderDate) = (SELECT month(max(orderDate)) FROM orders);

-- Q3
SELECT o.*, SUM(od.priceEach*od.quantityOrdered) as totalValue
FROM orders o, orderdetails od
WHERE o.orderNumber = od.orderNumber
GROUP BY od.orderNumber;

SELECT o.*, (SELECT SUM(priceEach*quantityOrdered) FROM orderdetails WHERE o.orderNumber = orderdetails.orderNumber) totalValue
FROM orders o;

-- Q4
SELECT c.customerName, SUM(od.quantityOrdered * od.priceEach) as totalPaid
FROM customers c, orders o, orderdetails od
WHERE c.customerNumber = o.customerNumber AND o.orderNumber = od.orderNumber
GROUP BY c.customerNumber
ORDER BY totalPayAmount DESC;

SELECT c.customerName, (SELECT SUM((SELECT SUM(priceEach*quantityOrdered) FROM orderdetails WHERE orderNumber = o.orderNumber)) FROM orders o WHERE o.customerNumber = c.customerNumber) as totalPaid
FROM customers c;

SELECT 
    c.customerName, 
    (SELECT 
            SUM(priceEach * quantityOrdered) totalPaid
        FROM
            orderdetails od
        WHERE
            orderNumber IN (SELECT 
                    orderNumber
                FROM
                    orders
                WHERE
                    customerNumber = c.customerNumber)) totalPaid
			FROM customers c;
