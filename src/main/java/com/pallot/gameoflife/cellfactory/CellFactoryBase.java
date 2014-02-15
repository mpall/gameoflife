package com.pallot.gameoflife.cellfactory;

import com.pallot.gameoflife.Cell;
import com.pallot.gameoflife.Grid;

public class CellFactoryBase {

	protected int index;
	protected Grid grid;

	public CellFactoryBase(Grid grid, int index) {
		this.index = index;
		this.grid = grid;
	}

	public int nw() {
		return index - (grid.getHightAndWidth() + 1);
	}

	public int n() {
		return index - grid.getHightAndWidth();
	}

	public int ne() {
		return index - (grid.getHightAndWidth() - 1);
	}

	public int w() {
		return index - 1;
	}

	public int e() {
		return index + 1;
	}

	public int sw() {
		return index + grid.getHightAndWidth() - 1;
	}

	public int s() {
		return index + grid.getHightAndWidth();
	}

	public int se() {
		return index + grid.getHightAndWidth() + 1;
	}
	
	public Cell getCell() {
		return new Cell(index, nw(), n(), ne(), w(), e(), sw(), s(), se());
	}
	

}
