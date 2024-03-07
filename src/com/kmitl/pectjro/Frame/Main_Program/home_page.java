package com.kmitl.pectjro.Frame.Main_Program;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.kmitl.pectjro.Frame.Tools.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.InternalFrameUI;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class home_page {

    private JFrame fr;
    private JPanel pn_north, pn_west, pn_south, ctn_pn_task, ctn_pn_calendar, ctn_pn_appraisement, ctn_pn_deadline,
            ctn_pn_deadline_2, pn_north_right, ps_mar_pmain, paneforsearch, up_mar_search, l_mar_search, r_mar_search, s_mar_search;
    private JTextField tf_seach_bar;
    private JButton bn_task, bn_calendar, bn_appraisement, bn_new, bn_option;
    private JLabel l1, l2, l3, l4;
    private TitledBorder tb_task, tb_calendar, tb_appraisement;

    public home_page(){
        //set up
        fr = new JFrame("PectJro");

        pn_north = new JPanel();
        pn_west = new JPanel();
        paneforsearch = new JPanel();
        pn_south = new JPanel();
        ps_mar_pmain = new JPanel();
        ctn_pn_task = new JPanel();
        ctn_pn_calendar = new JPanel();
        ctn_pn_appraisement = new JPanel();
        ctn_pn_deadline = new JPanel();
        ctn_pn_deadline_2 = new JPanel();
        pn_north_right = new JPanel();
        up_mar_search = new JPanel();
        l_mar_search = new JPanel();
        r_mar_search = new JPanel();
        s_mar_search = new JPanel();

        tf_seach_bar = new JTextField();

        bn_task = new JButton("Task");
        bn_calendar = new JButton("Calendar");
        bn_appraisement = new JButton("Appraisement");
        bn_new = new JButton("+");
        bn_option = new JButton("Option");

        l1 = new JLabel("Logo Program");
        l2 = new JLabel("Profile");
        l3 = new JLabel("3");
        l4 = new JLabel("Deadline");

        tb_task = new TitledBorder("");
        tb_calendar = new TitledBorder("");
        tb_appraisement = new TitledBorder("");


        //set upper part (pn_north)
        fr.setLayout(new BorderLayout());
        fr.setBackground(Color.white);

        fr.add(pn_north, BorderLayout.NORTH);
        pn_north.setLayout(new GridLayout(1,3));
        pn_north.setPreferredSize(new Dimension(1400, 75));

        pn_north.setBackground(Color.lightGray);
        pn_north.add(l1);

        paneforsearch.setLayout(new BorderLayout());
        paneforsearch.add(tf_seach_bar, BorderLayout.CENTER);
        paneforsearch.add(up_mar_search, BorderLayout.NORTH); up_mar_search.setBackground(Color.lightGray);
        paneforsearch.add(l_mar_search, BorderLayout.WEST); l_mar_search.setBackground(Color.lightGray);
        paneforsearch.add(r_mar_search, BorderLayout.EAST); r_mar_search.setBackground(Color.lightGray);
        paneforsearch.add(s_mar_search, BorderLayout.SOUTH); s_mar_search.setBackground(Color.lightGray);
        pn_north.add(paneforsearch);
        tf_seach_bar.setColumns(15);

        pn_north_right.setLayout(new FlowLayout(2,20,20)); // 2 = right , hgap = ซ้าย - ขวา , vgap = บน-ล่าง
        pn_north_right.setBackground(Color.lightGray);
        pn_north_right.add(bn_option); pn_north_right.add(l2);
        pn_north.add(pn_north_right);

        //set left part (pn_west)
        fr.add(pn_west, BorderLayout.WEST);
        pn_west.setLayout(new GridLayout(8, 1,-10,15));
        pn_west.setBackground(Color.lightGray);
        pn_west.setPreferredSize(new Dimension(125, 600));

        //set up inside left part
        ctn_pn_task.setBorder(tb_task);
        ctn_pn_task.setLayout(new FlowLayout());
        ctn_pn_task.setBackground(Color.lightGray);
        bn_task.setPreferredSize(new Dimension(100, 50));
        ctn_pn_task.add(bn_task); pn_west.add(ctn_pn_task);

        ctn_pn_calendar.setBorder(tb_calendar);
        ctn_pn_calendar.setLayout(new FlowLayout());
        ctn_pn_calendar.setBackground(Color.lightGray);
        bn_calendar.setPreferredSize(new Dimension(100, 50));
        ctn_pn_calendar.add(bn_calendar); pn_west.add(ctn_pn_calendar);

        ctn_pn_appraisement.setBorder(tb_appraisement);
        ctn_pn_appraisement.setLayout(new FlowLayout());
        ctn_pn_appraisement.setBackground(Color.lightGray);
        bn_appraisement.setPreferredSize(new Dimension(100, 50));
        ctn_pn_appraisement.add(bn_appraisement); pn_west.add(ctn_pn_appraisement);

        ctn_pn_deadline.setLayout(new FlowLayout());
        ctn_pn_deadline.setBackground(Color.lightGray);
        ctn_pn_deadline.add(l4); pn_west.add(ctn_pn_deadline);


        //button (+) at bottom right of corner
        ps_mar_pmain.setLayout(new FlowLayout(2, 30,25));
        fr.add(pn_south, BorderLayout.EAST);
        bn_new.setPreferredSize(new Dimension(40,40));
        ps_mar_pmain.add(bn_new);
        pn_south.setLayout(new BorderLayout());
        pn_south.add(ps_mar_pmain, BorderLayout.SOUTH);

        //show
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(1400, 800);
        fr.setResizable(false);
        fr.setVisible(true);
    }

    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(new FlatMacLightLaf());
        SwingUtilities.invokeLater(() -> {new home_page(); });
    }
}
