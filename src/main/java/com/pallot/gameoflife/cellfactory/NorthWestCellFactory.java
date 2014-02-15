package com.pallot.gameoflife.cellfactory;

import com.pallot.gameoflife.Grid;

public class NorthWestCellFactory extends CellFactoryBase {

	public NorthWestCellFactory(Grid grid, int index) {
		super(grid, index);
	}

	@Override
	public int nw() {
		return grid.size() - 1;
	}

	@Override
	public int n() {
		return grid.getHightAndWidth() * (grid.getHightAndWidth() - 1);
	}

	@Override
	public int ne() {
		return grid.getHightAndWidth() * (grid.getHightAndWidth() - 1) + 1;
	}

	@Override
	public int w() {
		return grid.getHightAndWidth() - 1;
	}

	@Override
	public int sw() {
		return index + (2 * grid.getHightAndWidth()) - 1;
	}

}
