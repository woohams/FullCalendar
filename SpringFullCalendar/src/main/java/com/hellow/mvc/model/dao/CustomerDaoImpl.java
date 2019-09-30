package com.hellow.mvc.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hellow.mvc.dto.CustomerDto;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<CustomerDto> selectList() {
		List <CustomerDto> list = new ArrayList<CustomerDto>();
		
		try {
			list = sqlSession.selectList(namespace + "selectList");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SELECT LIST ERROR");
			// error 발생 시 찾기 쉽게하려고
		}
		
		return list;
	}

	@Override
	public CustomerDto selectOne(String id) {

		CustomerDto dto = new CustomerDto();
		
		try {
			dto = sqlSession.selectOne(namespace + "selectOne", id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SELECT ONE ERROR");
		}
		
		return dto;
	}

	@Override
	public int insert(CustomerDto dto) {
		
		int res = 0;

		try {
			res = sqlSession.insert(namespace + "insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insert error");
		}
		
		return res;
	}

	@Override
	public int update(CustomerDto dto) {

		int res = 0;
		
		try {
			res = sqlSession.update(namespace + "update", dto);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("update error");
		}
		
		return res;
	}

	@Override
	public int delete(String id) {

		int res = 0;
		
		try {
			res = sqlSession.delete(namespace + "delete", id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete error");
		}
		
		return res;
	}

	@Override
	public CustomerDto login(String id, String password) {

		CustomerDto dto = new CustomerDto();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password", password);
		
		try {
			dto = sqlSession.selectOne(namespace + "login", map);
		} catch (Exception e) {
			System.out.println("login error");
			e.printStackTrace();
		}
		
		
		return dto;
	}

}
