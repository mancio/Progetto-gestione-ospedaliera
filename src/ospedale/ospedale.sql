-- MySQL dump 10.13  Distrib 5.5.24, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: ospedale
-- ------------------------------------------------------
-- Server version	5.5.24-0ubuntu0.12.04.1

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
-- Table structure for table `prenotazioni`
--

DROP TABLE IF EXISTS `prenotazioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prenotazioni` (
  `idprenotazione` int(11) NOT NULL AUTO_INCREMENT,
  `reparto` varchar(20) NOT NULL,
  `data` date NOT NULL,
  `ora` varchar(5) NOT NULL,
  `priorita` tinyint(1) DEFAULT NULL,
  `idpaziente` varchar(16) NOT NULL,
  PRIMARY KEY (`idprenotazione`),
  KEY `idpaziente` (`idpaziente`),
  CONSTRAINT `prenotazioni_ibfk_1` FOREIGN KEY (`idpaziente`) REFERENCES `utenti` (`cod_fisc`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazioni`
--

LOCK TABLES `prenotazioni` WRITE;
/*!40000 ALTER TABLE `prenotazioni` DISABLE KEYS */;
/*!40000 ALTER TABLE `prenotazioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prenotazioni1`
--

DROP TABLE IF EXISTS `prenotazioni1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prenotazioni1` (
  `idprenotazione` int(11) NOT NULL AUTO_INCREMENT,
  `reparto` varchar(20) NOT NULL,
  `data` date NOT NULL,
  `ora` varchar(5) NOT NULL,
  `priorita` tinyint(1) DEFAULT NULL,
  `idpaziente` varchar(16) NOT NULL,
  PRIMARY KEY (`idprenotazione`),
  KEY `idpaziente` (`idpaziente`),
  CONSTRAINT `prenotazioni1_ibfk_1` FOREIGN KEY (`idpaziente`) REFERENCES `utenti` (`cod_fisc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazioni1`
--

LOCK TABLES `prenotazioni1` WRITE;
/*!40000 ALTER TABLE `prenotazioni1` DISABLE KEYS */;
/*!40000 ALTER TABLE `prenotazioni1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `referti`
--

DROP TABLE IF EXISTS `referti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `referti` (
  `idprenotazione` int(11) NOT NULL,
  `cod_fisc` varchar(16) NOT NULL,
  `referto` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`idprenotazione`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `referti`
--

LOCK TABLES `referti` WRITE;
/*!40000 ALTER TABLE `referti` DISABLE KEYS */;
/*!40000 ALTER TABLE `referti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `referti1`
--

DROP TABLE IF EXISTS `referti1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `referti1` (
  `idprenotazione` int(11) NOT NULL,
  `cod_fisc` varchar(16) NOT NULL,
  `referto` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`idprenotazione`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `referti1`
--

LOCK TABLES `referti1` WRITE;
/*!40000 ALTER TABLE `referti1` DISABLE KEYS */;
/*!40000 ALTER TABLE `referti1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utenti`
--

DROP TABLE IF EXISTS `utenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utenti` (
  `cod_fisc` varchar(16) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telefono` varchar(20) NOT NULL,
  `residenza` varchar(100) NOT NULL,
  `is_admin` tinyint(1) NOT NULL,
  PRIMARY KEY (`cod_fisc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utenti`
--

LOCK TABLES `utenti` WRITE;
/*!40000 ALTER TABLE `utenti` DISABLE KEYS */;
INSERT INTO `utenti` VALUES ('admin1','Alessandro','admin1',NULL,'00000000','Bologna',1),('admin2','Andrea','admin2',NULL,'11111111','Bologna',1),('admin3','Claudio','admin3',NULL,'22222222','Bologna',1),('admin4','Luca','admin4',NULL,'33333333','Bologna',1);
/*!40000 ALTER TABLE `utenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visite`
--

DROP TABLE IF EXISTS `visite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `visite` (
  `reparto` varchar(9) NOT NULL,
  `data` date NOT NULL,
  `ora` varchar(5) NOT NULL,
  `priorita` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`reparto`,`data`,`ora`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visite`
--

LOCK TABLES `visite` WRITE;
/*!40000 ALTER TABLE `visite` DISABLE KEYS */;
INSERT INTO `visite` VALUES ('ortopedia','2012-06-28','08:00',1),('ortopedia','2012-06-28','08:30',1),('ortopedia','2012-06-28','09:00',1),('ortopedia','2012-06-28','09:30',1),('ortopedia','2012-06-28','10:00',0),('ortopedia','2012-06-28','10:30',0),('ortopedia','2012-06-28','11:00',0),('ortopedia','2012-06-28','11:30',0),('ortopedia','2012-06-28','12:00',0),('ortopedia','2012-06-28','12:30',0),('ortopedia','2012-06-28','13:00',0),('ortopedia','2012-06-28','13:30',0),('ortopedia','2012-06-29','08:00',1),('ortopedia','2012-06-29','08:30',1),('ortopedia','2012-06-29','09:00',1),('ortopedia','2012-06-29','09:30',1),('ortopedia','2012-06-29','10:00',0),('ortopedia','2012-06-29','10:30',0),('ortopedia','2012-06-29','11:00',0),('ortopedia','2012-06-29','11:30',0),('ortopedia','2012-06-29','12:00',0),('ortopedia','2012-06-29','12:30',0),('ortopedia','2012-06-29','13:00',0),('ortopedia','2012-06-29','13:30',0),('ortopedia','2012-06-30','08:00',1),('ortopedia','2012-06-30','08:30',1),('ortopedia','2012-06-30','09:00',1),('ortopedia','2012-06-30','09:30',1),('ortopedia','2012-06-30','10:00',0),('ortopedia','2012-06-30','10:30',0),('ortopedia','2012-06-30','11:00',0),('ortopedia','2012-06-30','11:30',0),('ortopedia','2012-06-30','12:00',0),('ortopedia','2012-06-30','12:30',0),('ortopedia','2012-06-30','13:00',0),('ortopedia','2012-06-30','13:30',0),('ortopedia','2012-07-01','08:00',1),('ortopedia','2012-07-01','08:30',1),('ortopedia','2012-07-01','09:00',1),('ortopedia','2012-07-01','09:30',1),('ortopedia','2012-07-01','10:00',0),('ortopedia','2012-07-01','10:30',0),('ortopedia','2012-07-01','11:00',0),('ortopedia','2012-07-01','11:30',0),('ortopedia','2012-07-01','12:00',0),('ortopedia','2012-07-01','12:30',0),('ortopedia','2012-07-01','13:00',0),('ortopedia','2012-07-01','13:30',0),('pediatria','2012-06-28','08:00',1),('pediatria','2012-06-28','08:30',1),('pediatria','2012-06-28','09:00',1),('pediatria','2012-06-28','09:30',1),('pediatria','2012-06-28','10:00',0),('pediatria','2012-06-28','10:30',0),('pediatria','2012-06-28','11:00',0),('pediatria','2012-06-28','11:30',0),('pediatria','2012-06-28','12:00',0),('pediatria','2012-06-28','12:30',0),('pediatria','2012-06-28','13:00',0),('pediatria','2012-06-28','13:30',0),('pediatria','2012-06-29','08:00',1),('pediatria','2012-06-29','08:30',1),('pediatria','2012-06-29','09:00',1),('pediatria','2012-06-29','09:30',1),('pediatria','2012-06-29','10:00',0),('pediatria','2012-06-29','10:30',0),('pediatria','2012-06-29','11:00',0),('pediatria','2012-06-29','11:30',0),('pediatria','2012-06-29','12:00',0),('pediatria','2012-06-29','12:30',0),('pediatria','2012-06-29','13:00',0),('pediatria','2012-06-29','13:30',0),('pediatria','2012-06-30','08:00',1),('pediatria','2012-06-30','08:30',1),('pediatria','2012-06-30','09:00',1),('pediatria','2012-06-30','09:30',1),('pediatria','2012-06-30','10:00',0),('pediatria','2012-06-30','10:30',0),('pediatria','2012-06-30','11:00',0),('pediatria','2012-06-30','11:30',0),('pediatria','2012-06-30','12:00',0),('pediatria','2012-06-30','12:30',0),('pediatria','2012-06-30','13:00',0),('pediatria','2012-06-30','13:30',0),('pediatria','2012-07-01','08:00',1),('pediatria','2012-07-01','08:30',1),('pediatria','2012-07-01','09:00',1),('pediatria','2012-07-01','09:30',1),('pediatria','2012-07-01','10:00',0),('pediatria','2012-07-01','10:30',0),('pediatria','2012-07-01','11:00',0),('pediatria','2012-07-01','11:30',0),('pediatria','2012-07-01','12:00',0),('pediatria','2012-07-01','12:30',0),('pediatria','2012-07-01','13:00',0),('pediatria','2012-07-01','13:30',0);
/*!40000 ALTER TABLE `visite` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-06-14 12:52:39
