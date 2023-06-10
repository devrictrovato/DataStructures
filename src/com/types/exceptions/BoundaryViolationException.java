package com.types.exceptions;

/* Exceção lançada se for feita uma tentativa de acessar um elemento cuja
* posição está fora do intervalo de posições da lista (por exemplo, chamando-se
* o método next sobre a última posição da sequência). */

@SuppressWarnings("serial")
public class BoundaryViolationException extends RuntimeException {
	public BoundaryViolationException(String err) { super(err); }
}