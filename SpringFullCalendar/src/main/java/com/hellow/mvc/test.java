package com.hellow.mvc;

import java.util.HashMap;
import java.util.List;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.hellow.mvc.dto.CalendarDto;
import com.hellow.mvc.model.biz.CalendarBiz;

import com.hellow.mvc.util.JsonUtil;

@Controller
public class test {
	
	@Autowired 
	private CalendarBiz Calendarbiz;
	
	private JsonUtil util;
	
public HashMap<String, Object> selectList(Model model) {
		
		List<CalendarDto> list = Calendarbiz.selectList();
		JSONArray jArr = new JSONArray();
		HashMap<String, Object> map = null;
		for(int i=0; i<list.size(); i++) {
			map = new HashMap<String, Object>();
			map.put("id", list.get(i).getCalendar_seq());
			map.put("title", list.get(i).getCalendar_title());
			map.put("start", list.get(i).getCalendar_start());
			map.put("end", list.get(i).getCalendar_end());
			map.put("description", list.get(i).getCalendar_content());
			map.put("url", list.get(i).getId());
		
			
			jArr.add(map);
			System.out.println(map);
		}
		
		JSONObject jobj;
		try {
			jobj = new JSONObject();
			jobj.put("event", jArr);
			
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(jobj.toString());
			
		} catch (JsonSyntaxException e) {
			System.out.println("JSON 변환실패");
			e.printStackTrace();
		}

		System.out.println(jArr.toString());
		
		return map;
		
		
	}
	public static void main(String[] args) {
		
		
	}
}
