package com.prodigious.messanger.service;

import com.prodigious.messanger.domain.UserPhone;

public interface KeyProvisionService {
	String getKeyForUserPhone(UserPhone userPhone);
}
