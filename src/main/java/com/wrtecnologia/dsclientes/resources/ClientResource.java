package com.wrtecnologia.dsclientes.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wrtecnologia.dsclientes.domain.Client;
import com.wrtecnologia.dsclientes.services.ClientService;

@RestController
@RequestMapping(value="/clients")
public class ClientResource {
	
	@Autowired
	private ClientService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Client obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
		/*
		Client cli1 = new Client(1, "Wagner Alves Pires", "428805481-87", (double) 2, null, 1);
		Client cli2 = new Client(2, "Miramar Maria Souza Neto Alves", "582398805-25", (double) 2, null, 2);		
		
		List<Client> lista  = new ArrayList<>();
		lista.add(cli1);
		lista.add(cli2);
		
		return lista; //"REST está funcionando";
		
		*/
		
	}

}
