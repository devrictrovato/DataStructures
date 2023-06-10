package com.types.tads;

import com.types.exceptions.EmptyStackException;
import com.types.exceptions.FullStackException;
import com.types.interfaces.Stack;

public class ArrayStack<T> implements Stack<T> {

	protected int capacity; // capacidade real do arranjo da pilha

	public static final int CAPACITY = 1000; // capacidade default

	protected T S[]; // Arranjo usado para implementar a pilha

	protected int top = -1; // índice para o topo da pilha

	public ArrayStack() {
		// Se a Pilha for criada sem um quantidade máxima definida,
		// faz com que a capacidade seja 1000, default.
		this(CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public ArrayStack(int cap) {
		capacity = cap;
		// o compilador deve gerar um aviso, mas está ok
		S = (T[]) new Object[capacity];
	}

	public int size() {
		return (top + 1);
	}

	public boolean isEmpty() {
		return (top < 0);
	}

	public void push(T element) throws FullStackException {
		if (size() == capacity)
			throw new FullStackException("Stack is full.");
		S[++top] = element;
	}

	public T top() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException("Stack is empty.");
		return S[top];
	}

	public T pop() throws EmptyStackException {
		T element;
		if (isEmpty())
			throw new EmptyStackException("Stack is empty.");
		element = S[top];
		// desreferência S[top] para o sistema de coleta de lixo
		S[top--] = null;
		return element;
	}

	public String toString() {
		String s;
		s = "[";
		if (size() > 0)
			s += S[0];
		if (size() > 1) {
			for (int i = 1; i <= size() - 1; i++) {
				s += ", " + S[i];
			}
		}
		return s + "]";
	}
}
