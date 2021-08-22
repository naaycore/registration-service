package com.prodigious.messanger.service;

import com.prodigious.messanger.domain.UserPhone;

public interface KeyValidationService {
	boolean validateKey(UserPhone userPhone) throws Exception;
}
