package com.kmitl.pectjro.Frame.Loading;

import com.kmitl.pectjro.Frame.Tools.Constraints;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Loading_GlassPane extends JPanel implements MouseListener {
	private JLabel pic;
	private JLabel text;
	private Loading_dialog loading;

	public Loading_GlassPane() {
		setOpaque(false);
		loading = new Loading_dialog(this);

		this.setLayout(new GridBagLayout());

		addMouseListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(0, 0, 0, 150));
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		e.consume();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		e.consume();
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	public void setLoading(boolean visible) {
		loading.setVisible(visible);
	}
}
