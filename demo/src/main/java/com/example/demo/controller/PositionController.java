package com.example.demo.controller;

import com.example.demo.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api/v1/position")
public class PositionController {

	@GetMapping("")
	public List<Position> getPositions() {
		return new ArrayList<>(Position.PositionRepository.values());
	}

	@GetMapping("/{id}")
	public Position getPosition(@PathVariable("id") UUID id) {
		return Position.PositionRepository.get(id);
	}

	@PutMapping("")
	public Position newPosition(String name, Integer salary){
		Position pos = new Position(name, salary);
		return Position.PositionRepository.put(Position.x, pos);
	}
}
