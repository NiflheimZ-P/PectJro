package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.NoteFeature;

import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page.project_progressbar;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NoteBox extends JPanel implements MouseListener {
    private JPanel pl, pforname, west_mar, south_mar, mid_fsouth;
    private JLabel name, desc, start, end;
    private JButton note;
    private project_progressbar pro_pro;

    //private Task task;
    //private TaskController tskc;

    public NoteBox() {
        pl = new JPanel();
        pforname =  new JPanel();
        west_mar = new JPanel();
        south_mar = new JPanel();
        mid_fsouth = new JPanel();

        //Label

        name = new JLabel("Note");
        //desc = new JLabel(info.description);





        pl.setLayout(new BorderLayout());
        this.add(pl);
        pforname.add(name);
        pforname.setPreferredSize(new Dimension(750, 50));
        pl.add(pforname, BorderLayout.NORTH);

        //add to pforname
        west_mar.setPreferredSize(new Dimension(60, 200));
        pl.add(west_mar, BorderLayout.WEST);
        south_mar.setPreferredSize(new Dimension(1, 40));
        south_mar.setLayout(new GridLayout(1,3));

        south_mar.add(mid_fsouth);

        pl.add(south_mar, BorderLayout.SOUTH);

        name.setFont(new Font("Sans", Font.BOLD, 18));
        //pl.add(desc, BorderLayout.CENTER);
        //desc.setFont(new Font("Sans", Font.PLAIN, 14));
        pl.setBorder(new LineBorder(new Color(30,31,34)));
        this.setBackground(new Color(49,51,56));

        pl.setPreferredSize(new Dimension(750,200));
        pl.addMouseListener(this);

        this.setVisible(true);
    }


    public JPanel getFrame(){
        return pl;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(pl)){
            new Note();
        }

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