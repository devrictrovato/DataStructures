package com.types.interfaces;

// Interface para entrada do par chave-valor.

public interface Entry<K, V> {

	// Retorna uma chave armazenada nesta entrada.
	
	public K getKey();
	
	// Retorna o valor armazenado nesta entrada.
	
	public V getValue();

}