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
INSERT INTO `users` VALUES (1,'E:2B:D1:41:43:5A:9F:CF:E7:30:F8:8E:E1:0F:02:07:B5:1C:8B:08:5','Guy','Kirschbaum','44444466',NULL,'guy@her1111','1972-12-22',NULL,NULL,NULL,NULL,NULL,'aaa'),(2,'D:E6:47:D4:3F:11:80:92:56:D5:6D:F0:EB:1A:DF:D2:5B:7C:A0:3F:C','Avi','Baruch','0544444',NULL,'avi@here.comj','1974-12-24',NULL,NULL,NULL,NULL,NULL,'bbb'),(3,'1:04:12:4F:61:0D:23:77:2A:79:E4:BC:A0:1F:13:80:FC:1B:CE:A5:7','Itay','Rimer','2211110543',NULL,'itay@here.com','1970-12-25',NULL,NULL,NULL,NULL,NULL,'ccc'),(4,'p4','Leo','Messi','054331234',NULL,'leo@here.com','1970-12-25',NULL,NULL,NULL,NULL,'http://i410.photobucket.com/albums/pp186/Rubyneraluna/Fangirls Guide 2009-10/World Cup/Argentina/LionelMessi.png','ddd'),(5,'0:68:CB:87:BB:6B:B2:F7:12:79:C1:9F:1F:CF:A3:AF:E7:89:3F:EC:5','C','R7','0555522',NULL,'cr7@here.com','1970-12-25',NULL,NULL,NULL,NULL,NULL,'ea2e1131-2e92-41e8-8492-fbe140f20226'),(6,'0:1F:A1:74:22:E5:20:14:63:1E:0C:DD:F8:A5:D6:F2:B6:46:61:36:9','Beni','Schmidt','054331235',NULL,'ben@here.com','1970-12-25',NULL,NULL,NULL,NULL,NULL,'dacf46d9-6c66-4fb1-86b0-433de3ba68f3'),(7,'4:32:28:1B:95:81:B7:F0:22:30:CF:BE:A9:84:90:7D:D1:DB:83:25:0','Yossi','Abuksis','054-3388014',NULL,'user@her1111','1977-08-22',NULL,NULL,NULL,NULL,NULL,'401d3fc7-c8bc-4e88-9128-c1e67ee0fd01'),(8,'6:0F:64:DE:D1:0C:3B:1C:E3:A1:DA:2A:CA:22:3F:27:02:0D:BF:00:5','Avi','Nimni','44444466',NULL,'user8@her1111','1972-12-22',NULL,NULL,NULL,NULL,NULL,'8bfc5c75-000a-48fe-a06a-644af2bbf676'),(9,'2:DB:06:F2:7B:7C:76:06:C6:4E:ED:32:A4:1D:FF:8C:67:E8:F2:D4:B','Anelka','','44444466',NULL,'user9@her1111','1972-12-22',NULL,NULL,NULL,NULL,NULL,'d5bb1c14-0f0c-48c5-8eba-d18f92ee0a60'),(10,'9:65:86:7D:A6:43:99:65:40:9A:21:57:74:46:E2:3F:37:C5:B3:3D:F','Zlatan','Ibrahimovic','44444466',NULL,'zi@me.com','1972-12-22',NULL,NULL,NULL,NULL,NULL,'89510468-2d1e-478a-90f6-52e541ecdaf4'),(11,'8:D3:FA:38:A4:58:52:52:C8:9A:7B:8C:9A:64:80:BA:60:52:65:80:D','Gili','Vermut','44444466',NULL,'gv@me.com','1972-12-22',NULL,NULL,NULL,NULL,NULL,'f57a108e-679b-4baa-8042-a4a3b224741d'),(12,'1:32:FC:2C:0A:E6:BE:2D:49:15:4A:4F:1E:22:C5:EF:5E:B2:A1:63:5','Maharan','Radi','44444466',NULL,'mr@me.com','1972-12-22',NULL,NULL,NULL,NULL,NULL,'049d5df6-9a23-46d7-9359-05693833f7cc');
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
INSERT INTO `usersacc` VALUES (1,'Stars'),(2,'Stars'),(3,'Winners'),(4,'Stars'),(5,'Winners'),(6,'Winners'),(7,'Stars'),(8,'Stars'),(9,'Stars'),(10,'Stars'),(11,'Stars'),(12,'Stars');
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

