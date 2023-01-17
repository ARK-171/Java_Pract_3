package com.example.demo.controller;

import com.example.demo.model.Position;
import com.example.demo.model.Stuff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api/v1/stuff")
public class StuffController {

	@GetMapping("")
	public List<Stuff> getStuff() {
		return new ArrayList<>(Stuff.StuffRepository.values());
	}

	@GetMapping("/{id}")
	public Stuff getStuffById(@PathVariable("id") UUID id) {
		return Stuff.StuffRepository.get(id);
	}

	@PutMapping("")
	public Stuff newStuff(String surname, String name, String patronymic, String sex,
						  LocalDate birthDate, Double salaryMultiplier, Position position){
		Stuff stuff = new Stuff(surname, name, patronymic, sex, birthDate, salaryMultiplier, position);
		return Stuff.StuffRepository.put(Stuff.x, stuff);
	}
}
