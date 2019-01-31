select `U`.`DISPLAY_NAME` AS `DISPLAY_NAME`,
       `U`.`USERS_ID` AS `USERS_ID`,
       `U`.`LAST_LOGIN` AS `LAST_LOGIN` 
       from `zfgc3_dev`.`users` `U` 
       where (`U`.`ACTIVE_CONNECTIONS` > 0) 