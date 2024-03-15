package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.ProjectTablePage;

import com.github.lgooddatepicker.components.DatePicker;
import com.kmitl.pectjro.Frame.Tools.Constraints;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;

public class ProjectAdd implements ActionListener {
	// Attribute
	private JInternalFrame frame;
	private JPanel main_panel, south, center, north;
	private JButton create, cancel;
	private JTextField name, description;
	private DatePicker start, end;

	// Constructor
	public ProjectAdd() {
		frame = new JInternalFrame("Add new project", false, true, false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(600, 400);

		main_panel = new JPanel(new BorderLayout());
		south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		center = new JPanel(new GridBagLayout());
		north = new JPanel(new FlowLayout(FlowLayout.LEFT));

		main_panel.add(north, BorderLayout.NORTH);
		main_panel.add(center);
		main_panel.add(south, BorderLayout.SOUTH);

		JLabel head = new JLabel("Create a new project");
		head.setFont(new Font("", Font.BOLD, 20));
		north.add(head); north.setBorder(new CompoundBorder(
				new EmptyBorder(15, 30, 10, 30),
				new MatteBorder(0, 0, 1, 0, Color.lightGray)
		));

		name = new JTextField(); name.setPreferredSize(new Dimension(250, 35));
		description = new JTextField(); description.setPreferredSize(new Dimension(500, 35));
		start = new DatePicker();
		end = new DatePicker();
		center.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));
		center.add(new JLabel("Project name"), new Constraints(0, 0, 1, 1, 25, new Insets(0, 0, 0, 0)));
		center.add(name, new Constraints(0, 1, 1 ,1, 21, new Insets(0, 0, 0, 0)));
		center.add(new JLabel("Description (optional)"), new Constraints(0, 2, 1, 1, 25, new Insets(0, 0, 0, 0)));
		center.add(description, new Constraints(0, 3, 2, 1, 1, 1, 21, new Insets(0, 0, 0, 0)));
		center.add(new JLabel("Start Date"), new Constraints(0, 4, 1, 1, 20, new Insets(0, 0, 0, 0)));
		center.add(new JLabel("Expired date"), new Constraints(1, 4, 1, 1, 20, new Insets(0, 0, 0, 0)));
		center.add(start, new Constraints(0, 5, 1, 1, new Insets(0, 0, 0, 0)));
		center.add(end, new Constraints(1, 5, 1, 1, new Insets(0, 0, 0, 0)));
		start.setPreferredSize(new Dimension(200, 35)); end.setPreferredSize(new Dimension(200, 35));

		create = new JButton("Create"); create.setEnabled(true); create.addActionListener(this);
		cancel = new JButton("Cancel"); cancel.addActionListener(this);
		south.add(create); south.add(cancel);
		south.setBorder(new EmptyBorder(20, 10, 10, 10));

		frame.add(main_panel);
	}

	// Listener
	@Override
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("Cancel")){frame.dispose();}
		else if (e.getActionCommand().equals("Create")){
			LocalDate a = LocalDate.now();
			System.out.println(a);
		}
	}

	// Accessor
	public JInternalFrame getFrame(){return this.frame;}
	public JButton getCreate(){return create;}
	public JButton getCancel(){return cancel;}
	public JTextField getName(){return name;}
	public JTextField getDescription(){return description;}
	public DatePicker getStart(){return start;}
	public DatePicker getEnd(){return end;}
}
