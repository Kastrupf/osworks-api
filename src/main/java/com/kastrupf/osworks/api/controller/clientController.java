package com.kastrupf.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kastrupf.osworks.domain.model.Client;

@RestController
public class ClientController {
	
	@GetMapping("/clients")
	public List<Client> lister() {
		var client1 = new Client();
		client1.setId(1L);
		client1.setNom("MENDES");
		client1.setPrenom("Juan");
		client1.setEmail("juan@email.com");
		client1.setTelephone("05.66.77.88.99");
		
		var client2= new Client();
		client2.setId(1L);
		client2.setNom("ALMEIDA");
		client2.setPrenom("Joana");
		client2.setEmail("joana@email.com");
		client2.setTelephone("06.88.77.66.55");
		
		return Arrays.asList(client1, client2);
	}

}
