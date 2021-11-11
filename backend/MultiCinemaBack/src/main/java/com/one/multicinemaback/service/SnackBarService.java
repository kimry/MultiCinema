package com.one.multicinemaback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.one.multicinemaback.dao.SnackBarDao;
import com.one.multicinemaback.dto.SnackBarDto;

@Service
@Transactional
public class SnackBarService {
	
	@Autowired
	SnackBarDao dao;
	
	public void addSnackBar(SnackBarDto product) {
		dao.addSnackBar(product);
	}
}
