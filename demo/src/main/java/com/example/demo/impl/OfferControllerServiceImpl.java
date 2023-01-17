package com.example.demo.impl;


import com.example.demo.model.Client;
import com.example.demo.model.Offer;
import com.example.demo.model.Stuff;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.StuffRepository;
import com.example.demo.service.OfferControllerService;
import com.example.demo.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;


public class OfferControllerServiceImpl implements OfferControllerService {

	private final ClientRepository clientRepository;

	private final StuffRepository stuffRepository;

	private final OfferService offerService;

	@Autowired
	public OfferControllerServiceImpl( ClientRepository clientRepository,
	                                   StuffRepository stuffRepository,
	                                   OfferService offerService) {
		this.clientRepository = clientRepository;
		this.stuffRepository = stuffRepository;
		this.offerService = offerService;
	}


	public Offer signNewOffer(LocalDate startDate, LocalDate endingDate, UUID clientId, UUID stuffId) {
		Objects.requireNonNull(startDate);
		Objects.requireNonNull(endingDate);
		Objects.requireNonNull(clientId);
		Objects.requireNonNull(stuffId);

		Client client = clientRepository.findById(clientId).orElseThrow();
		Stuff stuff = stuffRepository.findById(stuffId).orElseThrow();
		return offerService.signNewOffer(startDate, endingDate, client, stuff);
	}

}
