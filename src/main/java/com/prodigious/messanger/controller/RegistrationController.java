package com.prodigious.messanger.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prodigious.messanger.domain.UserPhone;
import com.prodigious.messanger.service.KeyProvisionService;
import com.prodigious.messanger.service.KeyValidationService;

@RestController
public class RegistrationController {

	public KeyProvisionService keyProvisionService;
	public KeyValidationService keyValidationService;

	public RegistrationController(KeyProvisionService keyProvisionService, 
			KeyValidationService keyValidationService) {
		this.keyProvisionService = keyProvisionService;
		this.keyValidationService = keyValidationService;
	}
	
	@PostMapping(value="/request-key", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> requestKey(@RequestBody UserPhone userPhone){
		return ResponseEntity.ok(keyProvisionService.getKeyForUserPhone(userPhone));
	}
	
	@PostMapping(value="/validate-key", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> validateKey(@RequestBody UserPhone userPhone){
		try {
			return ResponseEntity.ok(keyValidationService.validateKey(userPhone));
		} catch (Exception e) {
			 ResponseEntity.badRequest();
			 return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
