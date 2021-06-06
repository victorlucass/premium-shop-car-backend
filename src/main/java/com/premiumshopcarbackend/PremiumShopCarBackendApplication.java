package com.premiumshopcarbackend;

import com.premiumshopcarbackend.DTO.UserDTO;
import com.premiumshopcarbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PremiumShopCarBackendApplication implements CommandLineRunner {

	@Autowired
	private UserService service;

	public static void main(String[] args) {
		SpringApplication.run(PremiumShopCarBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
