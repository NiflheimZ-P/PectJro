package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.ProjectTablePage;

import com.kmitl.pectjro.Frame.Templates.Note_Template;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Note_popUp {
	private JFrame fr;
	private JTextArea textArea;
	private JPanel mainPanel;
	private JTextField textField;

	public Note_popUp(Note_Template note, Container owner) {
		fr = new JFrame("Note");
		mainPanel = new JPanel();
		textArea = new JTextArea(note.note);
		textField = new JTextField(note.name);
		textArea.setEditable(false);
		textField.setEditable(false);

		fr.add(mainPanel);
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(textArea, BorderLayout.CENTER);
		mainPanel.add(textField, BorderLayout.NORTH);
		textField.setPreferredSize(new Dimension(800, 50));
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));

		textArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JScrollPane scrollPane = new JScrollPane(textArea);
		mainPanel.add(scrollPane, BorderLayout.CENTER);

		textArea.setBorder(new EmptyBorder(7, 7, 7, 7));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		fr.setSize(800, 600);
		fr.setVisible(true);
		fr.setLocationRelativeTo(owner);
	}

	public JFrame getFr() {
		return fr;
	}

	public void setFr(JFrame fr) {
		this.fr = fr;
	}
}
