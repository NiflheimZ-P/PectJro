package com.kmitl.pectjro.Frame.Cache_Templates;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class User_Template implements Serializable {
    public String id;
    public String username;
    public String gmail;
    public String password;
    public String firstname;
    public String lastname;
    public String admin;

    public void setData(ArrayList<String> info) {
        id = info.get(0);
        username = info.get(1);
        gmail = info.get(2);
        password = info.get(3);
        firstname = info.get(4);
        lastname = info.get(5);
        admin = info.get(6);
    }

    public void setData(String id, String username, String gmail, String password, String firstname, String lastname, String admin){
        this.id = id;
        this.username = username;
        this.gmail = gmail;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.admin = admin;
    }

    public void setData(HashMap<String, String> info){
        id = info.get("id");
        username = info.get("username");
        gmail = info.get("gmail");
        password = info.get("password");
        firstname = info.get("firstname");
        lastname = info.get("lastname");
        admin = info.get("admin");
    }
}
