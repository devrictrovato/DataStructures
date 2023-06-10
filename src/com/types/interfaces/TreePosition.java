package com.types.interfaces;

public interface TreePosition<T> extends Position<T> {

	// Define o elemento a ser armazenado nesta posição
	public void setElement(T o);

	// Retorna o elemento armazenado nesta posição
	public T getElement();

	// Retorna os filhos desta posição
	public PositionList<Position<T>> getChildren();

	// Define os filhos desta posição
	public void setChildren(PositionList<Position<T>> c);

	// Retorna o pai desta posição
	public TreePosition<T> getParent();

	// Define o pai desta posição
	public void setParent(TreePosition<T> v);

}
