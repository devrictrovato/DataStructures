package com.types.exceptions;

@SuppressWarnings("serial")
public class FullStackException extends RuntimeException {
	public FullStackException(String err) {
		super(err);
	}
}