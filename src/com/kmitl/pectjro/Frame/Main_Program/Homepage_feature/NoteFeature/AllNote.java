package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.NoteFeature;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.kmitl.pectjro.Database.DatabaseTable.NoteTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AllNote {
    private JFrame fr;
    private JPanel psouth, westsmar, eastmar, plus_pane, ref_pane;
    private JButton plus, ref;
    public AllNote(){
        fr = new JFrame();
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //button
        plus = new JButton("+");
        ref = new JButton("Refresh");

        //panel
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

        fr.add(westsmar, BorderLayout.SOUTH);

        //set visible size
        fr.setSize(1400, 800);
        fr.setVisible(true);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel( new FlatMacDarkLaf() );
        SwingUtilities.invokeLater(() -> {new AllNote();});
    }
}
