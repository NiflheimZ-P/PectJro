package com.kmitl.pectjro.Database;

import com.kmitl.pectjro.Database.Connection.DBConnect;

import javax.swing.*;
import java.sql.Connection;
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
}
