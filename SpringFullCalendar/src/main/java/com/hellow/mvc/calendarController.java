package com.hellow.mvc;

import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.hellow.mvc.dto.CalendarDto;
import com.hellow.mvc.model.biz.CalendarBiz;

@Controller
public class calendarController {
	
	@Autowired 
	private CalendarBiz Calendarbiz;
	
	@RequestMapping(value = "/calendar.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String selectList() {
		return "calendar";
	}
	
	@RequestMapping(value = "/calendarajax.do", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
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
	
	@RequestMapping(value = "/calendarSelectOne.do")
	public String selectOne(int calendar_seq, Model model) {
		
		model.addAttribute("calendarDto", Calendarbiz.selectOne(calendar_seq));
		System.out.println(Calendarbiz.selectOne(calendar_seq).getCalendar_title());
		return "calendar";
	}
	
	@RequestMapping(value = "/calendarInsert.do", method=RequestMethod.GET)
	public String insert() {
		
		return "calendar";
	}
	
	@RequestMapping(value = "/calendarInsertres.do", method = RequestMethod.POST)
	public String insertRes(CalendarDto calendarDto, Model model) {
		
		int res = Calendarbiz.insert(calendarDto);
		
		if(res > 0) {
			model.addAttribute("calendarList", Calendarbiz.selectList());
			return "calendar";
		} else {
			return "calendar";
		}
	}
	
	@RequestMapping(value = "/calendarUpdate.do", method = RequestMethod.GET)
	public String update(CalendarDto calendarDto, int calendar_seq, Model model) {
		
		model.addAttribute("calendarDto", Calendarbiz.selectOne(calendar_seq));
		
		return "calendar";
	}
	
	@RequestMapping(value = "/calendarUpdateres.do", method = RequestMethod.POST)
	public String updateRes(CalendarDto calendarDto, Model model) {
		
		int res = Calendarbiz.update(calendarDto);
		
		if(res > 0) {
			model.addAttribute("calendarDto", Calendarbiz.update(calendarDto));
			model.addAttribute("calendarList", Calendarbiz.selectList());
			return "calendar";
		} else {
			return "calendar";
		}
		
	}
	
	@RequestMapping(value = "/calendarDelete.do", method = RequestMethod.GET)
	public String delete(int calendar_seq, Model model) {
		
		int res = Calendarbiz.delete(calendar_seq);
		
		if(res > 0) {
			model.addAttribute("calendarDto", Calendarbiz.delete(calendar_seq));
			model.addAttribute("calendarList", Calendarbiz.selectList());
			return "calendar";
		} else {
			return "calendar";
		}
		
	}
	

}
