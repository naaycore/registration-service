package com.prodigious.messanger.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("UserPhone")
public class UserPhone {
	@Id
	private String phoneNumber;
	private String key;
	private long requestTime;
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public long getRequestTime() {
		return requestTime;
	}
	
	public void setRequestTime(long requestTime) {
		this.requestTime = requestTime;
	}
}
