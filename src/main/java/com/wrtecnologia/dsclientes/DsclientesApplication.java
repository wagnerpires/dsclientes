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
		
		clientRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4));

	}

}
