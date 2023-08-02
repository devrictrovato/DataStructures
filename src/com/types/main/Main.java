package com.types.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.types.interfaces.IRender;
import com.types.panels.Menu;

public class Main extends JFrame implements IRender {

	// ID da janela
	private static final long serialVersionUID = 7820860139321930055L;
	
	// Tamanho da janela
	public static Dimension SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	
	// Componentes
	public static JFrame mainFrame;
	public static JPanel menu;
	private ImageIcon icon = new ImageIcon("res/dsicon.png");

	// Construtor
	public Main(String title) throws HeadlessException {
		renderComponents();
		init();
	}
	
	// Renderizador
	public void renderComponents() {
		menu = new Menu("gif_frame.gif");
		add(menu);
	}

	// Inicializando janela
	public void init() {
		setPreferredSize(SIZE);
		setIconImage(icon.getImage());
		setTitle("Estrutura de Dados - Java");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		getContentPane().setBackground(new Color(0, 155, 119));
		requestFocus();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	// Executar a janela
	public static void main(String[] args) {
		mainFrame = new Main("Estrutura de dados");
	}
}