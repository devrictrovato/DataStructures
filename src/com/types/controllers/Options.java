package com.types.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import com.types.main.Main;
import com.types.panels.managments.AVLTreeMapPanel;
import com.types.panels.managments.AboutPanel;
import com.types.panels.managments.ArrayIndexListPanel;
import com.types.panels.managments.ArrayQueuePanel;
import com.types.panels.managments.ArrayStackPanel;
import com.types.panels.managments.BinarySearchTreePanel;
import com.types.panels.managments.GraphPanel;
import com.types.panels.managments.HashTableMapPanel;
import com.types.panels.managments.HashTableMultiMapPanel;
import com.types.panels.managments.LinkedBinaryTreePanel;
import com.types.panels.managments.LinkedTreePanel;
import com.types.panels.managments.NodePositionListPanel;
import com.types.panels.managments.SortedListPriorityQueuePanel;

/*
 * Usado para controlar o direcionamento das respectivas janelas
 */
public class Options implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String option = (String)((JComponent) e.getSource()).getName();
		
		switch (option) {
			case "Arranjo": 
				disableMenu();
				Main.mainFrame.add(new ArrayIndexListPanel()); 
				break;
			case "Pilha": 
				disableMenu(); 
				Main.mainFrame.add(new ArrayStackPanel()); 
				break;
			case "Fila": 
				disableMenu(); 
				Main.mainFrame.add(new ArrayQueuePanel()); 
				break;
			case "Lista de Nodos": 
				disableMenu(); 
				Main.mainFrame.add(new NodePositionListPanel()); 
				break;
			case "Árvore Genérica": 
				disableMenu(); 
				Main.mainFrame.add(new LinkedTreePanel()); 
				break;
			case "Árvore Binária": 
				disableMenu(); 
				Main.mainFrame.add(new LinkedBinaryTreePanel()); 
				break;
			case "Fila de Prioridade": 
				disableMenu(); 
				Main.mainFrame.add(new SortedListPriorityQueuePanel()); 
				break;
			case "Mapa": 
				disableMenu(); 
				Main.mainFrame.add(new HashTableMapPanel()); 
				break;
			case "Dicionário": 
				disableMenu(); 
				Main.mainFrame.add(new HashTableMultiMapPanel()); 
				break;
			case "Mapa Ordenado (ABB)": 
				disableMenu(); 
				Main.mainFrame.add(new BinarySearchTreePanel()); 
				break;
			case "Mapa Ordenado (AVL)": 
				disableMenu(); 
				Main.mainFrame.add(new AVLTreeMapPanel()); 
				break;
			case "Grafos": 
				disableMenu(); 
				Main.mainFrame.add(new GraphPanel()); 
				break;
			case "Sobre":
				disableMenu(); 
				Main.mainFrame.add(new AboutPanel()); 
				break;
			case "Sair": 
				Main.mainFrame.dispose(); 
				break;
		}
	}
	
	// Desabilitar o menu principal
	private void disableMenu() {
		Main.menu.setVisible(false);
	}

}
