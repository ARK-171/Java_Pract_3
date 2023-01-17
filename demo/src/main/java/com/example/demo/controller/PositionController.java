package com.example.demo.controller;

import com.example.demo.model.Position;
import com.example.demo.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/position")
public class PositionController {

	private final PositionRepository positionRepository;

	@Autowired
	public PositionController(PositionRepository positionRepository) {
		this.positionRepository = positionRepository;
	}

	@GetMapping("/")
	public List<Position> getPositions() {
		return positionRepository.findAll();
	}

	@GetMapping("/{id}")
	public Position getPosition(@PathVariable("id") UUID id) {
		return positionRepository.findById(id).orElse(null);
	}
}
