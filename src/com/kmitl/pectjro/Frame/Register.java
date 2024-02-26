package com.kmitl.pectjro.Frame;
import java.awt.*;
import javax.swing.*;

public class Register {
    private JFrame fr;
    private JLabel regis_label, fn_label, ln_label, user_label,pass_label, con_label, emal_label;
    private JTextField f_txt, l_txt, u_txt, pass_txt, con_txt, email_txt;
    private JButton b1, b2;
    private JPanel pmain, center_part, p2, p3, p4, p5, p6, p_mar_left, p_mar_right, pTitle;
    public Register(){
        fr = new JFrame("Register Menu");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Label
        regis_label = new JLabel("Register");
        fn_label = new JLabel("First name");
        ln_label = new JLabel("Last name");
        user_label = new JLabel("Username");
        pass_label = new JLabel("Password");
        con_label = new JLabel("Confirm Password");
        emal_label = new JLabel("Email");
        
        //TextField
        f_txt = new JTextField();
        l_txt = new JTextField();
        u_txt = new JTextField();
        pass_txt = new JTextField();
        con_txt = new JTextField();
        email_txt = new JTextField();
        
        //button
        b1 = new JButton("Submit");
        b2 = new JButton("Back");
        
        //Panel
        pmain = new JPanel();
        pmain.setLayout(new BorderLayout());
        center_part = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p6 = new JPanel();
        p_mar_left = new JPanel();
        p_mar_right = new JPanel();
        pTitle = new JPanel();
        
        //center
        center_part.setLayout(new GridLayout(8, 1));
        p2.setLayout(new GridLayout(1,2));
        p2.add(fn_label);
        p2.add(ln_label);
        center_part.add(p2);
        p3.setLayout(new GridLayout(1, 2));
        p3.add(f_txt);
        p3.add(l_txt);
        center_part.add(p3);
        center_part.add(user_label);
        center_part.add(u_txt);
        p4.setLayout(new GridLayout(1,2));
        p4.add(pass_label);
        p4.add(con_label);
        center_part.add(p4);
        p5.setLayout(new GridLayout(1,2));
        p5.add(pass_txt);
        p5.add(con_txt);
        center_part.add(p5);
        center_part.add(emal_label);
        center_part.add(email_txt);
        
        //button part
        p6.setLayout(new FlowLayout());
        p6.add(b1);
        p6.add(b2);
        
        //add to frame
        pTitle.add(regis_label);
        pTitle.setLayout(new FlowLayout());
        pmain.add(pTitle, BorderLayout.NORTH);
        pmain.add(p6, BorderLayout.SOUTH);
        pmain.add(center_part, BorderLayout.CENTER);
        pmain.add(p_mar_left, BorderLayout.WEST);
        pmain.add(p_mar_right, BorderLayout.EAST);
        fr.add(pmain);
        
        //set
        fr.setSize(350,350);
        fr.setVisible(true);
    }
    public static void main(String[] args) {
        new Register();
    }
}