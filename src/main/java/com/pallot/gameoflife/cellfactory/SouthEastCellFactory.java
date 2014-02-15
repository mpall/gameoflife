package com.pallot.gameoflife.cellfactory;

import com.pallot.gameoflife.Grid;

public class SouthEastCellFactory extends CellFactoryBase {

	public SouthEastCellFactory(Grid grid, int index) {
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
	public int sw() {
		return index
				- (grid.getHightAndWidth() * (grid.getHightAndWidth() - 1)) - 1;
	}

	@Override
	public int s() {
		return index
				- (grid.getHightAndWidth() * (grid.getHightAndWidth() - 1));
	}

	public int se() {
		return index - (grid.getHightAndWidth() * grid.getHightAndWidth()) + 1;
	}

}
