package com.types.panels.visualization;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

import com.types.panels.Entry;
import com.types.panels.Standard;
import com.types.panels.Inputs;
import com.types.structures.HashTableMap;
import com.types.util.Descriptions;
import com.types.util.Tables;

public class HashTableMapPanel extends Standard {

	private static final long serialVersionUID = 2805127805792964365L;

	private HashTableMap<Object, Object> map;

	private JTextField keyUser, valueUser;
	private JComboBox<Object> keys;
	
	public HashTableMapPanel() {
		init();
		renderComponents();
	}
	
	public void renderComponents() {
		map = new HashTableMap<Object, Object>();
		tables = new Tables(7);
		instanceButton();
		buttonEvents(map);
		Descriptions.descriptionMap(this);
		generateLateral(true);
		
		keyUser = Inputs.createField("Chave:", 20, JTextField.CENTER, Object.class);
		valueUser = Inputs.createField("Valor:", 20, JTextField.CENTER, Object.class);
		keys = Inputs.createComboBox("Chaves:", generateList());
	}
	
	protected Entry insertEntry() {
		return new Entry(new JComponent[] { keyUser, valueUser });
	}

	protected Entry removeEntry() {
		keys.setModel(new DefaultComboBoxModel<Object>(generateList()));
		return new Entry(new JComponent[] { keys });
	}

	protected void insertEvent() {
		insertEntry.getSend().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tables.getInsertModel()
							.addRow(new Object[] { 
									"put(" + keyUser.getText() + ", " + 
											valueUser.getText() + ")", 
											map.put(keyUser.getText(), valueUser.getText()) });
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
					tables.getRemoveModel().addRow(new Object[] {
							"remove(" + keys.getSelectedItem() + ")", 
							map.remove(keys.getSelectedItem())
					});
				} catch (Exception ex) {
					showError(ex.getMessage());
				} finally {
					buttonStatus(true);
					removeEntry.dispose();
				}
			}
		});
	}
	
	private String[] generateList() {
		String[] list = new String[map.size()];
		int c = 0;
		for (Object key : map.keySet()) {
			list[c] = key.toString();
			c++;
		}
		return list;
	}

}
