package com.types.interfaces;

import java.util.Iterator;

import com.types.exceptions.BoundaryViolationException;
import com.types.exceptions.EmptyTreeException;
import com.types.exceptions.InvalidPositionException;

// Interface para uma árvore onde os nodos podem ter uma quantidade arbitrária de filhos.
public interface Tree<T> extends Iterable<T> {

	// Retorna a quantidade de nodos da árvore.
	public int size();

	// Retorna se a árvore está vazia.
	public boolean isEmpty();

	// Retorna um iterador sobre os elementos armazenados na árvore.
	public Iterator<T> iterator();

	// Retorna uma coleção iterável dos nodos.
	public Iterable<Position<T>> positions();

	// Substitui o elemento armazenado em um dado nodo.
	public T replace(Position<T> v, T e) throws InvalidPositionException;

	// Retorna a raiz da árvore.
	public Position<T> root() throws EmptyTreeException;

	// Retorna o pai de um dado nodo.
	public Position<T> parent(Position<T> v) throws InvalidPositionException, BoundaryViolationException;

	// Retorna uma coleção iterável dos filhos de um dado nodo.
	public Iterable<Position<T>> children(Position<T> v) throws InvalidPositionException;

	// Retorna se um dado nodo é interno.
	public boolean isInternal(Position<T> v) throws InvalidPositionException;

	// Retorna se um dado nodo é externo.
	public boolean isExternal(Position<T> v) throws InvalidPositionException;

	// Retorna se um dado nodo é a raiz da árvore.
	public boolean isRoot(Position<T> v) throws InvalidPositionException;

}