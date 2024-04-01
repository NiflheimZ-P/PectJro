package com.kmitl.pectjro.Frame.Main_Program.home_page;

import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page.project_progressbar;
import com.kmitl.pectjro.Frame.Main_Program.Main_Frame.MainController;
import com.kmitl.pectjro.Frame.Templates.Project_Template;
import com.kmitl.pectjro.Frame.Tools.Constraints;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DeadLine extends JPanel implements MouseListener {
	private JLabel name;
	private JLabel date;
	private project_progressbar newone;
	private final Project_Template info;
	private home_pageController controller;
	public DeadLine(Project_Template info, home_pageController controller) {
		this.info = info;
		name = new JLabel(info.name);
		int space = (int) Math.ceil((info.end.getTime() - System.currentTimeMillis()) / 86400000		) + 1;
		date = new JLabel();
		if (space < 0) {
			date.setText("Pass " + space*-1 + " day");
		} else {
			date.setText(space + " day");
		}
		this.controller = controller;
		this.setLayout(new GridBagLayout());
		this.add(name, new Constraints(0, 0, 1, 1, 21, new Insets(0, 0, 0, 0)));
		this.add(date, new Constraints(0, 0, 1, 1, 22, new Insets(0, 0, 0, 0)));
		this.setPreferredSize(new Dimension(185, 50));
		this.setBackground(new Color(43,45,49));
		this.addMouseListener(this);
		this.setBorder(new CompoundBorder(new LineBorder(new Color(30,31,34)),
				new EmptyBorder(5, 10, 5, 10)));
		name.setFont(new Font("Sans", Font.BOLD, 16));
		name.setForeground(new Color(88,101,242));
		date.setForeground(Color.WHITE);
		date.setFont(new Font("Sans", Font.BOLD, 16));
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(this)){
			SwingWorker<Void, Void> load = new SwingWorker<Void, Void>() {
				@Override
				protected Void doInBackground() throws Exception {
					MainController.glassPane.setVisible(true);
					MainController.glassPane.setLoading(true);

					newone = new project_progressbar(info, controller.getTask());
					newone.loadStep();
					newone.setUpChart();
					return null;
				}

				@Override
				protected void done(){
					newone.getFr().setVisible(true);

					MainController.glassPane.setVisible(false);
					MainController.glassPane.setLoading(false);
				}
			};
			load.execute();
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
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		name.setForeground(Color.white);
		date.setForeground(new Color(221,7,51));
		this.setBackground(new Color(88,101,242,255));
		this.setBorder(new CompoundBorder(new LineBorder(new Color(88,101,242,255)),
				new EmptyBorder(5, 10, 5, 10)));
		this.revalidate(); this.repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		name.setForeground(new Color(88,101,242));
		date.setForeground(Color.WHITE);
		this.setBackground(new Color(43,45,49));
		this.setBorder(new CompoundBorder(new LineBorder(new Color(30,31,34)),
				new EmptyBorder(5, 10, 5, 10)));
		this.revalidate(); this.repaint();
	}
}
