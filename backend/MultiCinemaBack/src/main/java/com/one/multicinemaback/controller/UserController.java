package com.one.multicinemaback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.one.multicinemaback.dto.UserDto;
import com.one.multicinemaback.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public UserDto getUser(String id){
		System.out.println("BbsController getUser()");
		UserDto user = service.getUser(id);
		return user;
	}
}
