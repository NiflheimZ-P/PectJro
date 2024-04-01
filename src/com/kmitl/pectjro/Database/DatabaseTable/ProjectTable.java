package com.kmitl.pectjro.Database.DatabaseTable;

import com.kmitl.pectjro.Frame.Templates.Project_Template;
import java.sql.*;
import java.util.ArrayList;

public class ProjectTable extends Database_Simple<Project_Template>{
	private Connection con;

	public ProjectTable(Connection con) {
		super(Project_Template.class);

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

	public ArrayList<Project_Template> getProjectData() throws Exception {
		String sql = "SELECT * FROM Project_info;";
		ResultSet result = getData(sql);

		return getArray(result);
	}

	public void addProjectData(int id, String name, String description, Date start, Date end) throws SQLException {
		PreparedStatement state = con.prepareStatement("INSERT INTO Project_info VALUES (DEFAULT, ?, ?, ?, ?, ?, DEFAULT)");
		state.setInt(1, id);
		state.setString(2, name);
		state.setString(3, description);
		state.setDate(4, start);
		state.setDate(5, end);
		state.executeUpdate();

		String sql = String.format("SELECT pi.Id FROM Project_info pi WHERE pi.Creator = %s AND pi.Id NOT IN (SELECT pi2.Id FROM Project_info pi2 WHERE pi2.Id IN (SELECT up.Project_id  FROM User_Project up WHERE User_id = %s));", id, id);
		ResultSet result = getData(sql);

		UserProjectTable user = new UserProjectTable(con);
		while (result.next()) {
			user.addCollaborator(id, result.getInt("Id"));
		}
	}

	public void deleteProject(int id) throws SQLException {
		String sql_project = String.format("DELETE FROM Project_info WHERE Id = %s;", id);
		String sql_user = String.format("DELETE FROM User_Project WHERE Project_id = %s;", id);
		String sql_step = String.format("DELETE FROM Step_info WHERE Owner_id = %s;", id);
		updateData(sql_project);
		updateData(sql_user);
		updateData(sql_step);
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

	public ArrayList<Project_Template> getProjectData(int id) throws Exception {
		String sql = String.format("SELECT * FROM Project_info pi2 WHERE Id IN (SELECT up.Project_id FROM User_Project up WHERE up.User_id = %s) ORDER BY Expired;", id);
		ResultSet result = getData(sql);

		return getArray(result);
	}
}
