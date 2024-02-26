package com.kmitl.pectjro.Frame;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Insi
 */
import java.awt.*;
import javax.swing.*;
public class Login {
    //เพิ่ม Component, Pmain ใช้เก็บ Componentอื่นๆ
    private JFrame fr;
    private JPanel Pmain, Ppic, Pmid, Plast;
    private JTextField email;
    private JPasswordField pass;
    private JLabel info, pic;
    private JCheckBox check;
    private JButton login, sign;

    public Login(){
        //ประกาศ Container
        fr = new JFrame("Login");
        Pmain = new JPanel();
        Ppic = new JPanel();
        Pmid = new JPanel();
        Plast = new JPanel();
        
        //Component Ppic
        pic = new JLabel("???PIC???");
        
        //Component Pmid
        email = new JTextField("Email");
        pass = new JPasswordField("Password");
        check = new JCheckBox("???????");
        login = new JButton("Login");
        
        //Component Plast
        info = new JLabel("??????");
        sign = new JButton("Sign up");
        
        //set frame และ กำหนด Layout Pmain
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLayout(new FlowLayout());
        fr.add(Pmain);
        Pmain.setLayout(new BorderLayout());
        
        //add Ppic, Pmid, Plast
        Pmain.add(Ppic, BorderLayout.NORTH);
        Pmain.add(Pmid, BorderLayout.CENTER);
        Pmain.add(Plast, BorderLayout.SOUTH);
        
        //กำหนด Layout Ppic และ Add Com
        Ppic.setLayout(new FlowLayout());
        Ppic.add(pic);
        
        //กำหนด Layout Pmid และ Add Com
        Pmid.setLayout(new GridLayout(4,1));
        Pmid.add(email);
        Pmid.add(pass);
        Pmid.add(check);
        Pmid.add(login);
        
        //กำหนด Layout Plast และ Add Com
        Plast.setLayout(new FlowLayout());
        Plast.add(info);
        Plast.add(sign);
        
        //set frame size, visible
        fr.setSize(300,300);
        fr.setVisible(true);
        
    }
    public static void main(String[] args) {
        new Login();
    }
}
