package com.kmitl.pectjro.Frame.Admin;

import com.kmitl.pectjro.Frame.Tools.Image_Resizer;

import javax.swing.*;
import java.awt.*;

public class user_feedback extends JPanel {
    private JTextArea user_name, user_message;

    private JPanel pl;

    public user_feedback(String username ,String usermessage, String userImage ){

        pl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ImageIcon icon = new ImageIcon("resources/Images/aunkung.jpeg");

        user_name = new JTextArea(); user_message = new JTextArea();

        user_message.setPreferredSize(new Dimension(500,150));

        this.setLayout(new BorderLayout(1,6));
        this.add(pl,BorderLayout.NORTH);
        this.add(user_message,BorderLayout.CENTER);

        ////

        pl.add(new Image_Resizer(icon, 80,60));
        pl.add(user_name);
        user_name.setFont(new Font("",Font.PLAIN,28));
        user_message.setFont(new Font("", Font.PLAIN,14));

        /// setter
        user_message.setText(usermessage);
        user_name.setText(username);
        icon.setImage(new ImageIcon(userImage).getImage());

        /////////Test

        //user_message.setText("Message --- EOFHWAEFJIOFJassweiopFJ0WEIOPFJASSWEIOPFJA90FJawe0iopfjAWEIOPFJAWEIasdfAdgrfxheweghwjkghasghasjkhgasjkl.ghasjghasdughasdg;hasweuighawerui;gwGH    WGHQWUIOGHWUIOHG    WUIOhgwurijSJGHBUIOAJWRHGUA;HWRGUIOHASRJKUGHBAUSJFGHSUIKFGHASDLDRYUIHLDGASUKGHASUIGASUGHUIASLRGHYUASGHEUASGHFASFGHAWEUIFGASEUIFGWUIEGF;WUgua;qwe;h;OPFAWEIOFWEAio");
        //user_name.setText("AuonAuon");

        user_message.setLineWrap(true);
        user_name.setEditable(false);
        user_message.setEditable(false);
        //////
        this.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.gray));
    }

}
