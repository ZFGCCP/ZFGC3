CREATE TABLE IF NOT EXISTS `PM_KEY` (
  `PM_KEY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERS_ID` int(11) NOT NULL,
  `PM_PUB_KEY_RSA` varchar(3000) NOT NULL,
  `PM_PRIV_KEY_RSA_ENCRYPTED` varchar(3000) NOT NULL,
  PRIMARY KEY (`PM_KEY_ID`),
  UNIQUE KEY `USERS_ID` (`USERS_ID`),
  CONSTRAINT `FK_PM_KEY_ID_USERS_ID` FOREIGN KEY (`USERS_ID`) REFERENCES `users` (`USERS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;