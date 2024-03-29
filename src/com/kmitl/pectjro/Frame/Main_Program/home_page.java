package com.kmitl.pectjro.Frame.Main_Program;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.kmitl.pectjro.Frame.Groups_interface.View_Getter;
import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.Calendars;
import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.Profile;
import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.Progress;
import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.ProjectCreate;
import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page.Task;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class home_page implements View_Getter, ActionListener {
    private JFrame main_panel;

    private JPanel bg, pn_north, pn_west, pn_east, ctn_pn_task, ctn_pn_calendar, ctn_pn_appraisement, ctn_pn_deadline,
            pn_north_right, ps_mar_pmain, paneforsearch, up_mar_search, l_mar_search, r_mar_search,
            s_mar_search, center_part;
    private JTextField tf_seach_bar;
    private Image im_program, im_profile;
    private JButton bn_task, bn_calendar, bn_appraisement, bn_new, bn_admin, bn_profile;
    private JLabel l1, l3, l4;

    CardLayout page = new CardLayout();

    private Progress pro;
    private Profile profile;
    private Calendars calen;
    private Task task;

    public home_page(){
        //set up
        main_panel = new JFrame();
        bg = new JPanel();
        pn_north = new JPanel();
        pn_west = new JPanel();
        paneforsearch = new JPanel();
        pn_east = new JPanel();
        ps_mar_pmain = new JPanel();
        ctn_pn_task = new JPanel();
        ctn_pn_calendar = new JPanel();
        ctn_pn_appraisement = new JPanel();
        ctn_pn_deadline = new JPanel();
        pn_north_right = new JPanel();
        up_mar_search = new JPanel();
        l_mar_search = new JPanel();
        r_mar_search = new JPanel();
        s_mar_search = new JPanel();

        tf_seach_bar = new JTextField();
        //prepare to add image
        im_program = new ImageIcon("resources/Images/Logo.png").getImage();
        Image tmp_program = im_program.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon ic_program = new ImageIcon(tmp_program);
        im_profile = new ImageIcon("resources/Images/aunkung.jpeg").getImage();
        Image tmp_profile = im_profile.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon ic_profile = new ImageIcon(tmp_profile);
        //im_task = new ImageIcon("resources/Images/task.png").getImage();

        bn_task = new JButton("Task");
        bn_calendar = new JButton("Calendar");
        bn_appraisement = new JButton("Appraisement");
        bn_new = new JButton("+");
        bn_admin = new JButton("Admin");
        bn_profile = new JButton();

        l1 = new JLabel();
        l3 = new JLabel("3");
        l4 = new JLabel("Deadline");

        //feature create
        pro = new Progress();
        profile = new Profile();
        calen = new Calendars();
        task = new Task();


        //card
        center_part = new JPanel();
        center_part.setLayout(page);

        //add to centerpart
        center_part.add(task.getFrame(), "0");
        center_part.add(calen.getFrame(), "1");
        center_part.add(pro.getFr(),"2");
        center_part.add(profile.getFr(), "3");

        //set center part
        main_panel.setLayout(new BorderLayout());
        main_panel.add(bg);
        main_panel.add(center_part, BorderLayout.CENTER);


        //set upper part (pn_north)
        main_panel.add(pn_north, BorderLayout.NORTH);
        pn_north.setLayout(new GridLayout(1,3));

        JPanel margin_l1 = new JPanel();
        pn_north.add(margin_l1);
        margin_l1.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 20));
        margin_l1.add(l1);
        l1.setIcon(ic_program);;

        paneforsearch.setLayout(new BorderLayout());
        paneforsearch.add(tf_seach_bar, BorderLayout.CENTER);
        paneforsearch.add(up_mar_search, BorderLayout.NORTH);
        up_mar_search.setPreferredSize(new Dimension(0, 25));
        paneforsearch.add(l_mar_search, BorderLayout.WEST);
        paneforsearch.add(r_mar_search, BorderLayout.EAST);
        paneforsearch.add(s_mar_search, BorderLayout.SOUTH);
        s_mar_search.setPreferredSize(new Dimension(0, 25));
        pn_north.add(paneforsearch);
        tf_seach_bar.setFocusable(true);

        pn_north_right.setLayout(new FlowLayout(2,20,20)); // 2 = right , hgap = ซ้าย - ขวา , vgap = บน-ล่าง
        pn_north_right.add(bn_admin); pn_north_right.add(bn_profile);
        bn_profile.setIcon(ic_profile);
        pn_north.add(pn_north_right);


        //set left part (pn_west)
        main_panel.add(pn_west, BorderLayout.WEST);
        pn_west.setLayout(new GridLayout(10, 1,0,0));
        pn_west.setPreferredSize(new Dimension(200, 600));

        //set up inside left part
        ctn_pn_task.setLayout(new GridLayout());
        bn_task.setBorder(BorderFactory.createEmptyBorder());
        bn_task.setFont(new Font("Sans", Font.PLAIN, 24));
        bn_task.setPreferredSize(new Dimension(190, 60));
        ctn_pn_task.add(bn_task); pn_west.add(ctn_pn_task);

        ctn_pn_calendar.setLayout(new GridLayout());
        bn_calendar.setBorder(BorderFactory.createEmptyBorder());
        bn_calendar.setFont(new Font("Sans", Font.PLAIN, 24));
        bn_calendar.setPreferredSize(new Dimension(190, 60));
        ctn_pn_calendar.add(bn_calendar); pn_west.add(ctn_pn_calendar);

        ctn_pn_appraisement.setLayout(new GridLayout());
        bn_appraisement.setBorder(BorderFactory.createEmptyBorder());
        bn_appraisement.setFont(new Font("Sans", Font.PLAIN, 24));
        bn_appraisement.setPreferredSize(new Dimension(190, 60));
        ctn_pn_appraisement.add(bn_appraisement); pn_west.add(ctn_pn_appraisement);

        ctn_pn_deadline.setLayout(new FlowLayout());
        l4.setFont(new Font("Sans", Font.BOLD, 18));
        ctn_pn_deadline.add(l4); pn_west.add(ctn_pn_deadline);


        //button (+) at bottom right of corner and right part (pn_east)
        ps_mar_pmain.setLayout(new FlowLayout(2, 30,25));
        main_panel.add(pn_east, BorderLayout.EAST);
        bn_new.setPreferredSize(new Dimension(40,40));
        ps_mar_pmain.add(bn_new);
        pn_east.setLayout(new BorderLayout());
        pn_east.add(ps_mar_pmain, BorderLayout.SOUTH);


        //set color
            //Panel
        bg.setBackground(new Color(49,51,56));
        pn_north.setBackground(new Color(30,31,34));
        up_mar_search.setBackground(new Color(30,31,34));
        l_mar_search.setBackground(new Color(30,31,34));
        r_mar_search.setBackground(new Color(30,31,34));
        s_mar_search.setBackground(new Color(30,31,34));
        pn_north_right.setBackground(new Color(30,31,34));
        margin_l1.setBackground(new Color(30,31,34));
        l1.setForeground(Color.BLACK);
        bn_profile.setBackground(new Color(49,51,56));

        pn_west.setBackground(new Color(30,31,34));
        ctn_pn_deadline.setBackground(new Color(30,31,34));
        ps_mar_pmain.setBackground(new Color(49,51,56));

        pn_east.setBackground(new Color(49,51,56));
            //Button
        bn_admin.setForeground(Color.white) ; bn_admin.setBackground(new Color(43,45,49));
        bn_task.setForeground(Color.white); bn_task.setBackground(new Color(43,45,49));
        bn_calendar.setForeground(Color.white); bn_calendar.setBackground(new Color(43,45,49));
        bn_appraisement.setForeground(Color.white); bn_appraisement.setBackground(new Color(43,45,49));
        bn_new.setForeground(Color.white) ; bn_new.setBackground(new Color(43,45,49));

            //Label
        l4.setForeground(Color.red);

        //add event
        bn_new.addActionListener(this);
        bn_task.addActionListener(this);
        bn_appraisement.addActionListener(this);
        bn_calendar.addActionListener(this);
        bn_profile.addActionListener(this);
        bn_admin.addActionListener(this);

        //ads
        profile.getBn_select_photo().addActionListener(this);


        //show
        main_panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_panel.setSize(1400, 800);
        main_panel.setResizable(false);
        main_panel.setVisible(true);
    }

    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(new FlatMacDarkLaf());
        SwingUtilities.invokeLater(() -> {new home_page(); });
    }

    public JButton getBn_profile() {
        return bn_profile;
    }

    public void setBn_profile(ImageIcon bn_profile) {
        this.bn_profile.setIcon(bn_profile);
    }

    @Override
    public Container getView() {
        return main_panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(bn_new)){
            new ProjectCreate();
        }else if (e.getSource().equals(bn_task)){
            page.show(center_part, "0");
            main_panel.add(pn_east, BorderLayout.EAST);
            paneforsearch.setVisible(true);
        }else if (e.getSource().equals(bn_calendar)) {
            page.show(center_part, "1");
            main_panel.remove(pn_east);
            paneforsearch.setVisible(false);
        }else if (e.getSource().equals(bn_appraisement)){
            page.show(center_part, "2");
            main_panel.remove(pn_east);
        }else if (e.getSource().equals(bn_profile)) {
            page.show(center_part, "3");
            main_panel.remove(pn_east);
        }else if (e.getSource().equals(profile.getBn_select_photo())) {
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(profile.getFr());
            File f = fc.getSelectedFile();
            im_profile = new ImageIcon(f.getAbsolutePath()).getImage();
            Image newImage = im_profile.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
            ImageIcon ic_image = new ImageIcon(newImage);
            profile.getIcon().setIcon(ic_image);
            Image tmp = im_profile.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            ImageIcon imttmp = new ImageIcon(tmp);
            bn_profile.setIcon(imttmp);
            paneforsearch.setVisible(false);
        }else if (e.getSource().equals(bn_profile)){
            page.show(center_part, "3");
            main_panel.remove(pn_east);
            paneforsearch.setVisible(false);
        }
    }
}
