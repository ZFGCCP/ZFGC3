package com.zfgc.model.forum;

import java.util.ArrayList;
import java.util.List;

import com.zfgc.model.BaseZfgcModel;

public class Thread extends Topic {
	
	private List<ThreadPost> posts = new ArrayList<>();
	
	public List<ThreadPost> getPosts() {
		return posts;
	}
	public void setPosts(List<ThreadPost> posts) {
		this.posts = posts;
	}
	
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public BaseZfgcModel copy(BaseZfgcModel other) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ThreadPost getHeadPost() {
		if(posts.isEmpty()) {
			return null;
		}
		
		return posts.get(0);
	}
	
	public ThreadPost getTailPost() {
		if(posts.isEmpty()) {
			return null;
		}

		return posts.get(posts.size() - 1);

	}
	
}
