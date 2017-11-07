BEGIN TRANSACTION;
CREATE TABLE "Workgroup" (
	id INTEGER NOT NULL, 
	name VARCHAR NOT NULL, 
	description VARCHAR NOT NULL, 
	"creationDate" DATE NOT NULL, 
	PRIMARY KEY (id), 
	UNIQUE (id)
);
INSERT INTO `Workgroup` (id,name,description,creationDate) VALUES (100,'AAAAAAAAA','AAAAAAAAA','1011-11-11');
CREATE TABLE "Synopsis" (
	"bookId" INTEGER NOT NULL, 
	synopsis VARCHAR, 
	PRIMARY KEY ("bookId"), 
	UNIQUE ("bookId")
);
INSERT INTO `Synopsis` (bookId,synopsis) VALUES (100,'AAAAAAAAA');
CREATE TABLE "Shop" (
	`code`	TEXT NOT NULL UNIQUE,
	`name`	TEXT,
	`address1`	TEXT,
	`address2`	TEXT,
	`zipCode`	INTEGER,
	`city`	TEXT,
	`countryCode`	TEXT NOT NULL,
	`phone`	TEXT,
	`email`	TEXT,
	`executive`	TEXT,
	PRIMARY KEY(`code`),
	FOREIGN KEY(`countryCode`) REFERENCES `Country`(`code`) ON DELETE RESTRICT,
	FOREIGN KEY(`executive`) REFERENCES `Employee`(`code`) ON DELETE RESTRICT
);
INSERT INTO `Shop` (code,name,address1,address2,zipCode,city,countryCode,phone,email,executive) VALUES ('AAA','AAAAAAAAA','AAAAAAAAA','AAAAAAAAA',111111111,'AAAAAAAAA','AAA','AAAAAAAAA','AAAAAAAAA',NULL);
CREATE TABLE "Review" (
	`customerCode`	VARCHAR NOT NULL,
	`bookId`	INTEGER NOT NULL,
	`reviewText`	INTEGER NOT NULL,
	`reviewNote`	INTEGER,
	`creation`	VARCHAR,
	`lastUpdate`	VARCHAR,
	PRIMARY KEY(`customerCode`,`bookId`),
	FOREIGN KEY(`customerCode`) REFERENCES `Customer`(`code`),
	FOREIGN KEY(`bookId`) REFERENCES `Book`(`id`)
);
CREATE TABLE "Publisher" (
	code INTEGER NOT NULL, 
	"countryCode" VARCHAR NOT NULL, 
	name VARCHAR, 
	email VARCHAR, 
	contact VARCHAR, 
	city VARCHAR, 
	"zipCode" INTEGER, 
	phone VARCHAR, 
	PRIMARY KEY (code), 
	UNIQUE (code), 
	FOREIGN KEY("countryCode") REFERENCES "Country" (code) ON DELETE RESTRICT
);
INSERT INTO `Publisher` (code,countryCode,name,email,contact,city,zipCode,phone) VALUES (100,'AAA','AAAAAAAAA','AAAAAAAAA','AAAAAAAAA','AAAAAAAAA',111111111,'AAAAAAAAA');
CREATE TABLE "EmployeeGroup" (
	`employeeCode`	VARCHAR NOT NULL,
	`groupId`	INTEGER NOT NULL,
	PRIMARY KEY(`employeeCode`,`groupId`),
	FOREIGN KEY(`employeeCode`) REFERENCES `Employee`(`code`),
	FOREIGN KEY(`groupId`) REFERENCES `Workgroup`(`id`)
);
INSERT INTO `EmployeeGroup` (employeeCode,groupId) VALUES ('AAA',100);
CREATE TABLE `Employee` (
	`code`	TEXT NOT NULL UNIQUE,
	`shopCode`	TEXT NOT NULL,
	`firstName`	TEXT,
	`lastName`	TEXT NOT NULL,
	`manager`	INTEGER,
	`badgeNumber`	INTEGER,
	`email`	TEXT,
	PRIMARY KEY(`code`),
	FOREIGN KEY(`shopCode`) REFERENCES Shop('code') ON DELETE RESTRICT,
	FOREIGN KEY(`badgeNumber`) REFERENCES Badge('badgeNumber') ON DELETE RESTRICT
);
INSERT INTO `Employee` (code,shopCode,firstName,lastName,manager,badgeNumber,email) VALUES ('AAA','AAA','AAAAAAAAA','AAAAAAAAA',111111111,NULL,'AAAAAAAAA');
CREATE TABLE "Customer" (
	code VARCHAR NOT NULL, 
	"countryCode" VARCHAR NOT NULL, 
	"firstName" VARCHAR, 
	"lastName" VARCHAR, 
	login VARCHAR NOT NULL, 
	password VARCHAR, 
	age INTEGER, 
	city VARCHAR, 
	"zipCode" INTEGER, 
	phone VARCHAR, 
	reviewer INTEGER, 
	PRIMARY KEY (code), 
	UNIQUE (code), 
	FOREIGN KEY("countryCode") REFERENCES "Country" (code) ON DELETE RESTRICT
);
INSERT INTO `Customer` (code,countryCode,firstName,lastName,login,password,age,city,zipCode,phone,reviewer) VALUES ('AAA','AAA','AAAAAAAAA','AAAAAAAAA','AAAAAAAAA','AAAAAAAAA',111111111,'AAAAAAAAA',111111111,'AAAAAAAAA',111111111);
CREATE TABLE "Country" (
	code VARCHAR NOT NULL, 
	name VARCHAR, 
	PRIMARY KEY (code), 
	UNIQUE (code)
);
INSERT INTO `Country` (code,name) VALUES ('AAA','AAAAAAAAA');
CREATE TABLE "BookOrderItem" (
	`bookOrderId`	INTEGER NOT NULL,
	`bookId`	INTEGER NOT NULL,
	`price`	INTEGER,
	`quantity`	INTEGER,
	PRIMARY KEY(`bookOrderId`,`bookId`),
	FOREIGN KEY(`bookOrderId`) REFERENCES `BookOrder`(`id`),
	FOREIGN KEY(`bookId`) REFERENCES `Book`(`id`)
);
CREATE TABLE "BookOrder" (
	id INTEGER NOT NULL, 
	"shopCode" VARCHAR NOT NULL, 
	"customerCode" VARCHAR NOT NULL, 
	"employeeCode" VARCHAR NOT NULL, 
	date DATE, 
	state INTEGER, 
	PRIMARY KEY (id), 
	UNIQUE (id), 
	FOREIGN KEY("shopCode") REFERENCES "Shop" (code) ON DELETE RESTRICT, 
	FOREIGN KEY("customerCode") REFERENCES "Customer" (code) ON DELETE RESTRICT, 
	FOREIGN KEY("employeeCode") REFERENCES "Employee" (code) ON DELETE RESTRICT
);
INSERT INTO `BookOrder` (id,shopCode,customerCode,employeeCode,date,state) VALUES (100,'AAA','AAA','AAA','1011-11-11',111111111);
CREATE TABLE "Book" (
	id INTEGER NOT NULL, 
	"publisherId" INTEGER NOT NULL, 
	"authorId" INTEGER NOT NULL, 
	isbn VARCHAR NOT NULL, 
	title VARCHAR, 
	price INTEGER, 
	quantity INTEGER, 
	discount INTEGER, 
	availability INTEGER, 
	"bestSeller" INTEGER, 
	PRIMARY KEY (id), 
	UNIQUE (id), 
	FOREIGN KEY("publisherId") REFERENCES "Publisher" (code) ON DELETE RESTRICT, 
	FOREIGN KEY("authorId") REFERENCES "Author" (id) ON DELETE RESTRICT
);
INSERT INTO `Book` (id,publisherId,authorId,isbn,title,price,quantity,discount,availability,bestSeller) VALUES (100,100,100,'AAAAAAAAA','AAAAAAAAA',111111111,111111111,111111111,111111111,111111111);
CREATE TABLE "Badge" (
	"badgeNumber" INTEGER NOT NULL, 
	"authorizationLevel" INTEGER NOT NULL, 
	"endOfValidity" DATE, 
	PRIMARY KEY ("badgeNumber"), 
	UNIQUE ("badgeNumber")
);
INSERT INTO `Badge` (badgeNumber,authorizationLevel,endOfValidity) VALUES (1,6,'2012-11-03 00:00:00');
INSERT INTO `Badge` (badgeNumber,authorizationLevel,endOfValidity) VALUES (100,111111111,'1011-11-11');
INSERT INTO `Badge` (badgeNumber,authorizationLevel,endOfValidity) VALUES (101,12,'2017-09-19T22:00:00.000Z');
INSERT INTO `Badge` (badgeNumber,authorizationLevel,endOfValidity) VALUES (102,66,'2017-09-01T22:00:00.000Z');
INSERT INTO `Badge` (badgeNumber,authorizationLevel,endOfValidity) VALUES (103,55,'2017-08-31T22:00:00.000Z');
INSERT INTO `Badge` (badgeNumber,authorizationLevel,endOfValidity) VALUES (104,6,'2012-11-03 00:00:00');
INSERT INTO `Badge` (badgeNumber,authorizationLevel,endOfValidity) VALUES (105,100,'2012-11-03 00:00:00');
INSERT INTO `Badge` (badgeNumber,authorizationLevel,endOfValidity) VALUES (106,13,'2017-09-01T22:00:00.000Z');
INSERT INTO `Badge` (badgeNumber,authorizationLevel,endOfValidity) VALUES (107,6,1351897200000);
INSERT INTO `Badge` (badgeNumber,authorizationLevel,endOfValidity) VALUES (108,6,'2012-11-02T23:00:00.000Z');
INSERT INTO `Badge` (badgeNumber,authorizationLevel,endOfValidity) VALUES (109,6,'2012-11-02T23:00:00.000Z');
INSERT INTO `Badge` (badgeNumber,authorizationLevel,endOfValidity) VALUES (110,6,'2012-11-02T23:00:00.000Z');
INSERT INTO `Badge` (badgeNumber,authorizationLevel,endOfValidity) VALUES (111,6,'2015-03-16T23:00:00.000Z');
INSERT INTO `Badge` (badgeNumber,authorizationLevel,endOfValidity) VALUES (112,8,'1999-12-12T11:12:12.000Z');
INSERT INTO `Badge` (badgeNumber,authorizationLevel,endOfValidity) VALUES (114,90,'1999-12-12T11:12:12.000Z');
INSERT INTO `Badge` (badgeNumber,authorizationLevel,endOfValidity) VALUES (115,6,'2012-11-02T23:00:00.000Z');
CREATE TABLE "Author" (
	id INTEGER NOT NULL, 
	"firstName" VARCHAR, 
	"lastName" VARCHAR, 
	PRIMARY KEY (id), 
	UNIQUE (id)
);
INSERT INTO `Author` (id,firstName,lastName) VALUES (1,'aureliane','lucas');
INSERT INTO `Author` (id,firstName,lastName) VALUES (2,'imad','el hitti');
INSERT INTO `Author` (id,firstName,lastName) VALUES (3,'theo','bertet');
INSERT INTO `Author` (id,firstName,lastName) VALUES (4,'romuald','truffeau');
INSERT INTO `Author` (id,firstName,lastName) VALUES (100,'AAAAAAAAA','AAAAAAAAA');
COMMIT;
