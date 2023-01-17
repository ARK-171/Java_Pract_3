package com.example.demo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Entity
@Table(name = "cw6_office")
public class Office {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID id;

	@Column(name = "address")
	private String address;

	@Column(name = "law_address")
	private String lawAddress;

	@Column(name = "cabinets_count")
	private Integer cabinetsCount;

	public Office() {
	}

	public Office(UUID id, String address, String lawAddress, Integer cabinetsCount) {
		this.id = id;
		this.address = address;
		this.lawAddress = lawAddress;
		this.cabinetsCount = cabinetsCount;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
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

	public class Builder {
		private UUID id;
		private String address;
		private String lawAddress;
		private Integer cabinetsCount;

		public Builder setId(UUID id) {
			this.id = id;
			return this;
		}

		public Builder setAddress(String address) {
			this.address = address;
			return this;
		}

		public Builder setLawAddress(String lawAddress) {
			this.lawAddress = lawAddress;
			return this;
		}

		public Builder setCabinetsCount(Integer cabinetsCount) {
			this.cabinetsCount = cabinetsCount;
			return this;
		}

		public Office createOffice() {
			return new Office(id, address, lawAddress, cabinetsCount);
		}
	}
}
