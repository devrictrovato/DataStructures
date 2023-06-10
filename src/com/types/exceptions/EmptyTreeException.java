package com.types.exceptions;

@SuppressWarnings("serial")

public class EmptyTreeException extends RuntimeException {
	
	// Exceção lançada se a lista estiver vazia e tentar,
	// por exemplo, obter o primeiro elemento da lista
	// usando o método first.
	
	public EmptyTreeException(String err) {
		super(err);
	}
}