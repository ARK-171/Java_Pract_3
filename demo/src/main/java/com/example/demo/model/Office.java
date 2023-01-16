package com.example.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Office {
	private int id;
	private String address;
	private String lawAddress;
	private Integer cabinetsCount;

	public Office() throws SQLException {
		Statement st = DB.getConnection().createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM Office ");
		this.id = rs.getInt("id");
		this.address = rs.getString("address");
		this.lawAddress = rs.getString("lawAddress");
		this.cabinetsCount = rs.getInt("cabinetsCount");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLawAddress() {
		return lawAddress;
	}

	public void setLawAddress(String lawAddress) {
		this.lawAddress = lawAddress;
	}

	public Integer getCabinetsCount() {
		return cabinetsCount;
	}

	public void setCabinetsCount(Integer cabinetsCount) {
		this.cabinetsCount = cabinetsCount;
	}

}
