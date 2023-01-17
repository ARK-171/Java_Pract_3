package com.example.demo.service;


import com.example.demo.model.Client;
import com.example.demo.model.Offer;
import com.example.demo.model.Stuff;

import java.time.LocalDate;

public interface OfferService {
	Offer signNewOffer(LocalDate startDate, LocalDate endingDate, Client client, Stuff stuff);
}
