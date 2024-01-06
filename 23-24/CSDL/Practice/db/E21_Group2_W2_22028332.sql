CREATE DATABASE My_Classicmodels;

USE My_Classicmodels;

CREATE TABLE productlines (
    productLine VARCHAR(50) NOT NULL PRIMARY KEY,
    textDescription VARCHAR(4000),
    htmlDescription MEDIUMTEXT,
    image MEDIUMBLOB
);

CREATE TABLE orders (
    orderNumber INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    orderDate DATETIME NOT NULL,
    requiredDate DATETIME NOT NULL,
    shippedDate DATETIME,
    status VARCHAR(15) NOT NULL,
    comments TEXT,
    customerNumber INT(11) NOT NULL
);
    
CREATE TABLE products (
    productCode VARCHAR(15) NOT NULL PRIMARY KEY,
    productName VARCHAR(70) NOT NULL,
    productLine VARCHAR(50) NOT NULL,
    productScale VARCHAR(10) NOT NULL,
    productVendor VARCHAR(50) NOT NULL,
    productDescription TEXT NOT NULL,
    quantityInStock SMALLINT(6) NOT NULL,
    buyPrice DOUBLE NOT NULL,
    CONSTRAINT fk_pLines_product FOREIGN KEY (productLine)
        REFERENCES productLines (productLine)
        ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE orderdetails (
    orderNumber INT(11) NOT NULL AUTO_INCREMENT,
    productCode VARCHAR(15) NOT NULL,
    quantityOrdered INT(11) NOT NULL,
    priceEach DOUBLE NOT NULL,
    orderLineNumber SMALLINT(6) NOT NULL,
    PRIMARY KEY (orderNumber , productCode),
    CONSTRAINT fk_ord_orddetails FOREIGN KEY (orderNumber)
        REFERENCES orders (orderNumber)
        ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT fk_product_ord FOREIGN KEY (productCode)
        REFERENCES products (productCode)
        ON DELETE RESTRICT ON UPDATE CASCADE
);