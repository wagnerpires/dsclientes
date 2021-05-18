package com.wrtecnologia.dsclientes.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wrtecnologia.dsclientes.domain.Client;
import com.wrtecnologia.dsclientes.dto.ClientDTO;
import com.wrtecnologia.dsclientes.repositories.ClientRepository;
import com.wrtecnologia.dsclientes.services.exceptions.DatabaseException;
import com.wrtecnologia.dsclientes.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repo;

	@Transactional(readOnly = true)
	public ClientDTO findById(Integer id) {
		Optional<Client> obj = repo.findById(id);
		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		dto.setId(null);
		Client entity = new Client();
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
		entity = repo.save(entity);
		return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO update(Integer id, ClientDTO dto) {
		try {
			Client entity = repo.getOne(id);
			entity.setName(dto.getName());
			entity.setCpf(dto.getCpf());
			entity.setIncome(dto.getIncome());
			entity.setBirthDate(dto.getBirthDate());
			entity.setChildren(dto.getChildren());
			entity = repo.save(entity);
			return new ClientDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);

		}
	}

	// Sem anotação @Transactional prá capturar uma exceção do banco caso ocorra.
	public void delete(Integer id) {
		try {
			repo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> page = repo.findAll(pageRequest);
		return page.map(x -> new ClientDTO(x));

	}

	public Page<Client> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}
