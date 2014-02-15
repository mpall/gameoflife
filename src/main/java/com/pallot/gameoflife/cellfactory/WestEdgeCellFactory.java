package com.pallot.gameoflife.cellfactory;

import com.pallot.gameoflife.Grid;

public class WestEdgeCellFactory extends CellFactoryBase {

	public WestEdgeCellFactory(Grid grid, int index) {
		super(grid, index);
	}
	
	@Override
	public int nw() {
		return index - 1;
	}

	@Override
	public int w() {
		return index + grid.getHightAndWidth() - 1;
	}
	
	@Override
	public int sw() {
		return index + (2 * grid.getHightAndWidth()) - 1;
	}



}
