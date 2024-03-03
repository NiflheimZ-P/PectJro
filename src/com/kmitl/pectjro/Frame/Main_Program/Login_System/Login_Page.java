package com.kmitl.pectjro.Frame.Main_Program.Login_System;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import com.kmitl.pectjro.Frame.Tools.*;

public class Login_Page extends JPanel {
    private JLabel login = new JLabel("Login");
    public Login_Page() {
        super();
        this.setBorder(new CompoundBorder(
                new EmptyBorder(5, 5, 5, 5),
                new MatteBorder(1, 1, 1, 1, Color.gray)
        ));
        this.setPreferredSize(new Dimension(480, 610));
        this.setLayout(new GridBagLayout());

        
    }
}
