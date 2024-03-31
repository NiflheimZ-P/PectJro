package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.DatabaseTable.UserTable;
import com.kmitl.pectjro.Frame.Loading.Loading_dialog;
import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.ProjectTablePage.UserBanner;
import com.kmitl.pectjro.Frame.Templates.User_Template;
import com.kmitl.pectjro.Frame.Tools.Constraints;
import com.kmitl.pectjro.Frame.Tools.JInfoGet;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.ArrayList;

public class Addpeople implements MouseListener, ActionListener, DocumentListener {
    private JFrame fr;
    private JPanel p_main, p_zone1, p_zone2, p_zone11, p_zone12, west, top, choose_team, pl_but , West_choose, East_choose, findPeople, select;
    private JButton Add, Close;
    private JTextArea ta;
    private JInfoGet search_member, tx;
    private JLabel l1;
    private ArrayList<User_Template> allPeople;
    private ArrayList<Integer> already;
    private JScrollPane scroll;
    private boolean selected;
    private Container owner;

    public Addpeople(Container owner){
        this.owner = owner;
        selected = false;

        fr = new JFrame();
        p_main = new JPanel();          choose_team = new JPanel(); pl_but = new JPanel();
        p_zone1 = new JPanel();         p_zone11 = new JPanel();    West_choose = new JPanel();
        p_zone2 = new JPanel();         p_zone12 = new JPanel();    East_choose = new JPanel();


        Add = new JButton("Add");
        Close = new JButton("Close");
        tx = new JInfoGet("Search Member");
        ta = new JTextArea();
        top = new JPanel();
        west = new JPanel();

        findPeople = new JPanel(new GridBagLayout());

        search_member = new JInfoGet("Search Member");

        l1 = new JLabel("Add member to this project");

        fr.add(p_main);
        p_main.setLayout(new GridLayout(1,2));
        p_main.add(p_zone1);
        p_main.add(p_zone2);

        p_zone1.setLayout(new BorderLayout());
        p_zone1.add(p_zone11, BorderLayout.CENTER);
        p_zone1.add(p_zone12, BorderLayout.SOUTH);
        p_zone12.setPreferredSize(new Dimension(300,140));

        p_zone11.setLayout(new BorderLayout());

        p_zone11.add(west, BorderLayout.WEST);
        p_zone11.add(top, BorderLayout.NORTH);
        top.setPreferredSize(new Dimension(200,60));
        west.setPreferredSize(new Dimension(0,100));
        JPanel tmp = new JPanel();
        p_zone11.add(tmp, BorderLayout.CENTER);

        tmp.add(l1);
        l1.setFont(new Font("Sans", Font.PLAIN, 14));
        tmp.add(tx);
        tx.setPreferredSize(new Dimension(200,32));
        tx.setBackground(new Color(30,31,34));

        p_zone12.setLayout(new BorderLayout());
        p_zone12.add(choose_team, BorderLayout.NORTH);

        choose_team.setPreferredSize(new Dimension(200,70));
        choose_team.setLayout(new BorderLayout());
        choose_team.add(West_choose, BorderLayout.WEST);
        choose_team.add(East_choose, BorderLayout.EAST);
        West_choose.setPreferredSize(new Dimension(50,70));
        East_choose.setPreferredSize(new Dimension(50,70));

        p_zone12.add(pl_but);
        pl_but.setLayout(new FlowLayout());
        pl_but.add(Add);
        Add.setPreferredSize(new Dimension(90,40));
        Add.setBorder(BorderFactory.createEmptyBorder());
        Add.setFont(new Font("Sans", Font.PLAIN, 12));
        pl_but.add(Close);
        Close.setPreferredSize(new Dimension(90,40));
        Close.setBorder(BorderFactory.createEmptyBorder());
        Close.setFont(new Font("Sans", Font.PLAIN, 12));
        

        p_zone2.setLayout(new FlowLayout());
        p_zone2.add(ta);
        ta.setBackground(new Color(30,31,34));
        ta.setPreferredSize(new Dimension(250,265));
        ta.setEditable(false);

        //set Color
        p_main.setBackground(new Color(49,51,56));
        choose_team.setBackground(new Color(30,31,34));
        p_zone1.setBackground(new Color(49,51,56));
        p_zone2.setBackground(new Color(49,51,56));
        tmp.setBackground(new Color(49,51,56));
        p_zone11.setBackground(new Color(49,51,56));
        p_zone12.setBackground(new Color(49,51,56));
        west.setBackground(new Color(49,51,56));
        top.setBackground(new Color(49,51,56));
        Add.setBackground(new Color(30,31,34));
        Close.setBackground(new Color(30,31,34));
        pl_but.setBackground(new Color(49,51,56));
        East_choose.setBackground(new Color(49,51,56));
        West_choose.setBackground(new Color(49,51,56));
        choose_team.setBorder(new LineBorder(new Color(49,51,56)));
        Add.addActionListener(this);
        Close.addActionListener(this);

        fr.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        fr.setResizable(false);
        fr.setSize(600,300);
        fr.setVisible(true);
        fr.setLocationRelativeTo(owner);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(Add)){

        } else if (e.getSource().equals(Close)) {
            System.exit(0);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void insertUpdate(DocumentEvent e) {
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }

    public void loadAlluser() {
        SwingWorker<Void, Void> load = new SwingWorker<Void, Void>() {
            private final Loading_dialog load = new Loading_dialog(owner);
            @Override
            protected Void doInBackground() throws Exception {
                load.setVisible(true);

                Connection con = DBConnect.createConnect();
                

                return null;
            }

            @Override
            protected void done(){

                load.dispose();
            }
        };
        load.execute();
    }
}
