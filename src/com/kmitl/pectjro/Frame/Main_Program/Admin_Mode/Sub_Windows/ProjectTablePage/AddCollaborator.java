package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.ProjectTablePage;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.DatabaseTable.UserTable;
import com.kmitl.pectjro.Frame.Templates.User_Template;
import com.kmitl.pectjro.Frame.Tools.Constraints;
import com.kmitl.pectjro.Frame.Tools.JInfoGet;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.ArrayList;

public class AddCollaborator implements DocumentListener, MouseListener, ActionListener {
	// Attribute
	private JDialog frame;
	private JPanel main_panel, findPeople, select;
	private Container owner;
	private JInfoGet search;
	private JButton confirm, close;
	private ArrayList<User_Template> allPeople;
	private JScrollPane scroll;
	private boolean selected;
	private ArrayList<Integer> already;

	// Constructor
	public AddCollaborator(Container owner, String name, ArrayList<Integer> already, WindowListener win) {
		this.already = already;
		selected = false;
		this.owner = owner;
		frame = new JDialog();
		loadUser();
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.addWindowListener(win);

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
		confirm.setEnabled(false);
		main_panel.add(confirm, new Constraints(0, 3, 1, 1, new Insets(10, 0, 0, 0)));

		main_panel.setBorder(new EmptyBorder(30, 30, 30, 30));

		findPeople = new JPanel(new GridBagLayout());
		scroll = new JScrollPane(findPeople, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(580, 100));
		scroll.getVerticalScrollBar().setUnitIncrement(5);
		main_panel.add(scroll, new Constraints(0, 2, 0, 0, new Insets(20, 0, 0, 0)));

		close = new JButton("X");
		close.setFont(new Font("", Font.BOLD, 13));
		close.setBackground(new Color(36,48,65,255));
		close.setBorder(null);
		close.addActionListener(this);

		frame.add(main_panel);
		frame.pack();
		frame.setFocusable(true);
		frame.requestFocus();
		search.setEditable(false);
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

			@Override
			protected void done(){
				search.setEditable(true);
			}
		};
		load.execute();
	}

	public void searchUp(){
		System.out.println(allPeople.size());
		if (!search.getText().equals(search.getShouldbe()) && !search.getText().isEmpty()) {
			findPeople.removeAll();
			int a = 0;
			for (int i = 0; i < allPeople.size(); i++){
				User_Template current = allPeople.get(i);
				if ((current.username.toLowerCase().contains(search.getText().toLowerCase()) ||
						current.firstname.toLowerCase().contains(search.getText().toLowerCase()) ||
						current.gmail.toLowerCase().contains(search.getText().toLowerCase())) && !already.contains(current.id) && a < 10)  {
					UserBanner addNew = new UserBanner(current);
					addNew.addMouseListener(this);
					a++;
					findPeople.add(addNew, new Constraints(0, i, 0, 0, GridBagConstraints.LINE_START, new Insets(0, 0, 0, 0)));
				}
			}
		} else {
			findPeople.removeAll();
		}
		frame.pack();
		frame.revalidate();
		frame.repaint();
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
	public void mouseClicked(MouseEvent e) {
		main_panel.remove(scroll);
		selected = true;
		search.setText("");
		confirm.setEnabled(true);

		select = (JPanel) e.getSource();
		select.setBackground(new Color(36,48,65,255));
		select.setBorder(new MatteBorder(1, 1, 1, 1, new Color(47,79,125,255)));
		select.add(close, new Constraints(3, 0, 1, 0, 22, new Insets(10, 10, 10, 10)));
		main_panel.add(select, new Constraints(0, 2, 0, 0, new Insets(20, 0, 0, 0)));

		frame.pack();
		frame.revalidate();
		frame.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (!selected){
			JPanel enter = ((JPanel) e.getSource());
			enter.setBackground(new Color(56,108,204));
			frame.revalidate();
			frame.repaint();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (!selected){
			JPanel enter = ((JPanel) e.getSource());
			enter.setBackground(new Color(30,30,30,255));
			frame.revalidate();
			frame.repaint();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("X")) {
			main_panel.remove(select);
			selected = false;

			main_panel.add(scroll, new Constraints(0, 2, 0, 0, new Insets(20, 0, 0, 0)));

			frame.pack();
			frame.revalidate();
			frame.repaint();
		}
	}

	// Accessor
	public JButton getConfirm() {
		return confirm;
	}
	public void setConfirm(JButton confirm) {
		this.confirm = confirm;
	}
	public JPanel getSelect() {
		return select;
	}
	public void setSelect(JPanel select) {
		this.select = select;
	}
	public JDialog getFrame() {
		return frame;
	}
	public void setFrame(JDialog frame) {
		this.frame = frame;
	}
}
