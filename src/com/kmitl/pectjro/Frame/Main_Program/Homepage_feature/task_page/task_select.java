package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class task_select extends JPanel implements MouseListener {
    private JPanel pl;
    private JLabel name, desc;

    private Task task;
    public task_select(){
        pl = new JPanel();

        name = new JLabel("   "+"Project Name");
        desc = new JLabel("  - "+"Cum ar thi buy");

        pl.setLayout(new GridLayout(2,1));
        this.add(pl);
        pl.add(name);
        name.setFont(new Font("Sans", Font.BOLD, 18));
        pl.add(desc);
        desc.setFont(new Font("Sans", Font.PLAIN, 14));
        pl.setBorder(new LineBorder(new Color(30,31,34)));
        this.setBackground(new Color(49,51,56));
        this.setVisible(true);
        pl.setPreferredSize(new Dimension(550,80));
        pl.addMouseListener(this);
    }
    public JPanel getFrame(){
        return pl;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
//        if(e.getSource().equals(pl)){
//            new project_progressbar("1","2");
//            home_page.page.show();
//        }
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
//    public void loadData() {
//        SwingWorker<Void, Void> getFeed = new SwingWorker<Void, Void>() {
//            private Loading_dialog loading = new Loading_dialog(pl);
//            @Override
//            protected Void doInBackground() throws Exception {
//                loading.setVisible(true);
//                name.removeAll();
//                desc.removeAll();
//
//                task.getRef().setEnabled(false);
//                Connection con = DBConnect.createConnect();
//
//                task.getRef().setEnabled(true);
////                if (!view.getSearch().getText().equals(view.getSearch().getShouldbe())){
////                    search();
////                }
////                return null;
////            }
//
////            @Override
////            protected void done() {
////                loading.dispose();
////            }
////        };
////        getFeed.execute();
//        }
}