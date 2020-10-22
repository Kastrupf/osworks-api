package com.kastrupf.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kastrupf.osworks.domain.model.Commande;
import com.kastrupf.osworks.domain.repository.CommandeRepository;
import com.kastrupf.osworks.domain.service.GestionCommande;

@RestController
@RequestMapping("/commandes")
public class CommandeController {
	
	@Autowired
	private GestionCommande gestionCommande;
	
	@Autowired
	private CommandeRepository commandeRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Commande creer(@Valid @RequestBody Commande commande) {
		return gestionCommande.creer(commande);
	}
	
	@GetMapping
	public List<Commande> lister() {
		return commandeRepository.findAll();	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Commande> listerParId(@PathVariable Long id) {
		Optional<Commande> commande= commandeRepository.findById(id);	
		
		if (commande.isPresent()) {
			return ResponseEntity.ok(commande.get());
		}
					
		return ResponseEntity.notFound().build();
	}
	
	
	
	
	
}
