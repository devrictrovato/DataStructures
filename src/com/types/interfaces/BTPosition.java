package com.types.interfaces;

public interface BTPosition<T> extends Position<T>{

	// Retorna o elemento armazenado nesta posição
	public T element();

	// Define o elemento armazenado nesta posição
	public void setElement(T o);

	// Retorna o filho da esquerda desta posição
	public BTPosition<T> getLeft();

	// Define o filho da esquerda desta posição
	public void setLeft(BTPosition<T> v);

	// Retorna o filho da direita desta posição
	public BTPosition<T> getRight();

	// Define o filho da direita desta posição
	public void setRight(BTPosition<T> v);

	// Retorna o pai desta posição
	public BTPosition<T> getParent();

	// Define o pai desta posição
	public void setParent(BTPosition<T> v);
}
