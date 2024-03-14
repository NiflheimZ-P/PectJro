package com.kmitl.pectjro.Database;

import com.kmitl.pectjro.Database.Connection.DBConnect;

import javax.swing.*;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTable {
	private final Connection con;
	public UpdateTable(Connection con) {
		this.con = con;
	}

	private void updateData(String sql) throws SQLException{
		Statement execute = con.createStatement();
		execute.executeUpdate(sql);
	}

	public void addUserData(String username, String gmail, String password, String firstname, String lastname) throws SQLException {
		String sql = String.format("INSERT INTO User_info VALUES (DEFAULT, '%s', '%s', '%s', '%s', '%s', DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);", username, gmail, password, firstname, lastname);
		updateData(sql);
		JOptionPane.showMessageDialog(null, "Your account has been created", "Created", JOptionPane.PLAIN_MESSAGE);
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
		System.out.println(sql);
		updateData(sql);
	}

	public void deleteUser(String gmail) throws SQLException {
		String sql = String.format("DELETE FROM User_info WHERE Gmail = '%s';", gmail);
		updateData(sql);
	}
}
