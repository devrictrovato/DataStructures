package com.types.panels.managments;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

import com.types.panels.Entry;
import com.types.panels.StandartPanel;
import com.types.panels.UserEntries;
import com.types.tads.ArrayIndexList;
import com.types.util.Descriptions;
import com.types.util.Tables;

public class ArrayIndexListPanel extends StandartPanel {

	private static final long serialVersionUID = 1515352884479601080L;

	ArrayIndexList<Object> arrayList;

	private JTextField posUser;
	private JTextField valueUser;

	public ArrayIndexListPanel() {
		init();
		renderComponents();
	}

	public void renderComponents() {
		arrayList = new ArrayIndexList<Object>();
		tables = new Tables(0);
		instanceButton();
		buttonEvents(arrayList);
		Descriptions.descriptionArrayList(this);
		generateLateral(true);
		
		posUser = UserEntries.createField("Indice:", 20, JTextField.CENTER, Integer.class);
		valueUser = UserEntries.createField("Elemento:", 20, JTextField.CENTER, Object.class);
	}

	protected void insertEvent() {
		insertEntry.getSend().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					arrayList.add(Integer.parseInt(posUser.getText()), valueUser.getText());
					tables.getInsertModel()
							.addRow(new Object[] { 
									"add(" + posUser.getText() + ", " + 
											valueUser.getText() + ")", null });
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
		removeEntry.getSend().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tables.getRemoveModel()
						.addRow(new Object[] { "remove(" + posUser.getText() + ")", 
								arrayList.remove(Integer.parseInt(posUser.getText())) });
				} catch(Exception ex) {
					showError(ex.getMessage());
				} finally {
					buttonStatus(true);
					removeEntry.dispose();
				}
			}
		});
	}

	public Entry insertEntry() {
		return new Entry(new JComponent[] { posUser, valueUser });
	}

	public Entry removeEntry() {
		return new Entry(new JComponent[] { posUser });
	}

}
