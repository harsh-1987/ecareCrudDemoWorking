package com.synechron.ecareCrudDemo.exception;

public class ResourceNotFoundException extends Exception{
	
	
	private static final long serialVersionUID = -6705756047886889369L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
