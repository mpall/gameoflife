package com.pallot.gameoflife;


public class CellLoader {
	Grid grid;

	public CellLoader(Grid grid) {
		this.grid = grid;
	}
	
	public Grid loadCells() {
		for(int i = 0; i < grid.size(); i++) {
			grid.set(i, new CellFactory(grid, i).getCellFactory().getCell());
		}
		return grid;
	}

}
