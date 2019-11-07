CREATE TABLE `AVATAR_STAGING` (
	`AVATAR_STAGING_ID` INT(11) NOT NULL,
	`FILENAME` VARCHAR(255) NOT NULL,
	`USERS_ID` INT(11) NOT NULL,
	`MAC` VARCHAR(16) NOT NULL,
	`CREATED_TS` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (`AVATAR_STAGING_ID`),
	INDEX `AVATAR_STAGING_USERS_ID` (`USERS_ID`),
	CONSTRAINT `AVATAR_STAGING_USERS_ID` FOREIGN KEY (`USERS_ID`) REFERENCES `users` (`USERS_ID`)
)
ENGINE=InnoDB
;