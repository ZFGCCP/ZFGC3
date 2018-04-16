CREATE TABLE IF NOT EXISTS `BB_CODE_ATTRIBUTE_MODE` (
  `BB_CODE_ATTRIBUTE_MODE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BB_CODE_CONFIG_ID` int(11) NOT NULL,
  `CONTENT_IS_ATTRIBUTE_FLAG` bit(1) NOT NULL DEFAULT b'0',
  `OPEN_TAG` varchar(512) NOT NULL,
  `CLOSE_TAG` varchar(512) NOT NULL,
  `OUTPUT_CONTENT_FLAG` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`BB_CODE_ATTRIBUTE_MODE_ID`),
  KEY `FK_BB_CODE_ATTRIBUTE_MODE_BB_CODE_CONFIG` (`BB_CODE_CONFIG_ID`),
  CONSTRAINT `FK_BB_CODE_ATTRIBUTE_MODE_BB_CODE_CONFIG` FOREIGN KEY (`BB_CODE_CONFIG_ID`) REFERENCES `BB_CODE_CONFIG` (`BB_CODE_CONFIG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Dumping data for table zfgc3_dev.BB_CODE_ATTRIBUTE_MODE: ~6 rows (approximately)
/*!40000 ALTER TABLE `BB_CODE_ATTRIBUTE_MODE` DISABLE KEYS */;
INSERT INTO `BB_CODE_ATTRIBUTE_MODE` (`BB_CODE_ATTRIBUTE_MODE_ID`, `BB_CODE_CONFIG_ID`, `CONTENT_IS_ATTRIBUTE_FLAG`, `OPEN_TAG`, `CLOSE_TAG`, `OUTPUT_CONTENT_FLAG`) VALUES
	(1, 5, b'1', '<span class=\'bb-code-img\'><img src=\'{{c}}\'/>', '</span>', b'0'),
	(2, 4, b'0', '<a href=\'{{0}}\'>', '</a>', b'1'),
	(3, 4, b'1', '<a href=\'{{c}}\'>', '</a>', b'1'),
	(4, 1, b'0', '<span class=\'bb-code-b\'>', '</span>', b'1'),
	(5, 2, b'0', '<span class=\'bb-code-i\'>', '</span>', b'1'),
	(6, 3, b'0', '<span class=\'bb-code-u\'>', '</span>', b'1');
/*!40000 ALTER TABLE `BB_CODE_ATTRIBUTE_MODE` ENABLE KEYS */;