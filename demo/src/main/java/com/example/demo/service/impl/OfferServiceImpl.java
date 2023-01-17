package com.example.demo.service.impl;

import com.example.demo.model.Client;
import com.example.demo.model.Offer;
import com.example.demo.model.Stuff;
import com.example.demo.service.OfferService;
import com.example.demo.service.SerialNumberGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

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
	public Offer signNewOffer(LocalDate startDate, LocalDate endingDate, Client client, Stuff stuff) {
		Offer newOffer = new Offer.Builder()
				.setId(UUID.randomUUID())
				.setSerialNumber(serialNumberGenerator.generateSerialNumber())
				.setClient(client)
				.setStuff(stuff)
				.setSignDate(LocalDate.now())
				.setStartDate(startDate)
				.setEndingDate(endingDate)
				.setOffice(officeRepository
						.findById(UUID.fromString("a68062fe-bac2-4408-af87-85ebd882d7a4"))
						.orElseThrow())
				.build();
		return offerRepository.save(newOffer);
	}
}
