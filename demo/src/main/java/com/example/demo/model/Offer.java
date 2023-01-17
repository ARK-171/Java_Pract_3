package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
public class Offer {
	public static Map<Integer, Offer> OfferRepository = new HashMap<>();
	public static int x = 0;
	private int id;
	private String serialNumber;
	private LocalDate signDate;
	private LocalDate endingDate;
	private LocalDate startDate;
	private Client client;
	private Office office;
	private Stuff stuff;

	public Offer(String serialNumber, LocalDate signDate, LocalDate endingDate,
	             LocalDate startDate, Client client, Office office, Stuff stuff) {
		this.id = x+1;
		x += 1;
		this.serialNumber = serialNumber;
		this.signDate = signDate;
		this.endingDate = endingDate;
		this.startDate = startDate;
		this.client = client;
		this.office = office;
		this.stuff = stuff;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public LocalDate getSignDate() {
		return signDate;
	}

	public void setSignDate(LocalDate signDate) {
		this.signDate = signDate;
	}

	public LocalDate getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(LocalDate endingDate) {
		this.endingDate = endingDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public Stuff getStuff() {
		return stuff;
	}

	public void setStuff(Stuff stuff) {
		this.stuff = stuff;
	}

	@Override
	public String toString() {
		return "Offer{" +
		       "id=" + id +
		       ", serialNumber='" + serialNumber + '\'' +
		       ", signDate=" + signDate +
		       ", endingDate=" + endingDate +
		       ", startDate=" + startDate +
		       ", client=" + client +
		       ", office=" + office +
		       ", stuff=" + stuff +
		       '}';
	}
}
