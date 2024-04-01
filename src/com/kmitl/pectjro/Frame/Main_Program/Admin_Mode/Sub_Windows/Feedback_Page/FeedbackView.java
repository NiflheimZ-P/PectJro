package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.Feedback_Page;

import com.kmitl.pectjro.Frame.Tools.Constraints;
import com.kmitl.pectjro.Frame.Tools.JInfoGet;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class FeedbackView {
	// Attribute
    private JInternalFrame frame;
    private JPanel comment, pl_Main_FeedBack, north;
	private JButton refresh;
	private JInfoGet search;
	private JScrollPane scroll;

	// Constructor
    public FeedbackView() {
		frame = new JInternalFrame("Feedback", true, true, false);
		comment = new JPanel(new GridBagLayout());
		north = new JPanel(new GridBagLayout());
		frame.setSize(650, 600);

		refresh = new JButton("Refresh");
		refresh.setEnabled(false);

		search = new JInfoGet("Search for Username");
		search.setPreferredSize(new Dimension((int) (frame.getWidth()*0.3), 27));

		north.add(search, new Constraints(0, 0, 1, 1, GridBagConstraints.LINE_START, new Insets(10, 20, 10, 10)));
		north.add(refresh, new Constraints( 1, 0, 1, 1,  GridBagConstraints.LINE_END, new Insets(10, 10, 10, 20)));

		comment.setMaximumSize(comment.getPreferredSize() );
		scroll = new JScrollPane(comment, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBorder(null);
		scroll.getVerticalScrollBar().setUnitIncrement(10);

		javax.swing.SwingUtilities.invokeLater(() -> scroll.getVerticalScrollBar().setValue(0));
		scroll.setAutoscrolls(false);

		pl_Main_FeedBack = new JPanel(new BorderLayout(0, 20));
		pl_Main_FeedBack.add(scroll);
		north.setBorder(new CompoundBorder(
				new MatteBorder(0, 0, 1, 0, Color.gray),
				new EmptyBorder(10, 10, 10, 10)
		));
		pl_Main_FeedBack.add(north, BorderLayout.NORTH);

		frame.setFocusable(true);
		frame.requestFocus();
		frame.add(pl_Main_FeedBack);
    }

	// Accessor
	public JInternalFrame getFrame() {
		return frame;
	}
	public JPanel getComment() {
		return comment;
	}
	public JButton getRefresh() {return refresh;}
	public JInfoGet getSearch() {return search;}
	public JScrollPane getScroll() {return scroll;}
}
