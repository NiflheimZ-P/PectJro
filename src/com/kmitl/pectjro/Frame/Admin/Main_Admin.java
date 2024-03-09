package com.kmitl.pectjro.Frame.Admin;

import com.kmitl.pectjro.Frame.Groups_interface.Changeable;
import com.kmitl.pectjro.Frame.Main_Program.Main_Frame;

import javax.swing.*;
import java.awt.*;

public class Main_Admin extends JDesktopPane implements Changeable {
	private JInternalFrame controls;

	public Main_Admin() {
		super();
		//Main_Frame.changeTheme(false);
		controls = new Main_Controls().getFrame();

		this.add(controls);
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
