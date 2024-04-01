package com.kmitl.pectjro.Database.DatabaseTable;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Frame.Templates.User_Template;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

public class UserTable extends Database_Simple<User_Template>{
	private final Connection con;

	public UserTable(Connection con) {
		super(User_Template.class);

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
		return setData(sql);
	}

	public User_Template getUserData(int id) throws SQLException {
		String sql = "SELECT * FROM User_info WHERE Id = '" + id + "';";
		return setData(sql);
	}

	private User_Template setData(String sql) throws SQLException {
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

	public ArrayList<User_Template> load_AllUser() throws Exception {
		ResultSet result = getData("SELECT * FROM User_info;");

		return getArray(result);
	}

	public ArrayList<User_Template> getById(ArrayList<Integer> id) throws Exception {
		String sql = String.format("SELECT * FROM User_info WHERE Id = %s", id.get(0));

		for (int i = 1; i < id.size(); i++) {
			sql += " || Id = " + id.get(i);
		}
		sql += ";";

		ResultSet result = getData(sql);

		return getArray(result);
	}

	public ArrayList<User_Template> getById(int id) throws Exception {
		String sql = String.format("SELECT * FROM User_info ui WHERE Id IN (SELECT up.User_id FROM User_Project up WHERE up.Project_id = %s);", id);
		ResultSet result = getData(sql);

		return getArray(result);
	}

	public void changeUserPicture(int id, InputStream pic) throws SQLException {
		PreparedStatement sql = con.prepareStatement("UPDATE User_info SET Image = ? WHERE Id = ?");
		sql.setBlob(1, pic);
		sql.setInt(2, id);
		sql.executeUpdate();
	}

	public void updateName(int id, String username) throws SQLException{
		String sql = String.format("UPDATE User_info SET Username = '%s' WHERE Id = %s;", username, id);
		updateData(sql);
	}

	public void updatePassword(int id, String Password) throws SQLException{
		String sql = String.format("UPDATE User_info SET Password = '%s' WHERE Id = %s;", Password, id);
		updateData(sql);
	}

}
