package com.example.demo;

import com.example.demo.model.Client;
import com.example.demo.model.Position;
import com.example.demo.model.Stuff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Position.PositionRepository.put(Position.x, new Position("ohranik", 25900));
		Stuff.StuffRepository.put(Stuff.x, new Stuff("Ivanov", "Ivan", "Ivanovich", "M", LocalDate.now(), 1.28, Position.PositionRepository.get(1)));
		Client.ClientRepository.put(Client.x, new Client("Kozlov", "Valeriy", "Aleksandrovich", "M", LocalDate.now(), "123456789", "987456321", "654823197"));
		Client.ClientRepository.put(Client.x, new Client("Ctepanov", "Sergey", "Aleksandrovich", "M", LocalDate.now(), "823451789", "997436326", "614883195"));
	}
}
