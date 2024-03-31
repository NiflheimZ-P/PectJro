package com.kmitl.pectjro.Database.DatabaseTable;

import com.kmitl.pectjro.Frame.Templates.Step_Template;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class StepTable {
	// Attribute
	private Connection con;

	// Constructor
	public StepTable(Connection con) {
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

	public LinkedList<Step_Template> getAllStep(int project_id) throws SQLException{
		String sql = String.format("SELECT * FROM Step_info WHERE Owner_id = %s;", project_id);
		ResultSet result = getData(sql);

		LinkedList<Step_Template> output = new LinkedList<>();
		while (result.next()) {
			Step_Template current = new Step_Template();
			current.id = result.getInt("Id");
			current.owner_id = result.getInt("Owner_id");
			current.step_name = result.getString("Name");
			current.start = result.getDate("Start");
			current.end = result.getDate("Expired");
			output.add(current);
		}

		return output;
	}
}
