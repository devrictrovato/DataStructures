package com.types.panels;

import java.awt.GridBagConstraints;

@SuppressWarnings("serial")
public class Layout extends GridBagConstraints {

	public void setConstraints(int x, int y, int w, int h, int anchor, int fill) {
		this.gridx = x;
		this.gridy = y;
		this.gridwidth = w;
		this.gridheight = h;
		this.anchor = anchor;
		this.fill = fill;
	}
	
}
