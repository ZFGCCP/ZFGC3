CREATE TABLE `PM_CONVERSATION` (
	`PM_CONVERSATION_ID` INT(11) NOT NULL AUTO_INCREMENT,
	`START_DT` DATETIME NOT NULL,
	`INITIATOR_ID` INT(11) NOT NULL,
	`SUBJECT` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`PM_CONVERSATION_ID`),
	INDEX `FK_PM_CONVERSATION_INITATOR_ID` (`INITIATOR_ID`),
	CONSTRAINT `FK_PM_CONVERSATION_INITATOR_ID` FOREIGN KEY (`INITIATOR_ID`) REFERENCES `users` (`USERS_ID`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=100
;
