package com.kmitl.pectjro.Frame.Main_Program.home_page;

import com.kmitl.pectjro.Frame.Groups_interface.View_Getter;
import com.kmitl.pectjro.Frame.Tools.Constraints;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class home_page implements View_Getter, MouseListener {

    private JPanel main_panel;

    private JPanel bg, pn_north, pn_west, pn_east, ctn_pn_task, ctn_pn_calendar, ctn_pn_appraisement, ctn_pn_deadline,
            pn_north_right, ps_mar_pmain, paneforsearch, up_mar_search, l_mar_search, r_mar_search,
            s_mar_search, center_part, warning;
    private JTextField tf_seach_bar;
    private Image im_program, im_profile;
    private JButton bn_task, bn_calendar, bn_appraisement, bn_admin, bn_profile;
    private JLabel l1, l3, l4;


    public JTextField getTf_seach_bar() {
        return tf_seach_bar;
    }

    public home_page(int height){
        //set up
        main_panel = new JPanel(new BorderLayout());
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
        warning = new JPanel(new GridBagLayout());

        tf_seach_bar = new JTextField();
        //prepare to add image
        im_program = new ImageIcon("resources/Images/Logo.png").getImage();
        Image tmp_program = im_program.getScaledInstance(180, 60, Image.SCALE_DEFAULT);
        ImageIcon ic_program = new ImageIcon(tmp_program);
        im_profile = new ImageIcon("resources/Images/aunkung.jpeg").getImage();
        Image tmp_profile = im_profile.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon ic_profile = new ImageIcon(tmp_profile);
        //im_task = new ImageIcon("resources/Images/task.png").getImage();

        bn_task = new JButton("Task");
        bn_calendar = new JButton("Calendar");
        bn_appraisement = new JButton("Stats");
        bn_admin = new JButton("Admin");
        bn_profile = new JButton();

        l1 = new JLabel();
        l3 = new JLabel("3");
        l4 = new JLabel("Deadline");

        //card
        center_part = new JPanel();

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
        pn_west.setLayout(new GridBagLayout());
        pn_west.setPreferredSize(new Dimension(200, 600));

        //set up inside left part
        ctn_pn_task.setLayout(new GridLayout());
        bn_task.setBorder(BorderFactory.createEmptyBorder());
        bn_task.setFont(new Font("Sans", Font.PLAIN, 24));
        bn_task.setPreferredSize(new Dimension(200, 100));
        ctn_pn_task.add(bn_task);
        pn_west.add(ctn_pn_task, new Constraints(0, 0, 0, 0, new Insets(0, 0, 0, 0)));

        ctn_pn_calendar.setLayout(new GridLayout());
        bn_calendar.setBorder(BorderFactory.createEmptyBorder());
        bn_calendar.setFont(new Font("Sans", Font.PLAIN, 24));
        bn_calendar.setPreferredSize(new Dimension(200, 100));
        ctn_pn_calendar.add(bn_calendar);
        pn_west.add(ctn_pn_calendar, new Constraints(0, 1, 0, 0, new Insets(0, 0, 0, 0)));

        ctn_pn_appraisement.setLayout(new GridLayout());
        bn_appraisement.setBorder(BorderFactory.createEmptyBorder());
        bn_appraisement.setFont(new Font("Sans", Font.PLAIN, 24));
        bn_appraisement.setPreferredSize(new Dimension(200, 100));
        ctn_pn_appraisement.add(bn_appraisement);
        pn_west.add(ctn_pn_appraisement, new Constraints(0, 2, 0, 0, new Insets(0, 0, 0, 0)));

        ctn_pn_deadline.setLayout(new FlowLayout());
        l4.setFont(new Font("Sans", Font.BOLD, 18));
        ctn_pn_deadline.add(l4);
        pn_west.add(ctn_pn_deadline, new Constraints(0, 3, 0, 0, new Insets(0, 0, 0, 0)));
        pn_west.add(warning, new Constraints(0, 4, 1, 1, GridBagConstraints.PAGE_START, new Insets(0, 0, 0, 0)));
        warning.setPreferredSize(new Dimension(200, (int)(height * 0.54)));


        //button (+) at bottom right of corner and right part (pn_east)
        ps_mar_pmain.setLayout(new FlowLayout(2, 30,25));
        //main_panel.add(pn_east, BorderLayout.EAST);
       // ps_mar_pmain.add(bn_new);
        //pn_east.setLayout(new BorderLayout());
        //pn_east.add(ps_mar_pmain, BorderLayout.SOUTH);


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
        bn_admin.setVisible(false);
        bn_task.setForeground(Color.white); bn_task.setBackground(new Color(43,45,49));
        bn_calendar.setForeground(Color.white); bn_calendar.setBackground(new Color(43,45,49));
        bn_appraisement.setForeground(Color.white); bn_appraisement.setBackground(new Color(43,45,49));
        bn_admin.setPreferredSize(new Dimension(80,35));
            //Label
        l4.setForeground(new Color(88,101,242));

        bn_task.addMouseListener(this);
        bn_calendar.addMouseListener(this);
        bn_appraisement.addMouseListener(this);
    }

    @Override
    public Container getView() {
        return main_panel;
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
        if (e.getSource().equals(bn_task)) {
            bn_task.setBackground(new Color(88,101,242));
            bn_task.setForeground(Color.black);
        } else if (e.getSource().equals(bn_calendar)){
            bn_calendar.setBackground(new Color(88,101,242));
            bn_calendar.setForeground(Color.black);
        } else if (e.getSource().equals(bn_appraisement)){
            bn_appraisement.setBackground(new Color(88,101,242));
            bn_appraisement.setForeground(Color.black);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(bn_task)) {
            bn_task.setBackground(new Color(43,45,49));
            bn_task.setForeground(Color.white);
        } else if (e.getSource().equals(bn_calendar)){
            bn_calendar.setBackground(new Color(43,45,49));
            bn_calendar.setForeground(Color.white);
        } else if (e.getSource().equals(bn_appraisement)){
            bn_appraisement.setBackground(new Color(43,45,49));
            bn_appraisement.setForeground(Color.white);
        }
    }

    // Accessor
    public JPanel getCenter_part() {
        return center_part;
    }
    public void setCenter_part(JPanel center_part) {
        this.center_part = center_part;
    }
    public JPanel getPaneforsearch() {
        return paneforsearch;
    }
    public void setPaneforsearch(JPanel paneforsearch) {
        this.paneforsearch = paneforsearch;
    }
    public JPanel getMain_panel() {
        return main_panel;
    }
    public void setMain_panel(JPanel main_panel) {
        this.main_panel = main_panel;
    }
    public JButton getBn_task() {
        return bn_task;
    }
    public void setBn_task(JButton bn_task) {
        this.bn_task = bn_task;
    }
    public JButton getBn_calendar() {
        return bn_calendar;
    }
    public void setBn_calendar(JButton bn_calendar) {
        this.bn_calendar = bn_calendar;
    }
    public JButton getBn_appraisement() {
        return bn_appraisement;
    }
    public void setBn_appraisement(JButton bn_appraisement) {
        this.bn_appraisement = bn_appraisement;
    }
    public JButton getBn_admin() {
        return bn_admin;
    }
    public void setBn_admin(JButton bn_admin) {
        this.bn_admin = bn_admin;
    }
    public void setBn_profile(JButton bn_profile) {
        this.bn_profile = bn_profile;
    }
    public Image getIm_profile() {
        return im_profile;
    }
    public void setIm_profile(Image im_profile) {
        this.im_profile = im_profile;
    }
    public JPanel getPn_east() {
        return pn_east;
    }
    public void setPn_east(JPanel pn_east) {
        this.pn_east = pn_east;
    }
    public JButton getBn_profile() {
        return bn_profile;
    }
    public void setBn_profile(ImageIcon bn_profile) {
        this.bn_profile.setIcon(bn_profile);
    }
    public JPanel getPn_west() {
        return pn_west;
    }
    public void setPn_west(JPanel pn_west) {
        this.pn_west = pn_west;
    }
    public JPanel getWarning() {
        return warning;
    }
    public void setWarning(JPanel warning) {
        this.warning = warning;
    }
}
