-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sys
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `programari`
--

DROP TABLE IF EXISTS `programari`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `programari` (
  `id_programari` int NOT NULL AUTO_INCREMENT,
  `id_doctor` int NOT NULL,
  `id_pacient` int NOT NULL,
  `data_programare` datetime NOT NULL,
  PRIMARY KEY (`id_programari`),
  KEY `id_doctor_idx` (`id_doctor`),
  KEY `id_pacient_idx` (`id_pacient`),
  CONSTRAINT `id_doctor` FOREIGN KEY (`id_doctor`) REFERENCES `personalcentrumedical` (`id_doctor`) ON DELETE CASCADE,
  CONSTRAINT `id_pacient` FOREIGN KEY (`id_pacient`) REFERENCES `pacienti` (`id_pacient`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programari`
--

LOCK TABLES `programari` WRITE;
/*!40000 ALTER TABLE `programari` DISABLE KEYS */;
INSERT INTO `programari` VALUES (1,1,1,'2021-01-20 12:30:00'),(2,1,1,'2022-08-09 03:00:00'),(3,1,1,'2022-08-10 03:00:00'),(4,2,1,'2020-10-10 03:00:00'),(5,1,1,'2021-10-10 03:00:00'),(6,2,1,'2022-10-10 03:00:00'),(7,1,1,'2021-10-10 03:00:00'),(8,1,1,'2021-10-10 03:00:00'),(9,1,1,'2021-10-10 03:00:00'),(10,1,1,'2021-10-10 03:00:00'),(11,1,1,'2021-10-10 03:00:00'),(12,1,1,'2021-10-10 03:00:00'),(13,1,1,'2021-10-10 03:00:00'),(14,1,5,'2021-08-26 03:00:00'),(15,1,5,'2021-08-29 03:00:00'),(16,2,2,'2021-08-30 10:00:00');
/*!40000 ALTER TABLE `programari` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-25 11:16:47
