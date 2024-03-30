package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.Calendar;

import com.kmitl.pectjro.Frame.Main_Program.home_page.home_pageController;

import java.util.Calendar;

public class CalendarController {
	// Attribute
	private Calendars view;
	private CalendarModel model;
	private home_pageController head_control;

	// Constructor
	public CalendarController(home_pageController head_control) {
		this.head_control = head_control;
		view = new Calendars();
		model = new CalendarModel(view, this);
	}




	// Accessor
	public Calendars getView() {
		return view;
	}
	public void setView(Calendars view) {
		this.view = view;
	}
	public CalendarModel getModel() {
		return model;
	}
	public void setModel(CalendarModel model) {
		this.model = model;
	}
	public home_pageController getHead_control() {
		return head_control;
	}
	public void setHead_control(home_pageController head_control) {
		this.head_control = head_control;
	}
}
