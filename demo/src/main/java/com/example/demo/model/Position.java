package com.example.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Position {
	private int id;
	private String name;
	private Integer salary;

	public Position() {
	}

	public Position(int id, String name, Integer salary) throws SQLException {
		Statement st = DB.getConnection().createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM Position ");
		this.id = rs.getInt("id");
		this.name = rs.getString("name");
		this.salary = rs.getInt("salary");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

}
