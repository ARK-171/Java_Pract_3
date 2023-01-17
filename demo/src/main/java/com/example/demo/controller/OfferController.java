package com.example.demo.controller;

import com.example.demo.dto.NewOfferParameters;
import com.example.demo.dto.OfferStatistic;
import com.example.demo.model.Client;
import com.example.demo.model.Offer;
import com.example.demo.service.OfferControllerService;
import com.example.demo.service.OfferStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api/v1/offer")
public class OfferController {

	private final OfferControllerService offerService;

	private final OfferStatisticService offerStatisticService;

	@Autowired
	public OfferController(
			               final OfferControllerService offerService,
	                       final OfferStatisticService offerStatisticService) {
		this.offerService = offerService;
		this.offerStatisticService = offerStatisticService;
	}

	@GetMapping("")
	public List<Offer> getOffer() {
		return new ArrayList<>(Offer.OfferRepository.values());
	}

	@GetMapping("/{id}")
	public Offer getOfferById(@PathVariable("id") UUID id) {
		return Offer.OfferRepository.get(id);
	}

	@PutMapping("")
	public Offer signNewOffer(@RequestBody NewOfferParameters offerParameters) {
		Objects.requireNonNull(offerParameters);
		Objects.requireNonNull(offerParameters.getClientId());
		Objects.requireNonNull(offerParameters.getStuffId());
		Objects.requireNonNull(offerParameters.getStartDate());
		Objects.requireNonNull(offerParameters.getEndingDate());

		return offerService.signNewOffer(
				offerParameters.getStartDate(),
				offerParameters.getEndingDate(),
				offerParameters.getClientId(),
				offerParameters.getStuffId());
	}

	@GetMapping("/statistic")
	public OfferStatistic getOfferStatistic() {
		return offerStatisticService.getOfferStatistic();
	}
}
