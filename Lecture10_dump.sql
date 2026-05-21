CREATE DATABASE  IF NOT EXISTS `lecture10` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `lecture10`;
-- MariaDB dump 10.19  Distrib 10.4.32-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: lecture10
-- ------------------------------------------------------
-- Server version	10.4.32-MariaDB

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
-- Table structure for table `d_device`
--

DROP TABLE IF EXISTS `d_device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `d_device` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `d_room` varchar(255) DEFAULT NULL,
  `d_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `d_device`
--

LOCK TABLES `d_device` WRITE;
/*!40000 ALTER TABLE `d_device` DISABLE KEYS */;
INSERT INTO `d_device` VALUES (1,'OP-Saal 1','Anästhesiegerät'),(2,'OP-Saal 2','Chirurgischer Roboter'),(3,'Intensivstation A','Beatmungsgerät'),(4,'Intensivstation A','Patientenmonitor'),(5,'Intensivstation B','Infusionspumpe'),(6,'Radiologie','MRT-Gerät'),(7,'Radiologie','CT-Scanner'),(8,'Radiologie','Röntgengerät'),(9,'Kardiologie','EKG-Gerät'),(10,'Kardiologie','Defibrillator'),(11,'Notaufnahme','AED (Automatischer Defibrillator)'),(12,'Notaufnahme','Blutdruckmessgerät'),(13,'Labor','Zentrifuge'),(14,'Labor','Blutanalysegerät'),(15,'Physiotherapie','Ultraschall-Therapiegerät'),(16,'Raum A101','MRT'),(17,'Raum B202','CT'),(18,'Raum C303','Röntgen'),(19,'Raum D404','Ultraschall'),(20,'Raum E505','EKG');
/*!40000 ALTER TABLE `d_device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `p_patient`
--

DROP TABLE IF EXISTS `p_patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `p_patient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `p_birth` date DEFAULT NULL,
  `p_gender` varchar(1) DEFAULT NULL,
  `p_ssn` bigint(20) DEFAULT NULL,
  `p_sname` varchar(255) DEFAULT NULL,
  `p_vname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `p_patient`
--

LOCK TABLES `p_patient` WRITE;
/*!40000 ALTER TABLE `p_patient` DISABLE KEYS */;
INSERT INTO `p_patient` VALUES (1,'0001-03-10','M',4078310808,'Abghel','Dragos'),(2,'2008-09-30','O',1238010190,'Vozarevic','Mateja '),(3,'0001-02-22','M',4078310808,'Abghel','Dragos'),(4,'2009-04-12','M',4078310808,'Anghel','Dragos'),(5,'2009-04-12','M',4078310808,'Anghel','Dragos'),(6,'2009-07-22','M',4078310808,'Aslanoglu','Mehmet akif'),(7,'1985-03-12','M',12345678901,'Müller','Max'),(8,'1992-07-25','F',23456789012,'Schmidt','Anna'),(9,'1978-11-05','M',34567890123,'Huber','Thomas'),(10,'2000-01-17','F',45678901234,'Wagner','Lisa'),(11,'1965-09-30','M',56789012345,'Gruber','Josef');
/*!40000 ALTER TABLE `p_patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_reservation`
--

DROP TABLE IF EXISTS `r_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `r_d_id` int(11) DEFAULT NULL,
  `r_p_id` int(11) DEFAULT NULL,
  `date` DATETIME DEFAULT NULL,
  `r_bodyregion` varchar(255) DEFAULT NULL,
  `r_comments` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdfmwnjtdc0e4maxawa5s6yvyq` (`r_d_id`),
  KEY `FKmbcx6havn8tuiax1yppmvw6va` (`r_p_id`),
  CONSTRAINT `FKdfmwnjtdc0e4maxawa5s6yvyq` FOREIGN KEY (`r_d_id`) REFERENCES `d_device` (`id`),
  CONSTRAINT `FKmbcx6havn8tuiax1yppmvw6va` FOREIGN KEY (`r_p_id`) REFERENCES `p_patient` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_reservation`
--

LOCK TABLES `r_reservation` WRITE;
/*!40000 ALTER TABLE `r_reservation` DISABLE KEYS */;
INSERT INTO `r_reservation` VALUES (1,9,6,'2020-04-12','Thorax','Yes'),(2,1,1,'2026-05-01 09:00','Kopf','Routineuntersuchung'),(3,2,2,'2026-05-01 10:30','Brustkorb','Verdacht auf Infektion'),(4,3,3,'2026-05-02 14:00','Arm','Frakturkontrolle'),(5,4,4,'2026-05-03 08:15','Bauch','Ultraschall Check'),(6,5,5,'2026-05-03 11:45','Herz','EKG Belastungstest'),(7,1,2,'2026-05-04 13:00','Wirbelsäule','Schmerzen im unteren Rücken'),(8,2,3,'2026-05-04 15:30','Lunge','Kontrolltermin');
/*!40000 ALTER TABLE `r_reservation` ENABLE KEYS */;
UNLOCK TABLES;
#Testdata
-- d_device (Geräte)
INSERT INTO `d_device` (`d_room`, `d_type`) VALUES
                                                ('OP-Saal 3', 'Laparoskop'),
                                                ('Intensivstation C', 'Beatmungsgerät'),
                                                ('Neurologie', 'EEG-Gerät'),
                                                ('Dermatologie', 'Lasertherapiegerät'),
                                                ('Raum F606', 'Ultraschall');

-- p_patient (Patienten)
INSERT INTO `p_patient` (`p_birth`, `p_gender`, `p_ssn`, `p_sname`, `p_vname`) VALUES
                                                                                   ('1990-06-15', 'F', 67890123456, 'Fischer', 'Laura'),
                                                                                   ('1975-11-23', 'M', 78901234567, 'Bauer', 'Klaus'),
                                                                                   ('2001-03-08', 'F', 89012345678, 'Wolf', 'Sophie'),
                                                                                   ('1988-09-14', 'O', 90123456789, 'Becker', 'Alex'),
                                                                                   ('1955-01-30', 'M', 10111213141, 'Schwarz', 'Hans');

-- r_reservation (Reservierungen) – referenziert bestehende + neue IDs
INSERT INTO `r_reservation` (`r_d_id`, `r_p_id`, `date`, `r_bodyregion`, `r_comments`) VALUES
                                                                                           (6,  7,  '2026-05-05 09:00', 'Knie',        'MRT nach Sportverletzung'),
                                                                                           (7,  8,  '2026-05-05 11:00', 'Schädel',     'CT Kontrolltermin'),
                                                                                           (9,  9,  '2026-05-06 08:30', 'Herz',        'Rhythmusstörung abklären'),
                                                                                           (10, 10, '2026-05-06 10:00', 'Thorax',      'Defi-Check nach Ohnmacht'),
                                                                                           (8,  11, '2026-05-07 13:15', 'Bauch',       'Röntgen nach Sturz'),
                                                                                           (21, 12, '2026-05-08 09:45', 'Bein',        'Laparoskopie Vorbesprechung'),
                                                                                           (22, 13, '2026-05-08 14:00', 'Gehirn',      'EEG Erstuntersuchung');
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-04-30 20:57:39
