package com.pallot.gameoflife;

import org.apache.commons.lang.StringUtils;

public class StringLoader {
	Grid grid;

	public StringLoader(Grid grid) {
		this.grid = grid;
	}
	
	public Grid loadWith(String value) {
		for(int i = 0; i < grid.size(); i++) {
			grid.set(i, value);
		}
		return grid;
	}
	
	public Grid loadNumbers() {
		for(int i = 0; i < grid.size(); i++) {
			grid.set(i, StringUtils.leftPad(String.valueOf(i),2));
		}
		return grid;
	}
}
