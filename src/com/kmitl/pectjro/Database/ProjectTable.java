package com.kmitl.pectjro.Database;

import com.kmitl.pectjro.Frame.Templates.Project_Template;

import java.sql.*;
import java.util.ArrayList;

public class ProjectTable {
	private Connection con;

	public ProjectTable(Connection con) {
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

	public ArrayList<Project_Template> getProjectData() throws SQLException{
		String sql = "SELECT * FROM Project_info;";
		ResultSet result = getData(sql);

		ArrayList<Project_Template> output = new ArrayList<>();
		while (result.next()) {
			Project_Template current = new Project_Template();
			current.setData(
					result.getInt("Id"),
					result.getString("Name"),
					result.getString("Description"),
					result.getDate("Start"),
					result.getDate("Expired")
			);
			output.add(current);
		}

		return output;
	}

	public void addProjectData(String name, String description, Date start, Date end) throws SQLException {
		PreparedStatement state = con.prepareStatement("INSERT INTO Project_info VALUES (DEFAULT, ?, ?, ?, ?, DEFAULT)");
		state.setString(1, name);
		state.setString(2, description);
		state.setDate(3, start);
		state.setDate(4, end);
		state.executeUpdate();
	}

	public void deleteProject(int id) throws SQLException {
		String sql = String.format("DELETE FROM Project_info WHERE Id = %s;", id);
		updateData(sql);
	}
}
