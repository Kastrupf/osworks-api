package com.kastrupf.osworks.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kastrupf.osworks.domain.model.Client;
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
	
	
	
}
