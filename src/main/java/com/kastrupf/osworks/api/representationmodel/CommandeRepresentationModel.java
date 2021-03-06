package com.kastrupf.osworks.api.representationmodel;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.kastrupf.osworks.domain.model.StatusCommande;

public class CommandeRepresentationModel {
	
	private Long id;
	private ClientResumeModel client;
	private String description;
	private BigDecimal prix;
	private StatusCommande status;
	private OffsetDateTime dateOuverture;
	private OffsetDateTime dateFermeture;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public ClientResumeModel getClient() {
		return client;
	}
	public void setClient(ClientResumeModel client) {
		this.client = client;
	}
}
