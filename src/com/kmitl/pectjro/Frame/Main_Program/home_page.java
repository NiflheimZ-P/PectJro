package com.kmitl.pectjro.Frame.Main_Program;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.kmitl.pectjro.Frame.Groups_interface.View_Getter;
import java.awt.*;
import javax.swing.*;

public class home_page implements View_Getter {
    private JPanel main_panel;

    private JPanel bg, pn_north, pn_west, pn_east, ctn_pn_task, ctn_pn_calendar, ctn_pn_appraisement, ctn_pn_deadline,
            ctn_pn_deadline_2, pn_north_right, ps_mar_pmain, paneforsearch, up_mar_search, l_mar_search, r_mar_search,
            s_mar_search;
    private JTextField tf_seach_bar;
    private ImageIcon ic_program, ic_profile, ic_task, ic_calendar, ic_appraisement;
    private JButton bn_task, bn_calendar, bn_appraisement, bn_new, bn_option;
    private JLabel l1, l2, l3, l4;


    public home_page(){
        //set up
        main_panel = new JPanel();
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
        ctn_pn_deadline_2 = new JPanel();
        pn_north_right = new JPanel();
        up_mar_search = new JPanel();
        l_mar_search = new JPanel();
        r_mar_search = new JPanel();
        s_mar_search = new JPanel();

        tf_seach_bar = new JTextField();
        //prepare to add image
        ic_program = new ImageIcon();
        ic_profile = new ImageIcon();
        ic_task = new ImageIcon("/Users/win/Documents/GitHub/PectJro/Untitled/resources/Images/task.png");
        ic_calendar = new ImageIcon();
        ic_appraisement = new ImageIcon();

        bn_task = new JButton("Task");
        bn_calendar = new JButton("Calendar");
        bn_appraisement = new JButton("Appraisement");
        bn_new = new JButton("+");
        bn_option = new JButton("Option");

        l1 = new JLabel("Logo Program");
        l2 = new JLabel("Profile");
        l3 = new JLabel("3");
        l4 = new JLabel("Deadline");


        //set center part
        main_panel.setLayout(new BorderLayout());
        main_panel.add(bg);


        //set upper part (pn_north)
        main_panel.add(pn_north, BorderLayout.NORTH);
        pn_north.setLayout(new GridLayout(1,3));
        pn_north.setPreferredSize(new Dimension(1400, 75));

        pn_north.add(l1);

        paneforsearch.setLayout(new BorderLayout());
        paneforsearch.add(tf_seach_bar, BorderLayout.CENTER);
        paneforsearch.add(up_mar_search, BorderLayout.NORTH);
        paneforsearch.add(l_mar_search, BorderLayout.WEST);
        paneforsearch.add(r_mar_search, BorderLayout.EAST);
        paneforsearch.add(s_mar_search, BorderLayout.SOUTH);
        pn_north.add(paneforsearch);
        tf_seach_bar.setFocusable(true);

        pn_north_right.setLayout(new FlowLayout(2,20,20)); // 2 = right , hgap = ซ้าย - ขวา , vgap = บน-ล่าง
        pn_north_right.add(bn_option); pn_north_right.add(l2);
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
        bg.setBackground(new Color(0, 0, 0));
        pn_north.setBackground(new Color(33, 33, 33));
        up_mar_search.setBackground(new Color(33, 33, 33));
        l_mar_search.setBackground(new Color(33, 33, 33));
        r_mar_search.setBackground(new Color(33, 33, 33));
        s_mar_search.setBackground(new Color(33, 33, 33));
        pn_north_right.setBackground(new Color(33, 33, 33));
        l1.setForeground(Color.white);
        l2.setForeground(Color.white);

        pn_west.setBackground(new Color(18, 18, 18));
        ctn_pn_task.setBackground(new Color(205, 198, 195));
        ctn_pn_calendar.setBackground(Color.lightGray);
        ctn_pn_appraisement.setBackground(Color.lightGray);
        ctn_pn_deadline.setBackground(new Color(18, 18, 18));
        ps_mar_pmain.setBackground(new Color(0, 0, 0));

        pn_east.setBackground(new Color(0, 0, 0));
            //Button
        bn_option.setForeground(Color.white) ; bn_option.setBackground(new Color(0x757575));
        bn_task.setForeground(Color.white); bn_task.setBackground(new Color(186, 9, 0));
        bn_calendar.setForeground(Color.white); bn_calendar.setBackground(new Color(186, 9, 0));
        bn_appraisement.setForeground(Color.white); bn_appraisement.setBackground(new Color(186, 9, 0));
        bn_new.setForeground(Color.white) ; bn_new.setBackground(new Color(0xBA0900));

            //Label
        l4.setForeground(Color.red);




        //show
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setSize(1400, 800);
//        this.setResizable(false);
//        this.setVisible(true);
    }

    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(new FlatMacLightLaf());
        SwingUtilities.invokeLater(() -> {new home_page(); });
    }

    @Override
    public Container getView() {
        return main_panel;
    }
}
