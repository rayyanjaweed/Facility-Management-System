CREATE DATABASE  IF NOT EXISTS `fmsdatabase` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `fmsdatabase`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: fmsdatabase
-- ------------------------------------------------------
-- Server version	5.6.23-log

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
-- Table structure for table `address_details`
--

DROP TABLE IF EXISTS `address_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address_details` (
  `facilityID` int(11) NOT NULL,
  `serialNumb` int(11) DEFAULT NULL,
  `zipCode` int(11) DEFAULT NULL,
  `streetName` varchar(50) DEFAULT NULL,
  `cityName` varchar(15) DEFAULT NULL,
  `stateName` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`facilityID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_details`
--

LOCK TABLES `address_details` WRITE;
/*!40000 ALTER TABLE `address_details` DISABLE KEYS */;
INSERT INTO `address_details` VALUES (1,2751,60645,'W Arthur Ave','Chicago','IL'),(2,2752,60645,'W Devon Ave','Chicago','IL'),(3,2753,60645,'N California Ave','Chicago','IL'),(4,2754,60645,'W Belmont Ave','Chicago','IL'),(6,2756,60645,'W Arthur Ave, Lakeshore Hills','Chicago','IL'),(7,2757,60645,'W Devon Ave, New Hills','Chicago','IL'),(9,2888,60648,'E Pearson Ave','Chicago','Illinois');
/*!40000 ALTER TABLE `address_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `building_details`
--

DROP TABLE IF EXISTS `building_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `building_details` (
  `facilityID` int(11) NOT NULL,
  `floors` int(11) DEFAULT NULL,
  `numbOfElevators` int(11) DEFAULT NULL,
  `numbOfEscalators` int(11) DEFAULT NULL,
  `numbOfRooms` int(11) DEFAULT NULL,
  `numbOfStaircases` int(11) DEFAULT NULL,
  `area` decimal(7,4) DEFAULT NULL,
  `buildingID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`buildingID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `building_details`
--

LOCK TABLES `building_details` WRITE;
/*!40000 ALTER TABLE `building_details` DISABLE KEYS */;
INSERT INTO `building_details` VALUES (1,10,4,4,1000,4,155.4500,1),(2,20,6,12,2000,12,218.7700,2),(3,30,8,16,3000,16,384.1400,3),(4,40,10,20,4000,20,499.4500,4),(6,60,12,24,6000,34,655.2100,5),(7,70,20,40,7000,50,715.9900,6),(9,25,7,3,85,5,881.7700,8);
/*!40000 ALTER TABLE `building_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facility_details`
--

DROP TABLE IF EXISTS `facility_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facility_details` (
  `facilityID` int(11) NOT NULL AUTO_INCREMENT,
  `facilityName` varchar(80) NOT NULL,
  `floorNumb` int(11) DEFAULT '0',
  `roomNumb` int(11) DEFAULT '0',
  `capacity` int(11) DEFAULT NULL,
  `isAvailable` tinyint(1) DEFAULT NULL,
  `isBuilding` tinyint(1) DEFAULT NULL,
  `facilityDetail` varchar(800) DEFAULT NULL,
  `isInUseNow` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`facilityID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility_details`
--

LOCK TABLES `facility_details` WRITE;
/*!40000 ALTER TABLE `facility_details` DISABLE KEYS */;
INSERT INTO `facility_details` VALUES (1,'TestName',0,0,25880,1,0,NULL,0),(2,'TestName55',0,0,2584580,1,0,NULL,0),(3,'TestNamewer55',0,0,2584580,1,0,NULL,0),(4,'Nice Place. Good Facility',3,302,150,1,0,NULL,0),(6,'Meeting Room',8,841,5000,1,0,NULL,0),(7,'New Fun Hall',8,852,100,1,0,NULL,0),(9,'Final Facility',1,144,200,1,1,NULL,0);
/*!40000 ALTER TABLE `facility_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facility_use_details`
--

DROP TABLE IF EXISTS `facility_use_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facility_use_details` (
  `bookingID` int(11) NOT NULL AUTO_INCREMENT,
  `facilityID` int(11) NOT NULL,
  `bookingDate` date DEFAULT NULL,
  `bookedBy` int(11) DEFAULT NULL,
  `numbOfSeats` int(11) DEFAULT NULL,
  PRIMARY KEY (`bookingID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility_use_details`
--

LOCK TABLES `facility_use_details` WRITE;
/*!40000 ALTER TABLE `facility_use_details` DISABLE KEYS */;
INSERT INTO `facility_use_details` VALUES (1,1,'2015-04-25',2,100),(2,2,'2015-04-25',1,100),(3,2,'2015-07-25',3,15),(6,2,'2015-07-29',3,2584580),(7,2,'2010-01-01',3,2584580),(8,2,'2010-01-05',3,2584580),(9,2,'2010-01-10',3,2584580),(10,2,'2010-01-11',3,2584580),(11,2,'2022-01-11',3,2584580),(13,6,'2033-03-25',1,100),(14,2,'2015-07-22',3,2584580),(15,6,'2015-07-22',3,5000);
/*!40000 ALTER TABLE `facility_use_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maintenance_details`
--

DROP TABLE IF EXISTS `maintenance_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maintenance_details` (
  `maintenanceID` int(11) NOT NULL AUTO_INCREMENT,
  `facilityID` int(11) DEFAULT NULL,
  `bookingID` int(11) DEFAULT NULL,
  `cost` decimal(15,4) DEFAULT NULL,
  `downTimeDays` decimal(7,4) DEFAULT NULL,
  PRIMARY KEY (`maintenanceID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maintenance_details`
--

LOCK TABLES `maintenance_details` WRITE;
/*!40000 ALTER TABLE `maintenance_details` DISABLE KEYS */;
INSERT INTO `maintenance_details` VALUES (4,2,10,2588580.0000,80.0000),(5,2,11,2588580.0000,80.0000),(17,2,14,2588580.0000,80.0000),(18,6,15,5000.0000,0.0000);
/*!40000 ALTER TABLE `maintenance_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_details`
--

DROP TABLE IF EXISTS `user_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_details` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `emailID` varchar(50) DEFAULT NULL,
  `firstName` varchar(15) DEFAULT NULL,
  `middleName` varchar(15) DEFAULT NULL,
  `lastName` varchar(15) DEFAULT NULL,
  `mobNumber` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_details`
--

LOCK TABLES `user_details` WRITE;
/*!40000 ALTER TABLE `user_details` DISABLE KEYS */;
INSERT INTO `user_details` VALUES (1,'rayyanjaweed@yahoo.com','Rayyan','Mohammed','Jaweed',3129187994),(2,'rayyanjaweed@gmail.com','Rayyan','Mohammed','Jaweed',3129187998),(3,'rayyanjaweednew@gmail.com','Rayyan','Mohammed','Jaweed',3129187993),(4,'ronaldinho@gmail.com','Ronaldinho','','Gaucho',3129147922),(5,'messi@gmail.com','Messi','','Lionel',3125437966),(6,'iniesta@gmail.com','Andres','','Iniesta',3125437983);
/*!40000 ALTER TABLE `user_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-02  9:47:03
