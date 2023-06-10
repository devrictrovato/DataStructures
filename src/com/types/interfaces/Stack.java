package com.types.interfaces;

import com.types.exceptions.EmptyStackException;

public interface Stack<T> {

	// Retorna o número de elementos na pilha.

	public int size();

	// @return True se a pilha é vazia, False em caso contrário.

	public boolean isEmpty();

	// @return o elemento que está no topo da pilha.

	// @exception EmptyStackException se a pilha estiver vazia.

	public T top() throws EmptyStackException;

	// @param elemento a ser inserido.

	public void push(T element);

	// @return elemento removido.

	// @exception EmptyStackException se a pilha estiver vazia.

	public T pop() throws EmptyStackException;

}
