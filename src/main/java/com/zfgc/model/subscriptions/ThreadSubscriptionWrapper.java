package com.zfgc.model.subscriptions;

import java.util.List;

import com.zfgc.model.pagination.Paginated;

public class ThreadSubscriptionWrapper extends Paginated {
	private List<ThreadSubscription> threadSubscriptions;

	public List<ThreadSubscription> getThreadSubscriptions() {
		return threadSubscriptions;
	}

	public void setThreadSubscriptions(List<ThreadSubscription> threadSubscriptions) {
		this.threadSubscriptions = threadSubscriptions;
	}
}