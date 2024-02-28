package com.kmitl.pectjro.DBConnection;

import java.io.Serializable;
import java.util.Objects;

public class Setting_Template implements Serializable{
    String host;
    String port;
    String username;
    String password;
    String database_name;

    public boolean check(){
        return (!Objects.equals(host, "") | !Objects.equals(port, "") | !Objects.equals(username, "") | !Objects.equals(password, "") | !Objects.equals(database_name, ""));
    }
}
