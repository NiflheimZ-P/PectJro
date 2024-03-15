package com.kmitl.pectjro.Database;

import com.kmitl.pectjro.Frame.Templates.Feedback_Template;
import com.kmitl.pectjro.Frame.Templates.User_Template;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

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

	public LinkedList<Feedback_Template> getAllFeedback() throws SQLException {
		String sql = "SELECT f.Id, ui.Image, ui.Username, f.Word FROM Feedback f JOIN User_info ui ON f.User_id = ui.Id;";
		ResultSet result = getData(sql);

		LinkedList<Feedback_Template> output = new LinkedList<Feedback_Template>();
		while (result.next()){
			Feedback_Template feed = new Feedback_Template();
			feed.id = result.getInt("Id");
			feed.image = result.getBytes("Image");
			feed.username = result.getString("Username");
			feed.word = result.getString("Word");
			output.add(feed);
		}

		return output;
	}
}
