package br.com.fiap.locatech.locatech.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1728300331578404097L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
