package com.types.panels.managments;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

import com.types.interfaces.Position;
import com.types.panels.Entry;
import com.types.panels.StandartPanel;
import com.types.panels.UserEntries;
import com.types.structures.NodePositionList;
import com.types.util.Descriptions;
import com.types.util.Tables;

public class NodePositionListPanel extends StandartPanel {

	private static final long serialVersionUID = 5046594777285996932L;

	private NodePositionList<Object> nodesList;

	private JComboBox<Object> whereUser, listNodes;
	private JTextField valueUser;

	public NodePositionListPanel() {
		init();
		renderComponents();
	}

	public void renderComponents() {
		nodesList = new NodePositionList<Object>();
		tables = new Tables(3);
		instanceButton();
		buttonEvents(nodesList);
		Descriptions.descriptionNodePositionList(this);
		generateLateral(true);
		
		listNodes = UserEntries.createComboBox("Do nodo:", generateList());
		
		String[] options = { "No inicio", "No final", 
				"Antes (" + listNodes.getName().substring(0, listNodes.getName().length() - 1) + ")", 
				"Depois (" + listNodes.getName().substring(0, listNodes.getName().length() - 1)  + ")" };
		whereUser = UserEntries.createComboBox("Colocar:", options);
		
		valueUser = UserEntries.createField("Valor:", 20, JTextField.CENTER, Object.class);
	}

	protected Entry insertEntry() {
		listNodes.setModel(new DefaultComboBoxModel<Object>(generateList()));
		return new Entry(new JComponent[] { whereUser, listNodes, valueUser });
	}

	protected Entry removeEntry() {
		listNodes.setModel(new DefaultComboBoxModel<Object>(generateList()));
		return new Entry(new JComponent[] { listNodes });
	}

	protected void insertEvent() {
		insertEntry.getSend().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					selectAndInsert();
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
					selectAndRemove();
				} catch(Exception ex) {
					showError(ex.getMessage());
				} finally {
					buttonStatus(true);
					removeEntry.dispose();
				}
			}
		});
	}
	
	private void selectAndInsert() {
		int index = whereUser.getSelectedIndex();
		switch (index) {
			case 0: 
				nodesList.addFirst(valueUser.getText());
				tables.getInsertModel().addRow(new Object[] {
						"addFirst(" + valueUser.getText() + ")", null
				});
				break;
			case 1: 
				nodesList.addLast(valueUser.getText());
				tables.getInsertModel().addRow(new Object[] {
						"addLast(" + valueUser.getText() + ")", null
				});
				break;
			case 2: 
				nodesList.addBefore(getPos(listNodes.getSelectedItem()), valueUser.getText());
				tables.getInsertModel().addRow(new Object[] {
						"addBefore(" + listNodes.getSelectedItem() + ", " + valueUser.getText() + ")", null
				});
				break;
			case 3: 
				nodesList.addAfter(getPos(listNodes.getSelectedItem()), valueUser.getText());
				tables.getInsertModel().addRow(new Object[] {
						"addAfter(" + listNodes.getSelectedItem() + ", " + valueUser.getText() + ")", null
				});
				break;
		}
	}
	
	// Seleciona e remove com base na opção
	private void selectAndRemove() {
		tables.getRemoveModel().addRow(new Object[] {
				"remove(" + listNodes.getSelectedItem() + ")", 
				nodesList.remove(getPos(listNodes.getSelectedItem()))
		});
	}
	
	// Pegar posição com base no elemento
	private Position<Object> getPos(Object element) {
		Position<Object> pos = nodesList.first();
		for (@SuppressWarnings("unused") Object node : nodesList) {
			if (pos.element().toString().equalsIgnoreCase(element.toString())) {
				return pos;
			} else {
				pos = nodesList.next(pos);
			}
		}
		return null;
	}

	// Gerar a lista de nodos para seleção
	private String[] generateList() {
		String[] list = new String[nodesList.size()];
		int i = 0;
		for (Object text : nodesList) {
			list[i] = text.toString();
			i += 1;
		}
		return list;
	}
}
