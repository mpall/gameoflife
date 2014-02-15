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
		//setupBlock();
		//setupBlinker();
		setupGlider(6);
		//setupGlider(10);
		setupGlider(12);
		//setupGlider(20);
		//setupLightWeightShip(7);
		setupLightWeightShip(13);
		//setupLightWeightShip(23);
		setupLightWeightShip(29);
		
		new Animator(thisGrid).interval(100).run();
		//new Animator(thisGrid).interactiveMode().run();
	}
	
	private void setup() {
		setupGrid(hightAndWidth);
	}
	
	private void setupLightWeightShip(int y) {
		thisGrid.set((thisGrid.getHightAndWidth() * y) + 1, ALIVE);
		thisGrid.set((thisGrid.getHightAndWidth() * y) + 2, ALIVE);
		thisGrid.set((thisGrid.getHightAndWidth() * y) + 3, ALIVE);
		thisGrid.set((thisGrid.getHightAndWidth() * y) + 4, ALIVE);
		thisGrid.set((thisGrid.getHightAndWidth() * y) + thisGrid.getHightAndWidth(), ALIVE);
		thisGrid.set((thisGrid.getHightAndWidth() * y) + thisGrid.getHightAndWidth() + 4, ALIVE);
		thisGrid.set((thisGrid.getHightAndWidth() * y) + thisGrid.getHightAndWidth() * 2 + 4, ALIVE);
		thisGrid.set((thisGrid.getHightAndWidth() * y) + thisGrid.getHightAndWidth() * 3 + 3, ALIVE);
		thisGrid.set((thisGrid.getHightAndWidth() * y) + thisGrid.getHightAndWidth() * 3, ALIVE);
	}
	
	private void setupGlider() {
		thisGrid.set(thisGrid.getHightAndWidth(), ALIVE);
		thisGrid.set((thisGrid.getHightAndWidth() * 2) + 1, ALIVE);
		thisGrid.set(2, ALIVE);
		thisGrid.set(thisGrid.getHightAndWidth() + 2, ALIVE);
		thisGrid.set((thisGrid.getHightAndWidth()* 2) + 2, ALIVE);
	}
	
	private void setupGlider(int offset) {
		thisGrid.set(thisGrid.getHightAndWidth() + offset, ALIVE);
		thisGrid.set((thisGrid.getHightAndWidth() * 2) + 1  + offset, ALIVE);
		thisGrid.set(2  + offset, ALIVE);
		thisGrid.set(thisGrid.getHightAndWidth() + 2  + offset, ALIVE);
		thisGrid.set((thisGrid.getHightAndWidth()* 2) + 2  + offset, ALIVE);
	}



	private void setupBlinker() {
		setupGrid(5);
		thisGrid.set(11, ALIVE);
		thisGrid.set(12, ALIVE);
		thisGrid.set(13, ALIVE);
	}


	private void setupBlock() {
		setupGrid(4);
		thisGrid.set(5, ALIVE);
		thisGrid.set(6, ALIVE);
		thisGrid.set(9, ALIVE);
		thisGrid.set(10, ALIVE);
	}
	
	private void setupGrid(int hightAndWidth) {
		thisGrid = new StringLoader(new Grid(hightAndWidth)).loadWith(DEAD);
	}
}
