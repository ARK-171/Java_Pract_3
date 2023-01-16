package com.example.demo;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@AutoConfiguration
@EnableJpaRepositories
@EnableWebMvc
public class ApplicationConfiguration {
}
