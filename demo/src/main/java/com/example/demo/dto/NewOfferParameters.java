package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class NewOfferParameters {
	@JsonProperty("client_id")
	private int clientId;

	@JsonProperty("stuff_id")
	private int stuffId;

	@JsonProperty("start_date")
	private LocalDate startDate;

	@JsonProperty("ending_date")
	private LocalDate endingDate;

	public NewOfferParameters() {
	}

	public NewOfferParameters(int clientId, int stuffId, LocalDate startDate, LocalDate endingDate) {
		this.clientId = clientId;
		this.stuffId = stuffId;
		this.startDate = startDate;
		this.endingDate = endingDate;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getStuffId() {
		return stuffId;
	}

	public void setStuffId(int stuffId) {
		this.stuffId = stuffId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(LocalDate endingDate) {
		this.endingDate = endingDate;
	}
}
