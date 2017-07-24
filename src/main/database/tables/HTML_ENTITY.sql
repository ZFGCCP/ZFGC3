CREATE TABLE `HTML_ENTITY` (
	`HTML_ENTITY_ID` INT(11) NOT NULL,
	`HTML_CHARACTER` VARCHAR(3) NOT NULL,
	`HTML_ENTITY` VARCHAR(10) NOT NULL,
	PRIMARY KEY (`HTML_ENTITY_ID`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

INSERT INTO `HTML_ENTITY` (`HTML_ENTITY_ID`, `HTML_CHARACTER`, `HTML_ENTITY`) VALUES
	(0, '&', '&amp;'),
	(1, '"', '&#34;'),
	(2, '\'', '&#39;'),
	(3, '-', '&#45;'),
	(4, '<', '&lt;'),
	(5, '>', '&gt;'),
	(6, '\\\\+', '&#43;'),
	(7, '`', '&#96;');