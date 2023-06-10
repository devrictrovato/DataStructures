package com.types.exceptions;

@SuppressWarnings("serial")
public class EmptyQueueException extends RuntimeException {
	public EmptyQueueException(String err) {
		super(err);
	}
}
