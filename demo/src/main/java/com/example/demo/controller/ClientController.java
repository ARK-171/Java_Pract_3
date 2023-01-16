package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

	private final ClientRepository clientRepository;

	@Autowired
	public ClientController(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@GetMapping("")
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	@GetMapping("/{id}")
	public Client getClientById(@PathVariable("id") int id) {
		Objects.requireNonNull(id);
		return clientRepository.findById(id).orElse(null);
	}
}
