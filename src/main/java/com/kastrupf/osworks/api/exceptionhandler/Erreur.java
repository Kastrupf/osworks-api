package com.kastrupf.osworks.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Erreur {
	
	private Integer status;
	private OffsetDateTime dateHeure;
	private String titre;
	private List<Champ> champs;
	
	public static class Champ {
		private String nom;
		private String message;
		
		public Champ(String nom, String message) {
			super();
			this.nom = nom;
			this.message = message;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
	}
			
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public OffsetDateTime getDateHeure() {
		return dateHeure;
	}
	public void setDateHeure(OffsetDateTime dateHeure) {
		this.dateHeure = dateHeure;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public List<Champ> getChamps() {
		return champs;
	}
	public void setChamps(List<Champ> champs) {
		this.champs = champs;
	}
	
}
