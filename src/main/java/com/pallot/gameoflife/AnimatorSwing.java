package com.pallot.gameoflife;

import com.pallot.gameoflife.CoreControl.JPanelGrid;

public class AnimatorSwing extends Animator{
	JPanelGrid jPanelGrid;

	public AnimatorSwing(Grid thisGrid) {
		super(thisGrid);
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
