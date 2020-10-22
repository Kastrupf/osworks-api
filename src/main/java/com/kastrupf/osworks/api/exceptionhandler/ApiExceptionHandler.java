package com.kastrupf.osworks.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.kastrupf.osworks.domain.exception.DomainException;


@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(DomainException.class)
	public ResponseEntity<Object> handleDomain(DomainException ex, WebRequest request) {
		var status = HttpStatus.BAD_REQUEST;
		
		var erreur = new Erreur();
		erreur.setStatus(status.value());
		erreur.setTitre(ex.getMessage());
		erreur.setDateHeure(OffsetDateTime.now());
		
		return handleExceptionInternal (ex, erreur, new HttpHeaders(), status, request);
			
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		var champs = new ArrayList<Erreur.Champ>();
		
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String nom = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			
			champs.add(new Erreur.Champ(nom, message));
		}
		
		var erreur = new Erreur();
		erreur.setStatus(status.value());
		erreur.setTitre("Un ou plusieurs champs ne sont pas valides. "
				+ "Remplissez correctement et réessayez.");
		erreur.setDateHeure(OffsetDateTime.now());
		erreur.setChamps(champs);
					
		return super.handleExceptionInternal(ex, erreur, headers, status, request);
		
	}
	
	
	
	
	
	
	
	
	
}
