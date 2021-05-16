package com.wrtecnologia.dsclientes.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wrtecnologia.dsclientes.domain.Client;
import com.wrtecnologia.dsclientes.services.ClientService;

@RestController
@RequestMapping(value="/clients")
public class ClientResource {
	
	@Autowired
	private ClientService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Client> find(@PathVariable Integer id) {
					Client obj = service.find(id);
			return ResponseEntity.ok().body(obj);
			
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Client obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Client obj, @PathVariable Integer id ){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

}
