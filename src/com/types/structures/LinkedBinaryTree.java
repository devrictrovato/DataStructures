package com.types.structures;

import java.util.Iterator;

import com.types.exceptions.BoundaryViolationException;
import com.types.exceptions.EmptyTreeException;
import com.types.exceptions.InvalidPositionException;
import com.types.exceptions.NonEmptyTreeException;
import com.types.interfaces.BTPosition;
import com.types.interfaces.BinaryTree;
import com.types.interfaces.Position;
import com.types.interfaces.PositionList;
import com.types.nodes.BTNode;
import com.types.util.BinaryPrinter;

//* Implementação da interface BinaryTree usando uma estrutura encadeada.

public class LinkedBinaryTree<T> implements BinaryTree<T> {

	protected BTPosition<T> root; // referência para a raiz

	protected int size; // número de nodos

	// Cria uma árvore binária vazia.
	public LinkedBinaryTree() {
		root = null; // inicia com uma árvore vazia
		size = 0;
	}

	// Retorna o número de nodos da árvore.
	public int size() {
		return size;
	}

	// Retorna se um nodo é interno.
	public boolean isInternal(Position<T> v) throws InvalidPositionException {
		checkPosition(v); // Método auxiliar
		return (hasLeft(v) || hasRight(v));

	}

	// Retorna se um nodo é a raiz.
	public boolean isRoot(Position<T> v) throws InvalidPositionException {
		checkPosition(v);
		return (v == root());
	}

	// Retorna se um nodo tem o filho da esquerda.
	public boolean hasLeft(Position<T> v) throws InvalidPositionException {
		BTPosition<T> vv = checkPosition(v);
		return (vv.getLeft() != null);
	}

	// Retorna a raiz da árvore.
	public Position<T> root() throws EmptyTreeException {
		if (root == null) throw new EmptyTreeException("The tree is empty");
		return root;
	}

	// Retorna o filho da esquerda de um nodo.
	public Position<T> left(Position<T> v) throws InvalidPositionException, BoundaryViolationException {
		BTPosition<T> vv = checkPosition(v);
		Position<T> leftPos = (Position<T>) vv.getLeft();
		if (leftPos == null)
			throw new BoundaryViolationException("No left child");
		return leftPos;
	}

	// Retorna o pai de um nodo.
	public Position<T> parent(Position<T> v) throws InvalidPositionException, BoundaryViolationException {
		BTPosition<T> vv = checkPosition(v);
		Position<T> parentPos = (Position<T>) vv.getParent();
		if (parentPos == null)
			throw new BoundaryViolationException("No parent");
		return parentPos;
	}

	// Retorna uma coleção iterável contendo os filhos de um nodo.
	public Iterable<Position<T>> children(Position<T> v) throws InvalidPositionException {
		PositionList<Position<T>> children = new NodePositionList<Position<T>>();
		if (hasLeft(v))
			children.addLast(left(v));
		if (hasRight(v))
			children.addLast(right(v));
		return children;
	}

	// Retorna uma coleção iterável (inorder) contendo os nodos da árvore.
	public Iterable<Position<T>> positionsInorder() {
		PositionList<Position<T>> positions = new NodePositionList<Position<T>>();
		if (size != 0)
			inorderPositions(root(), positions); // atribui as posições usando caminhamento prefixado
		return positions;
	}

	protected void inorderPositions(Position<T> v, PositionList<Position<T>> pos) {
		if (hasLeft(v))
			inorderPositions(left(v), pos);
		pos.addLast(v);
		if (hasRight(v))
			inorderPositions(right(v), pos);
	}
	

	// Retorna uma coleção iterável (desorder) contendo os nodos da árvore.
	public Iterable<Position<T>> positionsDesorder() {
		PositionList<Position<T>> positions = new NodePositionList<Position<T>>();
		if (size != 0)
			desorderPositions(root(), positions); // atribui as posições usando caminhamento prefixado
		return positions;
	}

