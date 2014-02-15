package com.pallot.gameoflife;

public class Printer {

	private Grid grid;

	public Printer(Grid grid) {
		this.grid = grid;
	}
	
	public String print() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < grid.size();  i++) {
			sb.append(grid.get(i));
			if(i == 0) {
				sb.append("|");
			}else if((i+1)%grid.getHightAndWidth() == 0) {
				sb.append("\n");
			} else {
				sb.append("|");
			}
		}
		return sb.toString();
	}
}
