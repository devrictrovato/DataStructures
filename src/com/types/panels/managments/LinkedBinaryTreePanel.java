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
import com.types.tads.LinkedBinaryTree;
import com.types.util.Descriptions;
import com.types.util.Tables;

public class LinkedBinaryTreePanel extends StandartPanel {

	private static final long serialVersionUID = -1561066618221153898L;

	private LinkedBinaryTree<Object> binaryTree;

	private JComboBox<Object> whereUser;
	private JTextField valueUser;

	public LinkedBinaryTreePanel() {
		init();
		renderComponents();
	}

	public void renderComponents() {
		binaryTree = new LinkedBinaryTree<Object>();
		tables = new Tables(5);
		instanceButton();
		buttonEvents(binaryTree);
		Descriptions.descriptionBinaryTree(this);
		generateLateral(true);

		whereUser = UserEntries.createComboBox("Raiz:", generateList());
		valueUser = UserEntries.createField("Valor:", 20, JTextField.CENTER, Object.class);
	}

	protected Entry insertEntry() {
		whereUser.setModel(new DefaultComboBoxModel<Object>(generateList()));
		return new Entry(new JComponent[] { whereUser, valueUser });
	}

	protected Entry removeEntry() {
		whereUser.setModel(new DefaultComboBoxModel<Object>(generateList()));
		return new Entry(new JComponent[] { whereUser });
	}

	protected void insertEvent() {
		insertEntry.getSend().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!binaryTree.isEmpty())
						createBTChild(getPos(whereUser.getSelectedItem()));
					else
						tables.getInsertModel().addRow(new Object[] { "addRoot(" + valueUser.getText() + ")",
								binaryTree.addRoot(valueUser.getText()).element() });
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
							"remove(" + whereUser.getSelectedItem() + ")", 
							binaryTree.remove(getPos(whereUser.getSelectedItem()))
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

	private void createBTChild(Position<Object> p) {
		if (!binaryTree.hasLeft(p)) {
			tables.getInsertModel()
					.addRow(new Object[] {
							"insertLeft(" + whereUser.getSelectedItem() + ", " + valueUser.getText() + ")",
							binaryTree.insertLeft(p, valueUser.getText()).element() });
		} else if (!binaryTree.hasRight(p)) {
			tables.getInsertModel()
					.addRow(new Object[] {
							"insertRight(" + whereUser.getSelectedItem() + ", " + valueUser.getText() + ")",
							binaryTree.insertRight(p, valueUser.getText()).element() });
		}
	}

	private Position<Object> getPos(Object element) {
		for (Position<Object> child : binaryTree.positions()) {
			if (child.element().toString().equalsIgnoreCase(element.toString()))
				return (Position<Object>) child;
		}
		return null;
	}

	private String[] generateList() {
		String[] list = new String[binaryTree.size()];
		int c = 0;
		for (Position<Object> pos : binaryTree.positions()) {
			list[c] = pos.element().toString();
			c++;
		}
		return list;
	}

}
