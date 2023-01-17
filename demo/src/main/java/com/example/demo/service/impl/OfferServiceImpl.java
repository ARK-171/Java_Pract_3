package com.example.demo.service.impl;

import com.example.demo.model.Client;
import com.example.demo.model.Offer;
import com.example.demo.model.Office;
import com.example.demo.model.Stuff;
import com.example.demo.service.OfferService;
import com.example.demo.service.SerialNumberGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {
	private SerialNumberGeneratorService serialNumberGenerator;

	@Autowired
	public OfferServiceImpl(SerialNumberGeneratorService serialNumberGenerator) {
		this.serialNumberGenerator = serialNumberGenerator;
	}

	@Override
	public Offer signNewOffer(LocalDate startDate, LocalDate endingDate, Client client, Stuff stuff) {
		Offer newOffer = new Offer(serialNumberGenerator.generateSerialNumber(), LocalDate.now(), endingDate, startDate, client, Office.OfficeRepository.get(new Random().nextInt(Office.x)), stuff);
		return Offer.OfferRepository.put(newOffer.getId(), newOffer);
	}
}
