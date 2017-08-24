CREATE TABLE IF NOT EXISTS `PERSONAL_MESSAGE` (
  `PERSONAL_MESSAGE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SENDER_ID` int(11) NOT NULL,
  `RECEIVER_ID` int(11) NOT NULL,
  `SENT_DT` datetime NOT NULL,
  `SUBJECT` text NOT NULL,
  `MESSAGE` mediumtext NOT NULL,
  `READ_FLAG` bit(1) NOT NULL DEFAULT b'0',
  `SEND_COPY_FLAG` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`PERSONAL_MESSAGE_ID`),
  KEY `FK_PERSONAL_MESSAGE_ID_USERS_ID` (`SENDER_ID`),
  KEY `FK_PERSONAL_MESSAGE_ID_RECEIVER_ID` (`RECEIVER_ID`),
  CONSTRAINT `FK_PERSONAL_MESSAGE_ID_RECEIVER_ID` FOREIGN KEY (`RECEIVER_ID`) REFERENCES `users` (`USERS_ID`),
  CONSTRAINT `FK_PERSONAL_MESSAGE_ID_USERS_ID` FOREIGN KEY (`SENDER_ID`) REFERENCES `users` (`USERS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;