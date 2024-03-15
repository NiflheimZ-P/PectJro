package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.Feedback_Page;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.kmitl.pectjro.Frame.Tools.Constraints;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class Feedback{
    private JInternalFrame fr;

    private JPanel pl_select, pl_Main_FeedBack, north;

    private JTextArea text_Area;
    public Feedback() {
		int a = 10;

        fr = new JInternalFrame("Feedback", true, true, false);
        text_Area = new JTextArea();
        pl_select = new JPanel(new GridBagLayout());
		north = new JPanel(new FlowLayout(FlowLayout.LEFT));

		for (int i = 0; i < a; i++) {
			pl_select.add(new user_feedback("Hello","UwU my name is Aun i'm going to see my gf UwU i am so nervous UwU","resources/Images/aunkung.jpeg"),
					new Constraints(0, i, 1, 1, new Insets(0, 0, 20, 0)));

		}
		pl_select.setMaximumSize( pl_select.getPreferredSize() );

		JScrollPane scroll = new JScrollPane(pl_select, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBorder(null);
		javax.swing.SwingUtilities.invokeLater(() -> scroll.getVerticalScrollBar().setValue(0));
		scroll.setAutoscrolls(false);

		pl_Main_FeedBack = new JPanel(new BorderLayout(0, 20));
		pl_Main_FeedBack.add(scroll);
		JLabel word = new JLabel("User Feedback");
		word.setFont(new Font("", Font.BOLD, 30));
		north.add(word);
		north.setBorder(new CompoundBorder(
				new MatteBorder(0, 0, 1, 0, Color.gray),
				new EmptyBorder(10, 10, 10, 10)
		));
		pl_Main_FeedBack.add(north, BorderLayout.NORTH);

		fr.add(pl_Main_FeedBack);

		fr.setFocusable(true);
		fr.requestFocus();
		fr.setSize(650, 600);
    }
    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(new FlatMacLightLaf());
        SwingUtilities.invokeLater(()->{new Feedback();});

    }
}
