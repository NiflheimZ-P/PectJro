package com.kmitl.pectjro.Frame.Templates;

import com.kmitl.pectjro.Frame.Groups_interface.Database_template;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Project_Template implements Database_template {
	public int id;
	public String name;
	public String description;
	public Date start;
	public Date end;
	public ArrayList<Integer> people;

	public Project_Template() {}
	public Project_Template(ResultSet result) throws SQLException {
		setData(result);
	}

	public void setProject(int id, String name, String description, Date start, Date end){
		this.id = id;
		this.name = name;
		this.description = description;
		this.start = start;
		this.end = end;
	}

	@Override
	public void setData(ResultSet result) throws SQLException {
		this.id = result.getInt("Id");
		this.name = result.getString("Name");
		this.description = result.getString("Description");
		this.start = result.getDate("Start");
		this.end = result.getDate("Expired");
	}
}
