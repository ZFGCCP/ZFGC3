CREATE TABLE `users` (
	`USERS_ID` INT(11) NOT NULL AUTO_INCREMENT,
	`PRIMARY_HOSTNAME_ID` INT(11) NULL DEFAULT NULL,
	`PRIMARY_MEMBER_GROUP_ID` INT(11) NOT NULL DEFAULT '2',
	`PRIMARY_IP` INT(11) NULL DEFAULT '2',
	`LOGIN_NAME` VARCHAR(64) NOT NULL,
	`DISPLAY_NAME` VARCHAR(64) NOT NULL,
	`PASSWORD` CHAR(128) NULL DEFAULT NULL,
	`PASS_SALT` CHAR(200) NOT NULL,
	`DATE_REGISTERED` DATETIME NOT NULL,
	`LANGUAGE` INT(11) NOT NULL DEFAULT '1',
	`LAST_LOGIN` DATETIME NULL DEFAULT NULL,
	`PERSONAL_TEXT` VARCHAR(64) NULL DEFAULT NULL,
	`GENDER_ID` INT(11) NULL DEFAULT NULL,
	`BIRTH_DATE` DATETIME NOT NULL DEFAULT '2000-01-01 00:00:00',
	`WEBSITE_TITLE` VARCHAR(32) NULL DEFAULT NULL,
	`WEBSITE_URL` VARCHAR(64) NULL DEFAULT NULL,
	`LOCATION` VARCHAR(32) NULL DEFAULT NULL,
	`SHOW_ONLINE_FLAG` BIT(1) NOT NULL DEFAULT b'1',
	`TIME_FORMAT` VARCHAR(24) NOT NULL DEFAULT 'MM//dd//yyyy hh:mm:ss',
	`SIGNATURE` VARCHAR(256) NULL DEFAULT NULL,
	`ACTIVE_FLAG` BIT(1) NOT NULL DEFAULT b'0',
	`TIME_OFFSET` SMALLINT(6) NULL DEFAULT '545',
	`PM_EMAIL_NOTIF_FLAG` BIT(1) NOT NULL DEFAULT b'1',
	`AVATAR_ID` INT(11) NULL DEFAULT NULL,
	`USER_TITLE` VARCHAR(32) NULL DEFAULT NULL,
	`TOTAL_TIME_LOGGED_IN` INT(11) NOT NULL DEFAULT '0',
	`WARN_LEVEL` TINYINT(4) NOT NULL DEFAULT '0',
	`LOCKED_UNTIL` DATETIME NULL DEFAULT NULL,
	`LOGIN_FAILED_ATTEMPTS` TINYINT(4) NOT NULL DEFAULT '0',
	`CUSTOM_TITLE` VARCHAR(64) NULL DEFAULT NULL,
	`ACTIVE_CONNECTIONS` INT(11) NOT NULL DEFAULT '0',
	`EMAIL_ACTIVATION_CODE` VARCHAR(128) NULL DEFAULT NULL,
	`PM_PUB_KEY` VARCHAR(3000) NULL DEFAULT NULL,
	PRIMARY KEY (`USERS_ID`),
	UNIQUE INDEX `IDX_USERS_LOGIN_NAME` (`LOGIN_NAME`),
	UNIQUE INDEX `IDX_USERS_DISPLAY_NAME` (`DISPLAY_NAME`),
	UNIQUE INDEX `AVATAR_ID` (`AVATAR_ID`),
	INDEX `FK_LANGUAGE` (`LANGUAGE`),
	INDEX `FK_PRIMARY_MEMBER_GROUP` (`PRIMARY_MEMBER_GROUP_ID`),
	INDEX `FK_USERS_TIMEZONE` (`TIME_OFFSET`),
	INDEX `FK_USERS_GENDER_ID` (`GENDER_ID`),
	INDEX `FK_USERS_IP_ADDRESS` (`PRIMARY_IP`),
	INDEX `FK_USERS_HOSTNAME` (`PRIMARY_HOSTNAME_ID`),
	CONSTRAINT `FK_USERS_HOSTNAME` FOREIGN KEY (`PRIMARY_HOSTNAME_ID`) REFERENCES `HOSTNAME` (`HOSTNAME_ID`),
	CONSTRAINT `FK_LANGUAGE` FOREIGN KEY (`LANGUAGE`) REFERENCES `LKUP_LANGUAGES` (`LK_LANGUAGES_ID`),
	CONSTRAINT `FK_PRIMARY_MEMBER_GROUP` FOREIGN KEY (`PRIMARY_MEMBER_GROUP_ID`) REFERENCES `LKUP_MEMBER_GROUP` (`MEMBER_GROUP_ID`),
	CONSTRAINT `FK_USERS_AVATAR_ID` FOREIGN KEY (`AVATAR_ID`) REFERENCES `AVATAR` (`AVATAR_ID`) ON DELETE SET NULL,
	CONSTRAINT `FK_USERS_GENDER_ID` FOREIGN KEY (`GENDER_ID`) REFERENCES `LKUP_GENDER` (`GENDER_ID`),
	CONSTRAINT `FK_USERS_IP_ADDRESS` FOREIGN KEY (`PRIMARY_IP`) REFERENCES `IP_ADDRESS` (`IP_ADDRESS_ID`),
	CONSTRAINT `FK_USERS_TIMEZONE` FOREIGN KEY (`TIME_OFFSET`) REFERENCES `LKUP_TIMEZONES` (`LKUP_TIMEZONES_ID`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=27430
;
