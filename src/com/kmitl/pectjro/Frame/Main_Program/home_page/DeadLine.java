package com.kmitl.pectjro.Frame.Main_Program.home_page;

import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page.project_progressbar;
import com.kmitl.pectjro.Frame.Main_Program.Main_Frame.MainController;
import com.kmitl.pectjro.Frame.Templates.Project_Template;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

public class DeadLine extends JPanel implements MouseListener {
	private JLabel name;
	private project_progressbar newone;
	private Project_Template info;
	private home_pageController controller;
	public DeadLine(Project_Template info, home_pageController controller) {
		this.info = info;
		name = new JLabel(info.name);
		this.controller = controller;
		this.add(name);
		this.setLayout(new GridBagLayout());
		this.setPreferredSize(new Dimension(185, 50));
		this.setBackground(new Color(43,45,49));
		this.addMouseListener(this);
		name.setFont(new Font("Sans", Font.BOLD, 16));
		name.setForeground(new Color(88,101,242));
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(this)){
			SwingWorker<Void, Void> load = new SwingWorker<Void, Void>() {
				@Override
				protected Void doInBackground() throws Exception {
					MainController.glassPane.setVisible(true);
					MainController.glassPane.setLoading(true);

					newone = new project_progressbar(info, controller.getMain_controller().getView().getFrame());
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
		name.setForeground(Color.white);
		this.setBackground(new Color(88,101,242,255));
		this.setBorder(new CompoundBorder(new LineBorder(new Color(88,101,242,255)),
				new EmptyBorder(20, 20, 20, 20)));
		this.revalidate(); this.repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		name.setForeground(new Color(88,101,242));
		this.setBackground(new Color(43,45,49));
		this.setBorder(new CompoundBorder(new LineBorder(new Color(30,31,34)),
				new EmptyBorder(20, 20, 20, 20)));
		this.revalidate(); this.repaint();
	}
}
