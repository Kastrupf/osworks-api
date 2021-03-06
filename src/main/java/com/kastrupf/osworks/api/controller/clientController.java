package com.kastrupf.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kastrupf.osworks.domain.model.Client;
import com.kastrupf.osworks.domain.repository.ClientRepository;
import com.kastrupf.osworks.domain.service.RegistreClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository; 
	
	@Autowired
	private RegistreClientService registreClient; 
	
	@GetMapping
	public List<Client> lister() {
		return clientRepository.findAll();	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> listerParId(@PathVariable Long id) {
		Optional<Client> client= clientRepository.findById(id);	
		
		if (client.isPresent()) {
			return ResponseEntity.ok(client.get());
		}
					
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client ajouter(@Valid @RequestBody Client client) {
		return registreClient.save(client);	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> mettreAJourLeClient(@Valid @PathVariable Long id, @RequestBody Client client) {
		if (!clientRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		client.setId(id);
		client = registreClient.save(client);	
		
		return ResponseEntity.ok(client);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> supprimer(@PathVariable Long id) {
		if (!clientRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		registreClient.supprimer(id);
		
		return ResponseEntity.noContent().build();
	}
}
