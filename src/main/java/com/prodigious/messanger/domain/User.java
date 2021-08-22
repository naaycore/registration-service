package com.prodigious.messanger.domain;

import java.util.Date;

public class User {
	private String userId;
	private String userPhone;
	private Date createdAt;

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
}
