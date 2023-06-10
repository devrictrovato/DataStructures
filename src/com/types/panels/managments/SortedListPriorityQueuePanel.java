package com.types.panels.managments;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

import com.types.panels.Entry;
import com.types.panels.StandartPanel;
import com.types.panels.UserEntries;
import com.types.structures.SortedListPriorityQueue;
import com.types.util.Descriptions;
import com.types.util.Tables;

public class SortedListPriorityQueuePanel extends StandartPanel {

	private static final long serialVersionUID = 4389064271814175535L;

	private SortedListPriorityQueue<Object, Object> priorityQueue;
	
	private JTextField keyUser, valueUser;
	
	public SortedListPriorityQueuePanel() {
		init();
		renderComponents();
	}
	
	public void renderComponents() {
		priorityQueue = new SortedListPriorityQueue<Object, Object>();
		tables = new Tables(6);
		instanceButton();
		buttonEvents(priorityQueue);
		Descriptions.descriptionPriorityQueue(this);
		generateLateral(true);
		
		keyUser = UserEntries.createField("Chave:", 20, JTextField.CENTER, Object.class);
		valueUser = UserEntries.createField("Valor:", 20, JTextField.CENTER, Object.class);
	}
	
	protected Entry insertEntry() {
		return new Entry(new JComponent[] { keyUser, valueUser });
	}

	protected Entry removeEntry() {
		return null;
	}

	protected void insertEvent() {
		insertEntry.getSend().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tables.getInsertModel()
							.addRow(new Object[] { 
									"insert(" + keyUser.getText() + ", " + 
											valueUser.getText() + ")", 
											priorityQueue.insert(keyUser.getText(), valueUser.getText()) });
				} catch(Exception ex) {
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
			buttonStatus(true);
			tables.getRemoveModel().addRow(new Object[] { "removeMin()", priorityQueue.removeMin() });
		} catch (Exception ex) {
			showError(ex.getMessage());
		} finally {
			buttonStatus(true);
		}
	}
	
}
