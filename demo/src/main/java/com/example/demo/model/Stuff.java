package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "cw6_stuff")
public class
Stuff {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID id;

	@Column(name = "surname")
	private String surname;

	@Column(name = "name")
	private String name;

	@Column(name = "patronymic")
	private String patronymic;

	@Column(name = "sex")
	private String sex;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@Column(name = "salary_multiplier")
	private Double salaryMultiplier;

	@ManyToOne(targetEntity = Position.class, optional = false)
	@JoinColumn(name = "position_id")
	private Position position;

	public Stuff() {
	}

	public Stuff(UUID id, String surname, String name, String patronymic, String sex,
	             LocalDate birthDate, Double salaryMultiplier, Position position) {
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.patronymic = patronymic;
		this.sex = sex;
		this.birthDate = birthDate;
		this.salaryMultiplier = salaryMultiplier;
		this.position = position;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
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

	public static class Builder {
		private UUID id;
		private String surname;
		private String name;
		private String patronymic;
		private String sex;
		private LocalDate birthDate;
		private Double salaryMultiplier;
		private Position position;

		public Stuff build() {
			Stuff stuff = new Stuff();
			stuff.setId(id);
			stuff.setSurname(surname);
			stuff.setName(name);
			stuff.setPatronymic(patronymic);
			stuff.setSex(sex);
			stuff.setPosition(position);
			stuff.setSalaryMultiplier(salaryMultiplier);
			stuff.setBirthDate(birthDate);
			return stuff;
		}

		public Builder setId(UUID id) {
			this.id = id;
			return this;
		}

		public Builder setSurname(String surname) {
			this.surname = surname;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setPatronymic(String patronymic) {
			this.patronymic = patronymic;
			return this;
		}

		public Builder setSex(String sex) {
			this.sex = sex;
			return this;
		}

		public Builder setBirthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public Builder setSalaryMultiplier(Double salaryMultiplier) {
			this.salaryMultiplier = salaryMultiplier;
			return this;
		}

		public Builder setPosition(Position position) {
			this.position = position;
			return this;
		}
	}
}
