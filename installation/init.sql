--Postgresql 9.6.1

CREATE USER test WITH SUPERUSER PASSWORD 'test';
create database bookstore owner test;


INSERT INTO Workgroup (id,name,description,creation_date) VALUES (100,'AAAAAAAAA','AAAAAAAAA','1011-11-11');

INSERT INTO Synopsis (book_id,synopsis) VALUES (100,'AAAAAAAAA');

INSERT INTO Shop (code,name,address_1,address_2,zip_code,city,country_code,phone,email,executive) VALUES ('AA','AAAAAAAAA','AAAAAAAAA','AAAAAAAAA',111111111,'AAAAAAAAA','AA','AAAAAAAAA','AAAAAAAAA',NULL);

INSERT INTO Publisher (code,country_code,name,email,contact,city,zip_code,phone) VALUES (100,'AA','AAAAAAAAA','AAAAAAAAA','AAAAAAAAA','AAAAAAAAA',111111111,'AAAAAAAAA');

INSERT INTO Employee_group (employee_code,group_id) VALUES ('AAA',100);

INSERT INTO Employee (code,shop_code,first_name,last_name,manager,badge_number,email) VALUES ('AAA','AAA','AAAAAAAAA','AAAAAAAAA',11111,NULL,'AAAAAAAAA');

INSERT INTO Customer (code,country_code,first_name,last_name,login,password,age,city,zip_code,phone,reviewer) VALUES ('AAA','AA','AAAAAAAAA','AAAAAAAAA','AAAAAAAAA','AAAAAAAAA',11111,'AAAAAAAAA',11111,'AAAAAAAAA',11111);

INSERT INTO Country (code,name) VALUES ('AA','AAAAAAAAA');

INSERT INTO Book_order (id,shop_code,customer_code,employee_code,date,state) VALUES (100,'AAA','AAA','AAA','1011-11-11',11111);

INSERT INTO Book (id,publisher_id,author_id,isbn,title,price,quantity,discount,availability,best_seller) VALUES (100,100,100,'AAAAAAAAA','AAAAAAAAA',11111,11111,11111,11111,11111);

INSERT INTO Badge (badge_number,authorization_level,end_of_validity) VALUES (1,6,'2012-11-03 00:00:00');
INSERT INTO Badge (badge_number,authorization_level,end_of_validity)  VALUES (100,111,'1011-11-11');
INSERT INTO Badge (badge_number,authorization_level,end_of_validity)  VALUES (101,12,'2017-09-19T22:00:00.000Z');
INSERT INTO Badge (badge_number,authorization_level,end_of_validity)  VALUES (102,66,'2017-09-01T22:00:00.000Z');
INSERT INTO Badge (badge_number,authorization_level,end_of_validity)  VALUES (103,55,'2017-08-31T22:00:00.000Z');
INSERT INTO Badge (badge_number,authorization_level,end_of_validity)  VALUES (104,6,'2012-11-03 00:00:00');
INSERT INTO Badge (badge_number,authorization_level,end_of_validity)  VALUES (105,100,'2012-11-03 00:00:00');
INSERT INTO Badge (badge_number,authorization_level,end_of_validity)  VALUES (106,13,'2017-09-01T22:00:00.000Z');
INSERT INTO Badge (badge_number,authorization_level,end_of_validity)  VALUES (107,6,'2017-09-01T22:00:00.000Z');
INSERT INTO Badge (badge_number,authorization_level,end_of_validity)  VALUES (108,6,'2012-11-02T23:00:00.000Z');
INSERT INTO Badge (badge_number,authorization_level,end_of_validity)  VALUES (109,6,'2012-11-02T23:00:00.000Z');
INSERT INTO Badge (badge_number,authorization_level,end_of_validity)  VALUES (110,6,'2012-11-02T23:00:00.000Z');
INSERT INTO Badge (badge_number,authorization_level,end_of_validity)  VALUES (111,6,'2015-03-16T23:00:00.000Z');
INSERT INTO Badge (badge_number,authorization_level,end_of_validity)  VALUES (112,8,'1999-12-12T11:12:12.000Z');
INSERT INTO Badge (badge_number,authorization_level,end_of_validity)  VALUES (114,90,'1999-12-12T11:12:12.000Z');
INSERT INTO Badge (badge_number,authorization_level,end_of_validity)  VALUES (115,6,'2012-11-02T23:00:00.000Z');

INSERT INTO Author (id,first_name,last_name) VALUES (1,'aureliane','lucas');
INSERT INTO Author (id,first_name,last_name) VALUES (2,'imad','el hitti');
INSERT INTO Author (id,first_name,last_name) VALUES (3,'theo','bertet');
INSERT INTO Author (id,first_name,last_name) VALUES (4,'romuald','truffeau');
INSERT INTO Author (id,first_name,last_name) VALUES (100,'AAAAAAAAA','AAAAAAAAA');
