package com.kastrupf.osworks.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kastrupf.osworks.domain.exception.DomainException;
import com.kastrupf.osworks.domain.exception.EntitieNonTrouveeException;
import com.kastrupf.osworks.domain.model.Client;
import com.kastrupf.osworks.domain.model.Commande;
import com.kastrupf.osworks.domain.model.Commentaire;
import com.kastrupf.osworks.domain.model.StatusCommande;
import com.kastrupf.osworks.domain.repository.ClientRepository;
import com.kastrupf.osworks.domain.repository.CommandeRepository;
import com.kastrupf.osworks.domain.repository.CommentaireRepository;

@Service
public class GestionCommande {
	
	@Autowired
	private CommandeRepository commandeRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private CommentaireRepository commentaireRepository;
	
		
	public Commande creer(Commande commande) {
		Client client = clientRepository.findById(commande.getClient().getId())
				.orElseThrow(() -> new DomainException("Client non trouvé."));
		
		commande.setClient(client);
		commande.setStatus(StatusCommande.OUVERT);
		commande.setDateOuverture(OffsetDateTime.now());
		
		return commandeRepository.save(commande);
	}
	
	public void fermerCommande(Long commandeId) {
		Commande commande = rechercher(commandeId);
		
		commande.fermer();
		
		commandeRepository.save(commande);
	}
				
	public Commentaire ajouterCommentaire(Long commandeId, String description) {
		Commande commande = rechercher(commandeId);
		
		Commentaire commentaire = new Commentaire();
		commentaire.setDate(OffsetDateTime.now());
		commentaire.setDescription(description);
		commentaire.setCommande(commande);
		
		return commentaireRepository.save(commentaire);
	}
	
	private Commande rechercher(Long commandeId) {
		return commandeRepository.findById(commandeId)
				.orElseThrow(() -> new EntitieNonTrouveeException("Commande non trouvée."));
	}
}
