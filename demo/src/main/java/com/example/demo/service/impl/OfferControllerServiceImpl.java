package com.example.demo.service.impl;

import com.example.demo.model.Client;
import com.example.demo.model.Offer;
import com.example.demo.model.Stuff;
import com.example.demo.service.OfferControllerService;
import com.example.demo.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Service
public class OfferControllerServiceImpl implements OfferControllerService {
	private final OfferService offerService;

	@Autowired
	public OfferControllerServiceImpl(OfferService offerService) {
		this.offerService = offerService;
	}

	@Override
	public Offer signNewOffer(LocalDate startDate, LocalDate endingDate, int clientId, int stuffId) {
		Objects.requireNonNull(startDate);
		Objects.requireNonNull(endingDate);
		Objects.requireNonNull(clientId);
		Objects.requireNonNull(stuffId);

		Client client = Client.ClientRepository.get(clientId);
		Stuff stuff = Stuff.StuffRepository.get(stuffId);
		return offerService.signNewOffer(startDate, endingDate, client, stuff);
	}

}
