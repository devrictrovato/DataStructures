package com.types.structures;

import java.util.Comparator;

import com.types.exceptions.DefaultComparator;
import com.types.exceptions.EmptyPriorityQueueException;
import com.types.exceptions.InvalidKeyException;
import com.types.interfaces.Entry;
import com.types.interfaces.Position;
import com.types.interfaces.PositionList;
import com.types.interfaces.PriorityQueue;

public class SortedListPriorityQueue<K, V> implements PriorityQueue<K, V> {

	protected PositionList<Entry<K, V>> entries;

	protected Comparator<K> compa;

	protected Position<Entry<K, V>> actionPos; // variable used by subclasses

	// Classe Entradas interna
	protected static class MyEntry<K, V> implements Entry<K, V> {

		protected K k; // key

		protected V v; // value

		public MyEntry(K key, V value) {
			k = key;
			v = value;
		}
		
		// methods of the Entry interface
		public K getKey() {
			return k;
		}

		public V getValue() {
			return v;
		}

		public String toString() {
			return "(" + k + "," + v + ")";
		}
	}

	// Cria a fila de prioridades com o comparador padrão
	public SortedListPriorityQueue() {
		entries = new NodePositionList<Entry<K, V>>();
		compa = new DefaultComparator<K>();
	}

	// Cria a fila de prioridades com um comparador informado
	public SortedListPriorityQueue(Comparator<K> comp) {
		entries = new NodePositionList<Entry<K, V>>();
		compa = comp;
	}

	// Cria a fila de prioridade com um comparador informado e lista.
	// Assume-se que a lista é ordenada em ordem não-decrescente
	public SortedListPriorityQueue(PositionList<Entry<K, V>> list, Comparator<K> comp) {
		entries = list;
		compa = comp;
	}

	// Configura o comparador para a fila de prioridade.
	//* @throws IllegalStateException se fila de prioridade estiver vazia
	public void setComparator(Comparator<K> comp) throws IllegalStateException {
		// só é permitido se a fila de prioridade estiver vazia
		if (!isEmpty())
			throw new IllegalStateException("Priority queue is not empty");
		compa = comp;
	}
	
	// Retorna o número de elementos da fila de propridade
	public int size() {
		return entries.size();
	}

	// Retorna se a fila de prioridade está vazia.
	public boolean isEmpty() {
		return entries.isEmpty();
	}

	// Retorna mas não remove uma entrada com a chave mínima.
	public Entry<K, V> min() throws EmptyPriorityQueueException {
		if (entries.isEmpty())
			throw new EmptyPriorityQueueException("priority queue is empty");
		else
			return entries.first().element();
	}

	// Insere um par chave-valor e retorna a entrada criada.
	public Entry<K, V> insert(K k, V v) throws InvalidKeyException {
		checkKey(k); // auxiliary key-checking method (could throw exception)
		Entry<K, V> entry = new MyEntry<K, V>(k, v);
		insertEntry(entry); // auxiliary insertion method
		return entry;
	}

	// Método auxiliar usado para inserção.
	protected void insertEntry(Entry<K, V> e) {
		if (entries.isEmpty()) {
			entries.addFirst(e); // insere na lista vazia
			actionPos = entries.first(); // posição de inserção
		} else if (compa.compare(e.getKey(), entries.last().element().getKey()) > 0) {
			entries.addLast(e); // insere no final da lista
			actionPos = entries.last(); // posição de inserção
		} else {
			Position<Entry<K, V>> curr = entries.first();
			while (compa.compare(e.getKey(), curr.element().getKey()) > 0) {
				curr = entries.next(curr); // avança para encontrar a posição de inserção
			}
			entries.addBefore(curr, e);
			actionPos = entries.prev(curr); // posição de inserção
		}
	}

	// Remove e returna uma entrada com a a menor chave.
	public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
		if (entries.isEmpty())
			throw new EmptyPriorityQueueException("priority queue is empty");
		else
			return entries.remove(entries.first());
	}

	// Determina se a chave é válida.
	protected boolean checkKey(K key) throws InvalidKeyException {
		boolean result;
		try { // verifica se a chave pode ser comparada
			result = (compa.compare(key, key) == 0);
		} catch (ClassCastException e) {
			throw new InvalidKeyException("key cannot be compared");
		}
		return result;
	}

	// Sebrescreve toString, útil para a depuração.
	public String toString() {
		return entries.toString();
	}
}