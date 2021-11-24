package com.one.multicinemaback.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.one.multicinemaback.dto.SbPayDto;

@Mapper
@Repository
public interface SbPayDao {

	List<SbPayDto> getSbPayList(String id);
}
