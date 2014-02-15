package com.pallot.gameoflife.cellfactory;

import com.pallot.gameoflife.Grid;

public class NorthEdgeCellFactory extends CellFactoryBase {

	public NorthEdgeCellFactory(Grid grid, int index) {
		super(grid, index);
	}
	
	@Override
	public int nw() {
		return index
				+ (grid.getHightAndWidth() * (grid.getHightAndWidth() - 1))
				- 1;
	}
	
	@Override
	public int n() {
		return index
				+ (grid.getHightAndWidth() * (grid.getHightAndWidth() - 1));
	}
	
	@Override
	public int ne() {
		return index
				+ (grid.getHightAndWidth() * (grid.getHightAndWidth() - 1))
				+ 1;
	}

}