	protected void desorderPositions(Position<T> v, PositionList<Position<T>> pos) {
		if (hasRight(v))
			inorderPositions(right(v), pos);
		pos.addLast(v);
		if (hasLeft(v))
			inorderPositions(left(v), pos);
	}

	// Retorna uma coleção iterável contendo os nodos da árvore.
	public Iterable<Position<T>> positions() {
		PositionList<Position<T>> positions = new NodePositionList<Position<T>>();
		if (size != 0)
			preorderPositions(root(), positions); // atribui as posiçães usando caminhamento prefixado
		return positions;
	}

	// Retorna um iterador sobre os elementos armazenados nos nodos
	public Iterator<T> iterator() {
		Iterable<Position<T>> positions = positions();
		PositionList<T> elements = new NodePositionList<T>();
		for (Position<T> pos : positions)
			elements.addLast(pos.element());
		return elements.iterator(); // Um iterador sobre os elementos
	}

	// Substitui o elemento armazenado no nodo.
	public T replace(Position<T> v, T o) throws InvalidPositionException {
		BTPosition<T> vv = checkPosition(v);
		T temp = v.element();
		vv.setElement(o);
		return temp;
	}

	// Método de acesso adicional
	// Retorna o irmão de um nodo
	public Position<T> sibling(Position<T> v) throws InvalidPositionException, BoundaryViolationException {
		BTPosition<T> vv = checkPosition(v);
		BTPosition<T> parentPos = vv.getParent();
		if (parentPos != null) {
			BTPosition<T> sibPos;
			BTPosition<T> leftPos = parentPos.getLeft();
			if (leftPos == vv)
				sibPos = parentPos.getRight();
			else
				sibPos = parentPos.getLeft();
			if (sibPos != null)
				return sibPos;
		}
		throw new BoundaryViolationException("No sibling");
	}

	// Métodos de acesso adicionais
	// Insere a raiz em uma árvore vazia
	public Position<T> addRoot(T e) throws NonEmptyTreeException {
		if (!isEmpty())
			throw new NonEmptyTreeException("Tree already has a root");
		size = 1;
		root = createNode(e, null, null, null);
		return root;
	}

	// Insere o filho da esquerda em um nodo.
	public Position<T> insertLeft(Position<T> v, T e) throws InvalidPositionException {
		BTPosition<T> vv = checkPosition(v);
		Position<T> leftPos = (Position<T>) vv.getLeft();
		if (leftPos != null)
			throw new InvalidPositionException("Node already has a left child");
		BTPosition<T> ww = createNode(e, vv, null, null);
		vv.setLeft(ww);
		size++;
		return ww;
	}

	// Insere o filho da direita em um nodo.
	public Position<T> insertRight(Position<T> v, T e) throws InvalidPositionException {
		BTPosition<T> vv = checkPosition(v);
		Position<T> rightPos = (Position<T>) vv.getRight();
		if (rightPos != null)
			throw new InvalidPositionException("Node already has a right child");
		BTPosition<T> ww = createNode(e, vv, null, null);
		vv.setRight(ww);
		size++;
		return ww;
	}

	// Remove um nodo com zero ou um filho.
	public T remove(Position<T> v) throws InvalidPositionException {
		BTPosition<T> vv = checkPosition(v);
		BTPosition<T> leftPos = vv.getLeft();
		BTPosition<T> rightPos = vv.getRight();
		if (leftPos != null && rightPos != null)
			throw new InvalidPositionException("Cannot remove node with two children");
		BTPosition<T> ww; // o único filho de v, se houver
		if (leftPos != null)
			ww = leftPos;
		else if (rightPos != null)
			ww = rightPos;
		else // v é folha
			ww = null;
		if (vv == root) { // v é a raiz
			if (ww != null)
				ww.setParent(null);
			root = ww;
		} else { // v não é a raiz
			BTPosition<T> uu = vv.getParent();
			if (vv == uu.getLeft())
				uu.setLeft(ww);
			else
				uu.setRight(ww);
			if (ww != null)
				ww.setParent(uu);
		}
		size--;
		return v.element();
	}

