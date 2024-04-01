package com.kmitl.pectjro.Database.DatabaseTable;

import com.kmitl.pectjro.Frame.Templates.Feedback_Template;
import com.kmitl.pectjro.Frame.Templates.User_Template;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class FeedbackTable extends Database_Simple<Feedback_Template> {
	private final Connection con;

	public FeedbackTable(Connection con){
		super(Feedback_Template.class);
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

	public LinkedList<Feedback_Template> getAllFeedback() throws Exception {
		String sql = "SELECT f.Id, ui.Image, ui.Username, f.Word FROM Feedback f JOIN User_info ui ON f.User_id = ui.Id;";
		ResultSet result = getData(sql);

		return getLink(result);
	}

}
