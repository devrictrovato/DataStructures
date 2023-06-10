package com.types.panels.managments;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

import com.types.panels.Entry;
import com.types.panels.StandartPanel;
import com.types.panels.UserEntries;
import com.types.structures.AVLTreeMap;
import com.types.util.Descriptions;
import com.types.util.Tables;

public class AVLTreeMapPanel extends StandartPanel {

	private static final long serialVersionUID = -4234178847655292824L;

	private AVLTreeMap<Object, Object> AVL;
	
	private JTextField keyUser, valueUser;
	private JComboBox<Object> keys;
	
	public AVLTreeMapPanel() {
		init();
		renderComponents();
	}
	
	public void renderComponents() {
		AVL = new AVLTreeMap<Object, Object>();
		tables = new Tables(10);
		instanceButton();
		buttonEvents(AVL);
		Descriptions.descriptionAVL(this);
		generateLateral(true);
		
		keyUser = UserEntries.createField("Chave:", 20, JTextField.CENTER, Object.class);
		valueUser = UserEntries.createField("Valor:", 20, JTextField.CENTER, Object.class);
		keys = UserEntries.createComboBox("Chaves:", generateList());
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
											AVL.put(keyUser.getText(), valueUser.getText()) });
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
							AVL.remove(keys.getSelectedItem())
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
		String[] list = new String[AVL.size()];
		int c = 0;
		for (Object key : AVL.keySet()) {
			list[c] = key.toString();
			c++;
		}
		return list;
	}

}
