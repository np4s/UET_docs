SELECT city, COUNT(*) as "Number of customers"
FROM customers
GROUP BY city;

SELECT COUNT(*)
FROM orders
WHERE month(orderDate) = '03' AND year(orderDate) = '2005';

SELECT month(orderDate) as month, COUNT(*) as "Number of orders"
FROM orders
WHERE year(orderDate) = '2005'
GROUP BY month;

SELECT year(orderDate) as year, month(orderDate) as month, COUNT(*) as "Number of orders"
FROM orders
GROUP BY year, month;

SELECT orderNumber, SUM(quantityOrdered*priceEach) as total
FROM orderdetails
GROUP BY orderNumber
ORDER BY total DESC
LIMIT 10;

SELECT productLine, SUM(quantityInStock) as "total quantity in stock"
FROM products
GROUP BY productLine;

-- 
SELECT customerNumber, SUM(amount) as "Payment amount"
FROM payments
GROUP BY customerNumber;

-- 
SELECT 
    customerNumber, SUM(total) as "Order amount"
FROM
    orders
        INNER JOIN
    (SELECT 
        orderNumber, SUM(quantityOrdered * priceEach) AS total
    FROM
        orderdetails
    GROUP BY orderNumber) tmp1 ON orders.orderNumber = tmp1.orderNumber
GROUP BY customerNumber
ORDER BY customerNumber;