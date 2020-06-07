SELECT T.THREAD_ID, 
	   T.NAME, 
	   T.THREAD_STARTER_ID, 
	   T.VIEWS,
	   T.LATEST_POST_ID,
	   T.POST_ICON_ID,
	   T.NEW_POSTS_FLAG,
	   T.POST_STATUS_ID,
	   T.LOCKED_FLAG,
	   T.STICKY_FLAG,
	   T.POLL_FLAG,
	   T.PARENT_FORUM_ID,
	   TP.AUTHOR_ID AS LATEST_POST_AUTHOR_ID,
	   US.DISPLAY_NAME AS AUTHOR_NAME,
	   UR.DISPLAY_NAME AS LATEST_AUTHOR_NAME,
	   PC.POST_DATA AS LATEST_POST_DATA
FROM THREAD T
JOIN users US ON T.THREAD_STARTER_ID = US.USERS_ID
JOIN THREAD_POST TP ON TP.THREAD_POST_ID = T.LATEST_POST_ID
JOIN POST_CONTENT PC ON PC.THREAD_POST_ID = TP.THREAD_POST_ID AND PC.CURRENT_FLAG = 1
JOIN users UR ON UR.USERS_ID = TP.AUTHOR_ID