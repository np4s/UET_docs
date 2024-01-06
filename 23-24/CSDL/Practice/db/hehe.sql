-- Q1
CREATE TABLE new_products (
  productCode varchar(15) NOT NULL,
  productName varchar(70) NOT NULL,
  productLine varchar(50) NOT NULL,
  productScale varchar(10) NOT NULL,
  productVendor varchar(50) NOT NULL,
  productDescription text NOT NULL,
  quantityInStock smallint NOT NULL,
  buyPrice decimal(10,2) NOT NULL,
  MSRP decimal(10,2) NOT NULL,
  PRIMARY KEY (productCode),
  CONSTRAINT products_ibfk_2 FOREIGN KEY (productLine) REFERENCES productlines (productLine)
);

INSERT INTO new_products
SELECT p.*
FROM products p, (SELECT productCode, SUM(quantityOrdered) totalOrder
				FROM orderdetails
				GROUP BY productCode
				HAVING totalOrder = (SELECT MAX(productOrder) maxOrder
									FROM (SELECT SUM(od.quantityOrdered) productOrder
									FROM orderdetails od
									GROUP BY od.productCode) tmp1)) tmp2
WHERE p.productCode = tmp2.productCode;

-- Q2
SELECT e1.*
FROM employees e1, employees e2
WHERE e1.reportsTo = e2.employeeNumber AND concat(e2.firstName, ' ', e2.lastName) = 'Mary Patterson';

SELECT *
FROM employees
WHERE reportsTo = (SELECT e.employeeNumber FROM employees e WHERE concat(e.firstName, ' ', e.lastName) = 'Mary Patterson');

-- Q3
SELECT c.customerName, c.state, c.country
FROM customers c, 
(SELECT state, COUNT(*) cState
FROM customers
GROUP BY state
HAVING cState = 1) tmp1,
(SELECT country, COUNT(*) cCountry
FROM customers
GROUP BY country
HAVING cCountry = 1) tmp2
WHERE c.state = tmp1.state AND c.country = tmp2.country;

-- Q4
SELECT *
FROM products
WHERE
productCode IN 
(SELECT DISTINCT productCode
FROM orderdetails
WHERE orderNumber IN
(SELECT orderNumber
FROM orders
WHERE status = 'Shipped' AND year(orderDate) = 2003))
AND productCode NOT IN
(SELECT DISTINCT productCode
FROM orderdetails
WHERE orderNumber IN
(SELECT orderNumber
FROM orders
WHERE status = 'Shipped' AND year(orderDate) = 2004));

-- Q5
SELECT c.customerName, mostValuable.orderNumber, mostValuable.totalAmount
FROM customers c, orders o,
(SELECT orderNumber, SUM(priceEach*quantityOrdered) totalAmount
FROM orderdetails
GROUP BY orderNumber
ORDER BY totalAmount DESC
LIMIT 1) mostValuable
WHERE c.customerNumber = o.customerNumber AND o.orderNumber = mostValuable.orderNumber;