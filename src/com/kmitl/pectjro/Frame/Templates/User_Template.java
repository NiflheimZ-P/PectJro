package com.kmitl.pectjro.Frame.Templates;

import com.kmitl.pectjro.Frame.Groups_interface.Database_template;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User_Template implements Serializable, Database_template {
    public int id;
    public String username;
    public String gmail;
    public String password;
    public String firstname;
    public String lastname;
    public byte[] image;
    public int project_done;
    public int project_expired;
    public int project_ontime;
    public boolean admin;

    public User_Template() {}
    public User_Template(ResultSet result) throws SQLException {
        setData(result);
    }

    public void setData(int id, String username, String gmail, String password, String firstname, String lastname, byte[] image, int project_done, int project_expired, int project_ontime, boolean admin){
        this.id = id;
        this.username = username;
        this.gmail = gmail;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.image = image;
        this.project_done = project_done;
        this.project_expired = project_expired;
        this.project_ontime = project_ontime;
        this.admin = admin;
    }

    @Override
    public void setData(ResultSet result) throws SQLException {
        this.id = result.getInt("Id");
        this.username = result.getString("Username");
        this.gmail = result.getString("Gmail");
        this.password = result.getString("Password");
        this.firstname = result.getString("Firstname");
        this.lastname = result.getString("Lastname");
        this.image = result.getBytes("Image");
        this.project_done = result.getInt("Project_Done");
        this.project_expired = result.getInt("Project_Expired");
        this.project_ontime = result.getInt("Project_Ontime");
        this.admin = result.getBoolean("Admin");
    }
}
