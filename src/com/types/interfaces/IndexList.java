package com.types.interfaces;

public interface IndexList<T> {

	public int size();
	public boolean isEmpty();
	public void add(int i, T e) throws IndexOutOfBoundsException;
	public T get(int i) throws IndexOutOfBoundsException;
	public T remove(int i) throws IndexOutOfBoundsException;
	public T set(int i, T e) throws IndexOutOfBoundsException;

}