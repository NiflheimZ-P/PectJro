package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.Feedback_Page;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.FeedbackTable;
import com.kmitl.pectjro.Frame.Loading.Loading_dialog;
import com.kmitl.pectjro.Frame.Templates.Feedback_Template;
import com.kmitl.pectjro.Frame.Tools.Constraints;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.util.LinkedList;

public class FeedbackModel {
	// Attribute
	private FeedbackView view;
	private FeedbackController controller;

	// Constructor
	public FeedbackModel(FeedbackView view, FeedbackController controller) {
		this.view = view;
		this.controller = controller;
	}

	// Methods
	public void addComment(LinkedList<Feedback_Template> feed){
		view.getComment().removeAll();
		for (int i = 0; i < feed.toArray().length; i++) {
			view.getComment().add(new user_feedback(feed.get(i)),
					new Constraints(0, i, 1, 1, new Insets(0, 0, 20, 0)));
		}
		view.getFrame().revalidate();
		view.getFrame().repaint();
	}

	public void loadData() {
		SwingWorker<Void, Void> getFeed = new SwingWorker<Void, Void>() {
			private Loading_dialog loading = new Loading_dialog(view.getFrame());
			@Override
			protected Void doInBackground() throws Exception {
				loading.setVisible(true);
				view.getComment().removeAll();
				view.getFrame().revalidate();
				view.getFrame().revalidate();

				view.getRefresh().setEnabled(false);
				Connection con = DBConnect.createConnect();
				FeedbackTable get = new FeedbackTable(con);
				controller.setFeed(get.getAllFeedback());
				addComment(controller.getFeed());
				view.getRefresh().setEnabled(true);
				if (!view.getSearch().getText().equals(view.getSearch().getShouldbe())){
					search();
				}
				return null;
			}

			@Override
			protected void done() {
				loading.dispose();
			}
		};
		getFeed.execute();
	}

	public void search() {
		view.getComment().removeAll();
		int a = 0;
		String word = view.getSearch().getText().toLowerCase();

		for (Feedback_Template i: controller.getFeed()){
			if (i.username.toLowerCase().contains(word) || i.username.toUpperCase().contains(word)){
				view.getComment().add(new user_feedback(i), new Constraints(0, a, 1, 1, new Insets(0, 0, 20, 0)));
				a++;
			}
		}

		javax.swing.SwingUtilities.invokeLater(() -> view.getScroll().getVerticalScrollBar().setValue(0));
		view.getFrame().revalidate();
		view.getFrame().repaint();
	}
}
