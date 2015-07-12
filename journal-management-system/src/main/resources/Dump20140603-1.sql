CREATE DATABASE  IF NOT EXISTS `dms` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dms`;
-- MySQL dump 10.13  Distrib 5.5.37, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: dms
-- ------------------------------------------------------
-- Server version	5.5.37-0ubuntu0.13.10.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `FOLDER`
--

DROP TABLE IF EXISTS `FOLDER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FOLDER` (
  `FOLDER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_USER` varchar(255) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `FOLDER_FILE_NAME` longtext,
  `FOLDER_PATH` longtext,
  `PARRENT_ID` bigint(20) DEFAULT NULL,
  `PATH_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`FOLDER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=332 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FOLDER`
--

LOCK TABLES `FOLDER` WRITE;
/*!40000 ALTER TABLE `FOLDER` DISABLE KEYS */;
INSERT INTO `FOLDER` VALUES (272,'b','2014-05-12 06:43:09','kelas1','/ ',0,'0 0'),(288,'b','2014-05-12 15:43:00','maria1','/ ',0,'0 0'),(330,'b','2014-05-12 20:56:27','maria2','/maria1',288,'0 0 288'),(331,'b','2014-05-13 19:42:21','kelas2','/kelas1',272,'0 0 272');
/*!40000 ALTER TABLE `FOLDER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `METADATA`
--

DROP TABLE IF EXISTS `METADATA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `METADATA` (
  `METADATA_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMMENTS` longtext,
  `CREATED_USER` varchar(255) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `DOCUMENT_FILE_NAME` longtext,
  `SIZE` bigint(20) DEFAULT NULL,
  `DOCUMENT_TYPE` varchar(200) DEFAULT NULL,
  `OWNER` varchar(100) NOT NULL,
  `SUBJECT` varchar(255) DEFAULT NULL,
  `UPDATED_DATE` datetime DEFAULT NULL,
  `UPDATED_USER` varchar(255) DEFAULT NULL,
  `PARRENT_ID` bigint(20) DEFAULT NULL,
  `file` tinyblob,
  `content` longblob,
  `ENABLED` int(11) DEFAULT NULL,
  PRIMARY KEY (`METADATA_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `METADATA`
--

LOCK TABLES `METADATA` WRITE;
/*!40000 ALTER TABLE `METADATA` DISABLE KEYS */;
/*!40000 ALTER TABLE `METADATA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PROJECTS`
--

DROP TABLE IF EXISTS `PROJECTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PROJECTS` (
  `PROJECTS_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FOLDER_ID` bigint(20) DEFAULT NULL,
  `USERNAME` varchar(100) DEFAULT NULL,
  `AUTHORITY` varchar(100) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`PROJECTS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROJECTS`
--

LOCK TABLES `PROJECTS` WRITE;
/*!40000 ALTER TABLE `PROJECTS` DISABLE KEYS */;
INSERT INTO `PROJECTS` VALUES (19,272,'c','ROLE_WORKPACKAGE_LEADER',NULL,'2014-05-13 19:30:44'),(20,272,'d','TASK_PARTICIPANT',NULL,'2014-05-14 15:51:10'),(21,272,'f','TASK_PARTICIPANT',NULL,'2014-05-14 15:51:13'),(22,288,'e','ROLE_WORKPACKAGE_LEADER',NULL,'2014-06-02 02:22:01');
/*!40000 ALTER TABLE `PROJECTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PUBLIC_DATA`
--

DROP TABLE IF EXISTS `PUBLIC_DATA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PUBLIC_DATA` (
  `PUBLIC_DATA_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DOCUMENT_FILE_NAME` longtext,
  `CREATED_USER` varchar(255) DEFAULT NULL,
  `DOCUMENT_TYPE` varchar(200) DEFAULT NULL,
  `OWNER` varchar(100) NOT NULL,
  `content` longblob,
  `SIZE` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`PUBLIC_DATA_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PUBLIC_DATA`
--

LOCK TABLES `PUBLIC_DATA` WRITE;
/*!40000 ALTER TABLE `PUBLIC_DATA` DISABLE KEYS */;
/*!40000 ALTER TABLE `PUBLIC_DATA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USERS`
--

DROP TABLE IF EXISTS `USERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USERS` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ENABLED` int(11) DEFAULT NULL,
  `USERNAME` varchar(100) DEFAULT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL,
  `FIRSTNAME` varchar(50) DEFAULT NULL,
  `LASTNAME` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USERS`
--

LOCK TABLES `USERS` WRITE;
/*!40000 ALTER TABLE `USERS` DISABLE KEYS */;
INSERT INTO `USERS` VALUES (1,1,'a','a','Just','user','kelas.spirit@gmail.com'),(2,1,'b','b','ADMIN','ROOT','kelas.spirit@gmail.com'),(3,1,'Kelesidis','182100lol','kelas','Nikolaos','kelas.spirit@gmail.com'),(4,1,'c','c','c','c','kelas.spirit@gmail.com'),(5,1,'d','d','d','d','kelas.spirit@gmail.com'),(6,1,'e','e','e','e','kelas.spirit@gmail.com'),(7,1,'f','f','f','f','kelas.spirit@gmail.com'),(8,1,'g','g','g','g','kelas.spirit@gmail.com'),(9,1,'kelas','182100','kk','lk','kelas.spirit@gmail.com'),(10,1,'lolita','182100','jjk','bhj','kelas.spirit@gmail.com');
/*!40000 ALTER TABLE `USERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_ROLES`
--

DROP TABLE IF EXISTS `USER_ROLES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_ROLES` (
  `USER_ROLE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) DEFAULT NULL,
  `AUTHORITY` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`USER_ROLE_ID`),
  KEY `FK_isqniqpjxwcvf0iip6l1qy0r2` (`USER_ID`),
  CONSTRAINT `FK_isqniqpjxwcvf0iip6l1qy0r2` FOREIGN KEY (`USER_ID`) REFERENCES `USERS` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_ROLES`
--

LOCK TABLES `USER_ROLES` WRITE;
/*!40000 ALTER TABLE `USER_ROLES` DISABLE KEYS */;
INSERT INTO `USER_ROLES` VALUES (1,1,'ROLE_USER'),(2,2,'ROLE_ADMIN'),(3,3,'ROLE_ADMIN'),(4,4,'ROLE_USER'),(5,5,'ROLE_USER'),(7,7,'ROLE_USER'),(8,8,'ROLE_USER'),(10,4,'ROLE_WORKPACKAGE_LEADER'),(20,6,'TASK_PARTICIPANT'),(26,7,'ROLE_COORDINATOR'),(27,5,'TASK_PARTICIPANT'),(28,7,'TASK_PARTICIPANT'),(29,8,'TASK_PARTICIPANT'),(31,4,'ROLE_TECHNICAL_MANAGER'),(36,9,'ROLE_USER'),(37,10,'ROLE_USER'),(39,1,'ROLE_COORDINATOR'),(40,1,'ROLE_TECHNICAL_MANAGER');
/*!40000 ALTER TABLE `USER_ROLES` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-06-03  0:02:12
