package com.example.demo.service.impl;

import com.example.demo.model.Client;
import com.example.demo.model.DB;
import com.example.demo.model.Offer;
import com.example.demo.model.Stuff;
import com.example.demo.repository.OfferRepository;
import com.example.demo.repository.OfficeRepository;
import com.example.demo.repository.StuffRepository;
import com.example.demo.service.OfferService;
import com.example.demo.service.SerialNumberGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Random;

@Service
public class OfferServiceImpl implements OfferService {

	private OfficeRepository officeRepository;

	private OfferRepository offerRepository;

	private SerialNumberGeneratorService serialNumberGenerator;

	@Autowired
	public OfferServiceImpl(OfficeRepository officeRepository, OfferRepository offerRepository, SerialNumberGeneratorService serialNumberGenerator) {
		this.officeRepository = officeRepository;
		this.offerRepository = offerRepository;
		this.serialNumberGenerator = serialNumberGenerator;
	}

	@Override
	public Offer signNewOffer(LocalDate startDate, LocalDate endingDate, int client, int stuff) {
		Offer newOffer = new Offer.Builder()
				.setSerialNumber(serialNumberGenerator.generateSerialNumber())
				.setClient(client)
				.setStuff(stuff)
				.setSignDate(LocalDate.now())
				.setStartDate(startDate)
				.setEndingDate(endingDate)
				.setOffice(new Random().nextInt(3)+1)
				.build();
		try {
			Statement st = DB.getConnection().createStatement();
			st.execute(new DB().Insert(newOffer.getId(), newOffer.getSerialNumber(), newOffer.getSignDate(),newOffer.getEndingDate(),newOffer.getStartDate(), newOffer.getClient(), newOffer.getOffice(), newOffer.getStuff()));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return offerRepository.save(newOffer);
	}
}
