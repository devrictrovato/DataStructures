package com.types.panels.visualization;

import com.types.panels.Entry;
import com.types.panels.Standard;
import com.types.util.Descriptions;

public class AboutPanel extends Standard {

	private static final long serialVersionUID = -3773379210163637373L;
	
	public AboutPanel() {
		init();
		renderComponents();
	}
	
	public void renderComponents() {
		Descriptions.descriptionAbout(this);
		instanceButton();
		buttonEvents(null);
		generateLateral(false);
	}
	
	protected Entry insertEntry() { return null; }
	protected Entry removeEntry() { return null; }
	protected void insertEvent() { }
	protected void removeEvent() { }
	
}
