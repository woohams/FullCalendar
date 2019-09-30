package com.hellow.mvc.model.dao;

import java.util.List;

import com.hellow.mvc.dto.CalendarDto;


public interface CalendarDao {
	
	String namespace = "calendar.";
	
	public List<CalendarDto> selectList();
	public CalendarDto selectOne(int calendar_seq);
	public int insert(CalendarDto calendarDto);
	public int update(CalendarDto calendarDto);
	public int delete(int calendar_seq);

}
