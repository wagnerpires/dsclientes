package com.wrtecnologia.dsclientes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrtecnologia.dsclientes.domain.Client;
import com.wrtecnologia.dsclientes.exceptions.ObjectNotFoundException;
import com.wrtecnologia.dsclientes.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repo;

	public Client find(Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Client.class.getName()));
		}
	
	public Client insert(Client obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Client update(Client obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
}

