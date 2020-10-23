package com.kastrupf.osworks.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kastrupf.osworks.api.representationmodel.CommandeInput;
import com.kastrupf.osworks.api.representationmodel.CommandeRepresentationModel;
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
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CommandeRepresentationModel creer(@Valid @RequestBody CommandeInput commandeInput) {
		Commande commande = toEntity(commandeInput);
		
		return toModel(gestionCommande.creer(commande));
	}
	
	@GetMapping
	public List<CommandeRepresentationModel> lister() {
		return toCollectionModel(commandeRepository.findAll());	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CommandeRepresentationModel> listerParId(@PathVariable Long id) {
		Optional<Commande> commande= commandeRepository.findById(id);	
		
		if (commande.isPresent()) {
			CommandeRepresentationModel commandeRepresentationModel = toModel(commande.get());
			return ResponseEntity.ok(commandeRepresentationModel);
		}
					
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{commandeId}/fermeture")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void fermer(@PathVariable Long commandeId) {
		gestionCommande.fermerCommande(commandeId);
	}
	
	private CommandeRepresentationModel toModel(Commande commande) {
		return modelMapper.map(commande, CommandeRepresentationModel.class);
	}
	
	private List<CommandeRepresentationModel> toCollectionModel(List<Commande> commandes) {
		return commandes.stream()
				.map(commande -> toModel(commande))
				.collect(Collectors.toList());
	}
	
	private Commande toEntity(CommandeInput commandeInput) {
		return modelMapper.map(commandeInput, Commande.class);
	}
}	

