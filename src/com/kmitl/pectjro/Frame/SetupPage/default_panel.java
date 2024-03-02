package com.kmitl.pectjro.Frame.SetupPage;

import java.awt.*;
import javax.swing.*;


public class default_panel extends JPanel {
    private JLabel info;
    public default_panel() {
        super();
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        info = new JLabel("<html><h1>Can you be my valentine UwU</h1><br/>" +
                "For the love of my life<br/>" +
                "She's got glow on her face<br/>" +
                "A glorious look in her eyes<br/>" +
                "My angel of light<br/>" +
                "I was all alone with the love of my life<br/>" +
                "She's got glitter for skin<br/>" +
                "My radiant beam in the night<br/>" +
                "I don't need no light to see you<br/>" +
                "Shine<br/>" +
                "It's your golden hour (oh)<br/>" +
                "You slow down time<br/>" +
                "In your golden hour (oh)</html>");
        this.add(info);
    }
}