-- Dump completed on 2013-02-05 22:41:25
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
  `game_date` datetime NOT NULL,
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

-- Dump completed on 2013-02-05 22:41:27
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
  `game_date` datetime NOT NULL,
  `winner` set('b','w','d') NOT NULL,
  `wgoals` int(11) NOT NULL DEFAULT '0',
  `bgoals` int(11) NOT NULL DEFAULT '0',
  `has_draft` tinyint(1) NOT NULL DEFAULT '0',
  `description` text,
  `misc` text,
  `more` text,
  PRIMARY KEY (`game_id`)
) ENGINE=InnoDB AUTO_INCREMENT=867 DEFAULT CHARSET=hebrew;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games_tbl`
--

LOCK TABLES `games_tbl` WRITE;
/*!40000 ALTER TABLE `games_tbl` DISABLE KEYS */;
INSERT INTO `games_tbl` VALUES (865,'','2013-01-15 00:00:00','b',0,2,0,'','',''),(866,'','2013-01-17 00:00:00','d',0,0,0,'','','');
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
INSERT INTO `lineup` VALUES (865,3,'b',1,0,3,''),(865,5,'b',1,0,3,''),(865,6,'w',0,0,0,''),(866,5,'b',0,0,1,''),(866,6,'w',0,0,1,'');
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

-- Dump completed on 2013-02-05 22:41:28
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
  `game_date` datetime NOT NULL,
  `winner` set('b','w','d') NOT NULL,
  `wgoals` int(11) NOT NULL DEFAULT '0',
  `bgoals` int(11) NOT NULL DEFAULT '0',
  `has_draft` tinyint(1) NOT NULL DEFAULT '0',
  `description` text,
  `misc` text,
  `more` text,
  PRIMARY KEY (`game_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1020 DEFAULT CHARSET=hebrew;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games_tbl`
--

LOCK TABLES `games_tbl` WRITE;
/*!40000 ALTER TABLE `games_tbl` DISABLE KEYS */;
INSERT INTO `games_tbl` VALUES (946,'','2013-01-15 00:00:00','d',0,0,0,'','',''),(947,'','2013-01-15 00:00:00','d',1,1,0,'','',''),(948,'','2013-01-15 00:00:00','w',2,1,0,'','',''),(949,'','2013-01-15 00:00:00','w',2,1,0,'','',''),(950,'','2013-01-15 00:00:00','w',2,1,0,'','',''),(951,'','2013-01-15 00:00:00','w',2,1,0,'','',''),(952,'','2013-01-16 00:00:00','w',2,1,0,'','',''),(953,'','2013-01-16 00:00:00','b',0,1,0,'','',''),(954,'','2013-01-16 00:00:00','b',0,2,0,'','',''),(955,'','2013-01-17 00:00:00','b',0,2,0,'','',''),(956,'','2013-01-17 00:00:00','b',0,1,0,'','',''),(957,'','2013-01-17 00:00:00','b',0,1,0,'','',''),(958,'','2013-01-17 00:00:00','b',1,2,0,'','',''),(959,'','2013-01-17 00:00:00','b',0,1,0,'','',''),(960,'','2013-01-17 00:00:00','d',0,0,0,'','',''),(961,'','2013-01-17 00:00:00','d',0,0,0,'','',''),(962,'','2013-01-17 00:00:00','d',0,0,0,'','',''),(963,'','2013-01-17 00:00:00','d',0,0,0,'','',''),(964,'','2013-01-17 00:00:00','d',0,0,0,'','',''),(965,'','2013-01-17 00:00:00','d',0,0,0,'','',''),(966,'','2013-01-17 00:00:00','d',0,0,0,'','',''),(967,'','2013-01-17 00:00:00','d',0,0,0,'','',''),(968,'','2013-01-17 00:00:00','d',0,0,0,'','',''),(969,'','2013-01-17 00:00:00','d',0,0,0,'','',''),(970,'','2013-01-17 00:00:00','d',0,0,0,'','',''),(971,'','2013-01-17 00:00:00','d',0,0,0,'','',''),(972,'','2013-01-17 00:00:00','d',0,0,0,'','',''),(973,'','2013-01-17 00:00:00','b',0,1,0,'','',''),(974,'','2013-01-17 00:00:00','b',0,1,0,'','',''),(975,'','2013-01-17 00:00:00','b',0,1,0,'','',''),(976,'','2013-01-17 00:00:00','b',0,1,0,'','',''),(977,'','2013-01-20 00:00:00','b',0,4,0,'','',''),(978,'','2013-01-20 00:00:00','d',0,0,0,'','',''),(979,'','2013-01-20 00:00:00','d',0,0,0,'','',''),(980,'','2013-01-20 00:00:00','d',0,0,0,'','',''),(981,'','2013-01-20 00:00:00','d',0,0,0,'','',''),(982,'','2013-01-20 00:00:00','d',0,0,0,'','',''),(983,'','2013-01-20 00:00:00','d',0,0,0,'','',''),(984,'','2013-01-20 00:00:00','d',0,0,0,'','',''),(985,'','2013-01-20 00:00:00','d',0,0,0,'','',''),(986,'','2013-01-20 00:00:00','d',0,0,0,'','',''),(987,'','2013-01-20 00:00:00','d',0,0,0,'','',''),(988,'','2013-01-20 00:00:00','d',0,0,0,'','',''),(989,'','2013-01-20 00:00:00','d',0,0,0,'','',''),(990,'','2013-01-20 00:00:00','d',0,0,0,'','',''),(991,'','2013-01-20 00:00:00','d',0,0,0,'','',''),(992,'','2013-01-20 00:00:00','b',0,6,0,'','',''),(993,'','2013-01-20 00:00:00','d',0,0,0,'','',''),(994,'','2013-01-20 00:00:00','b',0,7,0,'','',''),(995,'','2013-01-20 00:00:00','d',0,0,0,'','',''),(996,'','2013-01-20 00:00:00','b',0,9,0,'','',''),(997,'','2013-01-20 00:00:00','b',0,10,0,'','',''),(998,'','2013-01-20 00:00:00','b',0,11,0,'','',''),(999,'','2013-01-20 00:00:00','b',0,13,0,'','',''),(1000,'','2013-01-20 00:00:00','b',0,14,0,'','',''),(1001,'','2013-01-20 00:00:00','b',0,2,0,'','',''),(1002,'','2013-01-20 00:00:00','b',1,3,0,'','',''),(1003,'','2013-01-20 00:00:00','b',0,3,0,'','',''),(1004,'','2013-01-20 00:00:00','b',0,3,0,'','',''),(1005,'','2013-01-20 00:00:00','w',2,1,0,'','',''),(1006,'','2013-01-20 00:00:00','b',0,1,0,'','',''),(1007,'','2013-01-20 00:00:00','b',1,3,0,'','',''),(1008,'','2013-01-20 00:00:00','b',0,3,0,'','',''),(1009,'','2013-01-20 00:00:00','d',1,1,0,'','',''),(1010,'','2013-01-21 00:00:00','b',0,1,0,'','',''),(1011,'','2013-01-21 09:01:42','b',0,1,0,'','',''),(1012,'','2013-01-21 12:52:01','b',0,1,0,'','',''),(1013,'','2013-01-22 21:23:55','b',0,2,0,'','',''),(1014,'','2013-01-22 21:24:15','b',0,1,0,'','',''),(1015,'','2013-01-22 21:24:32','b',0,1,0,'','',''),(1016,'','2013-01-28 08:41:02','w',3,0,0,'','',''),(1017,'','2013-01-28 08:41:02','w',3,0,0,'','',''),(1018,'','2013-01-28 08:41:02','w',3,0,0,'','',''),(1019,'','2013-01-28 11:53:46','b',1,2,0,'','','');
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
INSERT INTO `lineup` VALUES (946,1,'w',0,0,1,''),(946,2,'b',0,0,1,''),(947,1,'b',1,0,1,''),(947,2,'w',1,0,1,''),(947,4,'b',0,0,1,''),(948,1,'b',1,0,0,''),(948,2,'w',2,0,3,''),(948,4,'b',0,0,0,''),(949,1,'b',1,0,0,''),(949,2,'w',2,0,3,''),(949,4,'b',0,0,0,''),(950,1,'b',1,0,0,''),(950,2,'w',2,0,3,''),(950,4,'b',0,0,0,''),(951,1,'b',1,0,0,''),(951,2,'w',2,0,3,''),(951,4,'b',0,0,0,''),(952,1,'b',1,0,0,''),(952,2,'w',2,0,3,''),(952,4,'b',0,0,0,''),(953,1,'b',1,0,3,''),(953,2,'w',0,0,0,''),(954,1,'b',2,0,3,''),(954,2,'w',0,0,0,''),(955,1,'b',1,0,3,''),(955,2,'b',1,0,3,''),(955,4,'w',0,0,0,''),(956,1,'b',1,0,3,''),(956,2,'w',0,0,0,''),(956,4,'w',0,0,0,''),(957,1,'b',1,0,3,''),(957,2,'w',0,0,0,''),(957,4,'w',0,0,0,''),(958,1,'w',1,0,0,''),(958,4,'b',2,0,3,''),(959,1,'b',1,0,3,''),(959,2,'w',0,0,0,''),(959,4,'w',0,0,0,''),(960,2,'b',0,0,1,''),(960,4,'b',0,0,1,''),(961,2,'b',0,0,1,''),(961,4,'b',0,0,1,''),(962,2,'b',0,0,1,''),(962,4,'b',0,0,1,''),(963,2,'b',0,0,1,''),(963,4,'b',0,0,1,''),(964,2,'b',0,0,1,''),(964,4,'b',0,0,1,''),(965,2,'b',0,0,1,''),(965,4,'b',0,0,1,''),(966,2,'b',0,0,1,''),(966,4,'b',0,0,1,''),(967,2,'b',0,0,1,''),(967,4,'b',0,0,1,''),(968,2,'b',0,0,1,''),(968,4,'b',0,0,1,''),(969,2,'b',0,0,1,''),(969,4,'b',0,0,1,''),(970,2,'b',0,0,1,''),(970,4,'b',0,0,1,''),(971,2,'b',0,0,1,''),(971,4,'b',0,0,1,''),(972,2,'b',0,0,1,''),(972,4,'b',0,0,1,''),(973,1,'b',1,0,3,''),(973,2,'b',0,0,3,''),(974,1,'b',1,0,3,''),(974,2,'b',0,0,3,''),(975,1,'b',1,0,3,''),(975,2,'b',0,0,3,''),(976,1,'b',1,0,3,''),(976,2,'b',0,0,3,''),(977,1,'b',2,0,3,''),(977,4,'b',2,0,3,''),(992,1,'b',4,0,3,''),(992,2,'w',0,0,0,''),(992,4,'b',2,0,3,''),(994,1,'b',5,0,3,''),(994,2,'w',0,0,0,''),(994,4,'b',2,0,3,''),(996,1,'b',7,0,3,''),(996,2,'w',0,0,0,''),(996,4,'b',2,0,3,''),(997,1,'b',7,0,3,''),(997,2,'w',0,0,0,''),(997,4,'b',3,0,3,''),(998,1,'b',8,0,3,''),(998,2,'w',0,0,0,''),(998,4,'b',3,0,3,''),(999,1,'b',10,0,3,''),(999,2,'w',0,0,0,''),(999,4,'b',3,0,3,''),(1000,1,'b',11,0,3,''),(1000,2,'w',0,0,0,''),(1000,4,'b',3,0,3,''),(1001,1,'b',2,0,3,''),(1001,2,'w',0,0,0,''),(1002,1,'b',2,0,3,''),(1002,2,'w',1,1,0,''),(1002,4,'b',0,0,3,''),(1003,1,'w',0,1,0,''),(1003,2,'b',2,0,3,''),(1004,1,'w',0,1,0,''),(1004,2,'b',2,0,3,''),(1005,1,'b',1,0,0,''),(1005,2,'w',2,0,3,''),(1006,1,'b',1,0,3,''),(1006,2,'w',0,0,0,''),(1007,1,'b',3,1,3,''),(1007,4,'w',0,0,0,''),(1008,1,'b',3,0,3,''),(1008,2,'w',0,0,0,''),(1008,4,'b',0,0,3,''),(1009,2,'w',1,0,1,''),(1009,4,'b',1,0,1,''),(1010,1,'b',0,0,3,''),(1010,2,'w',0,0,0,''),(1010,4,'b',1,0,3,''),(1011,1,'b',1,0,3,''),(1011,2,'w',0,0,0,''),(1012,1,'w',0,0,0,''),(1012,2,'b',1,0,3,''),(1013,1,'b',2,0,3,''),(1013,2,'w',0,0,0,''),(1013,4,'b',0,0,3,''),(1014,2,'b',1,0,3,''),(1015,2,'b',1,0,3,''),(1015,4,'b',0,0,3,''),(1015,7,'b',0,0,3,NULL),(1016,1,'b',0,0,0,''),(1016,2,'b',0,0,0,''),(1016,4,'w',2,0,3,''),(1016,7,'b',0,1,0,''),(1017,1,'b',0,0,0,''),(1017,2,'b',0,0,0,''),(1017,4,'w',2,0,3,''),(1017,7,'b',0,1,0,''),(1018,1,'b',0,0,0,''),(1018,2,'b',0,0,0,''),(1018,4,'w',2,0,3,''),(1018,7,'b',0,1,0,''),(1019,1,'w',0,0,0,''),(1019,2,'w',1,0,0,''),(1019,4,'w',0,0,0,''),(1019,7,'b',1,0,3,''),(1019,8,'b',1,0,3,''),(1019,9,'b',0,0,3,''),(1019,10,'w',0,0,0,''),(1019,11,'b',0,0,3,''),(1019,12,'w',0,0,0,'');
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
) ENGINE=InnoDB AUTO_INCREMENT=178 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineup_events`
--

