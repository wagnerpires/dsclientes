package com.wrtecnologia.dsclientes;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wrtecnologia.dsclientes.domain.Client;
import com.wrtecnologia.dsclientes.repositories.ClientRepository;

@SpringBootApplication
public class DsclientesApplication implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DsclientesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Instant iNow = Instant.now();

		Client cli1 = new Client(null, "Wagner Alves Pires", "123456789-87", (double) 1, iNow, 1);
		Client cli2 = new Client(null, "Miramar Maria Souza Neto Alves", "145222552-25", (double) 2, iNow, 2);		
		Client cli3 = new Client(null, "Mariana Pires de Souza", "852456753-32", (double) 3, iNow, 3);
		Client cli4 = new Client(null, "Gabriel Pires de Souza", "159842523-56", (double) 4, iNow, 4);		
		Client cli5 = new Client(null, "Professor Nelio Alves", "7583154885-87", (double) 5, iNow, 5);
		Client cli6 = new Client(null, "DevSuperior Bootcamp 3.0", "145222552-25", (double) 6, iNow, 6);		
		Client cli7 = new Client(null, "Lara Pires", "852456753-32", (double) 7, iNow, 7);
		Client cli8 = new Client(null, "Nice Alves", "159842523-56", (double) 8, iNow, 8);		
		Client cli9 = new Client(null, "Villa Souza Sodre", "123456789-87", (double) 9, iNow, 9);
		Client cli10 = new Client(null, "Antonio Carlos Mota", "145222552-25", (double) 10, iNow, 10);		
		Client cli11 = new Client(null, "Ataide Jose Andrade", "852456753-32", (double) 11, iNow, 11);
		Client cli12 = new Client(null, "Maria Jose da Silva Sauro", "159842523-56", (double) 12, iNow, 12);		
				
		clientRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5, cli6, cli7, cli8, cli9, cli10, cli11, cli12));

	}

}
