DELETE FROM user;
INSERT INTO user VALUES (1,'heather.sokasits@gmail.com','Heather','Sokasits',4,0,'heathersok','college1'),(2,'steve.sokasits@gmail.com','Steve','Sokasits',1,0,'sokasits31','college2'),(3,'Lea.sokasits@gmail.com','Lea','Sokasits',2,0,'leaclaire','college3');
DELETE FROM role;
INSERT INTO role VALUES (1,'admin','heathersok',1),(2,'vol','sokasits31',2);
DELETE FROM menuCategory;
INSERT INTO menuCategory VALUES (1,'Espresso Drinks'),(2,'Frozen Blended'),(3,'Brewed Coffee'),(4,'Tea Drinks'),(5,'Cold Bottled'),(6,'Bakery Items'),(7,'Food Menu'),(8,'Gift Certificates'),(9,'Gift Cards');
DELETE from menuItem;
INSERT INTO menuItem VALUES (1,'Cappuccino 12oz',NULL,2.00,1,'A1',1),(2,'Cappuccino 16oz',NULL,2.50,1,'A1',1),(3,'Mocha 12oz',NULL,2.00,1,'A1',1),(4,'Mocha 16oz',NULL,2.50,1,'A1',1),(5,'Latte 12oz',NULL,2.00,2,'A1',1),(6,'Latte 16oz',NULL,2.50,2,'A1',1),(7,'Americano 12oz',NULL,2.00,2,'A1',1),(8,'Americano 16oz',NULL,2.50,2,'A1',1),(9,'Steamer 12oz',NULL,2.00,2,'A1',1),(10,'Steamer 16oz',NULL,2.50,2,'A1',1),(11,'Hot Choc. 12oz',NULL,1.50,1,'A1',1),(12,'Hot Choc. 16oz',NULL,2.00,1,'A1',1),(13,'Kids HC 8oz.',NULL,1.00,2,'A1',1),(14,'Hot Cider 12oz',NULL,1.50,2,'A1',1),(15,'Hot Cider 16oz.',NULL,2.00,2,'A1',1),(16,'Vanilla Frappe 12oz.',NULL,2.00,2,'A1',2),(17,'Vanilla Frappe 16oz.',NULL,2.50,2,'A1',2),(18,'Chocolate Frappe 12oz',NULL,2.50,2,'A1',2),(19,'Chocolate Frappe 16oz.',NULL,3.00,2,'A1',2),(20,'Caremel Frappe 12oz.',NULL,2.50,1,'A1',2),(21,'Caremel Frappe 16oz.',NULL,2.50,1,'A1',2),(22,'Cookies Frappe 12oz.',NULL,2.50,2,'A1',2),(23,'Cookies Frappe 16oz.',NULL,2.50,2,'A1',2),(24,'Frappe Special 12oz.',NULL,2.50,1,'A1',2),(25,'Frappe Special 16oz.',NULL,2.50,1,'A1',2);
DELETE FROM testHistory;
INSERT INTO testHistory VALUES (6 , 3, 'test2222 item', 'alt test item', 1, 88.44, 'g', 'cat', 34, 'pass' , 3);


