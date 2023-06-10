package com.types.tads;

import java.util.Iterator;

import com.types.exceptions.BoundaryViolationException;
import com.types.exceptions.EmptyListException;
import com.types.exceptions.InvalidPositionException;
import com.types.interfaces.Position;
import com.types.interfaces.PositionList;
import com.types.nodes.DNode;
import com.types.util.ElementIterator;

public class NodePositionList<T> implements PositionList<T> {

	protected int numElts; // Número de elementos na lista
	protected DNode<T> header, trailer; // Sentinelas especiais
	
	// Construtor que cria uma lista vazia
	public NodePositionList() {
		numElts = 0;
		header = new DNode<T>(null, null, null); // cria a cabeça
		trailer = new DNode<T>(header, null, null); // cria a cauda
		header.setNext(trailer); // faz a cabeça e a cauda apontarem uma para a outra
	}
	
	// Verifica se a posição é válida para esta lista e a converte para DNode se for válida
	protected DNode<T> checkPosition(Position<T> p) throws InvalidPositionException {
		if (p == null) throw new InvalidPositionException("Null position passed to NodeList");
		if (p == header) throw new InvalidPositionException("The header node is not a valid position");
		if (p == trailer) throw new InvalidPositionException("The trailer node is not a valid position");
		try {
			DNode<T> temp = (DNode<T>) p;
			
			if ((temp.getPrev() == null) || (temp.getNext() == null))
				throw new InvalidPositionException("Position does not belong to a valid NodeList");
			
			return temp;
		} catch (ClassCastException e) { 
			throw new InvalidPositionException("Position is of wrong type for this list"); }
	}

	// Retorna a quantidade de elementos na lista
	public int size() {return numElts;}

	// Retorna quando a lista esta vazia
	public boolean isEmpty() { return (numElts == 0); }

	// Retorna a primeira posição da lista
	public Position<T> first() throws EmptyListException {
		if (isEmpty()) throw new EmptyListException("List is empty");
		return header.getNext();
	}

	// Retorna a posição que antecede a fornecida
	public Position<T> prev(Position<T> p) throws InvalidPositionException, BoundaryViolationException {
		DNode<T> v = checkPosition(p);
		DNode<T> prev = v.getPrev();
		if (prev == header) throw new BoundaryViolationException("Cannot advance past the beginning of the list");
		return prev;
	}

	// Insere o elemento antes da posição fornecida, retornando a nova posição
	public void addBefore(Position<T> p, T element) throws InvalidPositionException {
		DNode<T> v = checkPosition(p);
		numElts++;
		DNode<T> newNode = new DNode<T>(v.getPrev(), v, element);
		v.getPrev().setNext(newNode);
		v.setPrev(newNode);
	}

	// Insere o elemento dado no início da lista, retornando a nova posição
	public void addFirst(T element) {
		numElts++;
		DNode<T> newNode = new DNode<T>(header, header.getNext(), element);
		header.getNext().setPrev(newNode);
		header.setNext(newNode);
	}

	// Remove da lista a posição fornecida
	public T remove(Position<T> p) throws InvalidPositionException {
		DNode<T> v = checkPosition(p);
		numElts--;
		DNode<T> vPrev = v.getPrev();
		DNode<T> vNext = v.getNext();
		vPrev.setNext(vNext);
		vNext.setPrev(vPrev);
		T vElem = v.element();
		
		// Desconecta a posição da lista e marca-a como inválida
		v.setNext(null);
		v.setPrev(null);
		return vElem;
	}

	// Substitui o elemento da posição fornecida por um novo e retorna o elemento velho
	public T set(Position<T> p, T element) throws InvalidPositionException {
		DNode<T> v = checkPosition(p);
		T oldElt = v.element();
		v.setElement(element);
		return oldElt;
	}

	// Retorna o último nodo da lista.
	public Position<T> last() {
		if (isEmpty()) throw new EmptyListException("List is empty");
		return trailer.getPrev();
	}

	// Retorna o nodo que segue um dado nodo da lista.
	public Position<T> next(Position<T> p) throws InvalidPositionException, BoundaryViolationException {
		DNode<T> v = checkPosition(p);	
		DNode<T> next = v.getNext();
		if (next == trailer) throw new BoundaryViolationException("Cannot advance past the finaling of the list");
		return next;
	}

	// Insere um elemento na última posição, retornando uma posição nova.
	public void addLast(T e) {
		numElts++;
		DNode<T> newNode = new DNode<T>(trailer.getPrev(), trailer, e);
		trailer.getPrev().setNext(newNode);
		trailer.setPrev(newNode);
	}

	// Insere um elemento após um dado elemento da lista.
	public void addAfter(Position<T> p, T e) throws InvalidPositionException {
		DNode<T> v = checkPosition(p);
		numElts++;
		DNode<T> newNode = new DNode<T>(v, v.getNext(), e);
		v.getNext().setPrev(newNode);
		v.setNext(newNode);
	}

	// Retorna a representação textual de uma lista de nodos
	public static <E> String toString(PositionList<E> l) {
		String s = "";
		for (E i: l) { s += ", " + i; }
		s = (s.length() == 0 ? s : s.substring(2));
		return "[" + s + "]";
	}

	// Retorna o iterator a partir do ElemenIterator.
	public Iterator<T> iterator() { return new ElementIterator<T>(this); }
	
	public String toString() { return toString(this); }
}