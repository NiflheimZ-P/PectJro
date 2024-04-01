package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.NoteFeature;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.DatabaseTable.NoteTable;
import com.kmitl.pectjro.Frame.Loading.Loading_dialog;
import com.kmitl.pectjro.Frame.Templates.Note_Template;
import com.kmitl.pectjro.Frame.Templates.Project_Template;
import com.kmitl.pectjro.Frame.Tools.Constraints;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.ArrayList;

public class AllNote{
    private JFrame fr;
    private JPanel psouth, westsmar, eastmar, plus_pane, ref_pane, center;
    private JButton plus, ref;
    private NoteBox nb;
    private JScrollPane scroll;

    public AllNote(Container owner){
        fr = new JFrame();
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //button
        plus = new JButton("+");
        ref = new JButton("Refresh");

        //panel
        center = new JPanel();
        westsmar = new JPanel();
        eastmar = new JPanel();
        psouth = new JPanel();
        plus_pane = new JPanel();
        ref_pane = new JPanel();

        //add to pane
        plus_pane.add(plus);
        ref_pane.add(ref);

        plus.setPreferredSize(new Dimension(40, 40));

        //add to westsmar
        westsmar.setLayout(new FlowLayout(2));
        westsmar.add(ref_pane);
        westsmar.add(plus_pane);
        center.setLayout(new GridBagLayout());

        fr.add(center, BorderLayout.CENTER);
        fr.add(westsmar, BorderLayout.SOUTH);

        scroll = new JScrollPane(center, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        center.setBorder(new EmptyBorder(5, 10, 5, 10));
        center.setBackground(new Color(56,52,60));
        scroll.setBorder(null);
        scroll.getHorizontalScrollBar().setUnitIncrement(20);
        SwingUtilities.invokeLater(() -> scroll.getVerticalScrollBar().setValue(0));
        scroll.setAutoscrolls(false);
        fr.add(scroll);

        //set visible size
        fr.setSize(1200, 800);
        fr.setResizable(false);
        fr.setLocationRelativeTo(owner);
    }


    public JFrame getFr() {
        return fr;
    }

    public void setFr(JFrame fr) {
        this.fr = fr;
    }

    public JPanel getCenter() {
        return center;
    }

    public void setCenter(JPanel center) {
        this.center = center;
    }

    public JButton getPlus() {
        return plus;
    }

    public void setPlus(JButton plus) {
        this.plus = plus;
    }

    public JButton getRef() {
        return ref;
    }

    public void setRef(JButton ref) {
        this.ref = ref;
    }
}
