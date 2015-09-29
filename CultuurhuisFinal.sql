CREATE DATABASE  IF NOT EXISTS `cultuurhuis` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cultuurhuis`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: cultuurhuis
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
-- Table structure for table `genres`
--

DROP TABLE IF EXISTS `genres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genres` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `naam` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `naam` (`naam`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genres`
--

LOCK TABLES `genres` WRITE;
/*!40000 ALTER TABLE `genres` DISABLE KEYS */;
INSERT INTO `genres` VALUES (10,'Circustheater'),(6,'Dans'),(5,'Familievoorstelling'),(1,'Humor'),(8,'Modern klassiek'),(7,'Multimedia'),(3,'Muziek'),(9,'Muziektheater'),(2,'Theater'),(4,'Wereldmuziek');
/*!40000 ALTER TABLE `genres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `klanten`
--

DROP TABLE IF EXISTS `klanten`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `klanten` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `voornaam` varchar(50) NOT NULL,
  `familienaam` varchar(50) NOT NULL,
  `straat` varchar(50) NOT NULL,
  `huisnr` varchar(50) NOT NULL,
  `postcode` varchar(50) NOT NULL,
  `gemeente` varchar(50) NOT NULL,
  `gebruikersnaam` varchar(50) NOT NULL,
  `paswoord` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `gebruikersnaam` (`gebruikersnaam`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `klanten`
--

LOCK TABLES `klanten` WRITE;
/*!40000 ALTER TABLE `klanten` DISABLE KEYS */;
INSERT INTO `klanten` VALUES (1,'Hans','Desmet','Keizerslaan','7','1000','Brussel','hans','bolle',''),(2,'Alexandra','Blondeel','Anspachlaan','65','1000','Brussel','alexandra','belle','');
/*!40000 ALTER TABLE `klanten` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opvoeringen`
--

DROP TABLE IF EXISTS `opvoeringen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opvoeringen` (
  `id` int(11) unsigned NOT NULL,
  `datum` datetime NOT NULL,
  `prijs` decimal(10,2) NOT NULL,
  `vrijeplaatsen` int(11) unsigned NOT NULL,
  `voorstellingsid` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_opvoeringen_voorstellingsid_idx` (`voorstellingsid`),
  CONSTRAINT `FK_opvoeringen_voorstellingsid` FOREIGN KEY (`voorstellingsid`) REFERENCES `voorstellingen` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opvoeringen`
--

LOCK TABLES `opvoeringen` WRITE;
/*!40000 ALTER TABLE `opvoeringen` DISABLE KEYS */;
/*!40000 ALTER TABLE `opvoeringen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservaties`
--

DROP TABLE IF EXISTS `reservaties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservaties` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `klantid` int(11) unsigned NOT NULL,
  `plaatsen` int(11) unsigned NOT NULL,
  `opvoeringsid` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_reservaties_klanten` (`klantid`),
  KEY `FK_reservaties_opvoeringsid_idx` (`opvoeringsid`),
  CONSTRAINT `FK_reservaties_klanten` FOREIGN KEY (`klantid`) REFERENCES `klanten` (`id`),
  CONSTRAINT `FK_reservaties_opvoeringsid` FOREIGN KEY (`opvoeringsid`) REFERENCES `opvoeringen` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservaties`
--

LOCK TABLES `reservaties` WRITE;
/*!40000 ALTER TABLE `reservaties` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservaties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voorstellingen`
--

DROP TABLE IF EXISTS `voorstellingen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `voorstellingen` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `titel` varchar(50) NOT NULL,
  `uitvoerders` varchar(50) NOT NULL,
  `genreid` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_voorstellingen_genres` (`genreid`),
  CONSTRAINT `FK_voorstellingen_genres` FOREIGN KEY (`genreid`) REFERENCES `genres` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voorstellingen`
--

LOCK TABLES `voorstellingen` WRITE;
/*!40000 ALTER TABLE `voorstellingen` DISABLE KEYS */;
INSERT INTO `voorstellingen` VALUES (1,'Rechtstreeks & integraal/Ka-Boom!','Neveneffecten / Alex Agnew',1),(2,'De leeuw van Vlaanderen','Union Suspecte / Publiekstheater',2),(3,'Ano Neko','Dobet Gnahoré',4),(4,'Professor Bernhardi','de Roovers',2),(5,'Ich bin wie du','het Toneelhuis',2),(6,'Randschade','fABULEUS',5),(7,'Koning Lear','Tonic',2),(8,'Van alle landen thuis','Els Helewaut,D.Van Esbroeck & co',3),(9,'Ma - Earth','Akram Khan',6),(10,'Jerusalem','Berlin',7),(11,'De fijnste dagen van het jaar','Het Paleis/Jenny',5),(12,'Cancion de un amorio','Bodicxhel',4),(13,'Moest ik van u zijn','Wouter Deprez  ',1),(14,'Poézique cabaret','La compagnie du chien qui tousse',1),(15,'Eekhoornbrood','Lampe',2),(16,'Liederen v. Baert, Debussy, Chausson, Weill','Bernard Baert & Anna Pardon',8),(17,'L\"Hafa','Union Suspecte',2),(18,'Achter \'t eten','Ceremonia/Het muziek Lod/Theater Zuidpool',3),(19,'Poulenc / Stravinsky','Prometheus Ensemble',8),(20,'Lied der rusteloosheid','Eva De Roovere, Pedro Moutinho & G. de Mol',4),(21,'Wilde dingen','Kopergietery    ',5),(22,'Licht','Bos',7),(23,'Een hond in de nacht','Speeltheater Holland',5),(24,'Gloed','theater Malpertuis',2),(25,'To speak or not to speak','Spectra Ensemble',8),(26,'Tres cultures por la paz','Rosa Zaragoza',4),(27,'Zouff!','Les Argonautes',10),(28,'La cucina dell\"arte ','David & Danny Ronaldo',10),(29,'Speelt Rzewski','Frederic Rzewski',8),(30,'Tv-tunes K.N.T.','Wim Opbrouck & Maandacht',3),(31,'Schone woorden klinken zo...','Warre Borgmans & Jokke Schreurs',3),(32,'White Light White Heat - The Velvet Undergr.','Bea Van der Maat & Dr Kloot Per W',3),(33,'Het gaat toch rap','Raf Coppens',1),(34,'Emilia Galotti','Tijd',2),(35,'Iets over de liefde','theater Malpertuis',2),(36,'Hendrickx, Xenakis & Tan Dun','Spiegel Strijkkwartet',8),(37,'Cry like a man, part 2','J. Blaute, Paul Michiels & Roland',3),(38,'De Kreutzersonates','Het Net',2);
/*!40000 ALTER TABLE `voorstellingen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `winkelmandjes`
--

DROP TABLE IF EXISTS `winkelmandjes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `winkelmandjes` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `klantid` int(11) unsigned NOT NULL,
  `opvoeringsid` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_reservaties_klanten` (`klantid`),
  KEY `FK_reservaties_opvoeringsid_idx` (`opvoeringsid`),
  CONSTRAINT `FK_winkelmandjes_klantid` FOREIGN KEY (`klantid`) REFERENCES `klanten` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_winkelmandjes_opvoeringsid` FOREIGN KEY (`opvoeringsid`) REFERENCES `opvoeringen` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `winkelmandjes`
--

LOCK TABLES `winkelmandjes` WRITE;
/*!40000 ALTER TABLE `winkelmandjes` DISABLE KEYS */;
/*!40000 ALTER TABLE `winkelmandjes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-29 12:02:33
