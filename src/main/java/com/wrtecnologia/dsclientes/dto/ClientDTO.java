package com.wrtecnologia.dsclientes.dto;

import java.io.Serializable;
import com.wrtecnologia.dsclientes.domain.Client;

public class ClientDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	
	public ClientDTO() {
	}
	
	public ClientDTO(Client obj) {
		id = obj.getId();
		name = obj.getName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
