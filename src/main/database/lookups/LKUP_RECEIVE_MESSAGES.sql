CREATE TABLE IF NOT EXISTS `LKUP_RECEIVE_MESSAGES` (
  `LKUP_RECEIVE_MESSAGES_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DESC` varchar(40) NOT NULL DEFAULT '0',
  PRIMARY KEY (`LKUP_RECEIVE_MESSAGES_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


DELETE FROM `LKUP_RECEIVE_MESSAGES`;
INSERT INTO `LKUP_RECEIVE_MESSAGES` (`LKUP_RECEIVE_MESSAGES_ID`, `DESC`) VALUES
	(1, 'All members'),
	(2, 'All members, excluding my ignore list'),
	(3, 'Buddies and staff only'),
	(4, 'Staff only');