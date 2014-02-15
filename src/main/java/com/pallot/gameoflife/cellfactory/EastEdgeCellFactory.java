package com.pallot.gameoflife.cellfactory;

import com.pallot.gameoflife.Grid;

public class EastEdgeCellFactory extends CellFactoryBase {

	public EastEdgeCellFactory(Grid grid, int index) {
		super(grid, index);
	}

	@Override
	public int ne() {
		return index - (grid.getHightAndWidth() * 2) + 1;
	}
	
	@Override
	public int e() {
		return index - grid.getHightAndWidth() + 1;
	}
	
	@Override
	public int se() {
		return index + 1;
	}




}
