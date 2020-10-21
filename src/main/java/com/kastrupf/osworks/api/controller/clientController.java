package com.kastrupf.osworks.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class clientController {
	
	@GetMapping("/clients")
	public String list() {
		return "Test";
	}

}
