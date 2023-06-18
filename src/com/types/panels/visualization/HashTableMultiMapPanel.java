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
import com.types.structures.HashTableMultiMap;
import com.types.util.Descriptions;
import com.types.util.Tables;

public class HashTableMultiMapPanel extends Standard {

	private static final long serialVersionUID = -6158057641919924862L;

	private HashTableMultiMap<Object, Object> dictionary;

	private JTextField keyUser, valueUser;
	private JComboBox<Object> keys;

	public HashTableMultiMapPanel() {
		init();
		renderComponents();
	}

	public void renderComponents() {
		dictionary = new HashTableMultiMap<Object, Object>();
		tables = new Tables(8);
		instanceButton();
		buttonEvents(dictionary);
		Descriptions.descriptionDictionary(this);
		generateLateral(true);

		keyUser = Inputs.createField("Chave:", 20, JTextField.CENTER, Object.class);
		valueUser = Inputs.createField("Valor:", 20, JTextField.CENTER, Object.class);
		keys = Inputs.createComboBox("Chaves:", generateList());
	}

	protected Entry insertEntry() {
		return new Entry(new JComponent[] { keyUser, valueUser });
	}

	@Override
	protected Entry removeEntry() {
		keys.setModel(new DefaultComboBoxModel<Object>(generateList()));
		return new Entry(new JComponent[] { keys });
	}

	protected void insertEvent() {
		insertEntry.getSend().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tables.getInsertModel()
							.addRow(new Object[] { "put(" + keyUser.getText() + ", " + valueUser.getText() + ")",
									dictionary.put(keyUser.getText(), valueUser.getText()) });
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
		removeEntry.getSend().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tables.getRemoveModel().addRow(new Object[] {
							"remove(" + keys.getSelectedItem() + ")", 
							dictionary.remove(dictionary.get(keys.getSelectedItem()))
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
		String[] list = new String[dictionary.size()];
		int c = 0;
		for (Object key : dictionary.dictKeys()) {
			list[c] = key.toString();
			c++;
		}
		return list;
	}

}
