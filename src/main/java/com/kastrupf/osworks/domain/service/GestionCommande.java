package com.kastrupf.osworks.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kastrupf.osworks.domain.model.Commande;
import com.kastrupf.osworks.domain.model.StatusCommande;
import com.kastrupf.osworks.domain.repository.CommandeRepository;

@Service
public class GestionCommande {
	
	@Autowired
	private CommandeRepository commandeRepository;
		
	public Commande creer(Commande commande) {
		commande.setStatus(StatusCommande.OUVERTE);
		commande.setDateOuverture(LocalDateTime.now());
		
		return commandeRepository.save(commande);
	}
}
