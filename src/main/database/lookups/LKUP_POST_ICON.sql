CREATE TABLE `LKUP_POST_ICON` (
	`LKUP_POST_ICON_ID` INT NOT NULL,
	`POST_ICON_CODE` CHAR(4) NOT NULL,
	`POST_ICON_IMAGE_URL` VARCHAR(64) NOT NULL,
	`POST_ICON_DESCRIPTION` VARCHAR(32) NOT NULL,
	PRIMARY KEY (`LKUP_POST_ICON_ID`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

INSERT INTO LKUP_POST_ICON (LKUP_POST_ICON_ID,POST_ICON_CODE,POST_ICON_IMAGE_URL,POST_ICON_DESCRIPTION)
VALUES(1,'STD','xx.png','Standard'),
      (2,'TMBU','thumbup','Thumbs up'),
      (3,'THBD','thumbdown','Thumbs down');