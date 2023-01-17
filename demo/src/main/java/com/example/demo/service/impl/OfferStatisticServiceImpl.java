package com.example.demo.service.impl;

import com.example.demo.dto.OfferStatistic;
import com.example.demo.model.Client;
import com.example.demo.model.Offer;
import com.example.demo.service.OfferStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OfferStatisticServiceImpl implements OfferStatisticService {

	@Override
	public OfferStatistic getOfferStatistic() {
		OfferStatistic.Builder statisticBuilder = new OfferStatistic.Builder();
		List<Offer> offers = List.copyOf(Offer.OfferRepository.values());
		Map<String, Integer> clientStatistic = new HashMap<>();
		Map<String, Integer> stuffStatistic = new HashMap<>();
		offers.forEach(offer -> {
			if (clientStatistic.containsKey(offer.getClient().getSurname())) {
				clientStatistic.compute(offer.getClient().getSurname(), (k, v) -> v + 1);
			} else {
				clientStatistic.put(offer.getClient().getSurname(), 1);
			}
			if (stuffStatistic.containsKey(offer.getStuff().getSurname())) {
				stuffStatistic.compute(offer.getStuff().getSurname(), (k, v) -> v + 1);
			} else {
				stuffStatistic.put(offer.getStuff().getSurname(), 1);
			}
		});
		statisticBuilder.setStuffStatistics(stuffStatistic);
		statisticBuilder.setClientStatistics(clientStatistic);
		Set<String> clientSurnames = new HashSet<>();
		for (int i = 0; i < Client.x; i++){
			clientSurnames.add(Client.ClientRepository.get(i).toString());
		}
		statisticBuilder.setClientSurnames(clientSurnames);
		return statisticBuilder.build();
	}
}
