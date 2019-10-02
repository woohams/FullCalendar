package com.hellow.mvc;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hellow.mvc.dto.CalendarDto;
import com.hellow.mvc.model.biz.CalendarBiz;

@Controller
public class calendarController {
	
	@Autowired 
	private CalendarBiz Calendarbiz;
	
	@RequestMapping(value = "/calendar.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String selectList(Model model) {
		
//		model.addAttribute("calendarList", Calendarbiz.selectList());
		
		return "calendar";
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
