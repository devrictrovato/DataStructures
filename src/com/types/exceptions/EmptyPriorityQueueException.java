package com.types.exceptions;

@SuppressWarnings("serial")
public class EmptyPriorityQueueException extends RuntimeException {
	
	public EmptyPriorityQueueException(String err) {
		super(err);
	}
	
}
