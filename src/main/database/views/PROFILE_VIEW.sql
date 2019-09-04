select 
`U`.`USERS_ID` AS `USERS_ID`,
`U`.`LOGIN_NAME` AS `LOGIN_NAME`,
`U`.`DISPLAY_NAME` AS `DISPLAY_NAME`,
`U`.`PRIMARY_IP` AS `PRIMARY_IP`,
U.PRIMARY_HOSTNAME_ID AS HOSTNAME_ID,
`U`.`PRIMARY_MEMBER_GROUP_ID` AS `PRIMARY_MEMBER_GROUP_ID`,
`U`.`DATE_REGISTERED` AS `DATE_REGISTERED`,
`E`.`EMAIL_ADDRESS` AS `EMAIL_ADDRESS`,
`E`.`EMAIL_ADDRESS_ID` AS `EMAIL_ADDRESS_ID`,
`U`.`LAST_LOGIN` AS `LAST_LOGIN`,
`I`.`PERSONAL_TEXT` AS `PERSONAL_TEXT`,
`I`.`GENDER_ID` AS `GENDER_ID`,
`I`.`BIRTH_DATE` AS `BIRTH_DATE`,
`U`.`USER_TITLE` AS `USER_TITLE`,
 CASE WHEN U.ACTIVE_CONNECTIONS > 0 THEN 1 
 ELSE 0 END AS IS_ONLINE_FLAG,
`S`.`HIDE_EMAIL_FLAG` AS `HIDE_EMAIL_FLAG`,
`S`.`HIDE_GENDER_FLAG` AS `HIDE_GENDER_FLAG`,
`S`.`HIDE_BIRTH_DATE_FLAG` AS `HIDE_BIRTH_DATE_FLAG`,
`S`.`USER_SECURITY_SETTINGS_ID` AS `USER_SECURITY_SETTINGS_ID`,
`U`.`TIME_OFFSET` AS `TIME_OFFSET`,
`T`.`TIME_ZONE` AS `TIME_ZONE`,
`I`.`SIGNATURE` AS `SIGNATURE`,
`C`.`SKYPE` AS `SKYPE`,
`C`.`GTALK` AS `GTALK`,
`C`.`STEAM` AS `STEAM`,
`C`.`NNID` AS `NNID`,
`C`.`XBOX_LIVE` AS `XBOX_LIVE`,
`C`.`PSN` AS `PSN`,
C.FACEBOOK,
`C`.`USER_CONTACT_SETTINGS_ID` AS `USER_CONTACT_SETTINGS_ID`,
`S`.`HIDE_SKYPE_FLAG` AS `HIDE_SKYPE_FLAG`,
`S`.`HIDE_GTALK_FLAG` AS `HIDE_GTALK_FLAG`,
`S`.`HIDE_STEAM_FLAG` AS `HIDE_STEAM_FLAG`,
`S`.`HIDE_NNID_FLAG` AS `HIDE_NNID_FLAG`,
`S`.`HIDE_XBOX_LIVE_FLAG` AS `HIDE_XBOX_LIVE_FLAG`,
`S`.`HIDE_PSN_FLAG` AS `HIDE_PSN_FLAG`,
S.HIDE_FACEBOOK_FLAG,
`A`.`AVATAR_ID` AS `AVATAR_ID`,
`A`.`AVATAR_FILENAME` AS `AVATAR_FILENAME`,
`A`.`AVATAR_URL` AS `AVATAR_URL`,
`A`.`AVATAR_GALLERY_ID` AS `AVATAR_GALLERY_ID`,
`A`.`AVATAR_TYPE_ID` AS `AVATAR_TYPE_ID`,
`AG`.`AVATAR_FILE_PATH` AS `AVATAR_FILE_PATH`,
`I`.`CUSTOM_TITLE` AS `CUSTOM_TITLE`,
`I`.`LOCATION` AS `LOCATION`,
`I`.`WEBSITE_TITLE` AS `WEBSITE_TITLE`,
`I`.`WEBSITE_URL` AS `WEBSITE_URL`,
`I`.`USER_PERSONAL_INFO_ID` AS `USER_PERSONAL_INFO_ID`,
`N`.`NOTIFICATION_SETTINGS_ID` AS `NOTIFICATION_SETTINGS_ID`,
`N`.`KARMA_EMAIL_FLAG` AS `KARMA_EMAIL_FLAG`,
`N`.`KARMA_PM_FLAG` AS `KARMA_PM_FLAG`,
`N`.`TAGGED_EMAIL_FLAG` AS `TAGGED_EMAIL_FLAG`,
`N`.`TAGGED_PM_FLAG` AS `TAGGED_PM_FLAG`,
`N`.`FREQUENCY_ID` AS `FREQUENCY_ID`,
`P`.`PERSONAL_MESSAGING_SETTINGS_ID` AS `PERSONAL_MESSAGING_SETTINGS_ID`,
`P`.`RECEIVE_FROM_ID` AS `RECEIVE_FROM_ID`,
`P`.`NOTIFY_FREQUENCY_ID` AS `NOTIFY_FREQUENCY_ID`,
U.ACTIVE_FLAG,
G.MEMBER_GROUP_ID,
G.GROUP_NAME,
G.MIN_POSTS,
G.STARS_SPRITE,
G.HIDDEN_FLAG,
G.PARENT_GROUP,
IP.IP_ADDRESS,
HOST.HOSTNAME

from ((((((((((
`users` `U` 
left join `NOTIFICATION_SETTINGS` `N` on((`N`.`USERS_ID` = `U`.`USERS_ID`))) 
left join `PERSONAL_MESSAGING_SETTINGS` `P` on((`P`.`USERS_ID` = `U`.`USERS_ID`))) 
left join `USER_CONTACT_SETTINGS` `C` on((`C`.`USERS_ID` = `U`.`USERS_ID`))) 
left join `USER_SECURITY_SETTINGS` `S` on((`S`.`USERS_ID` = `U`.`USERS_ID`))) 
left join `USER_PERSONAL_INFO` `I` on((`I`.`USERS_ID` = `U`.`USERS_ID`))) 
left join `EMAIL_ADDRESS` `E` on((`E`.`EMAIL_ADDRESS_ID` = `C`.`EMAIL_ADDRESS_ID`))) 
left join `AVATAR` `A` on((`A`.`AVATAR_ID` = `I`.`AVATAR_ID`))) 
left join `LKUP_AVATAR_GALLERY` `AG` on((`AG`.`AVATAR_GALLERY_ID` = `A`.`AVATAR_GALLERY_ID`))) 
left join `LKUP_MEMBER_GROUP` `G` on((`U`.`PRIMARY_MEMBER_GROUP_ID` = `G`.`MEMBER_GROUP_ID`))) 
left join `LKUP_TIMEZONES` `T` on((`T`.`LKUP_TIMEZONES_ID` = `U`.`TIME_OFFSET`)))
JOIN IP_ADDRESS IP ON IP.IP_ADDRESS_ID = U.PRIMARY_IP
LEFT JOIN HOSTNAME HOST ON HOST.HOSTNAME_ID = U.PRIMARY_HOSTNAME_ID