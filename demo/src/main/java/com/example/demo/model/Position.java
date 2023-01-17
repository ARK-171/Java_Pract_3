package com.example.demo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Position {
	public static Map<Integer, Position> PositionRepository = new HashMap<>();
	public static int x = 0;
	private int id;
	private String name;
	private Integer salary;

	public Position(String name, Integer salary) {
		this.id = x+1;
		x += 1;
		this.name = name;
		this.salary = salary;
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
