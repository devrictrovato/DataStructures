package com.types.panels.managments;

import com.types.panels.Entry;
import com.types.panels.StandartPanel;
import com.types.util.Descriptions;

public class GraphPanel extends StandartPanel {

	private static final long serialVersionUID = 1019346404504823868L;
	
	public GraphPanel() {
		init();
		renderComponents();
	}
	
	public void renderComponents() {
		Descriptions.descriptionGraph(this);
		instanceButton();
		buttonEvents(null);
		generateLateral(false);
	}
	
	protected Entry insertEntry() { return null; }
	protected Entry removeEntry() { return null; }
	protected void insertEvent() { }
	protected void removeEvent() { }

}
