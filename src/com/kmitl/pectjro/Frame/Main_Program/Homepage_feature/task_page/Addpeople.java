package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.DatabaseTable.UserProjectTable;
import com.kmitl.pectjro.Database.DatabaseTable.UserTable;
import com.kmitl.pectjro.Frame.Loading.Loading_dialog;
import com.kmitl.pectjro.Frame.Templates.Project_Template;
import com.kmitl.pectjro.Frame.Templates.User_Template;
import com.kmitl.pectjro.Frame.Tools.Constraints;
import com.kmitl.pectjro.Frame.Tools.JInfoGet;
import javax.swing.*;
import javax.swing.border.LineBorder;
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
    private JPanel p_main, p_zone1, p_zone2, west, top, choose_team, ta, under;
    private JButton Add, Close, delete;
    private JInfoGet tx;
    private JLabel l1;
    private ArrayList<User_Template> allPeople;
    private ArrayList<User_Template> already;
    private JScrollPane scroll, scroll_in;
    private Container owner;
    private Project_Template info;
    private User_Template select;
    private ArrayList<Integer> check;

    public Addpeople(Project_Template info, Container owner){
        this.info = info;
        this.owner = owner;

        fr = new JFrame();
        p_main = new JPanel();          choose_team = new JPanel();
        p_zone1 = new JPanel();         under = new JPanel(new GridBagLayout());
        p_zone2 = new JPanel();
        fr.setSize(600,300);

        Add = new JButton("Add");
        Close = new JButton("Close");
        delete = new JButton("Delete");
        tx = new JInfoGet("Search Member");
        tx.getDocument().addDocumentListener(this);
        ta = new JPanel();
        ta.setLayout(new BoxLayout(ta, BoxLayout.Y_AXIS));
        scroll_in = new JScrollPane(ta);
        scroll_in.getVerticalScrollBar().setUnitIncrement(7);
        top = new JPanel();
        west = new JPanel();

        l1 = new JLabel("Add member to this project");

        fr.add(p_main);
        p_main.setLayout(new GridLayout(1,2));
        p_main.add(p_zone1);
        p_main.add(p_zone2);

        p_zone1.setLayout(new GridBagLayout());

        choose_team.setLayout(new BoxLayout(choose_team, BoxLayout.Y_AXIS));
        scroll = new JScrollPane(choose_team);
        scroll.setPreferredSize(new Dimension(230,110));
        scroll.getVerticalScrollBar().setUnitIncrement(5);

        top.setPreferredSize(new Dimension(200,60));
        west.setPreferredSize(new Dimension(0,100));

        under.add(Add, new Constraints(0, 0, 1, 1, 21, new Insets(0, 0, 0, 0)));
        under.add(delete, new Constraints(1, 0, 1, 1, new Insets(0, 0, 0, 0)));
        under.add(Close, new Constraints(2, 0, 1, 1, 22, new Insets(0, 0, 0, 0)));
        under.setPreferredSize(new Dimension(230, 70));

        p_zone1.add(l1, new Constraints(0, 0, 1, 1, 1, 1, new Insets(0, 0, 0, 0)));
        p_zone1.add(tx, new Constraints(0, 1, 1, 1, 1, 1, new Insets(0, 0, 0, 0)));
        p_zone1.add(scroll, new Constraints(0, 2, 1, 1, 1, 1, new Insets(0, 0, 0, 0)));
        p_zone1.add(under, new Constraints(0, 3, 1, 1, 1, 1, new Insets(0, 0, 0, 0)));

        l1.setFont(new Font("Sans", Font.PLAIN, 14));
        tx.setPreferredSize(new Dimension(230, 35));
        tx.setBackground(new Color(30,31,34));


        Add.setPreferredSize(new Dimension(60,40));
        Add.setBorder(BorderFactory.createEmptyBorder());
        Add.setFont(new Font("Sans", Font.PLAIN, 12));
        Close.setPreferredSize(new Dimension(60,40));
        Close.setBorder(BorderFactory.createEmptyBorder());
        Close.setFont(new Font("Sans", Font.PLAIN, 12));
        delete.setPreferredSize(new Dimension(60,40));
        delete.setBorder(BorderFactory.createEmptyBorder());
        delete.setFont(new Font("Sans", Font.PLAIN, 12));


        p_zone2.setLayout(new FlowLayout());
        p_zone2.add(scroll_in);
        ta.setBackground(new Color(30,31,34));
        scroll_in.setPreferredSize(new Dimension(250,265));

        //set Color
        under.setBackground(new Color(49,51,56));
        p_main.setBackground(new Color(49,51,56));
        choose_team.setBackground(new Color(30,31,34));
        p_zone1.setBackground(new Color(49,51,56));
        p_zone2.setBackground(new Color(49,51,56));
        west.setBackground(new Color(49,51,56));
        top.setBackground(new Color(49,51,56));
        Add.setBackground(new Color(30,31,34));
        Close.setBackground(new Color(30,31,34));
        delete.setBackground(new Color(30,31,34));
        choose_team.setBorder(new LineBorder(new Color(49,51,56)));
        Add.addActionListener(this);
        Close.addActionListener(this);
        delete.addActionListener(this);

        Add.setEnabled(false);

        fr.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        fr.setResizable(false);
        fr.setLocationRelativeTo(owner);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(Add)){
            addnew();
            fr.dispose();
        } else if (e.getSource().equals(Close)) {
            fr.dispose();
        } else if (e.getSource().equals(delete)) {
            deleteOne();
            fr.dispose();
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        Add.setEnabled(true);
        select = ((UserBanner) e.getSource()).getUser();
        tx.setText(select.username);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        ((UserBanner)e.getSource()).setBackground(new Color(88,101,242));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        ((UserBanner)e.getSource()).setBackground(new Color(30,31,34));
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        setFind();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        setFind();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        setFind();
    }

    public void loadAllUser() {
        SwingWorker<Void, Void> load = new SwingWorker<Void, Void>() {
            private final Loading_dialog load = new Loading_dialog(owner);
            @Override
            protected Void doInBackground() throws Exception {
                load.setVisible(true);

                Connection con = DBConnect.createConnect();
                UserTable user = new UserTable(con);
                already = user.getById(info.id);
                allPeople = user.load_AllUser();

                check = new ArrayList<>();
                for (User_Template i : already) {
                    check.add(i.id);
                }

                return null;
            }

            @Override
            protected void done(){
                setFind();
                setAlreadyIn();

                load.dispose();
                fr.setVisible(true);
            }
        };
        load.execute();
    }

    public void setFind() {
        if (!tx.getText().equals(tx.getShouldbe())) {
            choose_team.removeAll();
            int a = 0;
            for (int i = 0; i < allPeople.size(); i++){
                User_Template current = allPeople.get(i);
                if ((current.username.toLowerCase().contains(tx.getText().toLowerCase()) && !check.contains(current.id) && a < 10)){
                    UserBanner addNew = new UserBanner(current, 270, 40);
                    addNew.addMouseListener(this);
                    a++;
                    choose_team.add(addNew, new Constraints(0, i, 0, 0, GridBagConstraints.LINE_START, new Insets(0, 0, 0, 0)));
                }
            }
        } else {
            choose_team.removeAll();
        }
        fr.revalidate();
        fr.repaint();
    }

    public void setAlreadyIn() {
        ta.removeAll();
        for (User_Template i: already) {
            UserBanner current = new UserBanner(i, 270, 40);
            ta.add(current);
            current.addMouseListener(this);
        }
        ta.revalidate();
        ta.repaint();
    }

    public void addnew(){
        SwingWorker<Void, Void> add = new SwingWorker<Void, Void>() {
            private final Loading_dialog load = new Loading_dialog(fr);
            @Override
            protected Void doInBackground() throws Exception {
                load.setVisible(true);

                Connection con = DBConnect.createConnect();
                UserProjectTable user = new UserProjectTable(con);
                user.addCollaborator(select.id, info.id);

                already.add(select);
                check.add(select.id);

                return null;
            }

            @Override
            protected void done() {
                setAlreadyIn();
                setFind();
                tx.setText("");

                load.dispose();
            }
        };
        add.execute();
    }

    public void deleteOne(){
        SwingWorker<Void, Void> add = new SwingWorker<Void, Void>() {
            private final Loading_dialog load = new Loading_dialog(fr);
            @Override
            protected Void doInBackground() throws Exception {
                load.setVisible(true);

                Connection con = DBConnect.createConnect();
                UserProjectTable user = new UserProjectTable(con);
                user.deleteCollaborator(select.id, info.id);

                already.remove(select);
                check.remove(select.id);

                return null;
            }

            @Override
            protected void done() {
                setAlreadyIn();
                setFind();
                tx.setText("");

                load.dispose();
            }
        };
        add.execute();
    }
}
