package com.kmitl.pectjro.Frame.Templates;

import com.kmitl.pectjro.Frame.Groups_interface.Database_template;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Feedback_Template implements Database_template {
	public int id;
	public byte[] image;
	public String username;
	public String word;

	public Feedback_Template(ResultSet resultSet) throws SQLException {
			setData(resultSet);
	}

	public Feedback_Template() {}

	public void setFeedback(int id, byte[] image, String username, String word) {
		this.id = id;
		this.image = image;
		this.username = username;
		this.word = word;
	}

	@Override
	public void setData(ResultSet result) throws SQLException {
		this.id = result.getInt("Id");
		this.image = result.getBytes("Image");
		this.username = result.getString("Username");
		this.word = result.getString("Word");
	}
}
