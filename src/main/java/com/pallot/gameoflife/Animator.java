package com.pallot.gameoflife;

import static com.pallot.gameoflife.Cell.ALIVE;
import static com.pallot.gameoflife.Cell.DEAD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;

import com.pallot.gameoflife.console.Command;

public class Animator implements Runnable {
	Grid thisGrid;
	Grid nextGrid;
	Grid gridOfCells;
	String padding = "";
	private boolean interactiveMode = false;
	private int interval = 250;
	private Queue<Command> commandQueue;

	public Animator(Grid thisGrid, Queue<Command> commandQueue) {
		this.thisGrid = thisGrid;
		this.commandQueue = commandQueue;
	}

	
	public void run() {
		try {
		setupGrids();
		while (true) {
			if(!interactiveMode) {
				Command command = getCommand();
				if(command != null) {
					if(command.exit()) break;
					Shape.getShapeFromCommand(command.getShape()).animate(thisGrid, command.x(), command.y());
				}
			}
			draw();
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
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private Command getCommand() {
		if(!commandQueue.isEmpty()) {
			return commandQueue.poll();
		}
		return null;
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
