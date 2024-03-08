package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.ui.FlatRoundBorder;
import com.kmitl.pectjro.Frame.Main_Program.home_page;
import com.kmitl.pectjro.Frame.Tools.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.InternalFrameUI;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.border.Border;
public class project_progress {
    private JFrame fr;
    private JPanel upper_pmain, upper_west, upper_west_rpart, pane_for_note, panefor_close, logo_lmar;
    private JLabel pro_pic, team_label, pro_name_label;
    private JButton note_bn, close_bn;
    public project_progress(){
        fr = new JFrame();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Label
        pro_pic = new JLabel("Project pic");
        team_label = new JLabel("Team: ");
        pro_name_label = new JLabel("Project Name");

        //button
        note_bn = new JButton("Note");
        close_bn = new JButton("X");

        //panel
        upper_west_rpart = new JPanel();
        upper_west = new JPanel();
        pane_for_note = new JPanel();
        panefor_close = new JPanel();
        logo_lmar = new JPanel();
        upper_west.setLayout(new BorderLayout());
        upper_west_rpart.setLayout(new BorderLayout());
        pane_for_note.setLayout(new FlowLayout(2, 40,60));
        panefor_close.setLayout(new FlowLayout(2,10,10));

        //upper_west side
        upper_west.add(logo_lmar, BorderLayout.WEST);
        logo_lmar.setBackground(Color.lightGray);
        logo_lmar.setPreferredSize(new Dimension(70,100));
        upper_west.add(pro_pic, BorderLayout.CENTER);
        upper_west.add(upper_west_rpart, BorderLayout.EAST);
        upper_west.setBackground(Color.lightGray);

        //uppper west rpart add
        upper_west_rpart.add(pro_name_label, BorderLayout.NORTH);
        upper_west_rpart.add(team_label, BorderLayout.SOUTH);
        upper_west_rpart.setBackground(Color.lightGray);

        //upper part
        upper_pmain = new JPanel();
        upper_pmain.setLayout(new GridLayout(1,3));
        upper_pmain.setBackground(Color.lightGray);
        upper_pmain.add(upper_west);
        pane_for_note.add(note_bn);
        pane_for_note.setBackground(Color.lightGray);
        upper_pmain.add(pane_for_note);
        panefor_close.add(close_bn);
        panefor_close.setBackground(Color.lightGray);
        upper_pmain.add(panefor_close);
        upper_pmain.setPreferredSize(new Dimension(1000, 100));

        //set fr
        fr.add(upper_pmain, BorderLayout.NORTH);
        fr.setVisible(true);
        fr.setSize(1000, 600);
    }

    public static void main(String[] args) throws Exception {

        UIManager.setLookAndFeel(new FlatMacLightLaf());
        SwingUtilities.invokeLater(() -> {new project_progress(); });
    }
}
