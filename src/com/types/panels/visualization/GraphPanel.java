package com.types.panels.visualization;

import com.types.panels.Entry;
import com.types.panels.Standard;
import com.types.util.Descriptions;

public class GraphPanel extends Standard {

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
