package com.types.panels.managments;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

import com.types.panels.Entry;
import com.types.panels.StandartPanel;
import com.types.panels.UserEntries;
import com.types.structures.ArrayStack;
import com.types.util.Descriptions;
import com.types.util.Tables;

public class ArrayStackPanel extends StandartPanel {

	private static final long serialVersionUID = -189390063017820972L;

	private ArrayStack<Object> stack;

	private JTextField valueUser;

	public ArrayStackPanel() {
		init();
		renderComponents();
	}

	public void renderComponents() {
		stack = new ArrayStack<Object>();
		tables = new Tables(1);
		instanceButton();
		buttonEvents(stack);
		Descriptions.descriptionStack(this);
		generateLateral(true);
		
		valueUser = UserEntries.createField("Empilhar:", 20, JTextField.CENTER, Object.class);
	}

	protected Entry insertEntry() {
		return new Entry(new JComponent[] { valueUser });
	}

	protected void insertEvent() {
		insertEntry.getSend().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					stack.push(valueUser.getText());
					tables.getInsertModel().addRow(
							new Object[] { "push(" + valueUser.getText()  + ")", null });
				} catch (Exception ex) {
					showError(ex.getMessage());
				} finally {
					buttonStatus(true);
					insertEntry.dispose();
				}
			}
		});
	}

	protected void removeEvent() {
		try {
			tables.getRemoveModel().addRow(new Object[] { "pop()", stack.pop() });
			buttonStatus(true);
		} catch (Exception ex) {
			showError(ex.getMessage());
		} finally {
			buttonStatus(true);
		}
	}

	protected Entry removeEntry() { return null; }
}
