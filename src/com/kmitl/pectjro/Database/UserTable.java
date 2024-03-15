package com.kmitl.pectjro.Database;

import com.kmitl.pectjro.Frame.Templates.User_Template;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

public class UserTable {
	private final Connection con;

	public UserTable(Connection con) {
		this.con = con;
	}

	private void updateData(String sql) throws SQLException{
		Statement execute = con.createStatement();
		execute.executeUpdate(sql);
	}

	private ResultSet getData(String sql) throws SQLException{
		Statement state = con.createStatement();
		return state.executeQuery(sql);
	}

	public void addUserData(String username, String gmail, String password, String firstname, String lastname) throws SQLException, FileNotFoundException {
		PreparedStatement sql = con.prepareStatement("INSERT INTO User_info VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, DEFAULT, DEFAULT, DEFAULT, DEFAULT);");
		try (InputStream picture = new FileInputStream("resources/Images/aunkung.jpeg")){
			sql.setString(1, username);
			sql.setString(2, gmail);
			sql.setString(3, password);
			sql.setString(4, firstname);
			sql.setString(5, lastname);
			sql.setBlob(6, picture);
			sql.executeUpdate();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addUserData(String username, String gmail, String password, String firstname, String lastname, InputStream pic, boolean admin) throws SQLException {
		PreparedStatement statement = con.prepareStatement("INSERT INTO User_info VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, DEFAULT, DEFAULT, DEFAULT, ?)");
		statement.setString(1, username); statement.setString(2, gmail); statement.setString(3, password);
		statement.setString(4, firstname); statement.setString(5, lastname); statement.setBlob(6, pic);
		statement.setBoolean(7, admin);
		statement.executeUpdate();
	}

	public void updateUserData(String column, String value, String row) throws SQLException {
		String sql = String.format("UPDATE User_info SET %s = %s WHERE Id = %s", column, value, row);
		updateData(sql);
	}

	public void deleteUser(String gmail) throws SQLException {
		String sql = String.format("DELETE FROM User_info WHERE Gmail = '%s';", gmail);
		updateData(sql);
	}

	public User_Template getUserData(String gmail) throws SQLException {
		String sql = "SELECT * FROM User_info WHERE Gmail = '" + gmail + "';";
		ResultSet result = getData(sql);
		User_Template output = new User_Template();
		result.next();
		output.setData(result.getInt("Id"),
				result.getString("Username"),
				result.getString("Gmail"),
				result.getString("Password"),
				result.getString("Firstname"),
				result.getString("Lastname"),
				result.getBytes("Image"),
				result.getInt("Project_Done"),
				result.getInt("Project_Expired"),
				result.getInt("Project_Ontime"),
				result.getBoolean("Admin"));
		return output;
	}

	public ArrayList<User_Template> load_AllUser() throws SQLException{
		ArrayList<User_Template> output = new ArrayList<>();
		ResultSet result = getData("SELECT * FROM User_info;");
		User_Template user;
		while (result.next()){
			user = new User_Template();
			user.setData(
					result.getInt("Id"),
					result.getString("Username"),
					result.getString("Gmail"),
					result.getString("Password"),
					result.getString("Firstname"),
					result.getString("Lastname"),
					result.getBytes("Image"),
					result.getInt("Project_Done"),
					result.getInt("Project_Expired"),
					result.getInt("Project_Ontime"),
					result.getBoolean("Admin"));
			output.add(user);
		}
		return output;
	}
}
