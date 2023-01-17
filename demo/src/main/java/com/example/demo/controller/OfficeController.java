package com.example.demo.controller;

import com.example.demo.model.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
@RequestMapping("/api/v1/office")
public class OfficeController {
	public final Map<Integer, Office> OfficeRepository = new HashMap<>();

	@GetMapping("/")
	public List<Office> getOffice() {
		Office off = new Office(UUID.randomUUID(), "rechka 21", "Kazakstan", 56);
		OfficeRepository.put(1, off);
		return new ArrayList<>(OfficeRepository.values());
	}

	@GetMapping("/{id}")
	public Office getOfficeById(@PathVariable("id") UUID id) {
		return OfficeRepository.get(id);
	}
}
