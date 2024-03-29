package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.ProjectTablePage;

import com.github.lgooddatepicker.components.DatePicker;
import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.UserProjectTable;
import com.kmitl.pectjro.Database.UserTable;
import com.kmitl.pectjro.Frame.Loading.Loading_dialog;
import com.kmitl.pectjro.Frame.Templates.Project_Template;
import com.kmitl.pectjro.Frame.Templates.User_Template;
import com.kmitl.pectjro.Frame.Tools.Constraints;
import com.kmitl.pectjro.Frame.Tools.JInfoGet;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProjectEdit implements ActionListener, WindowListener {
	// Attribute
	private JInternalFrame frame;
	private JPanel north_info, north_peo, south, infomation, people, addPeople, north_add, center_add, noPeople, note;
	private JTabbedPane center;
	private JTextField name;
	private JTextArea description;
	private DatePicker start, end;
	private JButton add, save, cancel;
	private JScrollPane scroll_des, scroll_people;
	private JInfoGet search;
	private Project_Template info;
	private AddCollaborator find;
	private ArrayList<Integer> delete, addNew;
	private ArrayList<User_Template> data;
	private boolean refresh;

	// Constructor
	public ProjectEdit(Project_Template info) {
		refresh = true;
		delete = new ArrayList<>();
		addNew = new ArrayList<>();
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
				new MatteBorder(0, 0, 1, 0, new Color(60,60,60,255)
		));

		infomation = new JPanel(new GridBagLayout());
		infomation.setBorder(new EmptyBorder(0, 30, 0, 30));
		infomation.add(north_info, new Constraints(0, 0, 2, 1, 0, 0, 21,
				new Insets(20, 0, 20, 0)));
		name = new JTextField(info.name); name.setPreferredSize(new Dimension(300, 35));
		description = new JTextArea(info.description);
		description.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, new Color(60,60,60,255)),
				new EmptyBorder(5, 5, 5, 5))); description.setWrapStyleWord(true); description.setLineWrap(true);
		scroll_des = new JScrollPane(); scroll_des.setViewportView(description);  scroll_des.setPreferredSize(new Dimension(620, 100));
		scroll_des.getVerticalScrollBar().setUnitIncrement(1);

		infomation.add(new JLabel("Project name"), new Constraints(0, 1, 2, 1, 1, 1, GridBagConstraints.LAST_LINE_START,
				new Insets(0, 0, 10, 0)));
		infomation.add(name, new Constraints(0, 2, 2, 1, 1, 1, GridBagConstraints.FIRST_LINE_START,
				new Insets(0, 0, 0, 0)));
		infomation.add(new JLabel("Description"), new Constraints(0, 3, 2, 1, 1, 1, GridBagConstraints.LAST_LINE_START,
				new Insets(0, 0, 10, 0)));
		infomation.add(scroll_des, new Constraints(0, 4, 2, 1, 1, 1, GridBagConstraints.FIRST_LINE_START,
				new Insets(0, 0, 0, 0)));

		start = new DatePicker(); start.setPreferredSize(new Dimension(200, 35));
		start.setDate(info.start.toLocalDate()); start.getComponentDateTextField().setBackground(new Color(40,40,40,255));
		start.getComponentDateTextField().setBorder(new MatteBorder(1, 1, 1, 1, new Color(60,60,60,255)));
		start.getComponentDateTextField().setForeground(Color.white);
		end = new DatePicker(); end.setPreferredSize(new Dimension(200, 35));
		end.setDate(info.end.toLocalDate()); end.getComponentDateTextField().setBackground(new Color(40,40,40,255));
		end.getComponentDateTextField().setBorder(new MatteBorder(1, 1, 1, 1, new Color(60,60,60,255)));
		end.getComponentDateTextField().setForeground(Color.white);
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
					new MatteBorder(1, 0, 0, 0, new Color(60,60,60,255))
				));

		people = new JPanel(new GridBagLayout());

		north_peo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel head = new JLabel("Project Collaborator");
		head.setFont(new Font("", Font.BOLD, 20));
		north_peo.add(head);
		north_peo.setBorder(
				new MatteBorder(0, 0, 1, 0, new Color(60,60,60,255))
		);

		people.add(north_peo, new Constraints(0, 0, 2, 1, 0, 0, 21,
				new Insets(20, 0, 20, 0)));
		add = new JButton("Add people"); add.addActionListener(this);
		JLabel manage = new JLabel("Manage access"); manage.setFont(new Font("", Font.BOLD, 15));
		people.add(manage, new Constraints(0, 1, 0, 0, GridBagConstraints.LAST_LINE_START,
				new Insets(0, 0, 15, 0)));

		addPeople = new JPanel(new BorderLayout());
		north_add = new JPanel(); addPeople.add(north_add, BorderLayout.NORTH);
		center_add = new JPanel(new GridBagLayout());
		scroll_people = new JScrollPane(center_add, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll_people.setBorder(null); scroll_people.getVerticalScrollBar().setUnitIncrement(5);
		addPeople.add(scroll_people);

		addPeople.setBorder(new MatteBorder(1, 1, 1, 1, new Color(60,60,60,255)));
		north_add.setBorder(new MatteBorder(0, 0, 1, 0, new Color(60,60,60,255)));

		search = new JInfoGet("Find a collaborator");
		search.setPreferredSize(new Dimension((int) (frame.getWidth()*0.88), 35));

		noPeople = new JPanel(new GridBagLayout());
		noPeople.setPreferredSize(new Dimension((int) (frame.getWidth()*0.89), (int) (frame.getHeight()*0.4)));
		JLabel noOne = new JLabel("This project doesn't have any collaborators yet");
		noOne.setFont(new Font("", Font.BOLD, 20));
		noPeople.add(noOne, new Constraints(0, 0, 0, 0, new Insets(0, 0, 30, 0)));
		noPeople.setBorder(new LineBorder(new Color(51,51,51,255)));

		note = new JPanel(); // TODO: Make admin can edit note

		people.setBorder(new EmptyBorder(0, 30, 0, 30));
		center.add("Information", infomation);
		center.add("Collaborator", people);
		center.add("Note", note);

		frame.add(south, BorderLayout.SOUTH);
		frame.add(center);
	}

	// Methods
	public void loadCon() throws SQLException {
		Connection con = DBConnect.createConnect();
		UserProjectTable up = new UserProjectTable(con);
		info.people = up.getCollaborator(info.id);

		if (!info.people.isEmpty()) {
			UserTable user = new UserTable(con);
			data = user.getById(info.people);
		} else {
			data = new ArrayList<>();
		}
	}

	public void setUser() {
		SwingWorker<Void, Void> set = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				if (info.people.size() > 4) {
					scroll_people.setPreferredSize(new Dimension((int) (frame.getWidth()*0.87), (int) (frame.getHeight()*0.4)));
					refresh = true;
				} else if (refresh){
					System.out.println("in");
					scroll_people.setPreferredSize(null);
					people.remove(addPeople);
					people.remove(add);
					chooseOutput();
				}

				center_add.removeAll();
				for (int i = 0; i < info.people.size(); i++) {
					UserBanner goingToAdd = new UserBanner(data.get(i));
					JButton remove = new JButton("Remove");

					int currentNumber = i;
					remove.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Integer thisId = info.people.get(currentNumber);

							if (!addNew.contains(thisId)) {
								delete.add(thisId);
							} else {
								addNew.remove(thisId);
							}
							info.people.remove(thisId);

							if (info.people.isEmpty()) {
								refresh = true;
							}

							data.remove(currentNumber);

							setUser();
						}
					});

					goingToAdd.add(remove, new Constraints(3, 0, 1, 0, 22, new Insets(10, 10, 10, 5)));
					center_add.add(goingToAdd, new Constraints(0, i, 0, 0, 21, new Insets(0, 0, 0, 0)));
				}

				frame.revalidate();
				frame.repaint();
				return null;
			}
		};
		set.execute();
	}

	public void loadNewUser(int newUser){
		SwingWorker<Void, Void> load = new SwingWorker<Void, Void>() {
			private final Loading_dialog loading = new Loading_dialog(find.getFrame());
			@Override
			protected Void doInBackground() throws Exception {
				loading.setVisible(true);
				Connection con = DBConnect.createConnect();
				UserTable user = new UserTable(con);
				data.add(user.getUserData(newUser));

				return null;
			}

			@Override
			protected void done(){
				loading.dispose();
				chooseOutput();
				setUser();
			}
		};
		load.execute();
	}

	public void chooseOutput() {
		if (info.people.isEmpty()) {
			noPeople.add(add, new Constraints(0, 1, 0, 0, new Insets(0, 0, 0, 0)));
			people.add(noPeople, new Constraints(0, 2, 2, 1, 1, 1, GridBagConstraints.PAGE_START,
					new Insets(0, 0, 0, 0)));
			refresh = true;
		} else{
			people.add(add, new Constraints(1, 1, 0, 0, GridBagConstraints.LAST_LINE_END,
					new Insets(0, 0, 15, 0)));
			people.add(addPeople, new Constraints(0, 2, 2, 1, 1, 1, GridBagConstraints.PAGE_START,
					new Insets(0, 0, 0, 0)));
			north_add.add(search);
			refresh = false;
		}
		frame.revalidate();
		frame.repaint();
	}

	// Listener
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Add people")) {
			if (find == null) {
				find = new AddCollaborator(frame, info.name, info.people, this);
				find.getConfirm().addActionListener(this);
				find.start();
			}
		} else if (e.getActionCommand().equals("Select a collaborator")) {
			info.people.add(((UserBanner)find.getSelect()).getUser().id);
			loadNewUser(((UserBanner)find.getSelect()).getUser().id);
			addNew.add(((UserBanner)find.getSelect()).getUser().id);
			find.getFrame().dispose();
			people.remove(noPeople);
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {

	}

	@Override
	public void windowClosed(WindowEvent e) {
		find = null;
	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

	// Accessor
	public JInternalFrame getFrame() {
		return frame;
	}
	public void setFrame(JInternalFrame frame) {
		this.frame = frame;
	}
	public JButton getSave() {
		return save;
	}
	public void setSave(JButton save) {
		this.save = save;
	}
	public JButton getCancel() {
		return cancel;
	}
	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}
	public JTextField getName() {
		return name;
	}
	public void setName(JTextField name) {
		this.name = name;
	}
	public JTextArea getDescription() {
		return description;
	}
	public void setDescription(JTextArea description) {
		this.description = description;
	}
	public DatePicker getStart() {
		return start;
	}
	public void setStart(DatePicker start) {
		this.start = start;
	}
	public DatePicker getEnd() {
		return end;
	}
	public void setEnd(DatePicker end) {
		this.end = end;
	}

	public ArrayList<Integer> getDelete() {
		return delete;
	}
	public void setDelete(ArrayList<Integer> delete) {
		this.delete = delete;
	}
	public ArrayList<Integer> getAddNew() {
		return addNew;
	}
	public void setAddNew(ArrayList<Integer> addNew) {
		this.addNew = addNew;
	}
}
