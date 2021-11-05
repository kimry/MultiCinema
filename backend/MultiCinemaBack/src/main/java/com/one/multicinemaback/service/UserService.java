package com.one.multicinemaback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.one.multicinemaback.dao.UserDao;
import com.one.multicinemaback.dto.UserDto;

@Service
@Transactional
public class UserService {
	
	@Autowired
	UserDao dao;
	
	public Boolean addUser(UserDto user) {
		int n = dao.addUser(user);
		return n>0?true:false;
	}
	public UserDto getUser(String id) {
		return dao.getUser(id);
	}
}
