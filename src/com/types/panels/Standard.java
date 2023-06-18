package com.types.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.types.interfaces.IRender;
import com.types.main.Main;
import com.types.util.Tables;

public abstract class Standard extends JPanel implements IRender {

	// ID da janela
	private static final long serialVersionUID = 4531711490629253031L;

	// Layout para renderização
	protected Layout layout = new Layout();

	// Botões na coluna lateral
	protected static JButton insertButton;
	protected static JButton remotionButton;
	protected static JButton viewButton;
	protected static JButton backButton;

	// Tabelas da coluna lateral
	protected Tables tables;

	// Entradas
	protected Entry insertEntry;
	protected Entry removeEntry;

	// Metodo de adição dos components na coluna lateral
	protected void createLateralComponent(Component c, JPanel lateral) {
		defaultLayout();
		if (c instanceof JButton) {
			Styles.setStyleButtonLateral((JButton) c);
			lateral.add(c, layout);
		}
		else if (c instanceof JTable) {
			layout.weighty = 1;
			JScrollPane scroll = new JScrollPane(c);
			Styles.setStyleScrollPanel(scroll);
			Styles.setStyleTable((JTable) c);
			scroll.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			lateral.add(scroll, layout);
		}
	}

	// Renderizando da coluna lateral
	protected void generateLateral(boolean renderAll) {
		if (renderAll) {
			JPanel lateral = new JPanel(new GridBagLayout());

			if (insertButton != null) {
				createLateralComponent(insertButton, lateral);				
				createLateralComponent(tables.getInsertTable(), lateral);
			}
			if (remotionButton != null) {
				createLateralComponent(remotionButton, lateral);
				createLateralComponent(tables.getRemoveTable(), lateral);
			}
			if (viewButton != null) {				
				createLateralComponent(viewButton, lateral);
				createLateralComponent(tables.getViewTable(), lateral);
			}
			layout.insets = new Insets(0, 0, 0, 0);
			createLateralComponent(backButton, lateral);
			layout.insets = new Insets(0, 0, 0, 0);
			add(lateral, layout);
		} else {
			layout.setConstraints(0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			Styles.setStyleButtonLateral(backButton);
			add(backButton, layout);
		}
	}
	
	protected void defaultLayout() {
		layout.setConstraints(GridBagConstraints.RELATIVE, GridBagConstraints.RELATIVE, 
				1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		layout.gridwidth = GridBagConstraints.REMAINDER;
		layout.weightx = 1;
		layout.weighty = 0;
	}

	// Inicilizar os botões
	protected void instanceButton() {
		insertButton = new JButton("Inserir");
		remotionButton = new JButton("Remover");
		viewButton = new JButton("Visualizar");
		backButton = new JButton("Voltar");
	}

	// Eventos ao clicar
	protected void buttonEvents(Object tad) {
		// Evento para voltar ao menu
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Main.menu.setVisible(true);
			}
		});

		// Evento de inserção
		if (insertButton != null) {
			insertButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonStatus(false);
					insertEntry = insertEntry();
					insertEvent();
				}
			});
		}

		// Evento de remoção
		if (remotionButton != null) {
			remotionButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonStatus(false);
					removeEntry = removeEntry();
					removeEvent();
				}
			});
		}

		// Evento de mostrar o TAD
		if (viewButton != null) {
			viewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tables.getViewModel().addRow(new Object[] { tad.toString() });
				}
			});
		}
	}
	
	// Habilitar/Desabilitar botões
	public static void buttonStatus(boolean status) {
		if (insertButton != null) insertButton.setEnabled(status);
		if (remotionButton != null) remotionButton.setEnabled(status);
		if (viewButton != null) viewButton.setEnabled(status);
		backButton.setEnabled(status);
	}

	// Inicializando janela
	public void init() {
		setBackground(new Color(52, 123, 152));
		setLayout(new GridBagLayout());
		setVisible(true);
	}

	// Renderização padrão
	public void renderComponents() {
		generateLateral(true);
	}

	// Para renderizar os erros
	protected void showError(String msg) {
		JOptionPane optionPane = new JOptionPane(msg, JOptionPane.ERROR_MESSAGE);
		JDialog dialog = optionPane.createDialog("Erro");
		dialog.setAlwaysOnTop(true);
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}

	// Para implementar as entradas
	protected abstract Entry insertEntry();

	protected abstract Entry removeEntry();

	// Para implementar os eventos
	protected abstract void insertEvent();

	protected abstract void removeEvent();

}
