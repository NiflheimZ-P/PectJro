package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.Feedback_Page;

import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.AdminController;
import com.kmitl.pectjro.Frame.Templates.Feedback_Template;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class FeedbackController implements ActionListener, DocumentListener {
	// Attribute
	private FeedbackView view;
	private FeedbackModel model;
	private LinkedList<Feedback_Template> feed;

	// Constructor
	public FeedbackController(AdminController head_control) {
		view = new FeedbackView();
		model = new FeedbackModel(view, this);

		view.getFrame().addInternalFrameListener(head_control);
		view.getRefresh().addActionListener(this);
		view.getSearch().getDocument().addDocumentListener(this);
	}

	// Accessor
	public FeedbackView getView() {
		return view;
	}
	public FeedbackModel getModel() {
		return model;
	}
	public LinkedList<Feedback_Template> getFeed() {
		return feed;
	}
	public void setFeed(LinkedList<Feedback_Template> feed) {
		this.feed = feed;
	}

	// Listener
	@Override
	public void actionPerformed(ActionEvent e) {
		model.loadData();
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		if (!view.getSearch().getText().equals(view.getSearch().getShouldbe())){
			model.search();
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		if (!view.getSearch().getText().equals(view.getSearch().getShouldbe())){
			model.search();
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		if (!view.getSearch().getText().equals(view.getSearch().getShouldbe())){
			model.search();
		}
	}
}
