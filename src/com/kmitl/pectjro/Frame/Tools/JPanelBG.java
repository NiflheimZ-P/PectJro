package com.kmitl.pectjro.Frame.Tools;

import java.awt.*;
import javax.swing.*;

public class JPanelBG extends JPanel{
	private Image image;
	public JPanelBG(Image image){
		super();
		this.image = image;
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
	}
}
