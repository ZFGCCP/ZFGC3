-- --------------------------------------------------------
-- Host:                         zfgc.com
-- Server version:               5.5.61-0ubuntu0.14.04.1 - (Ubuntu)
-- Server OS:                    debian-linux-gnu
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table zfgc3_dev.SYSTEM_DIRECTORIES
CREATE TABLE IF NOT EXISTS `SYSTEM_DIRECTORIES` (
  `SYSTEM_DIRECTORY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SYSTEM_DIRECTORY_CODE` varchar(10) NOT NULL,
  `SYSTEM_DIRECTORY_DESC` varchar(50) NOT NULL,
  `SYSTEM_PATH` varchar(260) NOT NULL,
  PRIMARY KEY (`SYSTEM_DIRECTORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
