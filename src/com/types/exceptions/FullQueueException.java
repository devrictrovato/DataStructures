package com.types.exceptions;

@SuppressWarnings("serial")
public class FullQueueException extends RuntimeException {
	public FullQueueException(String err) {
		super(err);
	}
}