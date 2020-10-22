package com.kastrupf.osworks.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kastrupf.osworks.domain.exception.DomainException;
import com.kastrupf.osworks.domain.model.Client;
import com.kastrupf.osworks.domain.model.Commande;
import com.kastrupf.osworks.domain.model.StatusCommande;
import com.kastrupf.osworks.domain.repository.ClientRepository;
import com.kastrupf.osworks.domain.repository.CommandeRepository;

@Service
public class GestionCommande {
	
	@Autowired
	private CommandeRepository commandeRepository;
	
	@Autowired
	private ClientRepository clientRepository;
		
		
	public Commande creer(Commande commande) {
		Client client = clientRepository.findById(commande.getClient().getId())
				.orElseThrow(() -> new DomainException("Client non trouvé."));
		
		commande.setClient(client);
		commande.setStatus(StatusCommande.OUVERTE);
		commande.setDateOuverture(OffsetDateTime.now());
		
		return commandeRepository.save(commande);
	}
}
