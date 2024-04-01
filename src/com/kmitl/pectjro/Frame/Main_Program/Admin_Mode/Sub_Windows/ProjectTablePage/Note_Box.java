package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.ProjectTablePage;

import com.kmitl.pectjro.Frame.Templates.Note_Template;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Note_Box extends JPanel implements MouseListener {
	private JPanel pl, pforname;
	private JLabel name;
	private Note_Template note_info;
	private Container owner;


	public Note_Box(Note_Template note, Container owner) {
		this.owner = owner;
		pl = new JPanel();
		pforname =  new JPanel();
		this.note_info = note;

		//Label
		name = new JLabel(note.name);

		pl.setLayout(new GridBagLayout());
		this.add(pl);
		pforname.setLayout(new FlowLayout(FlowLayout.CENTER));
		pforname.add(name);
		pl.add(pforname);

		name.setFont(new Font("Sans", Font.BOLD, 50));
		pl.setBorder(new LineBorder(new Color(30,31,34)));
		this.setBackground(new Color(49,51,56));

		pl.setPreferredSize(new Dimension(200,300));
		pl.addMouseListener(this);

		this.setVisible(true);
	}

	public JLabel getNamea() {
		return name;
	}

	public JPanel getFrame(){
		return pl;
	}
	public void createNote() {
		Note_popUp open = new Note_popUp(note_info, owner);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(pl)){
			createNote();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource().equals(pl)) {
			pforname.setBackground(new Color(88,101,242));
			pl.setBackground(new Color(88,101,242));
			name.setForeground(Color.black);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource().equals(pl)) {
			pforname.setBackground(new Color(30,31,34));
			pl.setBackground(new Color(30,31,34));
			name.setForeground(Color.white);
		}
	}
}