package com.wrtecnologia.dsclientes.dto;

import java.io.Serializable;
import java.time.Instant;

import com.wrtecnologia.dsclientes.domain.Client;

public class ClientDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String cpf;
	private Double income;
	private Instant birthDate;
	private Integer children;

	
	public ClientDTO() {
	}
	
	public ClientDTO(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public ClientDTO(Client entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.cpf = entity.getCpf();
		this.income = entity.getIncome();
		this.birthDate = entity.getBirthDate();
		this.children = entity.getChildren();
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Instant getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

}
