package com.example.demo.controller;

import com.example.demo.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

	public final Map<Integer, Client> clientRepository = new HashMap<>();

	@GetMapping("")
	public List<Client> getAllClients() {
		Client c = new Client(UUID.randomUUID(), "kozlov", "Sergey", "Ivanovich", "M", LocalDate.now(), "947328439201", "7428019478", "+79167853426");
		clientRepository.put(1, c);
		c = new Client(UUID.randomUUID(), "Ivanov", "Ivan", "Ivanovich", "M", LocalDate.now(), "947368438201", "6418019478", "+79164953496");
		clientRepository.put(2, c);
		return new ArrayList<>(clientRepository.values());
	}

	@GetMapping("/{id}")
	public String getClientById(@PathVariable("id") UUID id) {
		Objects.requireNonNull(id);
		return clientRepository.get(id).toString();
	}

}
