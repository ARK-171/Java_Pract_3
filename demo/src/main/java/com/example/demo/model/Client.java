package com.example.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Client {
	private int id;
	private String surname;
	private String name;
	private String patronymic;
	private String sex;
	private LocalDate birthDate;
	private String inn;
	private String passportSerial;
	private String phone;

	public Client( ) throws SQLException {
		Statement st = DB.getConnection().createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM Client ");
		this.id = rs.getInt("id");
		this.surname = rs.getString("surname");
		this.name = rs.getString("name");
		this.patronymic = rs.getString("patronymic");
		this.sex = rs.getString("sex");
		this.birthDate = (rs.getDate("birthDate")).toLocalDate();
		this.inn = rs.getString("inn");
		this.passportSerial = rs.getString("passportSerial");
		this.phone = rs.getString("phone");
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

	public String getInn() {
		return inn;
	}

	public void setInn(String inn) {
		this.inn = inn;
	}

	public String getPassportSerial() {
		return passportSerial;
	}

	public void setPassportSerial(String passportSerial) {
		this.passportSerial = passportSerial;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
