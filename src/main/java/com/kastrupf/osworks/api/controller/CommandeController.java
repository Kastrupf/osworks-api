package com.kastrupf.osworks.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kastrupf.osworks.domain.model.Commande;
import com.kastrupf.osworks.domain.service.GestionCommande;

@RestController
@RequestMapping("/commandes")
public class CommandeController {
	
	@Autowired
	private GestionCommande gestionCommande;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Commande creer(@Valid @RequestBody Commande commande) {
		return gestionCommande.creer(commande);
	}
}
