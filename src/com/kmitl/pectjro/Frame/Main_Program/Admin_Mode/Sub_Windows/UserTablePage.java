package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows;

import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.Table_Page;

public class UserTablePage extends Table_Page {

    public UserTablePage() {
        super(); // เรียกใช้งานคอนสตรักเตอร์ของ Table_Page
        this.setTitle("User Data");
        this.setVisible(true);
    }

    @Override
    public void addNew() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void refresh() {

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


