package com.example.demo.controller;

import com.example.demo.model.Position;
import com.example.demo.model.Stuff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api/v1/stuff")
public class StuffController {

	@Autowired
	private PositionController pos;
	public final Map<Integer, Stuff> StuffRepository = new HashMap<>();

	@GetMapping("/")
	public List<Stuff> getStuff() {

		Stuff st = new Stuff(UUID.randomUUID(), "Vasilev","Rudolf","Sergeevich","M", LocalDate.now(),1.34, pos.PositionRepository.get(1));
		StuffRepository.put(1,st);
		return new ArrayList<>(StuffRepository.values());
	}

	@GetMapping("/{id}")
	public Stuff getStuffById(@PathVariable("id") UUID id) {
		return StuffRepository.get(id);
	}
}
