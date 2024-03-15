package com.kmitl.pectjro.Frame.Templates;

import javax.swing.*;
import java.awt.*;

public class Feedback_Template {
	public int id;
	public Image image;
	public String username;
	public String word;

	public void setFeedback(int id, byte[] image, String username, String word) {
		this.id = id;
		this.image = new ImageIcon(image).getImage();
		this.username = username;
		this.word = word;
	}
}