	// Conecta duas árvores para serem subárvores de um nodo externo.
	public void attach(Position<T> v, LinkedBinaryTree<T> T1, LinkedBinaryTree<T> T2) throws InvalidPositionException {
		BTPosition<T> vv = checkPosition(v);
		if (isInternal(v))
			throw new InvalidPositionException("Cannot attach from internal node");

		if (!T1.isEmpty()) {
			BTPosition<T> r1 = checkPosition(T1.root());
			vv.setLeft(r1);
			r1.setParent(vv); // T1 deve ser invalidada
		}

		if (!T2.isEmpty()) {
			BTPosition<T> r2 = checkPosition(T2.root());
			vv.setRight(r2);
			r2.setParent(vv); // T2 deve ser invalidada
		}
	}

	// Se v é um nodo de árvore binária, converte para BTPosition, caso contrário
	// lança exceção
	protected BTPosition<T> checkPosition(Position<T> v) throws InvalidPositionException {
		if (v == null || !(v instanceof BTPosition))
			throw new InvalidPositionException("The position is invalid");
		return (BTPosition<T>) v;
	}

	// Cria um novo nodo de árvore binária
	protected BTPosition<T> createNode(T element, BTPosition<T> parent, BTPosition<T> left, BTPosition<T> right) {
		return new BTNode<T>(element, parent, left, right);
	}

