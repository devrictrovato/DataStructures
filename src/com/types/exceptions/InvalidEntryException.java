package com.types.exceptions;

@SuppressWarnings("serial")
public class InvalidEntryException extends RuntimeException {
	
	public InvalidEntryException(String err) {
		super(err);
	}
	
}
