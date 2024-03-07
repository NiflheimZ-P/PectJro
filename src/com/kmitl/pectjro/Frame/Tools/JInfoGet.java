package com.kmitl.pectjro.Frame.Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class JInfoGet extends JTextField implements FocusListener {
    private String shouldbe;
    public JInfoGet(String word){
        super();
        shouldbe = word;
        this.setText(shouldbe);
        this.setForeground(Color.GRAY);
        this.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (getText().equals(shouldbe)){
            this.setText("");
            this.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (this.getText().isEmpty() || this.getText().equals(shouldbe)) {
            this.setText(shouldbe);
            this.setForeground(Color.GRAY);
        }
    }
}
