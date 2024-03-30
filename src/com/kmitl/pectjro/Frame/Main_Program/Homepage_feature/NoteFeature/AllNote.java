package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.NoteFeature;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.kmitl.pectjro.Database.DatabaseTable.NoteTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AllNote implements ActionListener{
    private JFrame fr;
    private JPanel psouth, westsmar, eastmar, plus_pane, ref_pane, center;
    private JButton plus, ref;
    private NoteBox nb;
    public AllNote(){
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

        plus.addActionListener(this);

        //add to westsmar
        westsmar.setLayout(new FlowLayout(2));
        westsmar.add(ref_pane);
        westsmar.add(plus_pane);


        center.setLayout(new FlowLayout());

        for(int i=0; i<=10; i++){
            NoteBox n = new NoteBox();
            center.add(n);

        }
        fr.add(center, BorderLayout.NORTH);
        fr.add(westsmar, BorderLayout.SOUTH);

        //set visible size
        fr.setSize(1400, 800);
        fr.setVisible(true);

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel( new FlatMacDarkLaf() );
        SwingUtilities.invokeLater(() -> {new AllNote();});
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(plus)){

        }
    }
}
