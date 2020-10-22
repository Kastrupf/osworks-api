package com.kastrupf.osworks.api.representationmodel;

import javax.validation.constraints.NotBlank;

public class CommentaireInput {
	
	@NotBlank
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
