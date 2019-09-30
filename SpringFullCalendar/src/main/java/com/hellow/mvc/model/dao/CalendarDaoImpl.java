package com.hellow.mvc.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hellow.mvc.dto.CalendarDto;
import com.hellow.mvc.dto.CustomerDto;

@Repository
public class CalendarDaoImpl implements CalendarDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<CalendarDto> selectList() {
		List <CalendarDto> calendarList = new ArrayList<CalendarDto>();
		
		try {
			calendarList = sqlSession.selectList(namespace + "selectList");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SELECTLIST ERROR");
		}
		
		return calendarList;
	}

	@Override
	public CalendarDto selectOne(int calendar_seq) {

		CalendarDto calendarDto = new CalendarDto();
		
		try {
			calendarDto = sqlSession.selectOne(namespace + "selectOne", calendar_seq);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SELECTONE ERROR");
		}
		
		return calendarDto;
	}

	@Override
	public int insert(CalendarDto calendarDto) {
		
		int res = 0;

		try {
			res = sqlSession.insert(namespace + "insert", calendarDto);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("INSERT ERROR");
		}
		
		return res;
	}

	@Override
	public int update(CalendarDto calendarDto) {

		int res = 0;
		
		try {
			res = sqlSession.update(namespace + "update", calendarDto);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UPDATE ERROR");
		}
		
		return res;
	}

	@Override
	public int delete(int calendar_seq) {

		int res = 0;
		
		try {
			res = sqlSession.delete(namespace + "delete", calendar_seq);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DELETE ERROR");
		}
		
		return res;
	}

}
