package com.kmitl.pectjro.Database.DatabaseTable;

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

	public void updateProject(Project_Template info) throws SQLException {
		PreparedStatement sql = con.prepareStatement("UPDATE Project_info SET Name = ?, Description = ?, Start = ?, Expired = ? WHERE Id = ?");
		sql.setString(1, info.name);
		sql.setString(2, info.description);
		sql.setDate(3, info.start);
		sql.setDate(4, info.end);
		sql.setInt(5, info.id);
		sql.executeUpdate();
	}

	public ArrayList<Project_Template> getProjectData(ArrayList<Integer> info) throws SQLException{
		String sql = String.format("SELECT * FROM Project_info WHERE Id = %s", info.get(0));
		for (int i = 1; i < info.size(); i++) {
			sql += "|| Id = " + info.get(i);
		}
		sql += ";";

		ArrayList<Project_Template> output = new ArrayList<>();
		ResultSet result = getData(sql);
		while (result.next()) {
			Project_Template current = new Project_Template();
			current.id = result.getInt("Id");
			current.name = result.getString("Name");
			current.description = result.getString("Description");
			current.start = result.getDate("Start");
			current.end = result.getDate("Expired");
			output.add(current);
		}
		return output;
	}
}
