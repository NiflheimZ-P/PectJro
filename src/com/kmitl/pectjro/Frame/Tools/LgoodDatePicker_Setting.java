package com.kmitl.pectjro.Frame.Tools;

import com.github.lgooddatepicker.components.DatePickerSettings;

import javax.swing.border.LineBorder;
import java.awt.*;

public class LgoodDatePicker_Setting {
	// Attribute
	private DatePickerSettings settings;

	// Constructor
	public LgoodDatePicker_Setting(){
		settings = new DatePickerSettings();
		settings.setColor(DatePickerSettings.DateArea.BackgroundOverallCalendarPanel, new Color(32,28,28));
		settings.setColor(DatePickerSettings.DateArea.BackgroundTodayLabel, new Color(32,28,28));
		settings.setColor(DatePickerSettings.DateArea.BackgroundMonthAndYearMenuLabels, new Color(32,28,28));
		settings.setColor(DatePickerSettings.DateArea.BackgroundClearLabel, new Color(32,28,28));
		settings.setColor(DatePickerSettings.DateArea.CalendarBackgroundNormalDates, new Color(60,60,60,255));
		settings.setColor(DatePickerSettings.DateArea.TextFieldBackgroundValidDate, new Color(40,40,40,255));
		settings.setColor(DatePickerSettings.DateArea.DatePickerTextValidDate, Color.WHITE);
		settings.setBorderCalendarPopup(new LineBorder(Color.black));
		settings.setColor(DatePickerSettings.DateArea.TextTodayLabel, Color.WHITE);
		settings.setColor(DatePickerSettings.DateArea.TextClearLabel, Color.WHITE);
		settings.setColor(DatePickerSettings.DateArea.TextMonthAndYearMenuLabels, Color.WHITE);
		settings.setColor(DatePickerSettings.DateArea.CalendarTextNormalDates, Color.WHITE);
		settings.setColorBackgroundWeekdayLabels(new Color(40,40,40,255), true);
		settings.setColor(DatePickerSettings.DateArea.CalendarTextWeekdays, Color.WHITE);
		settings.setColor(DatePickerSettings.DateArea.CalendarBorderSelectedDate, Color.black);
		settings.setColor(DatePickerSettings.DateArea.CalendarBackgroundSelectedDate, new Color(40,40,40,255));
	}

	// Accessor
	public DatePickerSettings getSettings() {
		return settings;
	}
	public void setSettings(DatePickerSettings settings) {
		this.settings = settings;
	}
}
