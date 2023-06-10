package com.types.structures;

import java.util.Iterator;

import com.types.exceptions.BoundaryViolationException;
import com.types.exceptions.EmptyTreeException;
import com.types.exceptions.InvalidPositionException;
import com.types.exceptions.NonEmptyTreeException;
import com.types.interfaces.Position;
import com.types.interfaces.PositionList;
import com.types.interfaces.Tree;
import com.types.interfaces.TreePosition;
import com.types.nodes.TreeNode;

// Um classe para a árvore ligada onde os nodos têm um Número arbitrário de filhos.
public class LinkedTree<T> implements Tree<T> {

	protected TreePosition<T> root; // Referência para a raíz
	protected int size; // Número de Nodos

	// Cria uma árvore vazia
	public LinkedTree() {
		root = null; // Inicia uma árvore vazia
		size = 0;
	}

	// Retorna um Número de nodos da árvore
	public int size() {
		return size;
	}

	// Retorna se a árvore está vazia
	public boolean isEmpty() {
		return (size == 0);
	}

	// Retorna se um nodo é interno
	public boolean isInternal(Position<T> v) throws InvalidPositionException {
		return !isExternal(v);
	}

	// Retorna se um nodo é externo
	public boolean isExternal(Position<T> v) throws InvalidPositionException {

		TreePosition<T> vv = checkPosition(v);
		return (vv.getChildren() == null) || vv.getChildren().isEmpty();
	}

	// Retorna se um nodo é a raíz
	public boolean isRoot(Position<T> v) throws InvalidPositionException {
		checkPosition(v);
		return (v == root());
	}

	// Retorna a raíz da árvore
	public TreePosition<T> root() throws EmptyTreeException {
		if (root == null)
			throw new EmptyTreeException("The tree is empty");
		return root;
	}

	// Retorna o pai de um nodo
	public TreePosition<T> parent(Position<T> v) throws InvalidPositionException, BoundaryViolationException {
		TreePosition<T> vv = checkPosition(v);
		TreePosition<T> parentPos = vv.getParent();
		if (parentPos == null)
			throw new BoundaryViolationException("No parent");
		return parentPos;
	}

	// Retorna uma coleção iterável dos filhos de um nodo
	public Iterable<Position<T>> children(Position<T> v) throws InvalidPositionException {
		TreePosition<T> vv = checkPosition(v);
		return vv.getChildren();
	}

	// Retorna uma coleção iterável dos nodos da árvore.
	public Iterable<Position<T>> positions() {
		PositionList<Position<T>> positions = new NodePositionList<Position<T>>();
		if (size != 0)
			preorderPositions(root(), positions);
		return positions;
	}

	// Retorna um iterator dos elementos armazenados nos nodos
	public Iterator<T> iterator() {
		Iterable<Position<T>> positions = positions();
		PositionList<T> elements = new NodePositionList<T>();
		for (Position<T> pos : positions)
			elements.addLast(pos.element());
		return elements.iterator();
	}

	// Troca o elemento de um nodo
	public T replace(Position<T> v, T o) throws InvalidPositionException {
		TreePosition<T> vv = checkPosition(v);
		T temp = v.element();
		vv.setElement(o);
		return temp;
	}

	// Métodos de atualização adicionais
	// Adiciona um nodo raíz para uma árvore vazia
	public TreePosition<T> addRoot(T e) throws NonEmptyTreeException {
		if (!isEmpty())
			throw new NonEmptyTreeException("Tree already has a root");
		size = 1;
		root = createNode(e, null, null);
		return root;
	}

	// Troca os elementos de dos nodos
	public void swapElements(Position<T> v, Position<T> w) throws InvalidPositionException {
		TreePosition<T> vv = checkPosition(v);
		TreePosition<T> ww = checkPosition(w);
		T temp = w.element();
		ww.setElement(v.element());
		vv.setElement(temp);
	}

	// Métodos auxiliares
	// Se v é um bom nodo da árvore, cast para TreePosition, caso contrário, lança
	// exceção
	protected TreePosition<T> checkPosition(Position<T> v) throws InvalidPositionException {
		if (v == null || !(v instanceof TreePosition))
			throw new InvalidPositionException("The position is invalid");
		return (TreePosition<T>) v;
	}

	// Cria um novo nodo da árvore
	protected TreePosition<T> createNode(T element, TreePosition<T> parent, PositionList<Position<T>> children) {
		return new TreeNode<T>(element, parent, children);
	}

	// Cria uma lista armazenando os nodos das subárvore de um nodo
	// ordenado de acordo com a travessia das subárvores
	protected void preorderPositions(Position<T> v, PositionList<Position<T>> pos) throws InvalidPositionException {
		pos.addLast(v);
		if (children(v) != null)
			for (Position<T> w : children(v))
				preorderPositions(w, pos);
	}

	public String toString() {
		return toString(this);
	}

	public <E> String toString(LinkedTree<E> T) {
//		String s = "";
//		for (E i : T) {
//			s += ", " + i;
//		}
//		s = (s.length() == 0 ? s : s.substring(2));
//		return "[" + s + "]";
		return this.parentheticRepresentation(this, root);
//		String s = "";
//		for (E i : T) { s += ", " + i; }
//		s = (s.length() == 0 ? s : s.substring(2));
//		return "[" + s + "]";
	}

	// depth
	public int depth(Tree<T> T, Position<T> v) {
		if (T.isRoot(v))
			return 0;
		else {
			Position<T> w = ((TreeNode<T>) v).getParent();
			return 1 + depth(T, w);
		}
	}

	// height1

	public int Max(int x, int y) {
		return x > y ? x : y;
	}

	public int height1(Tree<T> T) {
		int h = 0;
		for (Position<T> v : positions()) {
			if (isExternal(v))
				h = Max(h, depth(T, v));
		}
		return h;
	}

	// height2
	public int height2(Tree<T> T, Position<T> v) {
		if (isExternal(v))
			return 0;
		else {
			int h = 0;
			for (Position<T> w : children(v))
				h = Max(h, height2(T, w));
			return 1 + h;
		}
	}

	// parentheticRepresentation
	public String parentheticRepresentation(Tree<T> T, Position<T> v) {
		if (v == null)
			return "()";
		String s = "\"" + v.element().toString() + "\"";
		String tabs = "";
		int contTabs = depth(T, v);
		if (T.isInternal(v)) {
			Boolean firstTime = true;
			for (Position<T> w : T.children(v)) {
				if (firstTime) {
					for (int i = 0; i <= contTabs; i++) {
						tabs += " ";
					}
					s += ": {\n" + tabs + parentheticRepresentation(T, w);
					firstTime = false;
				} else {
					s += ",\n" + tabs + parentheticRepresentation(T, w);
				}
			}
			if (!firstTime)
				s += "\n" + tabs.substring(0, tabs.length() - 1) + "}";
		}
		return s;
	}

	// Aumenta o tamanho com base na adição de um filho
	public void increaseSize() {
		this.size += 1;
	}
}