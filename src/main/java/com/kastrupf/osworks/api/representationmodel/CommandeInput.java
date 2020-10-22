package com.kastrupf.osworks.api.representationmodel;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class CommandeInput {
	
	@NotBlank
	private String description;
	
	@NotNull
	private BigDecimal prix;
	
	@Valid
	@NotNull
	private ClientIdInput client;
	
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
	public ClientIdInput getClient() {
		return client;
	}
	public void setClient(ClientIdInput client) {
		this.client = client;
	}
}
