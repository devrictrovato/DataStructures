package com.types.structures;

import com.types.exceptions.EmptyQueueException;
import com.types.exceptions.FullQueueException;
import com.types.interfaces.Queue;

public class ArrayQueue<T> implements Queue<T> {

	private int f, r, N;
	private T[] Q;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		f = r = 0;
		N = 1000;
		Q = (T[]) new Object[N];
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int cap) {
		f = r = 0;
		N = cap;
		Q = (T[]) new Object[N];
	}
	
	@Override
	public int size() {
		return (N - f + r) % N;
	}

	@Override
	public boolean isEmpty() {
		return f == r;
	}

	@Override
	public T front() throws EmptyQueueException {
		if (isEmpty()) throw new EmptyQueueException("Queue is empty");
		return Q[f];
	}

	@Override
	public void enqueue(T element) {
		if (size() == N - 1) throw new FullQueueException("Queue is full");
		Q[r] = element;
		r = (r + 1) % N;
	}

	@Override
	public T dequeue() throws EmptyQueueException {
		if (isEmpty()) throw new EmptyQueueException("Queue is empty");
		T temp = Q[f];
		Q[f] = null;
		f = (f + 1) % N;
		return temp;
	}
	
	public String toString() {
		String s;
		s = "(";
		if (size() > 0) s += Q[f];
		if (size() > 1) {
			for (int i = 1; i < size(); i++) {
				s += ", " + Q[(f + i) % N];
			}
		}
		return s + ")";
	}

}
