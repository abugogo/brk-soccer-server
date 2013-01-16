CREATE DATABASE  IF NOT EXISTS `abugogo_acc_winn` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `abugogo_acc_winn`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: abugogo_acc_winn
-- ------------------------------------------------------
-- Server version	5.5.29

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
-- Table structure for table `games_tbl`
--

DROP TABLE IF EXISTS `games_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `games_tbl` (
  `game_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `game_name` text,
  `game_date` date NOT NULL,
  `winner` set('b','w','d') NOT NULL,
  `wgoals` int(11) NOT NULL DEFAULT '0',
  `bgoals` int(11) NOT NULL DEFAULT '0',
  `has_draft` tinyint(1) NOT NULL DEFAULT '0',
  `description` text,
  `misc` text,
  `more` text,
  PRIMARY KEY (`game_id`)
) ENGINE=InnoDB AUTO_INCREMENT=866 DEFAULT CHARSET=hebrew;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games_tbl`
--

LOCK TABLES `games_tbl` WRITE;
/*!40000 ALTER TABLE `games_tbl` DISABLE KEYS */;
INSERT INTO `games_tbl` VALUES (865,'','2013-01-15','b',0,2,0,'','','');
/*!40000 ALTER TABLE `games_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineup`
--

DROP TABLE IF EXISTS `lineup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lineup` (
  `game_id` bigint(20) NOT NULL,
  `player_id` bigint(20) NOT NULL,
  `color` set('b','w') NOT NULL,
  `goal` int(11) NOT NULL DEFAULT '0',
  `o_goal` int(11) NOT NULL DEFAULT '0',
  `points` smallint(6) NOT NULL DEFAULT '0',
  `misc` text,
  PRIMARY KEY (`game_id`,`player_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineup`
--

LOCK TABLES `lineup` WRITE;
/*!40000 ALTER TABLE `lineup` DISABLE KEYS */;
INSERT INTO `lineup` VALUES (865,3,'b',1,0,3,''),(865,5,'b',1,0,3,''),(865,6,'w',0,0,0,'');
/*!40000 ALTER TABLE `lineup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineup_events`
--

DROP TABLE IF EXISTS `lineup_events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lineup_events` (
  `pid` bigint(20) NOT NULL,
  `gid` bigint(20) NOT NULL,
  `type` int(11) NOT NULL,
  `time` datetime DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_pid_idx` (`pid`),
  KEY `fk_gid_idx` (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineup_events`
--

LOCK TABLES `lineup_events` WRITE;
/*!40000 ALTER TABLE `lineup_events` DISABLE KEYS */;
INSERT INTO `lineup_events` VALUES (3,865,0,'0000-00-00 00:00:00',15),(5,865,0,'0000-00-00 00:00:00',16);
/*!40000 ALTER TABLE `lineup_events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `players` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `position` smallint(6) DEFAULT '2',
  `description` text CHARACTER SET hebrew,
  `Active` bit(1) DEFAULT b'1',
  `isAdmin` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES (3,NULL,'','',''),(5,2,'','','\0'),(6,2,'','','\0');
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `positions`
--

DROP TABLE IF EXISTS `positions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `positions` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `type` enum('1','2','3','4') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `positions`
--

LOCK TABLES `positions` WRITE;
/*!40000 ALTER TABLE `positions` DISABLE KEYS */;
INSERT INTO `positions` VALUES (1,'Goalkeeper','1'),(2,'Fullback','2'),(3,'Sweeper','2'),(4,'Stopper','2'),(5,'Defensive Midfielder','3'),(6,'Central Midfielder','3'),(7,'Attacking Midfielder','3'),(8,'Central Midfielder','3'),(9,'Striker','4'),(10,'Forward','4');
/*!40000 ALTER TABLE `positions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seasons`
--

DROP TABLE IF EXISTS `seasons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seasons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sdate` date NOT NULL,
  `edate` date NOT NULL,
  `misc` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=hebrew;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seasons`
--

LOCK TABLES `seasons` WRITE;
/*!40000 ALTER TABLE `seasons` DISABLE KEYS */;
/*!40000 ALTER TABLE `seasons` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-01-16 22:02:43
CREATE DATABASE  IF NOT EXISTS `abugogo_acc_star` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `abugogo_acc_star`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: abugogo_acc_star
-- ------------------------------------------------------
-- Server version	5.5.29

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
-- Table structure for table `games_tbl`
--

DROP TABLE IF EXISTS `games_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `games_tbl` (
  `game_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `game_name` text,
  `game_date` date NOT NULL,
  `winner` set('b','w','d') NOT NULL,
  `wgoals` int(11) NOT NULL DEFAULT '0',
  `bgoals` int(11) NOT NULL DEFAULT '0',
  `has_draft` tinyint(1) NOT NULL DEFAULT '0',
  `description` text,
  `misc` text,
  `more` text,
  PRIMARY KEY (`game_id`)
) ENGINE=InnoDB AUTO_INCREMENT=955 DEFAULT CHARSET=hebrew;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games_tbl`
--

LOCK TABLES `games_tbl` WRITE;
/*!40000 ALTER TABLE `games_tbl` DISABLE KEYS */;
INSERT INTO `games_tbl` VALUES (946,'','2013-01-15','d',0,0,0,'','',''),(947,'','2013-01-15','d',1,1,0,'','',''),(948,'','2013-01-15','w',2,1,0,'','',''),(949,'','2013-01-15','w',2,1,0,'','',''),(950,'','2013-01-15','w',2,1,0,'','',''),(951,'','2013-01-15','w',2,1,0,'','',''),(952,'','2013-01-16','w',2,1,0,'','',''),(953,'','2013-01-16','b',0,1,0,'','',''),(954,'','2013-01-16','b',0,2,0,'','','');
/*!40000 ALTER TABLE `games_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineup`
--

DROP TABLE IF EXISTS `lineup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lineup` (
  `game_id` bigint(20) NOT NULL,
  `player_id` bigint(20) NOT NULL,
  `color` set('b','w') NOT NULL,
  `goal` int(11) NOT NULL DEFAULT '0',
  `o_goal` int(11) NOT NULL DEFAULT '0',
  `points` smallint(6) NOT NULL DEFAULT '0',
  `misc` text,
  PRIMARY KEY (`game_id`,`player_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineup`
--

LOCK TABLES `lineup` WRITE;
/*!40000 ALTER TABLE `lineup` DISABLE KEYS */;
INSERT INTO `lineup` VALUES (946,1,'w',0,0,1,''),(946,2,'b',0,0,1,''),(947,1,'b',1,0,1,''),(947,2,'w',1,0,1,''),(947,4,'b',0,0,1,''),(948,1,'b',1,0,0,''),(948,2,'w',2,0,3,''),(948,4,'b',0,0,0,''),(949,1,'b',1,0,0,''),(949,2,'w',2,0,3,''),(949,4,'b',0,0,0,''),(950,1,'b',1,0,0,''),(950,2,'w',2,0,3,''),(950,4,'b',0,0,0,''),(951,1,'b',1,0,0,''),(951,2,'w',2,0,3,''),(951,4,'b',0,0,0,''),(952,1,'b',1,0,0,''),(952,2,'w',2,0,3,''),(952,4,'b',0,0,0,''),(953,1,'b',1,0,3,''),(953,2,'w',0,0,0,''),(954,1,'b',2,0,3,''),(954,2,'w',0,0,0,'');
/*!40000 ALTER TABLE `lineup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineup_events`
--

DROP TABLE IF EXISTS `lineup_events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lineup_events` (
  `pid` bigint(20) NOT NULL,
  `gid` bigint(20) NOT NULL,
  `type` int(11) NOT NULL,
  `time` datetime DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_pid_idx` (`pid`),
  KEY `fk_gid_idx` (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineup_events`
--

LOCK TABLES `lineup_events` WRITE;
/*!40000 ALTER TABLE `lineup_events` DISABLE KEYS */;
INSERT INTO `lineup_events` VALUES (1,947,0,'0000-00-00 00:00:00',15),(2,947,0,'0000-00-00 00:00:00',16),(1,948,0,'0000-00-00 00:00:00',17),(2,948,0,'0000-00-00 00:00:00',18),(2,948,0,'0000-00-00 00:00:00',19),(1,949,0,'0000-00-00 00:00:00',20),(2,949,0,'0000-00-00 00:00:00',21),(2,949,0,'0000-00-00 00:00:00',22),(1,950,0,'0000-00-00 00:00:00',23),(2,950,0,'0000-00-00 00:00:00',24),(2,950,0,'0000-00-00 00:00:00',25),(1,951,0,'0000-00-00 00:00:00',26),(2,951,0,'0000-00-00 00:00:00',27),(2,951,0,'0000-00-00 00:00:00',28),(1,952,0,'0000-00-00 00:00:00',29),(2,952,0,'0000-00-00 00:00:00',30),(2,952,0,'0000-00-00 00:00:00',31),(1,953,0,'0000-00-00 00:00:00',32),(1,953,1,'0000-00-00 00:00:00',33),(1,954,0,'0000-00-00 00:00:00',34),(1,954,1,'0000-00-00 00:00:00',35),(1,954,0,'0000-00-00 00:00:00',36);
/*!40000 ALTER TABLE `lineup_events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `players` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `position` smallint(6) DEFAULT '2',
  `description` text CHARACTER SET hebrew,
  `Active` bit(1) DEFAULT b'1',
  `isAdmin` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES (1,NULL,'here I am position 2','',''),(2,NULL,'','','\0'),(4,3,'','','\0');
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `positions`
--

DROP TABLE IF EXISTS `positions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `positions` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `type` enum('1','2','3','4') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `positions`
--

LOCK TABLES `positions` WRITE;
/*!40000 ALTER TABLE `positions` DISABLE KEYS */;
INSERT INTO `positions` VALUES (1,'Goalkeeper','1'),(2,'Fullback','2'),(3,'Sweeper','2'),(4,'Stopper','2'),(5,'Defensive Midfielder','3'),(6,'Central Midfielder','3'),(7,'Attacking Midfielder','3'),(8,'Central Midfielder','3'),(9,'Striker','4'),(10,'Forward','4');
/*!40000 ALTER TABLE `positions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seasons`
--

DROP TABLE IF EXISTS `seasons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seasons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sdate` date NOT NULL,
  `edate` date NOT NULL,
  `misc` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=hebrew;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seasons`
--

LOCK TABLES `seasons` WRITE;
/*!40000 ALTER TABLE `seasons` DISABLE KEYS */;
/*!40000 ALTER TABLE `seasons` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-01-16 22:02:44
CREATE DATABASE  IF NOT EXISTS `abugogo_acc_super` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `abugogo_acc_super`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: abugogo_acc_super
-- ------------------------------------------------------
-- Server version	5.5.29

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
-- Table structure for table `games_tbl`
--

DROP TABLE IF EXISTS `games_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `games_tbl` (
  `game_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `game_name` text,
  `game_date` date NOT NULL,
  `winner` set('b','w','d') NOT NULL,
  `wgoals` int(11) NOT NULL DEFAULT '0',
  `bgoals` int(11) NOT NULL DEFAULT '0',
  `has_draft` tinyint(1) NOT NULL DEFAULT '0',
  `description` text,
  `misc` text,
  `more` text,
  PRIMARY KEY (`game_id`)
) ENGINE=InnoDB DEFAULT CHARSET=hebrew;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games_tbl`
--

LOCK TABLES `games_tbl` WRITE;
/*!40000 ALTER TABLE `games_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `games_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineup`
--

DROP TABLE IF EXISTS `lineup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lineup` (
  `game_id` bigint(20) NOT NULL,
  `player_id` bigint(20) NOT NULL,
  `color` set('b','w') NOT NULL,
  `goal` int(11) NOT NULL DEFAULT '0',
  `o_goal` int(11) NOT NULL DEFAULT '0',
  `points` smallint(6) NOT NULL DEFAULT '0',
  `misc` text,
  PRIMARY KEY (`game_id`,`player_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineup`
--

LOCK TABLES `lineup` WRITE;
/*!40000 ALTER TABLE `lineup` DISABLE KEYS */;
/*!40000 ALTER TABLE `lineup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineup_events`
--

DROP TABLE IF EXISTS `lineup_events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lineup_events` (
  `pid` bigint(20) NOT NULL,
  `gid` bigint(20) NOT NULL,
  `type` int(11) NOT NULL,
  `time` datetime DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_pid_idx` (`pid`),
  KEY `fk_gid_idx` (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineup_events`
--

LOCK TABLES `lineup_events` WRITE;
/*!40000 ALTER TABLE `lineup_events` DISABLE KEYS */;
/*!40000 ALTER TABLE `lineup_events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `players` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `position` smallint(6) DEFAULT '2',
  `description` text CHARACTER SET hebrew,
  `Active` bit(1) DEFAULT b'1',
  `isAdmin` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `positions`
--

DROP TABLE IF EXISTS `positions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `positions` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `type` enum('1','2','3','4') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `positions`
--

LOCK TABLES `positions` WRITE;
/*!40000 ALTER TABLE `positions` DISABLE KEYS */;
INSERT INTO `positions` VALUES (1,'Goalkeeper','1'),(2,'Fullback','2'),(3,'Sweeper','2'),(4,'Stopper','2'),(5,'Defensive Midfielder','3'),(6,'Central Midfielder','3'),(7,'Attacking Midfielder','3'),(8,'Central Midfielder','3'),(9,'Striker','4'),(10,'Forward','4');
/*!40000 ALTER TABLE `positions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seasons`
--

DROP TABLE IF EXISTS `seasons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seasons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sdate` date NOT NULL,
  `edate` date NOT NULL,
  `misc` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=hebrew;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seasons`
--

LOCK TABLES `seasons` WRITE;
/*!40000 ALTER TABLE `seasons` DISABLE KEYS */;
/*!40000 ALTER TABLE `seasons` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-01-16 22:02:45
