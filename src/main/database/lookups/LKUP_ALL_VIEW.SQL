select 'LKUP_TIMEZONES' AS `LKUP_TABLE`,
       'TIMEZONE' AS `LKUP_NAME`,
       `LKUP_TIMEZONES`.`LKUP_TIMEZONES_ID` AS `LKUP_ID`,
       `LKUP_TIMEZONES`.`TIME_ZONE` AS `LKUP_DESC` 
       from `LKUP_TIMEZONES` 
       union 
select 'LKUP_MEMBER_GROUP' AS `LKUP_TABLE`,
       'MEMBER_GROUP' AS `LKUP_NAME`,
       `LKUP_MEMBER_GROUP`.`MEMBER_GROUP_ID` AS `LKUP_ID`,
       `LKUP_MEMBER_GROUP`.`GROUP_NAME` AS `LKUP_DESC` 
       from `LKUP_MEMBER_GROUP` 
       union 
select 'LKUP_LANGUAGES' AS `LKUP_TABLE`,
       'LANGUAGE' AS `LKUP_NAME`,
       `LKUP_LANGUAGES`.`LK_LANGUAGES_ID` AS `LKUP_ID`,
       `LKUP_LANGUAGES`.`LANGUAGE_NAME` AS `LKUP_DESC` 
       from `LKUP_LANGUAGES` 
       union 
select 'LKUP_LOG_TYPE' AS `LKUP_TABLE`,
       'LOG_TYPE' AS `LKUP_NAME`,
       `LKUP_LOG_TYPE`.`LOG_TYPE_ID` AS `LKUP_ID`,
       `LKUP_LOG_TYPE`.`DESC` AS `LKUP_DESC` 
       from `LKUP_LOG_TYPE`
       union
select 'LKUP_POST_ICON' AS `LKUP_TABLE`,
	   'POST_ICON' AS `LKUP_NAME`,
	   LKUP_POST_ICON_ID AS LKUP_ID,
	   POST_ICON_DESCRIPTION AS LKUP_DESC
	   FROM LKUP_POST_ICON
	   union
select 'LKUP_THREAD_STATUS' AS `LKUP_TABLE`,
	   'THREAD_STATUS' AS `LKUP_NAME`,
	   LKUP_THREAD_STATUS_ID AS LKUP_ID,
	   THREAD_STATUS_DESC AS LKUP_DESC
	   FROM LKUP_THREAD_STATUS