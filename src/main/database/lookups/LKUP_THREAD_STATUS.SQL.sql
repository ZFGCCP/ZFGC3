CREATE TABLE `LKUP_THREAD_STATUS` (
	`LKUP_THREAD_STATUS_ID` INT(11) NOT NULL,
	`THREAD_STATUS_CODE` CHAR(4) NOT NULL,
	`THREAD_STATUS_DESC` VARCHAR(32) NOT NULL,
	`THREAD_STATUS_URL` VARCHAR(64) NOT NULL
)
ENGINE=InnoDB
;

INSERT INTO LKUP_THREAD_STATUS (LKUP_THREAD_STATUS_ID, THREAD_STATUS_CODE,THREAD_STATUS_DESC,THREAD_STATUS_URL)
VALUES(1,'HOT','Hot Thread!!','hot.png'),
      (2,'HOTP','Hot Poll!!','hotPoll.png'),
      (3,'NML','Normal Thread','normal.png'),
      (4,'NMLP','Normal Poll','normalPoll.png'),
      (5,'HTO','Hot Thread!!','hotOwn.png'),
      (6,'HTPO','Hot Poll!!','hotOwn.png'),
      (7,'NMLO','Normal Thread','normalOwn.png'),
      (8,'NMPO','Normal Poll','normalPollOwn.png')