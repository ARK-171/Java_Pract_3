package com.example.demo.controller;

import com.example.demo.model.Office;
import com.example.demo.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/office")
public class OfficeController {

	private final OfficeRepository officeRepository;

	@Autowired
	public OfficeController(OfficeRepository officeRepository) {
		this.officeRepository = officeRepository;
	}

	@GetMapping("/")
	public List<Office> getOffice() {
		return officeRepository.findAll();
	}

	@GetMapping("/{id}")
	public Office getOfficeById(@PathVariable("id") UUID id) {
		return officeRepository.findById(id).orElse(null);
	}
}
