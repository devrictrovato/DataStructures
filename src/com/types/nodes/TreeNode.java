package com.types.nodes;

import com.types.interfaces.Position;
import com.types.interfaces.PositionList;
import com.types.interfaces.TreePosition;

// Classe que implementa um nodo de uma árvore armazenando referências à um
// elemento, à um nodo pai, à um nodo esquerdo, e à um nodo direito.
public class TreeNode<T> implements TreePosition<T> {

	private T element; // Elemento armazenado neste nodo.

	private TreePosition<T> parent; // Nodo pai

	private PositionList<Position<T>> children; // Nodos filhos

	// Construtor padrão
	public TreeNode() {
	}

	// Construtor principal
	public TreeNode(T element, TreePosition<T> parent, PositionList<Position<T>> children) {
		setElement(element);
		setParent(parent);
		setChildren(children);
	}

	// Retorna o elemento armazenado nesta posição.
	public T element() {
		return element;
	}

	// Define o elemento a ser armazenado nesta posição
	public void setElement(T o) {
		element = o;
	}

	// Retorna o elemento armazenado nesta posição
	public T getElement() {
		return element;
	}

	// Retorna os filhos desta posição
	public PositionList<Position<T>> getChildren() {
		return children;
	}

	//	Define os filhos desta posição
	public void setChildren(PositionList<Position<T>> c) {
		children = c;
	}

	// Retorna o pai desta posição
	public TreePosition<T> getParent() {
		return parent;
	}

	// Define o pai desta posição
	public void setParent(TreePosition<T> v) {
		parent = v;
	}

}