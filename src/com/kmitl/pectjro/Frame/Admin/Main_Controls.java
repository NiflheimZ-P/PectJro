package com.kmitl.pectjro.Frame.Admin;

import javax.swing.*;
import java.awt.*;

import com.kmitl.pectjro.Frame.Main_Program.Main_Frame;
import com.kmitl.pectjro.Frame.Tools.*;

public class Main_Controls {
	private JInternalFrame main_Panel;
	private JButton user, project, feedback;
	public Main_Controls() {
		main_Panel = new JInternalFrame("Controls", false, false);
		main_Panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_Panel.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.25),
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.17));
		main_Panel.setLocation(
				(Main_Frame.frame.getWidth() - main_Panel.getWidth())/2,
				(Main_Frame.frame.getHeight() - main_Panel.getHeight())/2
		);

		user = create_button("resources/Images/Icons/user.png");
		project = create_button("resources/Images/Icons/project.png");
		feedback = create_button("resources/Images/Icons/feedback.png");


		main_Panel.setLayout(new GridBagLayout());
		main_Panel.add(user, new Constraints(0, 0, 1, 0, new Insets(0, 0, 0, 0)));
		main_Panel.add(project, new Constraints(1, 0, 1, 0, new Insets(0, 0, 0, 0)));
		main_Panel.add(feedback, new Constraints(2, 0, 1, 0, new Insets(0, 0, 0, 0)));

		main_Panel.setVisible(true);
	}

	public JButton create_button(String path){
		ImageIcon in = new ImageIcon(path);
		return new JButton(new ImageIcon(in.getImage().getScaledInstance(
				((int) (main_Panel.getWidth()*0.27)),
				((int) (main_Panel.getWidth()*0.27)), Image.SCALE_DEFAULT)));
	}

	public JInternalFrame getFrame(){
		return main_Panel;
	}
}
