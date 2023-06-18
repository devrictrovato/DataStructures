package com.types.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.types.interfaces.IRender;
import com.types.main.Main;
import com.types.main.Options;
import com.types.util.ImagePanel;

public class Menu extends ImagePanel implements IRender {

	// ID da janela
	private static final long serialVersionUID = -2293778474706031002L;
	
	// Layout para renderizando
	public Layout layout = new Layout();
	
	// Texto das opções
	public static final String[] texts = {
		"Arranjo",
		"Pilha",
		"Fila",
		"Lista de Nodos",
		"Árvore Genérica",
		"Árvore Binária",
		"Fila de Prioridade",
		"Mapa",
		"Dicionário",
		"Mapa Ordenado (ABB)",
		"Mapa Ordenado (AVL)",
		"Grafos"
	};
	
	// Construtor
	public Menu(String path) {
		super(path);
		init();
		renderComponents();
	}
	
	// Renderização padrão
	public void renderComponents() {
		createTitle();
		generateOptions();
	}
	
	// Inicializando janela
	public void init() {
		setBackground(Color.black);
		setLayout(new GridBagLayout());
		setVisible(true);
	}
	
	// Titulo do menu
	private void createTitle() {
		JLabel title = new JLabel("Estrutura de Dados");
		int fontSize = (Main.SIZE.width - Main.SIZE.height) / 10;
		title.setFont(new Font("Arial", Font.BOLD, fontSize));
		title.setForeground(Styles.colorThemeLight);
		title.setBorder(BorderFactory.createEmptyBorder(3, 0, 0, 0));
		layout.setConstraints(0, 0, 2, 1,
				GridBagConstraints.CENTER, GridBagConstraints.VERTICAL);
		layout.insets = new Insets(0, 0, 5 * texts.length, 0);
		add(title, layout);
	}
	
	// Geração dos botões
	private void generateOptions() {
		
		// Opções dos TADs
		for (int i = 0; i < texts.length / 2; i++) {			
			JButton button = new JButton(texts[i]);
			button.setName(texts[i]);
			button.addActionListener(new Options());
			Styles.setButtonMenu(button);
			layout.setConstraints(0, 5 * i + 1, 1, 1, 
					GridBagConstraints.CENTER, GridBagConstraints.VERTICAL);
			layout.insets = new Insets(10, 10, 10, 10);
			add(button, layout);
		}

		for (int i = 0; i < texts.length / 2; i++) {			
			JButton button = new JButton(texts[texts.length / 2 + i]);
			button.setName(texts[texts.length / 2 + i]);
			button.addActionListener(new Options());
			Styles.setButtonMenu(button);
			layout.setConstraints(1, 5 * i + 1, 1, 1,
					GridBagConstraints.CENTER, GridBagConstraints.VERTICAL);
			layout.insets = new Insets(10, 10, 10, 10);
			add(button, layout);
		}
		
		// Opção sobre o projeto
		JButton button = new JButton("Sobre");
		button.setName(button.getText());
		layout.setConstraints(0, 5 * texts.length, 1, 1, 
				GridBagConstraints.CENTER, GridBagConstraints.VERTICAL);
		Styles.setButtonMenu(button);
		layout.insets = new Insets(5 * texts.length, 0, 0, 0);
		button.addActionListener(new Options());
		add(button, layout);
		
		// Opção de sair
		button = new JButton("Sair");
		button.setName(button.getText());
		layout.setConstraints(1, 5 * texts.length, 1, 1, 
				GridBagConstraints.CENTER, GridBagConstraints.VERTICAL);
		Styles.setButtonMenu(button);
		layout.insets = new Insets(5 * texts.length, 0, 0, 0);
		button.addActionListener(new Options());
		add(button, layout);
	}
	
}
