package com.pallot.gameoflife;

import static com.pallot.gameoflife.Cell.ALIVE;
import static com.pallot.gameoflife.Cell.DEAD;

import java.io.IOException;

public class Main {
	Grid thisGrid;
	int hightAndWidth = 350;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		new Main().run();
	}
	public void run() throws IOException, InterruptedException {
		setup();
		//setupBlock(100, 100);
		//setupBlinker(100, 100);
		//setupGlider(6, 0);
		//setupGlider(10, 0);
		setupGlider(12, 0);
		setupGlider(20, 0);
		setupLightWeightShip(0, 7);
		setupLightWeightShip(0, 13);
		setupLightWeightShip(0, 23);
		setupLightWeightShip(0, 29);
		
		setupGlider(112, 0);
		setupGlider(120, 0);
		setupLightWeightShip(10, 7);
		setupLightWeightShip(10, 13);
		setupLightWeightShip(10, 23);
		setupLightWeightShip(10, 29);
		
		setupGlider(132, 0);
		setupGlider(130, 0);
		setupLightWeightShip(103, 7);
		setupLightWeightShip(103, 13);
		setupLightWeightShip(103, 23);
		setupLightWeightShip(103, 29);
		
		setupGlider(112, 10);
		setupGlider(120, 10);
		setupLightWeightShip(10, 70);
		setupLightWeightShip(10, 113);
		setupLightWeightShip(10, 123);
		setupLightWeightShip(10, 129);
		
		setupGlider(10, 10);
		setupGlider(20, 20);
		setupGlider(30, 30);
		setupGlider(40, 40);
		setupGlider(50, 50);
		setupGlider(60, 60);
		setupGlider(70, 70);
		setupGlider(80, 80);
		setupGlider(90, 90);
		setupGlider(100, 100);
		
		setupLightWeightShip(10, 20);
		setupLightWeightShip(10, 30);
		setupLightWeightShip(10, 40);
		setupLightWeightShip(10, 50);
		setupLightWeightShip(10, 60);
		setupLightWeightShip(10, 70);
		setupLightWeightShip(10, 80);
		setupLightWeightShip(10, 90);
		setupLightWeightShip(10, 100);
		setupLightWeightShip(10, 110);
		setupLightWeightShip(10, 120);
		
		//new Animator(thisGrid).interval(100).run();
		//new Animator(thisGrid).interactiveMode().run();
		new AnimatorSwing(thisGrid).interval(30).run();
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
