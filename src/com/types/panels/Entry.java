package com.types.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.types.design.Styles;
import com.types.interfaces.IRender;
import com.types.main.Layout;
import com.types.main.Main;

public class Entry extends JFrame implements IRender {

	// ID da janela
	private static final long serialVersionUID = 6352282748933539700L;

	// Painel da entrada
	private JPanel panel;
	
	// Components da entrada
	private JComponent[] components;

	// Opção padrão das entradas
	private JButton cancel;
	private JButton send;

	// Layout padrão
	private Layout layout;

	// Contrutor
	public Entry(JComponent[] components) {
		this.components = components;
		initPanel();
		renderComponents();
		buttonEvents();
		init();
	}

	// Inicializando janela
	public void init() {
		setPreferredSize(new Dimension(Main.SIZE.width / 3, Main.SIZE.height / 3));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setUndecorated(true);
		getContentPane().setBackground(new Color(0, 155, 119));
		requestFocus();
		setAlwaysOnTop(true);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	// Renderização padrão
	public void renderComponents() {
		cancel = new JButton("Cancelar");
		send = new JButton("Enviar");

		layout.setConstraints(0, 0, 1, 1, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
		layout.weightx = layout.weighty = 1;
		layout.insets = new Insets(0, 10, 0, 10);

		// Renderizando textos para os componentes
		for (JComponent comp : components) {
			JLabel label = new JLabel(comp.getName());
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setLabelFor(comp);
			Styles.setStyleLabel(label);
			
			panel.add(label, layout);
			layout.gridy += 1;
		}

		layout.gridy = 0;
		layout.gridx = 1;

		// Renderizando os componentes
		for (JComponent comp : components) {
			if (comp instanceof JTextField)
				Styles.setStyleField((JTextField) comp);
			panel.add(comp, layout);
			layout.gridy += 1;
		}

		// Renderizando botões
		layout.gridx = 0;
		Styles.setStyleButton(cancel);
		panel.add(cancel, layout);
		layout.gridx = 1;
		Styles.setStyleButton(send);
		panel.add(send, layout);

		add(panel);
	}

	// Eventos de click
	protected void buttonEvents() {
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				StandartPanel.buttonStatus(true); 
				dispose(); 
			} 
		});
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StandartPanel.buttonStatus(true);
				for (JComponent comp : components) {
					if (comp instanceof JTextField) ((JTextField) comp).setText("");
				}
			}
		});
	}

	// Instanciando painel
	private void initPanel() {
		layout = new Layout();
		panel = new JPanel(new GridBagLayout());
		Styles.setStyleModelPanel(panel);
	}
	
	// Get send button
	public JButton getSend() {
		return send;
	}

}
