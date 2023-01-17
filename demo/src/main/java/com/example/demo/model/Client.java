package com.example.demo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Client {
	public static Map<Integer, Client> ClientRepository = new HashMap<>();
	public static int x = 0;
	private int id;
	private String surname;
	private String name;
	private String patronymic;
	private String sex;
	private LocalDate birthDate;
	private String inn;
	private String passportSerial;
	private String phone;

	public Client(final String surname,
				  final String name,
				  final String patronymic,
				  final String sex,
				  final LocalDate birthDate,
				  final String inn,
				  final String passportSerial,
				  final String phone) {
		this.id = x+1;
		x += 1;
		this.surname = surname;
		this.name = name;
		this.patronymic = patronymic;
		this.sex = sex;
		this.birthDate = birthDate;
		this.inn = inn;
		this.passportSerial = passportSerial;
		this.phone = phone;
	}

	public int getId() {
		return id;
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

	@Override
	public String toString() {
		return "Client{" +
		       "id=" + id +
		       ", surname='" + surname + '\'' +
		       ", name='" + name + '\'' +
		       ", patronymic='" + patronymic + '\'' +
		       ", sex=" + sex +
		       ", birthDate=" + birthDate +
		       ", inn='" + inn + '\'' +
		       ", passportSerial='" + passportSerial + '\'' +
		       ", phone='" + phone + '\'' +
		       '}';
	}


}
