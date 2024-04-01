package com.kmitl.pectjro.Database.DatabaseTable;

import com.kmitl.pectjro.Frame.Groups_interface.Database_template;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;

public class Database_Simple<T extends Database_template> {
	private Class<T> type;

	public Database_Simple(Class<T> type) {
		this.type = type;
	}

	public ArrayList<T> getArray(ResultSet result) throws Exception {
		ArrayList<T> output = new ArrayList<>();

		while (result.next()){
			T object = this.type.getDeclaredConstructor().newInstance();
			object.setData(result);
			output.add(object);
		}

		return output;
	}

	public LinkedList<T> getLink(ResultSet result) throws Exception {
		LinkedList<T> output = new LinkedList<>();

		while (result.next()){
			T object = this.type.getDeclaredConstructor().newInstance();
			object.setData(result);
			output.add(object);
		}

		return output;
	}
}
