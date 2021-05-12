package com.wrtecnologia.dsclientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wrtecnologia.dsclientes.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
