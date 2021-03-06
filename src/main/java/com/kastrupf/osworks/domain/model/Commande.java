package com.kastrupf.osworks.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
//import javax.validation.groups.ConvertGroup;
//import javax.validation.groups.Default;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.kastrupf.osworks.domain.exception.DomainException;

//import com.kastrupf.osworks.domain.ValidationGroups;


@Entity
public class Commande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Valid
	//@ConvertGroup(from = Default.class, to = ValidationGroups.ClientId.class)
	//@NotNull
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@NotBlank
	private String description;
	
	@NotNull
	private BigDecimal prix;
	
	//@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private StatusCommande status;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dateOuverture;
	
	//@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dateFermeture;
	
	@OneToMany(mappedBy = "commande")
	private List<Commentaire> commentaires = new ArrayList<>();
		
	public List<Commentaire> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrix() {
		return prix;
	}
	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}
	public StatusCommande getStatus() {
		return status;
	}
	public void setStatus(StatusCommande status) {
		this.status = status;
	}
	public OffsetDateTime getDateOuverture() {
		return dateOuverture;
	}
	public void setDateOuverture(OffsetDateTime dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	public OffsetDateTime getDateFermeture() {
		return dateFermeture;
	}
	public void setDateFermeture(OffsetDateTime dateFermeture) {
		this.dateFermeture = dateFermeture;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commande other = (Commande) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public boolean peutEtreFerme() {
		return StatusCommande.OUVERT.equals(getStatus());
	}
	
	public boolean nePeutPasEtreFerme() {
		return !peutEtreFerme();
	}
		
	public void fermer() {
		if (nePeutPasEtreFerme()) {
			throw new DomainException("La commande ne peut pas etre fermée.");
		}
			
		setStatus(StatusCommande.FERME);
		setDateFermeture(OffsetDateTime.now());
	}
}
