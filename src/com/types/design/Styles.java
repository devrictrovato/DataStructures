package com.types.design;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import com.types.main.Main;
import com.types.panels.Menu;
import com.types.util.RoundedBorder;

/*
 * Estilos da aplicação
 */
public final class Styles {

	// Estilo dos botões do menu
	public static void setButtonMenu(JButton button) {
		button.setFont(new Font("Arial", Font.BOLD, 16));
		button.setPreferredSize(
				new Dimension(Main.SIZE.width / (Menu.texts.length / 4), Main.SIZE.height / Menu.texts.length));
		button.setBackground(new Color(91, 94, 166));
		button.setForeground(new Color(255, 255, 255));
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorder(new RoundedBorder(50));
		button.setBorderPainted(true);
	}

	// Cores TEMA - fundo
	public static Color colorTheme = new Color(81, 0, 148);
	public static Color colorThemeDark = new Color(59, 0, 107);
	public static Color colorThemeTooDark = new Color(38, 0, 69);
	public static Color colorThemeLight = new Color(115, 0, 209);
	public static Color colorThemeTooLight = new Color(221, 179, 255);
	
	// Cores TEMA - texto
	public static Color colorThemeTextLight = new Color(221, 179, 255);
	
	// Outras cores

	public static void setStyleTable(JTable table) {
		table.getTableHeader().setBackground(colorThemeTooLight);
		table.setBackground(colorTheme);
		table.setForeground(colorThemeTextLight);
		table.setGridColor(colorThemeTooDark);
	}

	// Estilo dos scrolls
	public static void setStyleScrollPanel(JScrollPane scroll) {
		scroll.getViewport().setBackground(colorThemeTooLight);
	}

	// Estilo dos de fundo dos paineis
	public static void setStyleModelPanel(JPanel panel) {
		panel.setBackground(colorTheme);
	}

	// Estilo dos botões
	public static void setStyleButton(JButton button) {
		button.setFont(new Font("Arial", Font.BOLD, Main.SIZE.height / 50)); // fonte
		button.setBackground(new Color(91, 94, 166)); // cor do botão
		button.setForeground(new Color(255, 255, 255)); // cor do texto
	}

	// Estilo dos botões laterais
	public static void setStyleButtonLateral(JButton button) {
		button.setFont(new Font("Impact", Font.PLAIN, Main.SIZE.height / 50)); // fonte
		button.setBackground(colorThemeDark); // cor do botão
		button.setForeground(colorThemeTextLight); // cor do texto
		button.setBorder(null);
	}

	// Estilo dos labels
	public static void setStyleLabel(JLabel label) {
		label.setFont(new Font("Arial", Font.BOLD, Main.SIZE.height / 60)); // fonte
		label.setForeground(colorThemeTextLight);
	}

	// Estilo dos campos
	public static void setStyleField(JTextField field) {
		field.setFont(new Font("Arial", Font.BOLD, Main.SIZE.height / 60)); // fonte
		field.setBorder(null);
		field.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	}

}
