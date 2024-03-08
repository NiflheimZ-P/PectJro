package com.kmitl.pectjro.Frame.Admin;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.kmitl.pectjro.Frame.Groups_interface.Changeable;
import com.kmitl.pectjro.Frame.Main_Program.Main_Frame;

import javax.swing.*;
import java.awt.*;

public class Main_Admin extends JDesktopPane implements Changeable {
	private JInternalFrame Main_Controls;
	public Main_Admin() {
		super();
		Main_Frame.changeTheme(false);
		create_mainControls();
	}

	public void create_mainControls(){
		Main_Controls = new JInternalFrame("", false, false);
		Main_Controls.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Main_Controls.setSize(500, 300);
		Main_Controls.setLocation(
				(Toolkit.getDefaultToolkit().getScreenSize().width - Main_Controls.getWidth())/2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - Main_Controls.getHeight())/2
		);
		this.add(Main_Controls);
		Main_Controls.setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		ImageIcon image = new ImageIcon("resources/Images/kmitl_it_data_science_01.jpg");
		g2.drawImage(image.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
	}
}
