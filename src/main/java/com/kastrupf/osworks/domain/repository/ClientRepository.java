package com.kastrupf.osworks.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kastrupf.osworks.domain.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	List<Client> findByNom(String nom);
	List<Client> findByNomContaining(String nom);
	Client findByEmail(String email);
}
