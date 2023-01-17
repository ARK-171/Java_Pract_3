package com.example.demo.controller;

import com.example.demo.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
@RequestMapping("/api/v1/position")
public class PositionController {

	public final Map<Integer, Position> PositionRepository = new HashMap<>();

	public PositionController(){

	}
	@GetMapping("/")
	public List<Position> getPositions() {
		Position p = new Position(UUID.randomUUID(), "bugalter", 45000);
		PositionRepository.put(1,p);
		return new ArrayList<>(PositionRepository.values());
	}

	@GetMapping("/{id}")
	public Position getPosition(@PathVariable("id") UUID id) {
		return PositionRepository.get(id);
	}
}
