package com.example.demo.controller;

import com.example.demo.dto.NewOfferParameters;
import com.example.demo.model.Client;
import com.example.demo.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

	@GetMapping("")
	public List<Client> getAllClients() {
		return new ArrayList<>(Client.ClientRepository.values());
	}

	@GetMapping("/{id}")
	public String getClientById(@PathVariable("id") UUID id) {
		Objects.requireNonNull(id);
		return Client.ClientRepository.get(id).toString();
	}
	@PutMapping("")
	public Client newClient(final String surname,
							final String name,
							final String patronymic,
							final String sex,
							final LocalDate birthDate,
							final String inn,
							final String passportSerial,
							final String phone) {
		Client client = new Client(surname, name, patronymic, sex, birthDate, inn, passportSerial, phone);
		return Client.ClientRepository.put(Client.x, client);
	}
}
