package com.types.exceptions;

// Retorna uma exceção quando se tenta criar uma raíz
// de uma árvore que não está vazia.

@SuppressWarnings("serial")
public class NonEmptyTreeException extends RuntimeException {
	public NonEmptyTreeException(String err) {
		super(err);
	}
}