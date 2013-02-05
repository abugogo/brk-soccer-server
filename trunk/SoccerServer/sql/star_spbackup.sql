-- MySQL dump 10.13  Distrib 5.5.29, for Win64 (x86)
--
-- Host: localhost    Database: abugogo_acc_star
-- ------------------------------------------------------
-- Server version	5.5.29
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping routines for database 'abugogo_acc_star'
--
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `getPlayerAggrEventTable`(IN evt_type INT, in start_date DATETIME, in end_date DATETIME)
BEGIN
DECLARE iter_id BIGINT(20);
DECLARE first_name VARCHAR(45);
DECLARE last_name VARCHAR(45);
DECLARE done INT DEFAULT FALSE;
DECLARE cur1 CURSOR FOR SELECT id,fname,lname FROM abugogo_soccer_sys.users;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

DROP TEMPORARY TABLE IF EXISTS output;
CREATE TEMPORARY TABLE output (
	pid BIGINT(20), 
	fname VARCHAR(45), 
	lname VARCHAR(45), 
	count INT default 0, 
	type INT
) ENGINE=MEMORY;

OPEN cur1;

read_loop: LOOP
FETCH cur1 INTO iter_id,first_name,last_name;
IF done THEN
      LEAVE read_loop;
END IF;
INSERT INTO output SELECT 
	iter_id as pid,
	first_name,
	last_name,
    SUM(LNPEG.tgoals) as evt_count,
	evt_type
FROM
    (SELECT
		game_date,
		GMS.game_id as game_id,
        LNP.player_id as player_id
    FROM
        abugogo_acc_star.lineup LNP
    INNER JOIN abugogo_acc_star.games_tbl GMS ON LNP.game_id = GMS.game_id
    WHERE
        LNP.player_id = iter_id) LG
        LEFT JOIN
    (SELECT 
        count(type) as tgoals, gid, pid
    FROM
        abugogo_acc_star.lineup_events
    WHERE
        type = evt_type AND pid = iter_id
    GROUP BY gid) LNPEG ON LNPEG.gid = LG.game_id
WHERE LG.game_date between start_date AND end_date 
	AND tgoals > 0
ORDER BY evt_count DESC;
END LOOP;
CLOSE cur1;
SELECT * FROM output ORDER BY count DESC;
DROP TEMPORARY TABLE IF EXISTS output;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `getPlayerEventTable`(IN evt_type INT, in start_date DATETIME, in end_date DATETIME)
BEGIN
DECLARE iter_id BIGINT(20);
DECLARE first_name VARCHAR(45);
DECLARE last_name VARCHAR(45);
DECLARE done INT DEFAULT FALSE;
DECLARE cur1 CURSOR FOR SELECT id,fname,lname FROM abugogo_soccer_sys.users;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

DROP TEMPORARY TABLE IF EXISTS output;
CREATE TEMPORARY TABLE output (
	pid BIGINT(20), 
	fname VARCHAR(45), 
	lname VARCHAR(45), 
	color SET('b','w'), 
	date DATETIME, 
	winner SET('b','w','d'), 
	gid BIGINT(20), 
	count INT, 
	type INT
) ENGINE=MEMORY;

OPEN cur1;

read_loop: LOOP
FETCH cur1 INTO iter_id,first_name,last_name;
IF done THEN
      LEAVE read_loop;
END IF;
INSERT INTO output SELECT 
	LG.player_id as pid,
	first_name,
	last_name,
    LG.color as c,
    LG.game_date as d,
    LG.winner as w,
    LG.game_id as g,
    LNPEG.tgoals as evt_count,
	LNPEG.type as evt_type
FROM
    (SELECT 
        color as color,
            game_date,
            winner,
            GMS.game_id as game_id,
            LNP.player_id as player_id
    FROM
        abugogo_acc_star.lineup LNP
    INNER JOIN abugogo_acc_star.games_tbl GMS ON LNP.game_id = GMS.game_id
    WHERE
        LNP.player_id = iter_id) LG
        LEFT JOIN
    (SELECT 
        count(type) as tgoals, gid, type
    FROM
        abugogo_acc_star.lineup_events
    WHERE
        type = evt_type AND pid = iter_id
    GROUP BY gid) LNPEG ON LNPEG.gid = LG.game_id
WHERE LG.game_date between start_date AND end_date
GROUP BY g
ORDER BY evt_count DESC
LIMIT 1;
END LOOP;
CLOSE cur1;
SELECT * FROM output ORDER BY count DESC;
DROP TEMPORARY TABLE IF EXISTS output;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `getPlayersRecords`(IN in_player_id BIGINT(20), in start_date DATETIME, in end_date DATETIME)
BEGIN
SELECT 
    LG.player_id as pid,
    LG.color as c,
    LG.game_date as d,
    LG.winner as w,
    LG.game_id as g,
    LNPEG.tgoals as tg,
    LNPEC.tcooks as tc,
	LNPEOG.towng as tog
FROM
    (SELECT 
        color as color,
            game_date,
            winner,
            GMS.game_id as game_id,
            LNP.player_id as player_id
    FROM
        abugogo_acc_star.lineup LNP
    INNER JOIN abugogo_acc_star.games_tbl GMS ON LNP.game_id = GMS.game_id
    WHERE
        LNP.player_id = in_player_id) LG
        LEFT JOIN
    (SELECT 
        count(type) as tgoals, gid
    FROM
        abugogo_acc_star.lineup_events
    WHERE
        type = 0 AND pid = in_player_id
    GROUP BY gid) LNPEG ON LNPEG.gid = LG.game_id
        LEFT JOIN
    (SELECT 
        count(type) as tcooks, gid
    FROM
        abugogo_acc_star.lineup_events
    WHERE
        type = 1 AND pid = in_player_id
    GROUP BY gid) LNPEC ON LNPEC.gid = LG.game_id
	LEFT JOIN
    (SELECT 
        count(type) as towng, gid
    FROM
        abugogo_acc_star.lineup_events
    WHERE
        type = 2 AND pid = in_player_id
    GROUP BY gid) LNPEOG ON LNPEOG.gid = LG.game_id
WHERE LG.game_date between start_date AND end_date
GROUP BY g
ORDER BY d;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-02-05 23:01:51