LOCK TABLES `lineup_events` WRITE;
/*!40000 ALTER TABLE `lineup_events` DISABLE KEYS */;
INSERT INTO `lineup_events` VALUES (1,947,0,'0000-00-00 00:00:00',15),(2,947,0,'0000-00-00 00:00:00',16),(1,948,0,'0000-00-00 00:00:00',17),(2,948,0,'0000-00-00 00:00:00',18),(2,948,0,'0000-00-00 00:00:00',19),(1,949,0,'0000-00-00 00:00:00',20),(2,949,0,'0000-00-00 00:00:00',21),(2,949,0,'0000-00-00 00:00:00',22),(1,950,0,'0000-00-00 00:00:00',23),(2,950,0,'0000-00-00 00:00:00',24),(2,950,0,'0000-00-00 00:00:00',25),(1,951,0,'0000-00-00 00:00:00',26),(2,951,0,'0000-00-00 00:00:00',27),(2,951,0,'0000-00-00 00:00:00',28),(1,952,0,'0000-00-00 00:00:00',29),(2,952,0,'0000-00-00 00:00:00',30),(2,952,0,'0000-00-00 00:00:00',31),(1,953,0,'0000-00-00 00:00:00',32),(1,953,1,'0000-00-00 00:00:00',33),(1,954,0,'0000-00-00 00:00:00',34),(1,954,1,'0000-00-00 00:00:00',35),(1,954,0,'0000-00-00 00:00:00',36),(2,955,0,'0000-00-00 00:00:00',37),(1,955,0,'0000-00-00 00:00:00',38),(1,956,0,'0000-00-00 00:00:00',39),(1,957,0,'0000-00-00 00:00:00',40),(4,958,0,'0000-00-00 00:00:00',41),(4,958,0,'0000-00-00 00:00:00',42),(1,958,0,'0000-00-00 00:00:00',43),(1,959,0,'0000-00-00 00:00:00',44),(1,973,0,'0000-00-00 00:00:00',45),(1,974,0,'0000-00-00 00:00:00',46),(1,975,0,'0000-00-00 00:00:00',47),(1,976,0,'0000-00-00 00:00:00',48),(1,977,0,'0000-00-00 00:00:00',49),(1,977,0,'0000-00-00 00:00:00',50),(4,977,0,'0000-00-00 00:00:00',51),(4,977,0,'0000-00-00 00:00:00',52),(1,992,0,'0000-00-00 00:00:00',53),(1,992,0,'0000-00-00 00:00:00',54),(1,992,0,'0000-00-00 00:00:00',55),(1,992,0,'0000-00-00 00:00:00',56),(4,992,0,'0000-00-00 00:00:00',57),(4,992,0,'0000-00-00 00:00:00',58),(1,994,0,'0000-00-00 00:00:00',59),(1,994,0,'0000-00-00 00:00:00',60),(1,994,0,'0000-00-00 00:00:00',61),(1,994,0,'0000-00-00 00:00:00',62),(1,994,0,'0000-00-00 00:00:00',63),(4,994,0,'0000-00-00 00:00:00',64),(4,994,0,'0000-00-00 00:00:00',65),(1,996,0,'0000-00-00 00:00:00',66),(1,996,0,'0000-00-00 00:00:00',67),(1,996,0,'0000-00-00 00:00:00',68),(1,996,0,'0000-00-00 00:00:00',69),(1,996,0,'0000-00-00 00:00:00',70),(1,996,0,'0000-00-00 00:00:00',71),(1,996,0,'0000-00-00 00:00:00',72),(4,996,0,'0000-00-00 00:00:00',73),(4,996,0,'0000-00-00 00:00:00',74),(1,997,0,'0000-00-00 00:00:00',75),(1,997,0,'0000-00-00 00:00:00',76),(1,997,0,'0000-00-00 00:00:00',77),(1,997,0,'0000-00-00 00:00:00',78),(1,997,0,'0000-00-00 00:00:00',79),(1,997,0,'0000-00-00 00:00:00',80),(1,997,0,'0000-00-00 00:00:00',81),(4,997,0,'0000-00-00 00:00:00',82),(4,997,0,'0000-00-00 00:00:00',83),(4,997,0,'0000-00-00 00:00:00',84),(1,998,0,'0000-00-00 00:00:00',85),(1,998,0,'0000-00-00 00:00:00',86),(1,998,0,'0000-00-00 00:00:00',87),(1,998,0,'0000-00-00 00:00:00',88),(1,998,0,'0000-00-00 00:00:00',89),(1,998,0,'0000-00-00 00:00:00',90),(1,998,0,'0000-00-00 00:00:00',91),(1,998,0,'0000-00-00 00:00:00',92),(4,998,0,'0000-00-00 00:00:00',93),(4,998,0,'0000-00-00 00:00:00',94),(4,998,0,'0000-00-00 00:00:00',95),(1,999,0,'0000-00-00 00:00:00',96),(1,999,0,'0000-00-00 00:00:00',97),(1,999,0,'0000-00-00 00:00:00',98),(1,999,0,'0000-00-00 00:00:00',99),(1,999,0,'0000-00-00 00:00:00',100),(1,999,0,'0000-00-00 00:00:00',101),(1,999,0,'0000-00-00 00:00:00',102),(1,999,0,'0000-00-00 00:00:00',103),(1,999,0,'0000-00-00 00:00:00',104),(1,999,0,'0000-00-00 00:00:00',105),(4,999,0,'0000-00-00 00:00:00',106),(4,999,0,'0000-00-00 00:00:00',107),(4,999,0,'0000-00-00 00:00:00',108),(1,1000,0,'0000-00-00 00:00:00',109),(1,1000,0,'0000-00-00 00:00:00',110),(1,1000,0,'0000-00-00 00:00:00',111),(1,1000,0,'0000-00-00 00:00:00',112),(1,1000,0,'0000-00-00 00:00:00',113),(1,1000,0,'0000-00-00 00:00:00',114),(1,1000,0,'0000-00-00 00:00:00',115),(1,1000,0,'0000-00-00 00:00:00',116),(1,1000,0,'0000-00-00 00:00:00',117),(1,1000,0,'0000-00-00 00:00:00',118),(1,1000,0,'0000-00-00 00:00:00',119),(4,1000,0,'0000-00-00 00:00:00',120),(4,1000,0,'0000-00-00 00:00:00',121),(4,1000,0,'0000-00-00 00:00:00',122),(1,1001,0,'0000-00-00 00:00:00',123),(1,1001,0,'0000-00-00 00:00:00',124),(1,1002,0,'0000-00-00 00:00:00',125),(1,1002,0,'0000-00-00 00:00:00',126),(2,1002,0,'0000-00-00 00:00:00',127),(2,1002,2,'0000-00-00 00:00:00',128),(2,1003,0,'0000-00-00 00:00:00',129),(2,1003,0,'0000-00-00 00:00:00',130),(1,1003,1,'0000-00-00 00:00:00',131),(1,1003,2,'0000-00-00 00:00:00',132),(2,1004,0,'0000-00-00 00:00:00',133),(2,1004,0,'0000-00-00 00:00:00',134),(1,1004,1,'0000-00-00 00:00:00',135),(1,1004,2,'0000-00-00 00:00:00',136),(1,1005,0,'0000-00-00 00:00:00',137),(2,1005,0,'0000-00-00 00:00:00',138),(2,1005,0,'0000-00-00 00:00:00',139),(1,1006,0,'0000-00-00 00:00:00',140),(1,1007,0,'0000-00-00 00:00:00',141),(1,1007,0,'0000-00-00 00:00:00',142),(1,1007,0,'0000-00-00 00:00:00',143),(1,1007,2,'0000-00-00 00:00:00',144),(1,1008,0,'0000-00-00 00:00:00',145),(1,1008,0,'0000-00-00 00:00:00',146),(1,1008,0,'0000-00-00 00:00:00',147),(4,1009,0,'0000-00-00 00:00:00',148),(2,1009,0,'0000-00-00 00:00:00',149),(4,1010,0,'0000-00-00 00:00:00',150),(1,1011,0,'0000-00-00 00:00:00',151),(2,1012,0,'0000-00-00 00:00:00',152),(1,1013,0,'0000-00-00 00:00:00',153),(1,1013,0,'0000-00-00 00:00:00',154),(2,1014,0,'0000-00-00 00:00:00',155),(2,1015,0,'0000-00-00 00:00:00',156),(1,1016,3,'0000-00-00 00:00:00',157),(7,1016,4,'0000-00-00 00:00:00',158),(7,1016,2,'0000-00-00 00:00:00',159),(4,1016,0,'0000-00-00 00:00:00',160),(4,1016,0,'0000-00-00 00:00:00',161),(1,1017,3,'0000-00-00 00:00:00',162),(7,1017,4,'0000-00-00 00:00:00',163),(7,1017,2,'0000-00-00 00:00:00',164),(4,1017,0,'0000-00-00 00:00:00',165),(4,1017,0,'0000-00-00 00:00:00',166),(1,1018,3,'0000-00-00 00:00:00',167),(7,1018,4,'0000-00-00 00:00:00',168),(7,1018,2,'0000-00-00 00:00:00',169),(4,1018,0,'0000-00-00 00:00:00',170),(4,1018,0,'0000-00-00 00:00:00',171),(7,1019,0,'0000-00-00 00:00:00',172),(8,1019,0,'0000-00-00 00:00:00',173),(9,1019,4,'0000-00-00 00:00:00',174),(2,1019,0,'0000-00-00 00:00:00',175),(10,1019,1,'0000-00-00 00:00:00',176),(12,1019,1,'0000-00-00 00:00:00',177);
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES (1,NULL,'here I am position 2','',''),(2,NULL,'','','\0'),(4,3,'','','\0'),(7,NULL,'I am Hapoel coach','','\0'),(8,0,'here I am cool Avi NNN','','\0'),(9,0,'here I am cool Avi NNN','','\0'),(10,0,'here I am with you','','\0'),(11,0,'got tired of injuries','','\0'),(12,0,'got tired of injuries','','\0');
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

-- Dump completed on 2013-02-05 22:41:29
