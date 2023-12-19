CREATE SCHEMA IF NOT EXISTS projectdb;
use projectdb;

/*create an item table*/
CREATE TABLE Item(
	id VARCHAR(20) NOT NULL PRIMARY KEY, 
	itemName VARCHAR(60) NOT NULL,
	itemDescription VARCHAR(60) NOT NULL, 
	category VARCHAR(60) NOT NULL, 
	brand VARCHAR(60) NOT NULL,
	quantity INT NOT NULL, 
	price INT NOT NULL
);

/* insert data into item table*/
INSERT INTO ITEM (id, itemName, itemDescription, category, brand, price, quantity) VALUES ('b001', 
'Little Prince', 'a book for all ages', 'book', 'penguin', 20, 100);
INSERT INTO ITEM (id, itemName, itemDescription, category, brand, price, quantity) VALUES ('c001', 
'iPad', 'a portable device for personal use', 'computer', 'Apple', 500, 100);
INSERT INTO ITEM (id, itemName, itemDescription, category, brand, price, quantity) VALUES 
('d001', 'laptop', 'a laptop for personal use', 'computer', 'Dell', 1500, 100);

/*create an address table*/
CREATE TABLE Address (
	id INT NOT NULL,
	street VARCHAR(100) NOT NULL, 
	province VARCHAR(20) NOT NULL, 
	country VARCHAR(20) NOT NULL,
	zip VARCHAR(20) NOT NULL, 
	phone VARCHAR(20),
	PRIMARY KEY(id)
);

/* insert data into address table*/
INSERT INTO Address (id, street, province, country, zip, phone) VALUES (1, '567 Yonge St', 
'ON', 'Canada', 'K1E 6T5' ,'647-123-4567');
INSERT INTO Address (id, street, province, country, zip, phone) VALUES (2, '945 Avenue 
rd', 'ON', 'Canada', 'M1C 6K5' ,'416-123-8569');
INSERT INTO Address (id, street, province, country, zip, phone) VALUES (3, '189 Keele 
St.', 'ON', 'Canada', 'K3C 9T5' ,'416-123-9568');

/*create a customer table*/
CREATE TABLE Customer ( 
	username VARCHAR(100) NOT NULL, 
	pass VARCHAR(100) NOT NULL,
	firstName VARCHAR(100) NOT NULL, 
	lastName VARCHAR(20) NOT NULL, 
	addressID INT NOT NULL, 
	PRIMARY KEY(username),
	FOREIGN KEY (addressID) REFERENCES Address (id)
);

/* insert data into customer table*/
INSERT INTO Customer VALUES ("test1@yorku.ca", 'test1', 
'test1First', 'test1Last', '1');
INSERT INTO Customer VALUES ("test2@yorku.ca", 'test2', 
'test2First', 'test2Last', '2');
INSERT INTO Customer VALUES ("test3@yorku.ca", 'test3', 
'test3First', 'test3Last', '3');

/*create an PO table - Keep Track of each item purchased by a customer*/
CREATE TABLE PO (
	id INT NOT NULL,
	customerID VARCHAR(100) NOT NULL,
	itemID VARCHAR(20) NOT NULL,
    qtyOrdered INT,
    totalPrice FLOAT,
	dateOfPurchase VARCHAR(100) NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY (customerID) REFERENCES Customer (username),
	FOREIGN KEY (itemID) REFERENCES Item (id)
);

/* insert data into PO table*/
INSERT INTO PO VALUES ("1", 'test1@yorku.ca', 'b001', '1', '20.0', '2023-12-16 19:23:51');
INSERT INTO PO VALUES ("2", 'test1@yorku.ca', 'd001', '2', '3000.0', '2023-12-17 10:24:11');
INSERT INTO PO VALUES ("3", 'test2@yorku.ca', 'c001', '3', '1500.0', '2023-12-17 12:24:32');
INSERT INTO PO VALUES ("4", 'test3@yorku.ca', 'b001', '2', '40.0', '2023-12-17 23:22:32');
INSERT INTO PO VALUES ("5", 'test1@yorku.ca', 'b001', '2', '40.0', '2023-12-18 19:23:51');
INSERT INTO PO VALUES ("6", 'test1@yorku.ca', 'b001', '3', '60.0', '2023-12-18 19:23:51');
INSERT INTO PO VALUES ("7", 'test1@yorku.ca', 'd001', '1', '1500.0', '2023-12-18 19:23:51');

/*create a CreditCard table*/
CREATE TABLE CreditCard ( 
	ccNum VARCHAR(100) NOT NULL, 
	cvv VARCHAR(3) NOT NULL,
	expiryDate VARCHAR(100) NOT NULL, 
    customerID VARCHAR(100) NOT NULL,
	PRIMARY KEY(ccNum),
    FOREIGN KEY (customerID) REFERENCES Customer (username)
);

/* insert data into CreditCard table*/
INSERT INTO CreditCard VALUES ("1111222233334444", '111', '2023-08', 'test1@yorku.ca');
INSERT INTO CreditCard VALUES ("2111222233334444", '222', '2024-09', 'test2@yorku.ca');
INSERT INTO CreditCard VALUES ("3111222233334444", '333', '2025-10', 'test3@yorku.ca');
