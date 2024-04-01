package com.kmitl.pectjro.Frame.Groups_interface;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Database_template {
	public abstract void setData(ResultSet result) throws SQLException;
}
