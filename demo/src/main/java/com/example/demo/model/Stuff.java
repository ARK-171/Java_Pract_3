package com.example.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Stuff {
	private int id;
	private String surname;
	private String name;
	private String patronymic;
	private String sex;
	private LocalDate birthDate;
	private Double salaryMultiplier;
	private int position;

	public Stuff() throws SQLException {
		Statement st = DB.getConnection().createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM Stuff ");
		this.id = rs.getInt("id");
		this.surname = rs.getString("surname");
		this.name = rs.getString("name");
		this.patronymic = rs.getString("patronymic");
		this.sex = rs.getString("sex");
		this.birthDate = (rs.getDate("birthDate")).toLocalDate();
		this.salaryMultiplier = rs.getDouble("salaryMultiplier");
		this.position = rs.getInt("position");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Double getSalaryMultiplier() {
		return salaryMultiplier;
	}

	public void setSalaryMultiplier(Double salaryMultiplier) {
		this.salaryMultiplier = salaryMultiplier;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
