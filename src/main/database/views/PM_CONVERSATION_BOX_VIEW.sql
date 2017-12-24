CREATE OR REPLACE VIEW AS PM_CONVERSATION_BOX_VIEW AS
select C.PM_CONVERSATION_ID,
       PM.RECEIVER_ID as USERS_ID,
       PM.RECEIVER_ID,
       C.INITIATOR_ID,
       PM.PERSONAL_MESSAGE_ID,
		 PM.SUBJECT,
		 PM.MESSAGE,
		 PM.SENT_DT,
		 C.START_DT
from PM_CONVERSATION C 
join PERSONAL_MESSAGE PM on PM.PM_CONVERSATION_ID = C.PM_CONVERSATION_ID 
where (PM.SENT_DT = (select max(PM2.SENT_DT) 
                      from PERSONAL_MESSAGE PM2 
							 where ((PM2.PM_CONVERSATION_ID = C.PM_CONVERSATION_ID)))) and 
		 PM.SEND_COPY_FLAG = 0
		 
UNION

select C.PM_CONVERSATION_ID,
       PM.SENDER_ID AS USERS_ID,
       PM.RECEIVER_ID,
       C.INITIATOR_ID,
       PM.PERSONAL_MESSAGE_ID,
		 PM.SUBJECT,
		 PM.MESSAGE,
		 PM.SENT_DT,
		 C.START_DT
from PM_CONVERSATION C 
join PERSONAL_MESSAGE PM on PM.PM_CONVERSATION_ID = C.PM_CONVERSATION_ID 
where (PM.SENT_DT = (select max(PM2.SENT_DT) 
                      from PERSONAL_MESSAGE PM2 
							 where ((PM2.PM_CONVERSATION_ID = C.PM_CONVERSATION_ID)))) and 
		 PM.SEND_COPY_FLAG = 1