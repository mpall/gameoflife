package com.pallot.gameoflife;

public class Grid {
	String[] data;
	Cell[] cellData;
	private int hightAndWidth;

	public Grid(int hightAndWidth) {
		this.hightAndWidth = hightAndWidth;
		data = new String[hightAndWidth * hightAndWidth];
		cellData = new Cell[hightAndWidth * hightAndWidth];
	}

	public void set(int index, String value) {
		data[index] = value;
	}
	
	public int getHightAndWidth() {
		return hightAndWidth;
	}

	public int size() {
		return data.length;
	}

	public Object get(int i) {
		return data[i];
	}

	public void set(int index, Cell cell) {
		cellData[index] = cell;
	}
	
	public Cell[] getCellData() {
		return cellData;
	}

}
