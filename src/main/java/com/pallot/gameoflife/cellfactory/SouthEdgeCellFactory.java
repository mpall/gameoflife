package com.pallot.gameoflife.cellfactory;

import com.pallot.gameoflife.Grid;

public class SouthEdgeCellFactory extends CellFactoryBase {

	public SouthEdgeCellFactory(Grid grid, int index) {
		super(grid, index);
	}

	@Override
	public int sw() {
		return index
				- (grid.getHightAndWidth() * (grid.getHightAndWidth() - 1)) - 1;
	}
	
	@Override
	public int s() {
		return index
				- (grid.getHightAndWidth() * (grid.getHightAndWidth() - 1));
	}
	
	@Override
	public int se() {
		return index
				- (grid.getHightAndWidth() * (grid.getHightAndWidth() - 1)) + 1;
	}



}
