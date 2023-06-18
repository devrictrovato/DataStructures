package com.types.util;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.types.panels.Menu;
import com.types.panels.Styles;

/* 
 * Classe responsável por mostrar os TADs em funcionamento
 */
public class Tables implements TableCellRenderer {

	// Tabelas para cada operação
	private JTable insertTable;
	private JTable removeTable;
	private JTable viewTable;

	// Modelos para cada operação
	private DefaultTableModel insertModel;
	private DefaultTableModel removeModel;
	private DefaultTableModel viewModel;

	// Construtor
	public Tables(int option) {
		// Gerando cada modelo para a devida tabela
		insertModel = createModelTable(new String[] { "Entrada", "Saida" });
		removeModel = createModelTable(new String[] { "Entrada", "Saida" });
		viewModel = createModelTable(new String[] { Menu.texts[option] });

		// Instanciando as tabelas com base no modelo
		insertTable = new JTable(insertModel);
		if (Menu.texts[option] == "TAD-Árvore Genérica")
			removeTable = null;
		else
			removeTable = new JTable(removeModel);
		viewTable = new JTable(viewModel);

		setResizeTable(new JTable[] { this.insertTable, this.removeTable, this.viewTable });
	}

	// Gera o modelo da tabela com a quantidade de colunas
	@SuppressWarnings("serial")
	private DefaultTableModel createModelTable(Object[] columns) {
		return new DefaultTableModel(columns, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}

	// Seta as dimensões das tabelas
	private void setResizeTable(JTable[] tables) {
		for (JTable table : tables) {
			if (table != null) {
				table.getTableHeader().setReorderingAllowed(false);
				table.getTableHeader().setResizingAllowed(false);
				for (int i = 0; i < table.getColumnCount(); i++) {
					table.getColumnModel().getColumn(i).setCellRenderer(this);
				}
				table.getTableHeader().setDefaultRenderer(new HeaderRenderer());
			}
		}
	}

	/* Getters & Setters */
	public JTable getInsertTable() {
		return insertTable;
	}

	public JTable getRemoveTable() {
		return removeTable;
	}

	public JTable getViewTable() {
		return viewTable;
	}

	public DefaultTableModel getInsertModel() {
		return insertModel;
	}

	public DefaultTableModel getRemoveModel() {
		return removeModel;
	}

	public DefaultTableModel getViewModel() {
		return viewModel;
	}
	/* */

	// Renderizador modificado das celulas das tabelas
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		JTextArea text = new JTextArea();
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		
		text.setText(value == null ? "" : value.toString());
		text.setSize(table.getColumnModel().getColumn(column).getWidth(), table.getRowHeight(row));

		
		int preferredHeight = text.getPreferredSize().height;

		if (table.getRowHeight(row) != preferredHeight) {
			table.setRowHeight(row, preferredHeight + table.getIntercellSpacing().height);
		}
		
		table.setShowGrid(false);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		
		table.setGridColor(text.getForeground());
		if (isSelected) {
			text.setBackground(Styles.colorThemeTooDark);
			text.setForeground(Color.white);
		} else {
			text.setBackground(Styles.colorThemeDark);
			text.setForeground(Color.white);
		}
		return text;
	}
}
