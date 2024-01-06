-- GK 3
SELECT
	concat_ws(', ', trim(contactFirstName),contactLastName) as Fullname,
    IF(addressLine2 is NULL, concat_ws(" - ", addressLine1, city, country, postalCode), concat_ws(" - ", addressLine1, addressLine2, city, country, postalCode)) as Address
FROM customers;

SELECT LEFT(comments, 20) AS shortComment
FROM orders
WHERE
	comments IS NOT NULL AND YEAR(orderDate) = 2003 AND MONTH(orderDate) in (11, 12) AND DATEDIFF(requiredDate, orderDate) < 5;
    
-- MID_2223
SELECT concat((contactLastName), (contactFirstName)) as Fullname,
	length(Fullname)
FROM customers
ORDER BY length(Fullname) DESC
LIMIT 1;

    