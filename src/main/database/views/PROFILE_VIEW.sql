select `U`.`USERS_ID` AS `USERS_ID`,
       `U`.`LOGIN_NAME` AS `LOGIN_NAME`,
		 `U`.`DISPLAY_NAME` AS `DISPLAY_NAME`,
		 `U`.`PRIMARY_IP` AS `PRIMARY_IP`,
		 `U`.`PRIMARY_MEMBER_GROUP_ID` AS `PRIMARY_MEMBER_GROUP_ID`,
		 `U`.`DATE_REGISTERED` AS `DATE_REGISTERED`,
		 `U`.`EMAIL_ADDRESS` AS `EMAIL_ADDRESS`,
		 `U`.`LAST_LOGIN` AS `LAST_LOGIN`,
		 `U`.`PERSONAL_TEXT` AS `PERSONAL_TEXT`,
		 `U`.`GENDER` AS `GENDER`,
		 `U`.`BIRTH_DATE` AS `BIRTH_DATE`,
		 `U`.`USER_TITLE` AS `USER_TITLE`,
		 `U`.`HIDE_EMAIL_FLAG` AS `HIDE_EMAIL_FLAG`,
		 `U`.`HIDE_AGE_FLAG` AS `HIDE_AGE_FLAG`,
		 `U`.`HIDE_GENDER_FLAG` AS `HIDE_GENDER_FLAG`,
		 `U`.`HIDE_BIRTH_DATE_FLAG` AS `HIDE_BIRTH_DATE_FLAG`,
		 `U`.`TIME_OFFSET` AS `TIME_OFFSET`,
		 `A`.`AVATAR_FILENAME` AS `AVATAR_FILENAME`,
		 `T`.`TIME_ZONE` AS `TIME_ZONE`,
		 U.SKYPE,
		 U.AIM,
		 U.YIM,
		 U.GTALK,
		 U.STEAM,
		 U.NNID,
		 U.XBOX_LIVE,
		 U.PSN,
		 U.HIDE_SKYPE_FLAG,
		 U.HIDE_AIM_FLAG,
		 U.HIDE_YIM_FLAG,
		 U.HIDE_GTALK_FLAG,
		 U.HIDE_STEAM_FLAG,
		 U.HIDE_NNID_FLAG,
		 U.HIDE_XBOX_LIVE_FLAG,
		 U.HIDE_PSN_FLAG
		 from `users` `U` 
		 join `AVATAR` `A` on`A`.`USERS_ID` = `U`.`USERS_ID`
		 join `LKUP_MEMBER_GROUP` `G` on `U`.`PRIMARY_MEMBER_GROUP_ID` = `G`.`MEMBER_GROUP_ID`
		 join `LKUP_TIMEZONES` `T` on `T`.`LKUP_TIMEZONES_ID` = `U`.`TIME_OFFSET`