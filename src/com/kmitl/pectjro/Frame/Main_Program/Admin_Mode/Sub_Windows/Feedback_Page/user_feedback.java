package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.Feedback_Page;

import com.kmitl.pectjro.Frame.Templates.Feedback_Template;
import com.kmitl.pectjro.Frame.Tools.Image_Resizer;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class user_feedback extends JPanel {
    private JTextArea name, message;
    private Image_Resizer image;
    private JPanel north;

    public user_feedback(Feedback_Template user){
        super();
        name = new JTextArea(user.username);
        message = new JTextArea(user.word);
        image = new Image_Resizer(new ImageIcon(user.image), 50, 50);
        image.setBorder(new MatteBorder(1, 1, 1, 1, Color.gray));
        north = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.setLayout(new BorderLayout(0, 5));

        name.setPreferredSize(new Dimension(400, 30));
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        north.add(image); north.add(name);

        this.add(message);
        this.add(north, BorderLayout.NORTH);

        name.setFont(new Font("", Font.BOLD, 20));
        message.setFont(new Font("", Font.PLAIN, 15));

        name.setBackground(Color.darkGray);
        message.setBackground(Color.darkGray);
        north.setBackground(Color.darkGray);
        this.setBackground(Color.darkGray);
        this.setBorder(new CompoundBorder(
                new MatteBorder(1, 1, 1, 1, Color.gray),
                new EmptyBorder(10, 10, 20, 10)
        ));
    }

}
