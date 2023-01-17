package com.example.demo.service;

import com.example.demo.model.Offer;

import java.time.LocalDate;
import java.util.UUID;

public interface OfferControllerService {
	Offer signNewOffer(LocalDate startDate, LocalDate endingDate, UUID clientId, UUID stuffId);
}
