CREATE DATABASE  IF NOT EXISTS `kitap` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `kitap`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: kitap
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `kitaplar`
--

DROP TABLE IF EXISTS `kitaplar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kitaplar` (
  `KitapID` int NOT NULL AUTO_INCREMENT,
  `YayıneviAdı` varchar(50) NOT NULL,
  `KitapAdı` varchar(255) NOT NULL,
  `Tür` varchar(50) DEFAULT NULL,
  `SayfaSayısı` int DEFAULT NULL,
  `StokAdedi` int DEFAULT '0',
  `Fiyat` float NOT NULL,
  `YazarID` int NOT NULL,
  `SaticiID` int DEFAULT NULL,
  PRIMARY KEY (`KitapID`),
  KEY `YazarID` (`YazarID`),
  KEY `fk_saticiid` (`SaticiID`),
  CONSTRAINT `fk_saticiid` FOREIGN KEY (`SaticiID`) REFERENCES `kullanıcılar` (`KullanıcıID`),
  CONSTRAINT `kitaplar_ibfk_1` FOREIGN KEY (`YazarID`) REFERENCES `yazarlar` (`YazarID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kitaplar`
--

LOCK TABLES `kitaplar` WRITE;
/*!40000 ALTER TABLE `kitaplar` DISABLE KEYS */;
INSERT INTO `kitaplar` VALUES (1,'Secker & Warburg','1984','Dystopian',328,100,45,6,1),(2,'Bloomsbury','Harry Potter and the Philosopher\'s Stone','Fantasy',223,150,60,7,1),(3,'Alfred A. Knopf','Norwegian Wood','Romance',400,80,55,8,1),(4,'Scribner','The Great Gatsby','Fiction',180,50,50,9,2),(5,'T. Egerton','Pride and Prejudice','Romance',279,70,40,10,2),(6,'The Russian Messenger','War and Peace','Historical Fiction',1225,30,75,11,2),(7,'HarperCollins','One Hundred Years of Solitude','Magical Realism',417,60,65,12,3),(8,'Chatto & Windus','The Adventures of Huckleberry Finn','Adventure',366,80,45,13,3),(9,'Gallimard','The Stranger','Philosophical Fiction',123,40,50,14,3),(10,'Schocken Books','The Trial','Psychological Fiction',280,60,55,15,4),(11,'Chapman & Hall','A Tale of Two Cities','Historical Fiction',341,90,50,16,4),(12,'The Belknap Press','The Complete Poems of Emily Dickinson','Poetry',400,100,45,17,4),(13,'Penguin Books','Hamlet','Tragedy',160,110,60,18,5),(14,'Harcourt','Mrs. Dalloway','Modernist Fiction',200,50,60,19,5),(15,'The Bodley Head','The Picture of Dorian Gray','Gothic Fiction',220,70,55,20,5),(16,'İthaki Yayınları','Aşk','Roman',450,35,50,5,6),(17,'Kalkedon Yayınları','Benim Adım Kırmızı','Roman',500,45,60,2,6),(18,'Varlık Yayınları','İnce Memed','Roman',600,60,50,4,6),(19,'Can Yayınları','Kürk Mantolu Madonna','Roman',160,50,45,1,7),(20,'Penguin Books','10 Minutes 38 Seconds in This Strange World','Roman',400,70,60,3,7);
/*!40000 ALTER TABLE `kitaplar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `kullanicisiparisleri`
--

DROP TABLE IF EXISTS `kullanicisiparisleri`;
/*!50001 DROP VIEW IF EXISTS `kullanicisiparisleri`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `kullanicisiparisleri` AS SELECT 
 1 AS `KullanıcıID`,
 1 AS `Ad`,
 1 AS `Soyad`,
 1 AS `SiparisID`,
 1 AS `ToplamUrunAdedi`,
 1 AS `ToplamTutar`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `kullanıcılar`
--

DROP TABLE IF EXISTS `kullanıcılar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kullanıcılar` (
  `KullanıcıID` int NOT NULL AUTO_INCREMENT,
  `Ad` varchar(50) NOT NULL,
  `Soyad` varchar(50) NOT NULL,
  `DogumTarihi` date NOT NULL,
  `Cinsiyet` enum('Erkek','Kadın','Diğer') NOT NULL,
  `Bakiye` float NOT NULL,
  `KullanıcıAdı` varchar(50) NOT NULL,
  `Sifre` varchar(50) NOT NULL,
  `TelefonNumarası` varchar(15) NOT NULL,
  `Email` varchar(50) NOT NULL,
  PRIMARY KEY (`KullanıcıID`),
  UNIQUE KEY `KullanıcıAdı` (`KullanıcıAdı`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kullanıcılar`
--

LOCK TABLES `kullanıcılar` WRITE;
/*!40000 ALTER TABLE `kullanıcılar` DISABLE KEYS */;
INSERT INTO `kullanıcılar` VALUES (1,'Ömer','Akçay','2004-01-01','Erkek',200,'omer_frk','1234','05555555555','omer.faruk@mail.com'),(2,'Ayşe','Yılmaz','1992-05-15','Kadın',150,'ayse_92','abcd','05555555556','ayse.yilmaz@mail.com'),(3,'Mehmet','Kaya','1988-03-22','Erkek',300,'mehmet_k','12345','05555555557','mehmet.kaya@mail.com'),(4,'Fatma','Demir','1995-07-10','Kadın',250,'fatma_d','qwerty','05555555558','fatma.demir@mail.com'),(5,'Ali','Çelik','2000-11-25','Erkek',500,'ali_celik','qwerty123','05555555559','ali.celik@mail.com'),(6,'Zeynep','Gül','1994-02-18','Kadın',100,'zeynep_g','password','05555555560','zeynep.gul@mail.com'),(7,'Emre','Bozkurt','1987-09-05','Erkek',350,'emre_boz','emre2024','05555555561','emre.bozkurt@mail.com'),(8,'Elif','Aydın','2002-12-30','Kadın',400,'elif_aydin','123456','05555555562','elif.aydin@mail.com'),(9,'Can','Sarı','1999-06-03','Erkek',600,'can_sari','can12345','05555555563','can.sari@mail.com'),(10,'Merve','Öztürk','1996-08-14','Kadın',450,'merve_ozturk','98765','05555555564','merve.ozturk@mail.com'),(11,'1','1','2001-01-20','Erkek',0,'1','1','1','1'),(13,'\"','\"','2001-01-01','Kadın',0,'\"','\"','1','\"'),(14,'qwer','qwer','2002-02-20','Erkek',0,'qwer','qwer','qwer','qwer');
/*!40000 ALTER TABLE `kullanıcılar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `siparisdetay`
--

DROP TABLE IF EXISTS `siparisdetay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `siparisdetay` (
  `DetayID` int NOT NULL AUTO_INCREMENT,
  `SiparisID` int NOT NULL,
  `KitapID` int NOT NULL,
  `Adet` int NOT NULL,
  `Fiyat` float NOT NULL,
  `ToplamFiyat` float NOT NULL,
  PRIMARY KEY (`DetayID`),
  KEY `SiparisID` (`SiparisID`),
  KEY `KitapID` (`KitapID`),
  CONSTRAINT `siparisdetay_ibfk_2` FOREIGN KEY (`SiparisID`) REFERENCES `siparisler` (`SiparisID`),
  CONSTRAINT `siparisdetay_ibfk_3` FOREIGN KEY (`KitapID`) REFERENCES `kitaplar` (`KitapID`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `siparisdetay`
--

LOCK TABLES `siparisdetay` WRITE;
/*!40000 ALTER TABLE `siparisdetay` DISABLE KEYS */;
INSERT INTO `siparisdetay` VALUES (1,1,3,1,50,50),(2,1,5,2,50,100),(3,2,7,1,60,60),(4,3,8,2,55,110),(8,5,6,3,60,180),(9,5,7,2,60,120),(10,6,9,1,75,75),(11,7,1,2,65,130),(12,7,3,1,65,65),(13,8,5,1,45,45),(14,8,8,1,45,45),(15,9,6,3,75,225),(16,9,9,3,75,225),(17,10,2,1,55,55),(18,11,2,1,60,60),(19,11,2,1,60,60),(20,11,1,1,45,45),(21,11,13,1,60,60),(22,11,10,1,55,55),(25,12,1,1,45,45),(26,12,2,1,60,60),(27,12,8,1,45,45),(29,12,6,1,75,75),(31,13,5,1,40,40),(32,13,13,1,60,60),(33,14,10,1,55,55),(35,15,3,1,55,55),(36,15,8,1,45,45),(37,15,11,1,50,50),(38,15,9,1,50,50),(39,15,4,1,50,50),(40,15,2,1,60,60),(41,15,1,1,45,45),(42,15,2,1,60,60),(43,16,5,1,40,40),(44,16,10,1,55,55),(45,16,11,1,50,50),(49,16,2,1,60,60),(50,17,3,1,55,55),(51,17,10,1,55,55),(52,17,12,1,45,45),(53,17,3,1,55,55),(54,17,1,1,45,45),(55,17,2,1,60,60),(56,18,5,1,40,40),(57,18,10,1,55,55),(58,18,9,1,50,50),(59,18,1,1,45,45),(60,18,2,1,60,60),(63,19,5,1,40,40),(64,19,4,1,50,50),(65,19,8,1,45,45),(66,20,2,1,60,60),(67,21,6,1,75,75),(68,21,11,1,50,50);
/*!40000 ALTER TABLE `siparisdetay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `siparisler`
--

DROP TABLE IF EXISTS `siparisler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `siparisler` (
  `SiparisID` int NOT NULL AUTO_INCREMENT,
  `KullanıcıID` int NOT NULL,
  `ToplamUrunAdedi` int NOT NULL,
  `ToplamTutar` float NOT NULL,
  `SiparisTarihi` datetime NOT NULL,
  `Completed` bit(1) DEFAULT NULL,
  PRIMARY KEY (`SiparisID`),
  KEY `KullanıcıID` (`KullanıcıID`),
  CONSTRAINT `siparisler_ibfk_1` FOREIGN KEY (`KullanıcıID`) REFERENCES `kullanıcılar` (`KullanıcıID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `siparisler`
--

LOCK TABLES `siparisler` WRITE;
/*!40000 ALTER TABLE `siparisler` DISABLE KEYS */;
INSERT INTO `siparisler` VALUES (1,1,3,150,'2024-12-01 00:00:00',_binary ''),(2,2,1,60,'2024-12-02 00:00:00',_binary ''),(3,3,4,220,'2024-12-03 00:00:00',_binary ''),(4,4,2,100,'2024-12-04 00:00:00',_binary ''),(5,5,5,300,'2024-12-05 00:00:00',_binary ''),(6,6,1,75,'2024-12-06 00:00:00',_binary ''),(7,7,3,195,'2024-12-07 00:00:00',_binary ''),(8,8,2,90,'2024-12-08 00:00:00',_binary ''),(9,9,6,450,'2024-12-09 00:00:00',_binary ''),(10,10,1,55,'2024-12-10 00:00:00',_binary ''),(11,1,7,395,'2025-01-06 00:00:00',_binary ''),(12,1,6,365,'2025-01-08 00:00:00',_binary ''),(13,1,2,100,'2025-01-08 00:00:00',_binary ''),(14,1,2,105,'2025-01-08 00:00:00',_binary ''),(15,1,8,415,'2025-01-08 00:00:00',_binary ''),(16,1,7,375,'2025-01-08 00:00:00',_binary ''),(17,1,6,315,'2025-01-08 00:00:00',_binary ''),(18,1,5,250,'2025-01-08 00:00:00',_binary ''),(19,1,5,225,'2025-01-08 00:00:00',_binary ''),(20,1,1,60,'2025-01-09 00:00:00',_binary ''),(21,1,2,125,'2025-01-09 00:00:00',_binary '\0');
/*!40000 ALTER TABLE `siparisler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yazarlar`
--

DROP TABLE IF EXISTS `yazarlar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `yazarlar` (
  `YazarID` int NOT NULL AUTO_INCREMENT,
  `YazarAdı` varchar(50) NOT NULL,
  `YazarSoyadı` varchar(50) NOT NULL,
  PRIMARY KEY (`YazarID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yazarlar`
--

LOCK TABLES `yazarlar` WRITE;
/*!40000 ALTER TABLE `yazarlar` DISABLE KEYS */;
INSERT INTO `yazarlar` VALUES (1,'Sabahattin','Ali'),(2,'Orhan','Pamuk'),(3,'Elif','Şafak'),(4,'Yaşar','Kemal'),(5,'İhsan','Okur'),(6,'George','Orwell'),(7,'J.K.','Rowling'),(8,'Haruki','Murakami'),(9,'F. Scott','Fitzgerald'),(10,'Jane','Austen'),(11,'Leo','Tolstoy'),(12,'Gabriel','García Márquez'),(13,'Mark','Twain'),(14,'Albert','Camus'),(15,'Franz','Kafka'),(16,'Charles','Dickens'),(17,'Emily','Dickinson'),(18,'William','Shakespeare'),(19,'Virginia','Woolf'),(20,'Oscar','Wilde');
/*!40000 ALTER TABLE `yazarlar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `kullanicisiparisleri`
--

/*!50001 DROP VIEW IF EXISTS `kullanicisiparisleri`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `kullanicisiparisleri` AS select `k`.`KullanıcıID` AS `KullanıcıID`,`k`.`Ad` AS `Ad`,`k`.`Soyad` AS `Soyad`,`s`.`SiparisID` AS `SiparisID`,`s`.`ToplamUrunAdedi` AS `ToplamUrunAdedi`,`s`.`ToplamTutar` AS `ToplamTutar` from (`kullanıcılar` `k` join `siparisler` `s` on((`k`.`KullanıcıID` = `s`.`KullanıcıID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-10 14:04:13
