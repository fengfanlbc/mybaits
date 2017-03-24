package com.zoro.domain;

import java.util.List;

public class UserQueryVO {
	//用户信息
	private User user;
	
	private List<Integer> idList;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Integer> getIdList() {
		return idList;
	}

	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}
	
	//商品信息
	
}
