package com.prodigious.messanger.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prodigious.messanger.domain.UserPhone;

@Repository
public interface UserPhoneRepository extends CrudRepository<UserPhone, String> {}
