package com.prodigious.messanger.service.impl;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.prodigious.messanger.domain.User;
import com.prodigious.messanger.domain.UserPhone;
import com.prodigious.messanger.repository.UserDao;
import com.prodigious.messanger.repository.UserPhoneRepository;
import com.prodigious.messanger.service.KeyValidationService;

@Service
public class KeyValidationServiceImpl implements KeyValidationService {
	UserPhoneRepository userPhoneRepository;
	UserDao userDao;
	@Value("${key.expiry.duration}")
	private String expiryDuration;
	
	
	public KeyValidationServiceImpl(UserPhoneRepository userPhoneRepository, UserDao userDao) {
		this.userPhoneRepository = userPhoneRepository;
		this.userDao = userDao;
	}
	
	@Override
	public boolean validateKey(UserPhone userPhone) throws Exception {
		Date creationDate = new Date();
		long currentTime = creationDate.getTime();
		Optional<UserPhone> userPhoneOptional = userPhoneRepository.findById(userPhone.getPhoneNumber());
		
		try {
			UserPhone retrievedPhone = userPhoneOptional.get();
			if(currentTime - retrievedPhone.getRequestTime() > Integer.valueOf(expiryDuration)) {
				userPhoneRepository.deleteById(userPhone.getPhoneNumber());
				return false;
			}
			userPhoneRepository.deleteById(userPhone.getPhoneNumber());
			
			User user = new User();
			user.setUserId(userPhone.getPhoneNumber().substring(5, userPhone.getPhoneNumber().length()) + currentTime % 10000);
			user.setCreatedAt(creationDate);
			user.setUserPhone(retrievedPhone.getPhoneNumber());
			userDao.saveUser(user);
			return true;
		}catch(NoSuchElementException e) {
			throw new Exception("Key no saved in cache");
		}
	}
}
