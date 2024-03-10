package com.kmitl.pectjro.Frame.Admin;

import javax.swing.*;

public class UserTablePage extends Table_Page {

    public UserTablePage() {
        super(); // เรียกใช้งานคอนสตรักเตอร์ของ Table_Page
    }

    // เมทอดสำหรับแสดงข้อมูลผู้ใช้
    public void displayUserData() {
        // เคลียร์ข้อมูลในตาราง
        clearTable();

        // สร้างเชื่อมต่อกับฐานข้อมูลและสร้างคำสั่ง SQL เพื่อดึงข้อมูลผู้ใช้
        // และแสดงผลลัพธ์ในตาราง
    }

    protected void clearTable() {
        //DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // ลบข้อมูลทั้งหมดออกจากตาราง
    }
}


