package com.kastrupf.osworks.api.representationmodel;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.kastrupf.osworks.domain.model.StatusCommande;

public class CommandeRepresentationModel {
	
	private Long reference;
	private String nomClient;
	private String description;
	private BigDecimal prix;
	private StatusCommande status;
	private OffsetDateTime dateOuverture;
	private OffsetDateTime dateFermeture;
	public Long getReference() {
		return reference;
	}
	public void setReference(Long reference) {
		this.reference = reference;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
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
}
