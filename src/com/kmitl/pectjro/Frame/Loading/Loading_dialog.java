package com.kmitl.pectjro.Frame.Loading;

import com.kmitl.pectjro.Frame.Tools.Image_Resizer;

import javax.swing.*;
import java.awt.*;

public class Loading_dialog extends JDialog {
	public Loading_dialog(Container owner){
		super();
		this.setResizable(false);
		this.setTitle("Please wait");
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

		Image_Resizer image = new Image_Resizer(new ImageIcon("resources/Images/ZZ5H.gif"), 30, 30);
		this.add(image);
		this.add(new JLabel("Loading Data..."));
		this.pack();
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(owner);
	}
}
