package com.pallot.gameoflife;

import java.util.Queue;

import com.pallot.gameoflife.CoreControl.JPanelGrid;
import com.pallot.gameoflife.console.Command;

public class AnimatorSwing extends Animator{
	JPanelGrid jPanelGrid;

	public AnimatorSwing(Grid thisGrid, Queue<Command> commandQueue) {
		super(thisGrid, commandQueue);
	}
	
	@Override
	protected void setupGrids() {
		super.setupGrids();
		CoreControl control = new CoreControl(thisGrid);
		jPanelGrid = control.setUp();
	}
	
	@Override
	protected void becomeAlive(Cell cell) {
		super.becomeAlive(cell);
		jPanelGrid.fillCell(cell);
	}
	
	@Override
	protected void draw() {
		jPanelGrid.repaint();
	}
	
	@Override
	protected void postWait() {
		jPanelGrid.clear();
	}
	
	

}
