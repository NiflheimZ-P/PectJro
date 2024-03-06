package com.kmitl.pectjro.Frame.SetupPage;

import java.awt.*;
import javax.swing.*;


public class default_panel extends JPanel {
    private JLabel info;
    public default_panel() {
        super();
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        info = new JLabel("<html><h1>Welcome to the PectJro<br/>Desktop Setup program.</h1><br/>" +
                "It is strongly recommended that you exit all Windows programs<br/>" +
                "before running this setup program.<br/>" +
                " <br/>" +
                "Click Cancel to quit setup and close any programs you have running.<br/>" +
                "Click Next to continue the installation<br/>");
        this.add(info);
    }
}
