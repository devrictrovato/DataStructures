package com.types.exceptions;

/* Exceção lançada se a posição fornecida como argumento não é válida (por
* exemplo, se é uma referência nula ou não tem lista associada). */

@SuppressWarnings("serial")
public class InvalidPositionException extends RuntimeException {
	public InvalidPositionException(String err) { super(err); }
}