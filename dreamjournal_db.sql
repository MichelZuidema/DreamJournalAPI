-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.38-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.1.0.6116
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for dreamjournal_db
CREATE DATABASE IF NOT EXISTS `dreamjournal_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dreamjournal_db`;

-- Dumping structure for table dreamjournal_db.story
CREATE TABLE IF NOT EXISTS `story` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `content` varchar(255) NOT NULL DEFAULT '0',
    `secure` tinyint(4) NOT NULL DEFAULT '0',
    `password` varchar(255) DEFAULT '0',
    `deleted` tinyint(4) DEFAULT '0',
    `created_by` int(11) DEFAULT NULL,
    `created_at` datetime DEFAULT NULL,
    `updated_at` datetime DEFAULT NULL,
    KEY `Index 1` (`id`),
    KEY `FKk8ot2fwpo77g7w468jetl3ek3` (`created_by`),
    CONSTRAINT `FKk8ot2fwpo77g7w468jetl3ek3` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;

-- Dumping data for table dreamjournal_db.story: ~0 rows (approximately)
DELETE FROM `story`;
/*!40000 ALTER TABLE `story` DISABLE KEYS */;
/*!40000 ALTER TABLE `story` ENABLE KEYS */;

-- Dumping structure for table dreamjournal_db.user
CREATE TABLE IF NOT EXISTS `user` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(100) NOT NULL DEFAULT '0',
    `password` blob NOT NULL,
    `created_at` datetime DEFAULT NULL,
    `updated_at` datetime DEFAULT NULL,
    KEY `Index 1` (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- Dumping data for table dreamjournal_db.user: ~1 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
