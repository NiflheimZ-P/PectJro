package com.kmitl.pectjro.Frame.Cache_Templates;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Setting_Template implements Serializable{
    public String host;
    public String port;
    public String username;
    public String password;
    public String database_name;

    public void setData(ArrayList<String> info) {
        host = info.get(0);
        port = info.get(1);
        database_name = info.get(2);
        username = info.get(3);
        password = info.get(4);
    }

    public void setData(String host, String port, String database_name, String username, String password){
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.database_name = database_name;
    }
}
