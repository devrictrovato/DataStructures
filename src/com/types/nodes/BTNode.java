package com.types.nodes;

import com.types.interfaces.BTPosition;

// Classe que implementa um nodo de árvore binária armazenando referências
// para um elemento, o nodo pai, o nodo da direita e o nodo da esquerda.
public class BTNode<T> implements BTPosition<T> {

	private T element; // elemento armazenado neste nodo

	private BTPosition<T> left, right, parent; // nodos adjacentes

	// Construtor principal
	public BTNode(T element, BTPosition<T> parent, BTPosition<T> left, BTPosition<T> right) {
		setElement(element);
		setParent(parent);
		setLeft(left);
		setRight(right);
	}

	public BTNode() {	}

	// Retorna o elemento armazenado nesta posição
	public T element() {
		return element;
	}

	// Define o elemento armazenado nesta posição
	public void setElement(T o) {
		element = o;
	}

	// Retorna o filho da esquerda desta posição
	public BTPosition<T> getLeft() {
		return left;
	}

	// Define o filho da esquerda desta posição
	public void setLeft(BTPosition<T> v) {
		left = v;
	}

	// Retorna o filho da direita desta posição
	public BTPosition<T> getRight() {
		return right;
	}

	// Define o filho da direita desta posição
	public void setRight(BTPosition<T> v) {
		right = v;
	}

	// Retorna o pai desta posição
	public BTPosition<T> getParent() {
		return parent;
	}

	// Define o pai desta posição
	public void setParent(BTPosition<T> v) {
		parent = v;
	}

}