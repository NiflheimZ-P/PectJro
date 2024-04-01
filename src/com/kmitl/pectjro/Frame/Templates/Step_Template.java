package com.kmitl.pectjro.Frame.Templates;

import com.kmitl.pectjro.Frame.Groups_interface.Database_template;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Step_Template implements Database_template {
	public int id;
	public int owner_id;
	public String step_name;
	public Date start;
	public Date end;

	public Step_Template() {}
	public Step_Template(ResultSet result) throws SQLException {
		setData(result);
	}

	@Override
	public void setData(ResultSet result) throws SQLException {
		this.id = result.getInt("Id");
		this.owner_id = result.getInt("Owner_id");
		this.step_name = result.getString("Name");
		this.start = result.getDate("Start");
		this.end = result.getDate("Expired");
	}
}
