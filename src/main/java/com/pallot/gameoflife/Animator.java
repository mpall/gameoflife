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
			draw();
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
			postWait();

			for (Cell cell : gridOfCells.getCellData()) {
				int neighbours = cell.neighboursCount(thisGrid);
				if (cell.isAlive(thisGrid)) {
					if (underPopulated(neighbours)) {
						nextGrid.set(cell.getIndex(), DEAD);
					} else if (justRight(neighbours)) {
						becomeAlive(cell);
					} else if (overPopulated(neighbours)) {
						nextGrid.set(cell.getIndex(), DEAD);
					}
				} else {
					if (readyForReproduction(neighbours)) {
						becomeAlive(cell);
					}
				}
			}
			thisGrid = nextGrid;
			nextGrid = new Grid(thisGrid.getHightAndWidth());
			new StringLoader(nextGrid).loadWith(" ");
		}

	}

	protected void postWait() {
		
	}

	protected void draw() {
		System.out.println(new Printer(thisGrid).print());
	}

	protected void becomeAlive(Cell cell) {
		nextGrid.set(cell.getIndex(), ALIVE);
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

	protected void setupGrids() {
		gridOfCells = new CellLoader(new Grid(thisGrid.getHightAndWidth())).loadCells();
		nextGrid = new StringLoader(new Grid(thisGrid.getHightAndWidth())).loadWith(DEAD);
	}

	public Animator interactiveMode() {
		this.interactiveMode  = true;
		return this;
	}
	
	public Animator interval(int interval) {
		this.interval = interval;
		return this;
	}

}
