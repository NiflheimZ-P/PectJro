package com.kmitl.pectjro.Database.DatabaseTable;

import com.kmitl.pectjro.Frame.Templates.Step_Template;
import java.sql.*;
import java.util.LinkedList;

public class StepTable extends Database_Simple<Step_Template> {
	// Attribute
	private Connection con;

	// Constructor
	public StepTable(Connection con) {
		super(Step_Template.class);

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

	public void addStep(Step_Template info) throws SQLException{
		PreparedStatement state = con.prepareStatement("INSERT INTO Step_info VALUES (DEFAULT, ?, ?, ?, ?)");
		state.setInt(1, info.owner_id);
		state.setString(2, info.step_name);
		state.setDate(3, info.start);
		state.setDate(4, info.end);
		state.executeUpdate();
	}

	public LinkedList<Step_Template> getAllStep(int project_id) throws Exception {
		String sql = String.format("SELECT * FROM Step_info WHERE Owner_id = %s;", project_id);
		ResultSet result = getData(sql);

		return getLink(result);
	}

	public void deleteStep(int id) throws SQLException{
		String sql = String.format("DELETE FROM Step_info WHERE Id = %s;", id);
		updateData(sql);
	}
}
