package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.ProjectTablePage;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.UserTable;
import com.kmitl.pectjro.Frame.Templates.User_Template;
import com.kmitl.pectjro.Frame.Tools.Constraints;
import com.kmitl.pectjro.Frame.Tools.Image_Resizer;
import com.kmitl.pectjro.Frame.Tools.JInfoGet;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.util.ArrayList;

public class AddCollaborator implements DocumentListener, FocusListener {
	// Attribute
	private JDialog frame;
	private JPanel main_panel, findPeople;
	private Container owner;
	private JInfoGet search;
	private JButton confirm;
	private ArrayList<User_Template> allPeople;
	private JScrollPane scroll;

	// Constructor
	public AddCollaborator(Container owner, String name) {
		this.owner = owner;
		frame = new JDialog();
		loadUser();
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		main_panel = new JPanel(new GridBagLayout());
		JLabel head = new JLabel("Add a collaborator to '" + name + "'");
		head.setFont(new Font("", Font.BOLD, 20));
		main_panel.add(head, new Constraints(0, 0, 1, 1, new Insets(0, 0, 30, 0)));

		search = new JInfoGet("Search by username, full name, or email");
		search.setPreferredSize(new Dimension(580, 35));
		search.getDocument().addDocumentListener(this);
		main_panel.add(search, new Constraints(0, 1, 0, 0, new Insets(0, 0, 0, 0)));

		confirm = new JButton("Select a collaborator");
		confirm.setPreferredSize(new Dimension(580, 35));
		main_panel.add(confirm, new Constraints(0, 3, 1, 1, new Insets(10, 0, 0, 0)));

		main_panel.setBorder(new EmptyBorder(30, 30, 30, 30));



		frame.add(main_panel);
		frame.pack();
		frame.setFocusable(true);
		frame.requestFocus();
	}

	// Methods
	public void start(){
		frame.setLocationRelativeTo(owner);
		frame.setVisible(true);
	}

	public void loadUser(){
		SwingWorker<Void, Void> load = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				Connection con = DBConnect.createConnect();
				UserTable user = new UserTable(con);
				allPeople = user.load_AllUser();
				return null;
			}
		};
		load.execute();
	}

	public void searchUp(){
		if (!search.getText().equals(search.getShouldbe()) && !search.getText().isEmpty()) {
			findPeople = new JPanel(new GridBagLayout());

			for (int i = 0; i < allPeople.size() && i < 10; i++){
				User_Template current = allPeople.get(i);
				if (current.username.contains(search.getText()) ||
						current.firstname.contains(search.getText()) ||
						current.gmail.contains(search.getText())) {
					findPeople.add(new JPanel(){
						{
							this.setLayout(new FlowLayout(FlowLayout.LEFT));
							this.add(new Image_Resizer(new ImageIcon(current.image), 20, 20));
							JLabel username = new JLabel(current.username); username.setFont(new Font("", Font.BOLD, 10));
							this.add(username);
							JLabel fullname = new JLabel(current.firstname + " " + current.lastname); fullname.setFont(new Font("", Font.PLAIN, 7));
							fullname.setBackground(Color.lightGray);
							this.add(fullname);
							this.setPreferredSize(new Dimension(580, 150));
							// TODO: What the fuck is this, fix this please
						}
					}, new Constraints(0, i, 0, 0, GridBagConstraints.PAGE_START, new Insets(0, 0, 0, 0)));
				}
			}
			scroll = new JScrollPane(findPeople);
			scroll.setMaximumSize(new Dimension(580, 500));
			main_panel.add(scroll, new Constraints(0, 2, 0, 0, new Insets(20, 0, 0, 0)));
			frame.pack();
			frame.revalidate();
			frame.repaint();
		}
	}

	// Listener
	@Override
	public void insertUpdate(DocumentEvent e) {
		searchUp();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		searchUp();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		searchUp();
	}

	@Override
	public void focusGained(FocusEvent e) {

	}

	@Override
	public void focusLost(FocusEvent e) {

	}
}
