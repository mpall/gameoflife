package com.pallot.gameoflife;

import com.pallot.gameoflife.cellfactory.CellFactoryBase;
import com.pallot.gameoflife.cellfactory.EastEdgeCellFactory;
import com.pallot.gameoflife.cellfactory.NorthEastCellFactory;
import com.pallot.gameoflife.cellfactory.NorthEdgeCellFactory;
import com.pallot.gameoflife.cellfactory.NorthWestCellFactory;
import com.pallot.gameoflife.cellfactory.SouthEastCellFactory;
import com.pallot.gameoflife.cellfactory.SouthEdgeCellFactory;
import com.pallot.gameoflife.cellfactory.SouthWestCellFactory;
import com.pallot.gameoflife.cellfactory.WestEdgeCellFactory;

public class CellFactory {
	private int index;
	private Grid grid;
	private CellFactoryBase cellFactory;

	public CellFactory(Grid grid, int index) {
		this.index = index;
		this.grid = grid;
	}

	public CellFactoryBase getCellFactory() {
		if(nwCorner()) {
			cellFactory = new NorthWestCellFactory(grid, index);
		}else if(neCorner()) {
			cellFactory = new NorthEastCellFactory(grid, index);
		}else if(swCorner()) {
			cellFactory = new SouthWestCellFactory(grid, index);
		}else if(seCorner()) {
			cellFactory = new SouthEastCellFactory(grid, index);
		}else if(eEdge()) {
			cellFactory = new EastEdgeCellFactory(grid,index);
		}else if(nEdge()) {
			cellFactory = new NorthEdgeCellFactory(grid, index);
		}else if(sEdge()) {
			cellFactory = new SouthEdgeCellFactory(grid, index);
		}else if(wEdge()) {
			cellFactory = new WestEdgeCellFactory(grid, index);
		}else {
			cellFactory = new CellFactoryBase(grid,index);
		}
		return cellFactory;
	}
	
	public boolean seCorner() {
		return (grid.size() - 1) == index;
	}

	public boolean swCorner() {
		return (grid.size() - grid.getHightAndWidth()) == index;
	}

	public boolean nwCorner() {
		return 0 == index;
	}

	public boolean neCorner() {
		return index == (grid.getHightAndWidth() - 1);
	}

	public boolean wEdge() {
		return (index % grid.getHightAndWidth()) == 0 && !nwCorner()
				&& !swCorner();
	}

	public boolean nEdge() {
		return index < grid.getHightAndWidth() && !nwCorner() && !seCorner();
	}

	public boolean eEdge() {
		return ((index - grid.getHightAndWidth() + 1) % grid.getHightAndWidth()) == 0
				&& !neCorner() && !seCorner();
	}

	public boolean sEdge() {
		return index > (grid.size() - grid.getHightAndWidth()) && !seCorner()
				&& !swCorner();
	}
	

}
