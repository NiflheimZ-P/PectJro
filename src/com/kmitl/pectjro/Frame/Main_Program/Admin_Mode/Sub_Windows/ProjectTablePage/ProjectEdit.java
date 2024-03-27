package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.ProjectTablePage;

import com.github.lgooddatepicker.components.DatePicker;
import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.UserProjectTable;
import com.kmitl.pectjro.Frame.Templates.Project_Template;
import com.kmitl.pectjro.Frame.Tools.Constraints;
import com.kmitl.pectjro.Frame.Tools.JInfoGet;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class ProjectEdit implements ActionListener {
	// Attribute
	private JInternalFrame frame;
	private JPanel north_info, north_peo, south, infomation, people, addPeople, north_add, center_add;
	private JTabbedPane center;
	private JTextField name;
	private JTextArea description;
	private DatePicker start, end;
	private JButton add, save, cancel;
	private JScrollPane scroll_des, scroll_people;
	private JInfoGet search;
	private Project_Template info;
	private JDialog addCon;

	// Constructor
	public ProjectEdit(Project_Template info) {
		this.info = info;
		frame = new JInternalFrame("'" + info.name + "' Info", false, true, false);
		frame.setSize(700, 550);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		center = new JTabbedPane();

		north_info = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel header = new JLabel("Project Information");
		header.setFont(new Font("", Font.BOLD, 20));
		north_info.add(header);
		north_info.setBorder(
				new MatteBorder(0, 0, 1, 0, Color.lightGray)
		);

		infomation = new JPanel(new GridBagLayout());
		infomation.setBorder(new EmptyBorder(0, 30, 0, 30));
		infomation.add(north_info, new Constraints(0, 0, 2, 1, 1, 1, 21,
				new Insets(0, 0, 0, 0)));
		name = new JTextField(info.name); name.setPreferredSize(new Dimension(300, 35));
		description = new JTextArea(info.description);
		description.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, Color.lightGray),
				new EmptyBorder(5, 5, 5, 5))); description.setWrapStyleWord(true); description.setLineWrap(true);
		scroll_des = new JScrollPane(); scroll_des.setViewportView(description);  scroll_des.setPreferredSize(new Dimension(620, 100));
		scroll_des.getVerticalScrollBar().setUnitIncrement(1); scroll_des.setBorder(null);

		infomation.add(new JLabel("Project name"), new Constraints(0, 1, 2, 1, 1, 1, GridBagConstraints.LAST_LINE_START,
				new Insets(0, 0, 10, 0)));
		infomation.add(name, new Constraints(0, 2, 2, 1, 1, 1, GridBagConstraints.FIRST_LINE_START,
				new Insets(0, 0, 0, 0)));
		infomation.add(new JLabel("Description"), new Constraints(0, 3, 2, 1, 1, 1, GridBagConstraints.LAST_LINE_START,
				new Insets(0, 0, 10, 0)));
		infomation.add(scroll_des, new Constraints(0, 4, 2, 1, 1, 1, GridBagConstraints.FIRST_LINE_START,
				new Insets(0, 0, 0, 0)));

		start = new DatePicker(); start.setPreferredSize(new Dimension(200, 35));
		start.setDate(info.start.toLocalDate());
		end = new DatePicker(); end.setPreferredSize(new Dimension(200, 35));
		end.setDate(info.end.toLocalDate());
		infomation.add(new JLabel("Start Date"), new Constraints(0, 5, 1, 1, GridBagConstraints.PAGE_END,
				new Insets(0, 0, 0, 0)));
		infomation.add(new JLabel("Expired Date"), new Constraints(1, 5, 1, 1, GridBagConstraints.PAGE_END,
				new Insets(0, 0, 0, 0)));
		infomation.add(start, new Constraints(0, 6, 1, 1,
				new Insets(0, 0, 0, 0)));
		infomation.add(end, new Constraints(1, 6, 1, 1,
				new Insets(0, 0, 0, 0)));


		south = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		cancel = new JButton("Cancel"); save = new JButton("Save");
		south.add(save); south.add(cancel);
		south.setBorder(new CompoundBorder(new EmptyBorder(20, 10, 3, 10),
					new MatteBorder(1, 0, 0, 0, Color.lightGray)
				));

		center.add("Information", infomation);

		people = new JPanel(new GridBagLayout());

		north_peo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel head = new JLabel("Project Information");
		head.setFont(new Font("", Font.BOLD, 20));
		north_peo.add(head);
		north_peo.setBorder(
				new MatteBorder(0, 0, 1, 0, Color.lightGray)
		);

		people.add(north_peo, new Constraints(0, 0, 2, 1, 1, 1, 21,
				new Insets(0, 0, 0, 0)));
		add = new JButton("Add people"); add.addActionListener(this);
		people.add(new JLabel("Manage access"), new Constraints(0, 1, 1, 1, 21,
				new Insets(0, 0, 0, 0)));
		people.add(add, new Constraints(1, 1, 1, 1, 22,
				new Insets(0, 0, 0, 0)));

		addPeople = new JPanel(new BorderLayout());
		north_add = new JPanel(); addPeople.add(north_add, BorderLayout.NORTH);
		center_add = new JPanel(new GridBagLayout()); addPeople.add(center_add);

		addPeople.setBorder(new MatteBorder(1, 1, 1, 1, Color.lightGray));
		north_add.setBorder(new MatteBorder(0, 0, 1, 0, Color.lightGray));

		search = new JInfoGet("Find a collaborator");
		search.setPreferredSize(new Dimension((int) (frame.getWidth()*0.85), 35));
		north_add.add(search);

		scroll_people = new JScrollPane(center);

		people.add(addPeople, new Constraints(0, 2, 2, 1, 1, 1,
				new Insets(0, 0, 0, 0)));

		people.setBorder(new EmptyBorder(0, 30, 0, 30));
		center.add("Collaborator", people);

		frame.add(south, BorderLayout.SOUTH);
		frame.add(center);
	}

	// Methods
	public void loadCon() {
		SwingWorker<Void, Void> load = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				Connection con = DBConnect.createConnect();
				UserProjectTable up = new UserProjectTable(con);
				info.people = up.getCollaborator(info.id);
				return null;
			}
		};
		load.execute();
	}

	// Listener
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Add people")) {
			AddCollaborator find = new AddCollaborator(frame, info.name);
			find.start();
		}
	}

	// Accessor
	public JInternalFrame getFrame() {
		return frame;
	}
	public void setFrame(JInternalFrame frame) {
		this.frame = frame;
	}
}
