package com.kmitl.pectjro.Frame.Templates;

import java.io.Serializable;
import java.awt.*;

public class User_Template implements Serializable {
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
}
