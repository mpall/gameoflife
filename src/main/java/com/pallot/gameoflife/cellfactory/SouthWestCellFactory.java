package com.pallot.gameoflife.cellfactory;

import com.pallot.gameoflife.Grid;

public class SouthWestCellFactory extends CellFactoryBase {

	public SouthWestCellFactory(Grid grid, int index) {
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
		return index
				- (grid.getHightAndWidth() * (grid.getHightAndWidth() - 2)) - 1;
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