	// Cria uma lista que armazena os nodos da subárvore de um nodo ordenados de
	// acordo com o
	// caminhamento prefixado da subárvore.
	protected void preorderPositions(Position<T> v, PositionList<Position<T>> pos) throws InvalidPositionException {
		pos.addLast(v);
		if (hasLeft(v))
			preorderPositions(left(v), pos); // recursão sobre o filho da esquerda
		if (hasRight(v))
			preorderPositions(right(v), pos); // recursão sobre o filho da direita
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public boolean isExternal(Position<T> v) throws InvalidPositionException {
		return !isInternal(v);
	}

	public Position<T> right(Position<T> v) throws InvalidPositionException, BoundaryViolationException {
		BTPosition<T> vv = checkPosition(v);
		Position<T> rightPos = (Position<T>) vv.getRight();
		if (rightPos == null)
			throw new BoundaryViolationException("No right child");
		return rightPos;
	}

	public boolean hasRight(Position<T> v) throws InvalidPositionException {
		BTPosition<T> vv = checkPosition(v);
		return (vv.getRight() != null);
	}

	// 5. b) binaryPreorder conforme slide 31.
	public void binaryPreorder(LinkedBinaryTree<T> T, BTNode<T> v) {
		BTNode<T> temp = (BTNode<T>) this.checkPosition(v);
		// Saída dos dados
		String s = temp.element().toString();
		System.out.print(s);
		if (this.hasLeft(temp)) {
			binaryPreorder(T, (BTNode<T>) temp.getLeft());
		}
		if (this.hasRight(temp)) {
			binaryPreorder(T, (BTNode<T>) temp.getRight());
		}
	}

	// 5. c) binaryPostorder conforme slide 32.
	public void binaryPostorder(LinkedBinaryTree<T> T, BTNode<T> v) {
		if (this.hasLeft(v)) {
			binaryPostorder(T, (BTNode<T>) v.getLeft());
		}
		if (this.hasRight(v)) {
			binaryPostorder(T, (BTNode<T>) v.getRight());
		}
		BTNode<T> temp = (BTNode<T>) this.checkPosition(v);
		// Saída dos dados
		String s = temp.element().toString();
		System.out.print(s);
	}

	// 5. e) inorder conforme slide 43.
	public void inorder(LinkedBinaryTree<T> T, BTNode<T> v) {
		if (T.hasLeft(v)) {
			inorder(T, (BTNode<T>) v.getLeft());
		}
		BTNode<T> temp = (BTNode<T>) this.checkPosition(v);
		System.out.print(temp.element().toString());
		if (T.hasRight(v)) {
			inorder(T, (BTNode<T>) v.getRight());
		}
	}

	// 5. f) makerBTSearch e exiba o seu caminhamento inorder conforme slide 45.
	public void makerBTSearch(LinkedBinaryTree<T> T, Position<T> v) {
		String s = "";
		for (Position<T> i : positionsInorder()) {
			s += i.element().toString() + ", ";
		}
		System.out.println(s.substring(0, s.length() - 2));
	}

	// 5. g) Método que desenhe a árvore binária de expressão conforme slide 47.
	protected int toDraw(T m[][], Position<T> v, int lin, int col) {
		if (hasLeft(v))
			col = toDraw(m, left(v), lin + 1, col);
		m[lin][col] = v.element();
		col += 1;
		if (hasRight(v))
			col = toDraw(m, right(v), lin + 1, col);
		return col;
	}
	
	// Max
	public int Max(int x, int y) {
		return x > y ? x : y;
	}

	// height
	public int height(LinkedBinaryTree<T> T, Position<T> v) {
		if (isExternal(v))
			return 0;
		else {
			int h = 0;
			for (Position<T> w : children(v))
				h = Max(h, height(T, w));
			return 1 + h;
		}
	}
	
	// Desenha a árvore. (exercício 5 letra g)
	public String drawBinaryTree(LinkedBinaryTree<T> a, Position<T> p) {
		if (isEmpty())
			return "";
			
		@SuppressWarnings("unchecked")
		T[][] m = (T[][]) new Object[height(a, p) + 1][a.size()];

		toDraw(m, a.root(), 0, 0);

		String s = "";
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (m[i][j] == null)
					s += "		";
				else
					s += m[i][j] + "";
			}
			s += "\n";
		}
		return s.substring(0, s.length() - 1);
	}
	
	public String toString() {
		return BinaryPrinter.traversePreOrder(root);
	}

	// 5. h) eulerTour conforme slide 51.
	public void eulerTour(LinkedBinaryTree<T> T, BTNode<T> v) {
		BTNode<T> l = (BTNode<T>) this.checkPosition(v);
		System.out.print(l.element().toString());
		if (T.hasLeft(l)) {
			eulerTour(T, (BTNode<T>) v.getLeft());
		}
		BTNode<T> d = (BTNode<T>) this.checkPosition(v);
		System.out.print(d.element().toString());
		if (T.hasRight(d)) {
			eulerTour(T, (BTNode<T>) v.getRight());
		}
		BTNode<T> r = (BTNode<T>) this.checkPosition(v);
		System.out.print(r.element().toString());
	}

	// 5. i) printExpression conforme slide 53.
	public void printExpression(LinkedBinaryTree<T> T, Position<T> v) {
		if (T.isInternal(v))
			System.out.print("(");
		if (T.hasLeft(v))
			printExpression(T, T.left(v));
		if (T.isInternal(v))
			System.out.print(v.element().toString());
		else
			System.out.print(v.element().toString());
		if (T.hasRight(v))
			printExpression(T, T.right(v));
		if (T.isInternal(v))
			System.out.print(")");
	}

	// 5. j) Método para contar os nodos esquerdos e externos de uma árvore binária.
	public int countLeftExternalNodes(LinkedBinaryTree<T> T) {
		int c = 0;
		for (Position<T> temp : positionsInorder()) {
			if (T.isRoot(temp))
				break;
			if (T.isExternal(temp))
				c++;
		}
		return c;
	}

	// 5. k) Método para contar os nodos direitos e externos de uma árvore binária.
	public int countRightExternalNodes(LinkedBinaryTree<T> T) {
		int c = 0;
		for (Position<T> temp : positionsDesorder()) {
			if (T.isRoot(temp))
				break;
			if (T.isExternal(temp))
				c++;
		}
		return c;
	}
}
