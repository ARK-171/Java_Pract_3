package com.example.demo.service.impl;

import com.example.demo.dto.OfferStatistic;
import com.example.demo.model.Client;
import com.example.demo.model.Offer;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.OfferRepository;
import com.example.demo.service.OfferStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OfferStatisticServiceImpl implements OfferStatisticService {

	private final OfferRepository offerRepository;

	private final ClientRepository clientRepository;

	@Autowired
	public OfferStatisticServiceImpl( OfferRepository offerRepository, ClientRepository clientRepository) {
		this.offerRepository = offerRepository;
		this.clientRepository = clientRepository;
	}

	@Override
	public OfferStatistic getOfferStatistic() {
		OfferStatistic.Builder statisticBuilder = new OfferStatistic.Builder();
		List<Offer> offers = offerRepository.findAll();
		Map<String, Integer> clientStatistic = new HashMap<>();
		Map<String, Integer> stuffStatistic = new HashMap<>();
		offers.forEach(offer -> {
			if (clientStatistic.containsKey(clientRepository.getReferenceById(offer.getClient()).getSurname())) {
				clientStatistic.compute(clientRepository.getReferenceById(offer.getClient()).getSurname(), (k, v) -> v + 1);
			} else {
				clientStatistic.put(clientRepository.getReferenceById(offer.getClient()).getSurname(), 1);
			}
			if (stuffStatistic.containsKey(clientRepository.getReferenceById(offer.getClient()).getSurname())) {
				stuffStatistic.compute(clientRepository.getReferenceById(offer.getClient()).getSurname(), (k, v) -> v + 1);
			} else {
				stuffStatistic.put(clientRepository.getReferenceById(offer.getClient()).getSurname(), 1);
			}
		});
		statisticBuilder.setStuffStatistics(stuffStatistic);
		statisticBuilder.setClientStatistics(clientStatistic);
		Set<String> clientSurnames = clientRepository.findAll()
				.stream()
				.map(Client::getSurname)
				.collect(Collectors.toSet());
		statisticBuilder.setClientSurnames(clientSurnames);
		return statisticBuilder.build();
	}
}
