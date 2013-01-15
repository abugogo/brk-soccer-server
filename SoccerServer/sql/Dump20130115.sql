CREATE DATABASE  IF NOT EXISTS `abugogo_soccer_sys` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `abugogo_soccer_sys`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: abugogo_soccer_sys
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
-- Table structure for table `accmap`
--

DROP TABLE IF EXISTS `accmap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accmap` (
  `accname` varchar(45) NOT NULL,
  `accschema` varchar(45) NOT NULL,
  PRIMARY KEY (`accname`,`accschema`),
  UNIQUE KEY `accname_UNIQUE` (`accname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accmap`
--

LOCK TABLES `accmap` WRITE;
/*!40000 ALTER TABLE `accmap` DISABLE KEYS */;
INSERT INTO `accmap` VALUES ('Crazy','abugogo_acc_super'),('Stars','abugogo_acc_star'),('Winners','abugogo_acc_winn');
/*!40000 ALTER TABLE `accmap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hkey`
--

DROP TABLE IF EXISTS `hkey`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hkey` (
  `value` varchar(22) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`value`),
  UNIQUE KEY `value_UNIQUE` (`value`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hkey`
--

LOCK TABLES `hkey` WRITE;
/*!40000 ALTER TABLE `hkey` DISABLE KEYS */;
/*!40000 ALTER TABLE `hkey` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) unsigned NOT NULL,
  `pwd` varchar(100) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `tel1` varchar(45) DEFAULT NULL,
  `tel2` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `bday` date DEFAULT NULL,
  `fb_user` varchar(45) DEFAULT NULL,
  `occupation` varchar(45) DEFAULT NULL,
  `address1` varchar(45) DEFAULT NULL,
  `address2` varchar(45) DEFAULT NULL,
  `P_img` varchar(200) DEFAULT NULL,
  `salt` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'E:2B:D1:41:43:5A:9F:CF:E7:30:F8:8E:E1:0F:02:07:B5:1C:8B:08:5','Guy','Kirschbaum','22233222222',NULL,'guy@her1111','1972-12-22',NULL,NULL,NULL,NULL,NULL,'aaa'),(2,'D:E6:47:D4:3F:11:80:92:56:D5:6D:F0:EB:1A:DF:D2:5B:7C:A0:3F:C','Avi','Baruch','0544444',NULL,'avi@here.comj','1973-12-24',NULL,NULL,NULL,NULL,NULL,'bbb'),(3,'1:04:12:4F:61:0D:23:77:2A:79:E4:BC:A0:1F:13:80:FC:1B:CE:A5:7','Itay','Rimer','2211110543',NULL,'itay@here.com','1970-12-25',NULL,NULL,NULL,NULL,NULL,'ccc'),(4,'p4','Leo','Messi','054331234',NULL,'leo@here.com','1970-12-25',NULL,NULL,NULL,NULL,'http://i410.photobucket.com/albums/pp186/Rubyneraluna/Fangirls Guide 2009-10/World Cup/Argentina/LionelMessi.png','ddd'),(5,'0:68:CB:87:BB:6B:B2:F7:12:79:C1:9F:1F:CF:A3:AF:E7:89:3F:EC:5','C','R7','0555522',NULL,'cr7@here.com','1970-12-25',NULL,NULL,NULL,NULL,NULL,'ea2e1131-2e92-41e8-8492-fbe140f20226'),(6,'0:1F:A1:74:22:E5:20:14:63:1E:0C:DD:F8:A5:D6:F2:B6:46:61:36:9','Beni','Schmidt','054331235',NULL,'ben@here.com','1970-12-25',NULL,NULL,NULL,NULL,NULL,'dacf46d9-6c66-4fb1-86b0-433de3ba68f3');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usersacc`
--

DROP TABLE IF EXISTS `usersacc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usersacc` (
  `uid` bigint(20) unsigned NOT NULL,
  `acc` varchar(45) NOT NULL,
  PRIMARY KEY (`uid`,`acc`),
  UNIQUE KEY `uid_UNIQUE` (`uid`),
  KEY `fk_id_idx` (`uid`),
  KEY `fk_acc_idx` (`acc`),
  CONSTRAINT `fk_acc` FOREIGN KEY (`acc`) REFERENCES `accmap` (`accname`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_id` FOREIGN KEY (`uid`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usersacc`
--

LOCK TABLES `usersacc` WRITE;
/*!40000 ALTER TABLE `usersacc` DISABLE KEYS */;
INSERT INTO `usersacc` VALUES (1,'Stars'),(2,'Stars'),(3,'Winners'),(4,'Stars'),(5,'Winners'),(6,'Winners');
/*!40000 ALTER TABLE `usersacc` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-01-15 14:08:44
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
) ENGINE=InnoDB AUTO_INCREMENT=925 DEFAULT CHARSET=hebrew;
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
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
  `Active` binary(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=hebrew;
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

-- Dump completed on 2013-01-15 14:08:45
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
) ENGINE=InnoDB AUTO_INCREMENT=865 DEFAULT CHARSET=hebrew;
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
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
  `Active` binary(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES (3,NULL,'',NULL),(5,2,'','1'),(6,2,'','1');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=hebrew;
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

-- Dump completed on 2013-01-15 14:08:46
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
) ENGINE=InnoDB AUTO_INCREMENT=946 DEFAULT CHARSET=hebrew;
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
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
  `Active` binary(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES (1,3,'here I am position 2',NULL),(2,4,'',NULL),(4,3,'','1');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=hebrew;
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

-- Dump completed on 2013-01-15 14:08:47
