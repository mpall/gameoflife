package com.pallot.gameoflife;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.pallot.gameoflife.Cell.*;

public class Animator {
	Grid thisGrid;
	Grid nextGrid;
	Grid gridOfCells;
	String padding = "";
	private boolean interactiveMode = false;
	private int interval = 250;

	public Animator(Grid thisGrid) {
		this.thisGrid = thisGrid;
	}

	public void run() throws IOException, InterruptedException {
		setupGrids();
		while (true) {
			System.out.println(new Printer(thisGrid).print());
			System.out.println(padding);
			if(interactiveMode) {
				BufferedReader bis = new BufferedReader(new InputStreamReader(
						System.in));
				String line = bis.readLine();
				if ("exit".equals(line))
					break;
			}else {
				Thread.sleep(interval);
			}

			for (Cell cell : gridOfCells.getCellData()) {
				int neighbours = cell.neighboursCount(thisGrid);
				if (cell.isAlive(thisGrid)) {
					if (underPopulated(neighbours)) {
						nextGrid.set(cell.getIndex(), DEAD);
					} else if (justRight(neighbours)) {
						nextGrid.set(cell.getIndex(), ALIVE);
					} else if (overPopulated(neighbours)) {
						nextGrid.set(cell.getIndex(), DEAD);
					}
				} else {
					if (readyForReproduction(neighbours)) {
						nextGrid.set(cell.getIndex(), ALIVE);
					}
				}
			}
			thisGrid = nextGrid;
			nextGrid = new Grid(thisGrid.getHightAndWidth());
			new StringLoader(nextGrid).loadWith(" ");
		}

	}

	private boolean readyForReproduction(int neighbours) {
		return neighbours == 3;
	}

	private boolean overPopulated(int neighbours) {
		return neighbours > 3;
	}

	private boolean justRight(int neighbours) {
		return neighbours == 2 || readyForReproduction(neighbours);
	}

	private boolean underPopulated(int neighbours) {
		return neighbours < 2;
	}

	private void setupGrids() {
		gridOfCells = new Grid(thisGrid.getHightAndWidth());
		CellLoader loader = new CellLoader(gridOfCells);
		loader.loadCells();

		nextGrid = new Grid(thisGrid.getHightAndWidth());

		new StringLoader(nextGrid).loadWith(DEAD);
	}

	public void interactiveMode() {
		this.interactiveMode  = true;
	}
	
	public void interval(int interval) {
		this.interval = interval;
	}

}
