package com.pallot.gameoflife;

import static com.pallot.gameoflife.Cell.ALIVE;
import static com.pallot.gameoflife.Cell.DEAD;

import java.io.IOException;

public class Main {
	Grid thisGrid;
	int hightAndWidth = 39;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		new Main().run();
	}
	public void run() throws IOException, InterruptedException {
		setup();
		//setupBlock(0, 0);
		//setupBlinker(0, 0);
		setupGlider(6, 0);
		//setupGlider(10, 0);
		setupGlider(12, 0);
		//setupGlider(20, 0);
		//setupLightWeightShip(0, 7);
		setupLightWeightShip(0, 13);
		//setupLightWeightShip(0, 23);
		setupLightWeightShip(0, 29);
		
		new Animator(thisGrid).interval(100).run();
		//new Animator(thisGrid).interactiveMode().run();
	}
	
	private void setup() {
		setupGrid(hightAndWidth);
	}
	
	private int shift(int x, int y) {
		return (thisGrid.getHightAndWidth() * y) + x;
	}
	
	private void setupLightWeightShip(int x, int y) {
		thisGrid.set(shift(x, y) + 1, ALIVE);
		thisGrid.set(shift(x, y) + 2, ALIVE);
		thisGrid.set(shift(x, y) + 3, ALIVE);
		thisGrid.set(shift(x, y) + 4, ALIVE);
		thisGrid.set(shift(x, y) + thisGrid.getHightAndWidth(), ALIVE);
		thisGrid.set(shift(x, y) + thisGrid.getHightAndWidth() + 4, ALIVE);
		thisGrid.set(shift(x, y) + thisGrid.getHightAndWidth() * 2 + 4, ALIVE);
		thisGrid.set(shift(x, y) + thisGrid.getHightAndWidth() * 3 + 3, ALIVE);
		thisGrid.set(shift(x, y) + thisGrid.getHightAndWidth() * 3, ALIVE);
	}
	
	private void setupGlider(int x, int y) {
		thisGrid.set(shift(x, y) + thisGrid.getHightAndWidth(), ALIVE);
		thisGrid.set(shift(x, y) + (thisGrid.getHightAndWidth() * 2) + 1, ALIVE);
		thisGrid.set(shift(x, y) + 2, ALIVE);
		thisGrid.set(shift(x, y) + thisGrid.getHightAndWidth() + 2, ALIVE);
		thisGrid.set(shift(x, y) + (thisGrid.getHightAndWidth()* 2) + 2, ALIVE);
	}
	
	private void setupBlinker(int x, int y) {
		setupGrid(shift(x, y) + 5);
		thisGrid.set(shift(x, y) + 11, ALIVE);
		thisGrid.set(shift(x, y) + 12, ALIVE);
		thisGrid.set(shift(x, y) + 13, ALIVE);
	}


	private void setupBlock(int x, int y) {
		setupGrid(shift(x, y) + 4);
		thisGrid.set(shift(x, y) + 5, ALIVE);
		thisGrid.set(shift(x, y) + 6, ALIVE);
		thisGrid.set(shift(x, y) + 9, ALIVE);
		thisGrid.set(shift(x, y) + 10, ALIVE);
	}
	
	private void setupGrid(int hightAndWidth) {
		thisGrid = new StringLoader(new Grid(hightAndWidth)).loadWith(DEAD);
	}
}
