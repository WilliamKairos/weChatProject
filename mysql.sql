-- MySQL dump 10.13  Distrib 8.1.0, for macos14.0 (arm64)
--
-- Host: 127.0.0.1    Database: wechat
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity` (
  `id` varchar(50) NOT NULL,
  `title` varchar(50) NOT NULL,
  `photo` varchar(100) DEFAULT NULL,
  `activity_date` datetime NOT NULL,
  `originator` varchar(20) NOT NULL,
  `init_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Registrant`
--

DROP TABLE IF EXISTS `Registrant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Registrant` (
  `uid` varchar(10) NOT NULL,
  `avatar` varchar(50) NOT NULL,
  `emp_info` varchar(50) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `age` int NOT NULL,
  `date_of_birth` varchar(20) NOT NULL,
  `identity` varchar(50) NOT NULL,
  `ic` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `nickname` varchar(20) NOT NULL,
  `material` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Registrant`
--

LOCK TABLES `Registrant` WRITE;
/*!40000 ALTER TABLE `Registrant` DISABLE KEYS */;
INSERT INTO `Registrant` VALUES ('1','avatar_1.jpg','emp_info_1','123-456-7890',28,'1995-07-15','Identity_A','IC123456','John','Johnny','Material_1'),('2','avatar_2.jpg','emp_info_2','987-654-3210',35,'1988-03-22','Identity_B','IC987654','Jane','Janey','Material_2'),('3','avatar_url_here','Employee info','1234567890',30,'1993-08-31 08:00:00','Employee','123456789012345','John Doe','JDjjj','[\"material1\",\"material2\",\"material3\"]'),('4','avatar_4.jpg','emp_info_4','222-333-4444',22,'2001-09-03','Identity_A','IC222333','Emily','Emmy','Material_3');
/*!40000 ALTER TABLE `Registrant` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-10 20:55:50
