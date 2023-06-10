package com.types.exceptions;

@SuppressWarnings("serial")
public class EmptyStackException extends RuntimeException {
	public EmptyStackException(String err) {
		super(err);
	}
}