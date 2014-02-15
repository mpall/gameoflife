package com.pallot.gameoflife;

public class Cell {
	int[] indexes = new int[8];
	int index;
	public static final String ALIVE = "*";
	public static final String DEAD = " ";

	public Cell(int index, int nw, int n, int ne, int w,int e, int sw, int s, int se) {
		indexes[0] = nw;
		indexes[1] = n;
		indexes[2] = ne;
		indexes[3] = w;
		indexes[4] = e;
		indexes[5] = sw;
		indexes[6] = s;
		indexes[7] = se;
		this.index = index;
	}
	
	public int[] neighboursIndexes() {
		return indexes;
	}
	
	public int getIndex() {
		return index;
	}

	public int neighboursCount(Grid thisGrid) {
		int count = 0;
		for(int i: indexes) {
			if(isAlive(i, thisGrid)) {
				count++;
			}
		}
		return count;
	}
	
	public boolean isAlive(int i, Grid thisGrid) {
		return ALIVE.equals(thisGrid.get(i));
	}

	public boolean isAlive(Grid thisGrid) {
		return isAlive(index, thisGrid);
	}
	
}
