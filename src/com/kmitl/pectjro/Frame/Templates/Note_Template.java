package com.kmitl.pectjro.Frame.Templates;

import com.kmitl.pectjro.Frame.Groups_interface.Database_template;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Note_Template implements Database_template {
    public int id;
    public int ownerid;
    public String name;
    public String note;

    public Note_Template() {}
    public Note_Template(ResultSet result) throws SQLException {
        setData(result);
    }

    @Override
    public void setData(ResultSet result) throws SQLException {
        this.id = result.getInt("Id");
        this.ownerid = result.getInt("Owner_id");
        this.name = result.getString("Name");
        this.note = result.getString("Note");
    }
}
