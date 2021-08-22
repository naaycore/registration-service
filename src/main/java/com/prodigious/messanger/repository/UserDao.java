package com.prodigious.messanger.repository;

import com.prodigious.messanger.domain.User;

public interface UserDao {
	void saveUser(User user);
	User getUserById(String id);
}
