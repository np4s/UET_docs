-- Q1
SELECT c.customerName, c.customerNumber,
(SELECT datediff("2005-06-02", MAX(orderDate))
FROM orders
WHERE customerNumber = c.customerNumber) Recency,
(SELECT COUNT(*)
FROM orders
WHERE customerNumber = c.customerNumber) Frequency,
(SELECT SUM(quantityOrdered*priceEach)
FROM orderdetails
WHERE orderNumber IN (SELECT DISTINCT orderNumber
						FROM orders
                        WHERE customerNumber = c.customerNumber)) Monetary
FROM customers c;

-- Q2
SELECT c.customerName, c.customerNumber,
(SELECT datediff("2005-06-02", MAX(orderDate))
FROM orders
WHERE customerNumber = c.customerNumber) Recency,
(SELECT COUNT(*)
FROM orders
WHERE customerNumber = c.customerNumber) Frequency,
(SELECT SUM(quantityOrdered*priceEach)
FROM orderdetails
WHERE orderNumber IN (SELECT DISTINCT orderNumber
						FROM orders
                        WHERE customerNumber = c.customerNumber)) Monetary
FROM customers c
HAVING (Recency <= 5 AND Frequency >= 5) OR (Monetary > 500000);

-- Q3
SELECT pl.productLine, pl.textDescription,
(SELECT SUM(quantityInStock)
FROM products
WHERE productLine = pl.productLine) +
(SELECT SUM(quantityOrdered)
FROM orderdetails
WHERE productCode IN (SELECT productCode FROM products WHERE productLine = pl.productLine)) total_quantity_of_products
FROM productlines pl
HAVING total_quantity_of_products > 50000;

-- Q4
SELECT c.customerName,
(SELECT SUM(quantityOrdered*priceEach)
FROM orderdetails 
WHERE orderNumber IN (SELECT orderNumber FROM orders WHERE customerNumber = c.customerNumber)) totalPurchased,
(SELECT SUM(amount)
FROM payments
WHERE customerNumber = c.customerNumber) totalPaid,
(SELECT(totalPurchased-totalPaid)) totalDebt
FROM customers c
HAVING totalPaid < 100000;

-- Q5
CREATE TABLE new_payments LIKE payments;
INSERT INTO new_payments 
(SELECT * FROM payments WHERE amount > 50000);

-- Q6
SELECT *,
(SELECT SUM(quantityInStock*buyPrice)
FROM products
WHERE productLine = pl.productLine) "inventory money"
FROM productlines pl;