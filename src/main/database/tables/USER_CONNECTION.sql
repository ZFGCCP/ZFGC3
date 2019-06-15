CREATE TABLE `USER_CONNECTION` (
	`USER_CONNECTION_ID` INT(11) NOT NULL AUTO_INCREMENT,
	`USERS_ID` INT(11) NOT NULL,
	`USER_AGENT_VERSION` VARCHAR(50) NULL DEFAULT NULL,
	`IP_ADDRESS_ID` INT(11) NOT NULL,
	`USER_AGENT` VARCHAR(50) NULL DEFAULT NULL,
	`OS_TYPE` VARCHAR(50) NULL DEFAULT NULL,
	`OS_NAME` VARCHAR(50) NULL DEFAULT NULL,
	`OS_VERSION` VARCHAR(50) NULL DEFAULT NULL,
	`SESSION_ID` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`USER_CONNECTION_ID`),
	UNIQUE INDEX `SESSION_ID` (`SESSION_ID`),
	INDEX `FK_USER_CONNECTION_USERS_ID` (`USERS_ID`),
	INDEX `FK_USER_CONNECTION_IP_ADDRESS_ID` (`IP_ADDRESS_ID`),
	CONSTRAINT `FK_USER_CONNECTION_IP_ADDRESS_ID` FOREIGN KEY (`IP_ADDRESS_ID`) REFERENCES `IP_ADDRESS` (`IP_ADDRESS_ID`),
	CONSTRAINT `FK_USER_CONNECTION_USERS_ID` FOREIGN KEY (`USERS_ID`) REFERENCES `users` (`USERS_ID`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=5
;
