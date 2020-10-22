package com.kastrupf.osworks.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kastrupf.osworks.domain.model.Client;
import com.kastrupf.osworks.domain.repository.ClientRepository;

@Service
public class RegistreClientService {
			
	@Autowired
	private ClientRepository clientRepository;
				
	public Client save(Client client) {
		return clientRepository.save(client);
	}
	
	public void supprimer(Long id) {
		clientRepository.deleteById(id);
	}
}
