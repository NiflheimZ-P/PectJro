package com.kmitl.pectjro.Database;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Frame.Cache_Templates.User_Template;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.*;

public class GetInfomation {
	private final Connection con;
	public GetInfomation(Connection con){
		this.con = con;
	}

	private ResultSet getData(String sql) throws SQLException{
		Statement state = con.createStatement();
		return state.executeQuery(sql);
	}

	public User_Template getUserData(String gmail) throws SQLException {
		String sql = "SELECT * FROM User_info WHERE Gmail = '" + gmail + "';";
		ResultSet result = getData(sql);
		User_Template output = new User_Template();
		result.next();
		Image image;
		if (result.getBytes("Image") == null) {
			image = new ImageIcon("resources/Images/Logo.png").getImage();
		} else {
			image = new ImageIcon(result.getBytes("Image")).getImage();
		}
		output.setData(result.getInt("Id"),
				result.getString("Username"),
				result.getString("Gmail"),
				result.getString("Password"),
				result.getString("Firstname"),
				result.getString("Lastname"),
				image,
				result.getInt("Project_Done"),
				result.getInt("Project_Expired"),
				result.getInt("Project_Ontime"),
				result.getBoolean("Admin"));
		return output;
	}
}
