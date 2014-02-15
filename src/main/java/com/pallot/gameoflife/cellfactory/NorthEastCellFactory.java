package com.pallot.gameoflife.cellfactory;

import com.pallot.gameoflife.Grid;

public class NorthEastCellFactory extends CellFactoryBase {

	public NorthEastCellFactory(Grid grid, int index) {
		super(grid, index);
	}

	@Override
	public int nw() {
		return grid.size() - 2;
	}

	@Override
	public int n() {
		return grid.size() - 1;
	}

	@Override
	public int ne() {
		return grid.size() - grid.getHightAndWidth();
	}

	@Override
	public int e() {
		return 0;
	}

	@Override
	public int se() {
		return index + 1;
	}

}
