package com.hellow.mvc.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellow.mvc.dto.CalendarDto;
import com.hellow.mvc.model.dao.CalendarDao;

@Service
public class CalendarBizImpl implements CalendarBiz {

	@Autowired
	private CalendarDao dao;
	
	@Override
	public List<CalendarDto> selectList() {
		return dao.selectList();
	}

	@Override
	public CalendarDto selectOne(int calendar_seq) {
		return dao.selectOne(calendar_seq);
	}

	@Override
	public int insert(CalendarDto calendarDto) {
		return dao.insert(calendarDto);
	}

	@Override
	public int update(CalendarDto calendarDto) {
		return dao.update(calendarDto);
	}

	@Override
	public int delete(int calendar_seq) {
		return dao.delete(calendar_seq);
	}

}
