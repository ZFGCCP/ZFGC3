package com.zfgc.model.subscriptions;

import com.zfgc.model.BaseZfgcModel;

public class ThreadSubscription extends BaseZfgcModel{

	private Integer threadId;
    private String name;
    private Integer threadStarterId;
    private String threadStarterName;
    private String subscriberId;
    private String subscriberName;
    
	public Integer getThreadId() {
		return threadId;
	}

	public void setThreadId(Integer threadId) {
		this.threadId = threadId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getThreadStarterId() {
		return threadStarterId;
	}

	public void setThreadStarterId(Integer threadStarterId) {
		this.threadStarterId = threadStarterId;
	}

	public String getThreadStarterName() {
		return threadStarterName;
	}

	public void setThreadStarterName(String threadStarterName) {
		this.threadStarterName = threadStarterName;
	}

	@Override
	public boolean equals(Object other){
		ThreadSubscription compare = (ThreadSubscription)other;
		
		return this.name.equals(compare.name) &&
		       this.threadId.equals(compare.threadId) &&
		       this.threadStarterId.equals(compare.threadStarterId) &&
		       this.threadStarterName.equals(compare.threadStarterName);
	}
	
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSubscriberName() {
		return subscriberName;
	}

	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}

	public String getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}

	@Override
	public BaseZfgcModel copy(BaseZfgcModel other) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
