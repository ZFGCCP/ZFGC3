CREATE TABLE `NAV_TAB` (
	`NAV_TAB_ID` INT(11) NOT NULL,
	`PARENT_TAB_ID` INT(11) NULL DEFAULT NULL,
	`TITLE` VARCHAR(32) NOT NULL,
	`SEQUENCE_NO` INT(11) NOT NULL DEFAULT '0',
	`SECTION_CODE` CHAR(4) NULL DEFAULT NULL,
	PRIMARY KEY (`NAV_TAB_ID`),
	UNIQUE INDEX `SECTION_CODE` (`SECTION_CODE`),
	INDEX `FK_NAV_TAB_ID_PARENT_TAB_ID` (`PARENT_TAB_ID`),
	CONSTRAINT `FK_NAV_TAB_ID_PARENT_TAB_ID` FOREIGN KEY (`PARENT_TAB_ID`) REFERENCES `NAV_TAB` (`NAV_TAB_ID`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

INSERT INTO `NAV_TAB` (`NAV_TAB_ID`, `LKUP_NAV_SECTION_ID`, `PARENT_TAB_ID`, `TITLE`, `SEQUENCE_NO`, `ALLOW_SELF_FLAG`) VALUES
	(0, 5, NULL, 'Profile Info', -4, b'0'),
	(1, 3, NULL, 'Modify Profile', -3, b'1'),
	(2, 4, NULL, 'Messaging', -2, b'0'),
	(3, 8, NULL, 'Track User', -1, b'0'),
	(4, 7, 0, 'Summary', 1, b'0'),
	(5, 1, 1, 'Account Settings', 1, b'1'),
	(6, 2, 1, 'Forum Profile', 1, b'1'),
	(7, 6, 0, 'Show Stats', 2, b'0'),
	(8, 9, 2, 'Notification Settings', 1, b'1'),
	(9, 10, 2, 'PM Settings', 2, b'1'),
	(10, 11, 2, 'Buddy/Ignore List', 3, b'1');
