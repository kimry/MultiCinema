package com.one.multicinemaback.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.one.multicinemaback.dao.TicketDao;
import com.one.multicinemaback.dto.TicketDto;

@Service
@Transactional
public class TicketService {
	
	@Autowired
	TicketDao dao;
	
	public List<TicketDto> getTodayList(String id){
		return dao.getTodayList(id);
	}
	
	public List<TicketDto> getPastList(String id){
		return dao.getPastList(id);
	}
	
	public List<TicketDto> getSeatList(TicketDto dto){
		return dao.getSeatList(dto);
	}
}
