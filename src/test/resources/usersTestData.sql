DELETE FROM user;
INSERT INTO `user` VALUES (1,'heather.sokasits@gmail.com','Heather','Sokasits',4,0,'heathersok','college1'),(2,'steve.sokasits@gmail.com','Steve','Sokasits',1,0,'sokasits31','college2'),(3,'Lea.sokasits@gmail.com','Lea','Sokasits',2,0,'leaclaire','college3');
DELETE FROM role;
INSERT INTO `role` VALUES (1,'admin','heathersok',1),(2,'vol','sokasits31',2);
DELETE FROM testScore;
INSERT INTO `testScore` VALUES (1,'1969-12-31',1,1,1,2),(2,'1969-12-31',1,1,2,2),(3,'1969-12-31',1,1,3,2),(4,'1969-12-31',1,1,4,2),(5,'1969-12-31',1,1,5,2),(6,'1969-12-31',1,1,6,2),(7,'2018-10-09',1,1,7,2),(8,'1969-12-31',1,1,8,3),(9,'1969-12-31',1,1,9,3),(10,'1969-12-31',1,1,10,3),(11,'1969-12-31',2,2,5,3),(12,'1969-12-31',2,2,6,3),(13,'1969-12-31',2,2,7,3),(14,'1969-12-31',2,2,8,3),(15,'1969-12-31',2,2,9,3),(16,'1969-12-31',2,2,10,3),(17,'1969-12-31',2,2,11,2),(18,'1969-12-31',2,2,12,2),(19,'1969-12-31',2,2,13,2),(20,'1969-12-31',2,2,14,2),(21,'1969-12-31',2,2,15,2),(22,'1969-12-31',2,2,16,2),(23,'1969-12-31',2,2,18,2),(24,'1969-12-31',2,2,19,2),(25,'1969-12-31',2,2,2,2);
DELETE FROM doorCreekCafe.menuCategory;
INSERT INTO `menuCategory` VALUES (1,'Espresso Drinks'),(2,'Frozen Blended'),(3,'Brewed Coffee'),(4,'Tea Drinks'),(5,'Cold Bottled'),(6,'Bakery Items'),(7,'Food Menu'),(8,'Gift Certificates'),(9,'Gift Cards');
DELETE from menuItem;
INSERT INTO `menuItem` VALUES (1,'Cappuccino 12oz',NULL,2.00,1,'A1',1),(2,'Cappuccino 16oz',NULL,2.50,1,'A1',1),(3,'Mocha 12oz',NULL,2.00,1,'A1',1),(4,'Mocha 16oz',NULL,2.50,1,'A1',1),(5,'Latte 12oz',NULL,2.00,2,'A1',1),(6,'Latte 16oz',NULL,2.50,2,'A1',1),(7,'Americano 12oz',NULL,2.00,2,'A1',1),(8,'Americano 16oz',NULL,2.50,2,'A1',1),(9,'Steamer 12oz',NULL,2.00,2,'A1',1),(10,'Steamer 16oz',NULL,2.50,2,'A1',1),(11,'Hot Choc. 12oz',NULL,1.50,1,'A1',1),(12,'Hot Choc. 16oz',NULL,2.00,1,'A1',1),(13,'Kids HC 8oz.',NULL,1.00,2,'A1',1),(14,'Hot Cider 12oz',NULL,1.50,2,'A1',1),(15,'Hot Cider 16oz.',NULL,2.00,2,'A1',1),(16,'Vanilla Frappe 12oz.',NULL,2.00,2,'A1',2),(17,'Vanilla Frappe 16oz.',NULL,2.50,2,'A1',2),(18,'Chocolate Frappe 12oz',NULL,2.50,2,'A1',2),(19,'Chocolate Frappe 16oz.',NULL,3.00,2,'A1',2),(20,'Caremel Frappe 12oz.',NULL,2.50,1,'A1',2),(21,'Caremel Frappe 16oz.',NULL,2.50,1,'A1',2),(22,'Cookies Frappe 12oz.',NULL,2.50,2,'A1',2),(23,'Cookies Frappe 16oz.',NULL,2.50,2,'A1',2),(24,'Frappe Special 12oz.',NULL,2.50,1,'A1',2),(25,'Frappe Special 16oz.',NULL,2.50,1,'A1',2);

