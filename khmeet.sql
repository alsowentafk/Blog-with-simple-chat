-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: khmeet
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `text` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL,
  `contacts` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `category` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`article_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (6,'Lorem ipsum dolor','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Magna etiam tempor orci eu lobortis elementum nibh tellus. Purus ut faucibus pulvinar elementum integer enim. Vitae semper quis lectus nulla at volutpat. Massa placerat duis ultricies lacus sed turpis tincidunt id. Iaculis eu non diam phasellus vestibulum. Duis convallis convallis tellus id interdum velit. Libero volutpat sed cras ornare. Gravida dictum fusce ut placerat orci nulla pellentesque dignissim. Gravida arcu ac tortor dignissim convallis aenean et tortor. Mauris ultrices eros in cursus turpis massa.','2019-11-30 13:40:41','65654645654654',7,'bmw_325i_e30_belyj_avto_93276_1920x1080.jpg','Подорожі'),(7,'Sapien et ligula ullamcorper','Sapien et ligula ullamcorper malesuada. Urna et pharetra pharetra massa massa ultricies mi quis. Congue quisque egestas diam in. Leo vel orci porta non pulvinar neque. Mauris a diam maecenas sed enim ut sem viverra aliquet. Nibh sit amet commodo nulla facilisi nullam vehicula ipsum a. Congue nisi vitae suscipit tellus mauris. Neque convallis a cras semper auctor neque vitae tempus quam. Proin libero nunc consequat interdum varius sit. Sit amet commodo nulla facilisi. Amet consectetur adipiscing elit duis tristique sollicitudin nibh sit amet. Consectetur libero id faucibus nisl tincidunt eget nullam non nisi. Metus vulputate eu scelerisque felis. Phasellus faucibus scelerisque eleifend donec pretium.','2019-11-30 13:41:39','jkasdf - 4654654',7,'porsche_911_turbo_997_black_front_porshe_chyornyj_solntse_gazon_bliki_94733_1920x1080.jpg','Спорт'),(8,'Sit amet risus nullam','Nunc scelerisque viverra mauris','2019-11-30 13:42:23','wafwqfsadfasfd',1,'ozero_bereg_derevia_150723_1920x1080.jpg','Домашні улюбленці'),(9,'Lacus suspendisse faucibu','Lacus suspendisse faucibus interdum posuere lorem ipsum. Sed sed risus pretium quam vulputate dignissim suspendisse. Tempor commodo ullamcorper a lacus vestibulum sed. Congue quisque egestas diam in. Id faucibus nisl tincidunt eget nullam non nisi est. Leo integer malesuada nunc vel risus commodo. Urna id volutpat lacus laoreet non. Vitae proin sagittis nisl rhoncus mattis rhoncus urna. Ut tellus elementum sagittis vitae et leo. Pellentesque sit amet porttitor eget dolor morbi non. Auctor neque vitae tempus quam pellentesque. Non odio euismod lacinia at quis. In dictum non consectetur a erat nam at lectus urna. Vel risus commodo viverra maecenas accumsan lacus.','2019-11-30 13:42:53','65465465456',1,'bashnia_neboskreb_gorod_151445_1920x1080.jpg','Настільні ігри'),(10,'asdfasdfasdfasdf','sadfasdfasdfsadf','2019-12-02 07:20:39','234132412424',8,'peshchera_kanon_temnyj_150634_1920x1080.jpg','Настільні ігри');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `confirmation_token`
--

DROP TABLE IF EXISTS `confirmation_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `confirmation_token` (
  `token_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `created_date` datetime NOT NULL,
  `confirmation_token` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`token_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `confirmation_token_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `confirmation_token`
--

LOCK TABLES `confirmation_token` WRITE;
/*!40000 ALTER TABLE `confirmation_token` DISABLE KEYS */;
INSERT INTO `confirmation_token` VALUES (2,5,'2019-11-26 11:38:09','f58720e8-95a8-4b6f-9492-fc4b17bd315e'),(4,7,'2019-11-29 08:45:55','96d9ce26-7676-4907-8568-721776214df3'),(5,8,'2019-12-02 07:17:40','b11ee864-aeac-422a-8656-4460d2553152');
/*!40000 ALTER TABLE `confirmation_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorites`
--

DROP TABLE IF EXISTS `favorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorites` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `th_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `type_id` (`th_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `favorites_ibfk_1` FOREIGN KEY (`th_id`) REFERENCES `type_hobby` (`th_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `favorites_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorites`
--

LOCK TABLES `favorites` WRITE;
/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hashtags`
--

DROP TABLE IF EXISTS `hashtags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hashtags` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hobby_id` int(11) NOT NULL,
  `article_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `article_id` (`article_id`),
  KEY `hobby_id` (`hobby_id`),
  CONSTRAINT `hashtags_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `hashtags_ibfk_2` FOREIGN KEY (`hobby_id`) REFERENCES `hobby` (`hobby_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hashtags`
--

LOCK TABLES `hashtags` WRITE;
/*!40000 ALTER TABLE `hashtags` DISABLE KEYS */;
/*!40000 ALTER TABLE `hashtags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hobby`
--

DROP TABLE IF EXISTS `hobby`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hobby` (
  `hobby_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `th_id` int(11) NOT NULL,
  PRIMARY KEY (`hobby_id`),
  KEY `hobby_ibfk_1` (`th_id`),
  CONSTRAINT `hobby_ibfk_1` FOREIGN KEY (`th_id`) REFERENCES `type_hobby` (`th_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hobby`
--

LOCK TABLES `hobby` WRITE;
/*!40000 ALTER TABLE `hobby` DISABLE KEYS */;
/*!40000 ALTER TABLE `hobby` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_hobby`
--

DROP TABLE IF EXISTS `type_hobby`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_hobby` (
  `th_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`th_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_hobby`
--

LOCK TABLES `type_hobby` WRITE;
/*!40000 ALTER TABLE `type_hobby` DISABLE KEYS */;
/*!40000 ALTER TABLE `type_hobby` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `birthday` datetime DEFAULT NULL,
  `about` text COLLATE utf8mb4_unicode_ci,
  `phone` text COLLATE utf8mb4_unicode_ci,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `is_confirmed` tinyint(1) NOT NULL,
  `role` enum('admin','user') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'guest','2010-01-01 00:00:00',NULL,'26465656564','guest@gmail.com',0,'admin','24912491','Battlefield-4.jpg'),(5,'Yegor',NULL,NULL,NULL,'oxcworld@gmail.com',0,'admin','159357',NULL),(7,'dima',NULL,NULL,NULL,'asdfasdf@gmail.com',1,'admin','2491249131','Need-for-Speed-Heat-Digital-Deluxe-Upgrade.png'),(8,'guestguest',NULL,NULL,NULL,'supremecdgtnf@gmail.com',1,'admin','2491','skaly_volny_vid_sverhu_151222_1920x1080.jpg');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-05 13:28:47
