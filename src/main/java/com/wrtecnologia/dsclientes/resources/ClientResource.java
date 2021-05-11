package com.wrtecnologia.dsclientes.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wrtecnologia.dsclientes.domain.Client;

@RestController
@RequestMapping(value="/clients")
public class ClientResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Client> listar() {
		
		Client cli1 = new Client(1, "Wagner Alves Pires", "428805481-87", (double) 2, null, 1);
		Client cli2 = new Client(2, "Miramar Maria Souza Neto Alves", "582398805-25", (double) 2, null, 2);		
		
		List<Client> lista  = new ArrayList<>();
		lista.add(cli1);
		lista.add(cli2);
		
		return lista; //"REST está funcionando";
		
	}

}
