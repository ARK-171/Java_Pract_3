package com.example.demo;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	private static ClientRepository cc;

	@Autowired
	public DemoApplication(ClientRepository r){ cc = r;}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Client c = new Client();
		System.out.println(c.getId());
		System.out.println(c.getSurname());
		System.out.println(cc.findById(c.getId()));
	}
}
