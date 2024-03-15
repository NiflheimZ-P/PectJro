package com.kmitl.pectjro.Database;

import com.kmitl.pectjro.Frame.Templates.Feedback_Template;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FeedbackTable {
	private final Connection con;

	public FeedbackTable(Connection con){
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

	public void addFeedback(String word, int id) throws SQLException{
		String sql = String.format("INSERT INTO Feedback VALUES (DEFAULT, %d, '%s');", id, word);
		updateData(sql);
	}

//	public ArrayList<Feedback_Template> getFeedback() {
//		String sql = String.format("")
//	}
}
