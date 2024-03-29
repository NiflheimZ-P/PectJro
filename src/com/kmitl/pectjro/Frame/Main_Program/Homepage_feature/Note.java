//package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.*;
//
//
//public class Note extends JFrame implements ActionListener{
//
//    private JTextArea textArea;
//    private JPanel mainPanel;
//    private JButton save;
//
//    public Note() {
//        setTitle("Note");
//        setSize(800, 600);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // สร้าง Panel หลัก
//        mainPanel = new JPanel();
//        mainPanel.setLayout(new BorderLayout());
//        add(mainPanel, BorderLayout.CENTER);
//
//        // สร้าง TextArea
//        textArea = new JTextArea();
//        textArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        JScrollPane scrollPane = new JScrollPane(textArea);
//        add(scrollPane, BorderLayout.CENTER);
//
//        // สร้าง Button
//        save = new JButton("Save");
//        save.addActionListener(this); // เพิ่ม ActionListener
//        mainPanel.add(save, BorderLayout.EAST); // เพิ่มปุ่ม save ไปทางขวา
//
//        // แสดงหน้าต่าง
//        setVisible(true);
//    }
//
//
//    public static void main(String[] args) {
//        new Note();
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == save) {
//            // บันทึกข้อมูล text area
//            String text = textArea.getText();
//            saveToDatabase(text); // เรียกใช้ฟังก์ชั่น saveToDatabase
//        }
//
//    }
//    private void saveToDatabase(String text) {
//        try {
//            // สร้าง Connection object
//            Connection dbConnect = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
//
//            // สร้าง Statement object
//            Statement statement = dbConnect.createStatement();
//
//            // เขียน SQL query
//            String sql = "INSERT INTO notes (text) VALUES (?)";
//
//            // เตรียม PreparedStatement
//            PreparedStatement preparedStatement = dbConnect.prepareStatement(sql);
//            preparedStatement.setString(1, text);
//
//            // Execute query
//            preparedStatement.executeUpdate();
//
//            // ปิด Connection
//            dbConnect.close();
//
//            // แสดงข้อความแจ้งเตือน
//            JOptionPane.showMessageDialog(this, "Data saved successfully!");
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            JOptionPane.showMessageDialog(this, "An error logging has occurred!");
//        }
//    }
//
//}
