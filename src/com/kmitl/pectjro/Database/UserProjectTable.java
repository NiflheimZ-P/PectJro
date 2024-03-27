package com.kmitl.pectjro.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserProjectTable {
	private Connection con;

	public UserProjectTable(Connection con) {
		this.con = con;
	}

	private void updateData(String sql) throws SQLException {
		Statement execute = con.createStatement();
		execute.executeUpdate(sql);
	}

	private ResultSet getData(String sql) throws SQLException{
		Statement state = con.createStatement();
		return state.executeQuery(sql);
	}

	public ArrayList<Integer> getCollaborator(int projectId) throws SQLException{
		String sql = String.format("SELECT * FROM User_Project WHERE Project_id = %s", projectId);
		ArrayList<Integer> output = new ArrayList<>();
		ResultSet result = getData(sql);
		while (result.next()){
			output.add(result.getInt("User_id"));
		}
		return output;
	}
}
