package com.prodigious.messanger.service.impl;

import org.springframework.stereotype.Component;

import com.prodigious.messanger.domain.UserPhone;
import com.prodigious.messanger.repository.UserPhoneDao;
import com.prodigious.messanger.service.RegisterUserPhone;

@Component
public class RegisterUserPhoneImpl implements RegisterUserPhone{
	
	private UserPhoneDao phoneDao;
	
	public RegisterUserPhoneImpl(UserPhoneDao phoneDao) {
		this.phoneDao = phoneDao;
	}

	@Override
	public void saveNumber(UserPhone phone) {
		phoneDao.save(phone);
		
	}
}
