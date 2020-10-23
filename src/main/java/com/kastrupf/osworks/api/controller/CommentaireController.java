package com.kastrupf.osworks.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kastrupf.osworks.api.representationmodel.CommentaireInput;
import com.kastrupf.osworks.api.representationmodel.CommentaireRepresentationModel;
import com.kastrupf.osworks.domain.exception.EntitieNonTrouveeException;
import com.kastrupf.osworks.domain.model.Commande;
import com.kastrupf.osworks.domain.model.Commentaire;
import com.kastrupf.osworks.domain.repository.CommandeRepository;
import com.kastrupf.osworks.domain.service.GestionCommande;

@RestController
@RequestMapping("/commandes/{commandeId}/commentaires")
public class CommentaireController {
	
	@Autowired
	private GestionCommande gestionCommande;
	
	@Autowired
	private CommandeRepository commandeRepository; 
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public List<CommentaireRepresentationModel> lister(@PathVariable Long commandeId) {
		Commande commande = commandeRepository.findById(commandeId)
				.orElseThrow(() -> new EntitieNonTrouveeException("Commande non trouvée."));
		
		return toCollectionModel(commande.getCommentaires());
	}
	
	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	public CommentaireRepresentationModel ajouter(@PathVariable Long commandeId, 
			@Valid @RequestBody CommentaireInput commentaireInput) {
		
		Commentaire commentaire = gestionCommande.ajouterCommentaire(commandeId, 
				commentaireInput.getDescription());
		
		return toModel(commentaire);
	}
		
	private CommentaireRepresentationModel toModel(Commentaire commentaire) {
		return modelMapper.map(commentaire, CommentaireRepresentationModel.class);
	}
	
	private List<CommentaireRepresentationModel> toCollectionModel(List<Commentaire> commentaires) {
		return commentaires.stream()
				.map(commentaire -> toModel(commentaire))
				.collect(Collectors.toList());
	}
				
}


