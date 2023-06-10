package com.types.panels.managments;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

import com.types.panels.Entry;
import com.types.panels.StandartPanel;
import com.types.panels.UserEntries;
import com.types.structures.ArrayQueue;
import com.types.util.Descriptions;
import com.types.util.Tables;

public class ArrayQueuePanel extends StandartPanel {

	private static final long serialVersionUID = 7000372001620939944L;

	private ArrayQueue<Object> queue;

	private JTextField valueUser;
	
	public ArrayQueuePanel() {
		init();
		renderComponents();
	}

	public void renderComponents() {
		queue = new ArrayQueue<Object>();
		tables = new Tables(2);
		instanceButton();
		buttonEvents(queue);
		Descriptions.descriptionQueue(this);
		generateLateral(true);
		
		valueUser = UserEntries.createField("Adicionar:", 20, JTextField.CENTER, Object.class);
	}

	protected Entry insertEntry() {
		return new Entry(new JComponent[] { valueUser });
	}

	protected void insertEvent() {
		insertEntry.getSend().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					queue.enqueue(valueUser.getText());
					tables.getInsertModel().addRow(new Object[] { "enqueue(" + valueUser.getText() + ")", null });
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
			tables.getRemoveModel().addRow(new Object[] { "dequeue()", queue.dequeue() });
			buttonStatus(true);
		} catch (Exception ex) {
			buttonStatus(true);
			showError(ex.getMessage());
		}
	}

	protected Entry removeEntry() {
		return null;
	}
}
