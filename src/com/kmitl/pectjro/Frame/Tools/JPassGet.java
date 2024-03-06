package com.kmitl.pectjro.Frame.Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class JPassGet extends JPasswordField implements FocusListener {
    public String shouldbe;

    public JPassGet(String word){
        super();
        shouldbe = word;
        this.setEchoChar((char) 0);

        this.addFocusListener(this);
        this.setText(shouldbe);
        this.setForeground(Color.GRAY);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if ((this.getMyPass().equals(shouldbe) && this.getEchoChar() != '*') || this.getMyPass().isEmpty()){
            this.setText("");
            this.setEchoChar('*');
            this.setForeground(Color.BLACK);
        }
        System.out.println(getMyPass());
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (this.getMyPass().isEmpty()){
            this.setText(shouldbe);
            this.setEchoChar((char) 0);
            this.setForeground(Color.GRAY);
        }
        System.out.println(getMyPass());
    }

    public String getMyPass(){
        return String.valueOf(this.getPassword());
    }
}
