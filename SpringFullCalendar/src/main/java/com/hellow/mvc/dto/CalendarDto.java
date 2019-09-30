package com.hellow.mvc.dto;

import java.util.Date;

public class CalendarDto {
	
	private int calendar_seq;
	private String id;
	private String calendar_category;
	private String calendar_title;
	private String calendar_content;
	private String calendar_backgroundColor;
	private Date calendar_start;
	private Date calendar_end;
	private String calendar_allDay;
	
	public CalendarDto() {
		
	}

	public CalendarDto(int calendar_seq, String id, String calendar_category, String calendar_title,
			String calendar_content, String calendar_backgroundColor, Date calendar_start, Date calendar_end,
			String calendar_allDay) {
		this.calendar_seq = calendar_seq;
		this.id = id;
		this.calendar_category = calendar_category;
		this.calendar_title = calendar_title;
		this.calendar_content = calendar_content;
		this.calendar_backgroundColor = calendar_backgroundColor;
		this.calendar_start = calendar_start;
		this.calendar_end = calendar_end;
		this.calendar_allDay = calendar_allDay;
	}

	public int getCalendar_seq() {
		return calendar_seq;
	}

	public void setCalendar_seq(int calendar_seq) {
		this.calendar_seq = calendar_seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCalendar_category() {
		return calendar_category;
	}

	public void setCalendar_category(String calendar_category) {
		this.calendar_category = calendar_category;
	}

	public String getCalendar_title() {
		return calendar_title;
	}

	public void setCalendar_title(String calendar_title) {
		this.calendar_title = calendar_title;
	}

	public String getCalendar_content() {
		return calendar_content;
	}

	public void setCalendar_content(String calendar_content) {
		this.calendar_content = calendar_content;
	}

	public String getCalendar_backgroundColor() {
		return calendar_backgroundColor;
	}

	public void setCalendar_backgroundColor(String calendar_backgroundColor) {
		this.calendar_backgroundColor = calendar_backgroundColor;
	}

	public Date getCalendar_start() {
		return calendar_start;
	}

	public void setCalendar_start(Date calendar_start) {
		this.calendar_start = calendar_start;
	}

	public Date getCalendar_end() {
		return calendar_end;
	}

	public void setCalendar_end(Date calendar_end) {
		this.calendar_end = calendar_end;
	}

	public String getCalendar_allDay() {
		return calendar_allDay;
	}

	public void setCalendar_allDay(String calendar_allDay) {
		this.calendar_allDay = calendar_allDay;
	}

	

	
		
}
