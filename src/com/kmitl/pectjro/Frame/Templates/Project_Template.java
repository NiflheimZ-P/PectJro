package com.kmitl.pectjro.Frame.Templates;

import java.sql.Date;
import java.util.ArrayList;

public class Project_Template {
	public int id;
	public String name;
	public String description;
	public Date start;
	public Date end;
	public ArrayList<Integer> people;

	public void setData(int id, String name, String description, Date start, Date end){
		this.id = id;
		this.name = name;
		this.description = description;
		this.start = start;
		this.end = end;
	}
}
