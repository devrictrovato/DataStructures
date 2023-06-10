package com.types.util;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/*
 * Renderizador modificado do cabeçalho das tabelas
 */
@SuppressWarnings("serial")
public class HeaderRenderer extends JLabel implements TableCellRenderer {

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		setText(value.toString());
		setBorder(BorderFactory.createEmptyBorder());
		setHorizontalAlignment(CENTER);
		return this;
	}

}
