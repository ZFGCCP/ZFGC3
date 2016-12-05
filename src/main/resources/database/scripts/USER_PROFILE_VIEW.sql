SELECT U.USERS_ID, 
       U.LOGIN_NAME, 
		 U.DISPLAY_NAME, 
		 U.PRIMARY_IP, 
		 U.PRIMARY_MEMBER_GROUP_ID, 
		 U.DATE_REGISTERED,
		 U.EMAIL_ADDRESS,
		 U.LAST_LOGIN,
		 U.PERSONAL_TEXT,
		 U.GENDER,
		 U.BIRTH_DATE,
		 U.USER_TITLE,
		 U.HIDE_EMAIL_FLAG,
		 U.HIDE_AGE_FLAG,
		 U.HIDE_GENDER_FLAG,
		 U.HIDE_BIRTH_DATE_FLAG,
		 U.TIME_OFFSET,
		 A.AVATAR_FILENAME,
		 T.TIME_ZONE
FROM users U
JOIN AVATAR A ON A.USERS_ID = U.USERS_ID
JOIN LKUP_MEMBER_GROUP G ON U.PRIMARY_MEMBER_GROUP_ID = G.MEMBER_GROUP_ID
JOIN LKUP_TIMEZONES T ON T.LKUP_TIMEZONES_ID = U.TIME_OFFSET