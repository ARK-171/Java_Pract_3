package com.example.demo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Office {
	public static Map<Integer, Office> OfficeRepository = new HashMap<>();
	public static int x = 0;
	private int id;
	private String address;
	private String lawAddress;
	private Integer cabinetsCount;
	public Office() {
	}

	public Office(String address, String lawAddress, Integer cabinetsCount) {
		this.id = x+1;
		x += 1;
		this.address = address;
		this.lawAddress = lawAddress;
		this.cabinetsCount = cabinetsCount;
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
