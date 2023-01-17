package com.example.demo.controller;

import com.example.demo.model.Office;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api/v1/office")
public class OfficeController {

	@GetMapping("")
	public List<Office> getOffice() {
		return new ArrayList<>(Office.OfficeRepository.values());
	}

	@GetMapping("/{id}")
	public Office getOfficeById(@PathVariable("id") int id) {
		return Office.OfficeRepository.get(id);
	}

	@PutMapping("")
	public Office newOffice(String address, String lawAddress, Integer cabinetsCount){
		Office office = new Office(address, lawAddress, cabinetsCount);
		return Office.OfficeRepository.put(Office.x, office);
	}
}
