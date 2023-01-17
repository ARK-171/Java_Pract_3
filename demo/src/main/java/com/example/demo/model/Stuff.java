package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class
Stuff {
	public static Map<Integer, Stuff> StuffRepository = new HashMap<>();
	public  static  int x = 0;
	private int id;
	private String surname;
	private String name;
	private String patronymic;
	private String sex;
	private LocalDate birthDate;
	private Double salaryMultiplier;
	private Position position;
	public Stuff() {
	}

	public Stuff(String surname, String name, String patronymic, String sex,
	             LocalDate birthDate, Double salaryMultiplier, Position position) {
		this.id = x + 1;
		x += 1;
		this.surname = surname;
		this.name = name;
		this.patronymic = patronymic;
		this.sex = sex;
		this.birthDate = birthDate;
		this.salaryMultiplier = salaryMultiplier;
		this.position = position;
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

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}


}
