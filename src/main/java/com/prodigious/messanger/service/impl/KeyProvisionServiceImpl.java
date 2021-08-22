package com.prodigious.messanger.service.impl;

import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.prodigious.messanger.domain.UserPhone;
import com.prodigious.messanger.repository.UserPhoneRepository;
import com.prodigious.messanger.service.KeyProvisionService;

@Service
public class KeyProvisionServiceImpl implements KeyProvisionService{
	private UserPhoneRepository UserPhoneRepository;

	public KeyProvisionServiceImpl(UserPhoneRepository userPhoneRepository) {
		this.UserPhoneRepository = userPhoneRepository;
	}
	
	@Override
	public String getKeyForUserPhone(UserPhone userPhone) {
		String key = generateKey();
		userPhone.setKey(key);
		userPhone.setRequestTime(new Date().getTime());
		UserPhoneRepository.save(userPhone);
		return key;
	}
	
	private String generateKey() {
		int leftLimit = 48;
	    int rightLimit = 122;
	    int targetStringLength = 8;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    return generatedString;
	}
}
