package com.pallot.gameoflife;

import static com.pallot.gameoflife.Cell.DEAD;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.pallot.gameoflife.console.Command;
import com.pallot.gameoflife.console.ConsoleReader;

public class Main {
	Grid thisGrid;
	int hightAndWidth = 350;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		new Main().run();
	}
	public void run() throws IOException, InterruptedException {
		setup();
		setupGrid(250);
		//setupBlock(100, 100);
		//setupBlinker(100, 100);
		//setupGlider(6, 0);
		//setupGlider(10, 0);
		
		Queue<Command> queue = new ConcurrentLinkedQueue<Command>();
		//new Animator(thisGrid).interval(100).run();
		//new Animator(thisGrid).interactiveMode().run();
		Animator animator = new AnimatorSwing(thisGrid, queue).interval(30);
		ConsoleReader consoleReader = new ConsoleReader(); 
		initialObjects(animator);
		startThread(animator);
		consoleReader.setQueue(queue);
		startThread(consoleReader);
		
		

		
			
	}
	
	private void startThread(Runnable runnable) {
		Thread thread = new Thread(runnable);
		thread.start();
	}
	private void initialObjects(Animator animator) {
		Shape.GLIDER.animate(thisGrid, 12, 0);
		Shape.GLIDER.animate(thisGrid, 20, 0);
		Shape.SHIP.animate(thisGrid, 0, 7);
		
		Shape.SHIP.animate(thisGrid, 0, 13);
		Shape.SHIP.animate(thisGrid, 0, 23);
		Shape.SHIP.animate(thisGrid, 0, 29);
		
		Shape.GLIDER.animate(thisGrid, 112, 0);
		Shape.GLIDER.animate(thisGrid, 120, 0);
		Shape.SHIP.animate(thisGrid, 10, 7);
		Shape.SHIP.animate(thisGrid, 10, 13);
		Shape.SHIP.animate(thisGrid, 10, 23);
		Shape.SHIP.animate(thisGrid, 10, 29);
		
		Shape.GLIDER.animate(thisGrid, 132, 0);
		Shape.GLIDER.animate(thisGrid, 130, 0);
		Shape.SHIP.animate(thisGrid, 103, 7);
		Shape.SHIP.animate(thisGrid, 103, 13);
		Shape.SHIP.animate(thisGrid, 103, 23);
		Shape.SHIP.animate(thisGrid, 103, 29);
		
		Shape.GLIDER.animate(thisGrid, 112, 10);
		Shape.GLIDER.animate(thisGrid, 120, 10);
		Shape.SHIP.animate(thisGrid, 10, 70);
		Shape.SHIP.animate(thisGrid, 10, 113);
		Shape.SHIP.animate(thisGrid, 10, 123);
		Shape.SHIP.animate(thisGrid, 10, 129);
		
		Shape.GLIDER.animate(thisGrid, 10, 10);
		Shape.GLIDER.animate(thisGrid, 20, 20);
		Shape.GLIDER.animate(thisGrid, 30, 30);
		Shape.GLIDER.animate(thisGrid, 40, 40);
		Shape.GLIDER.animate(thisGrid, 50, 50);
		Shape.GLIDER.animate(thisGrid, 60, 60);
		Shape.GLIDER.animate(thisGrid, 70, 70);
		Shape.GLIDER.animate(thisGrid, 80, 80);
		Shape.GLIDER.animate(thisGrid, 90, 90);
		Shape.GLIDER.animate(thisGrid, 100, 100);
		
		Shape.SHIP.animate(thisGrid, 10, 20);
		Shape.SHIP.animate(thisGrid, 10, 30);
		Shape.SHIP.animate(thisGrid, 10, 40);
		Shape.SHIP.animate(thisGrid, 10, 50);
		Shape.SHIP.animate(thisGrid, 10, 60);
		Shape.SHIP.animate(thisGrid, 10, 70);
		Shape.SHIP.animate(thisGrid, 10, 80);
		Shape.SHIP.animate(thisGrid, 10, 90);
		Shape.SHIP.animate(thisGrid, 10, 100);
		Shape.SHIP.animate(thisGrid, 10, 110);
		Shape.SHIP.animate(thisGrid, 10, 120);
		
		Shape.SHIP.animate(thisGrid, 20, 20);
		Shape.SHIP.animate(thisGrid, 20, 30);
		Shape.SHIP.animate(thisGrid, 20, 40);
		Shape.SHIP.animate(thisGrid, 20, 50);
		Shape.SHIP.animate(thisGrid, 20, 60);
		Shape.SHIP.animate(thisGrid, 20, 70);
		Shape.SHIP.animate(thisGrid, 20, 80);
		Shape.SHIP.animate(thisGrid, 20, 90);
		Shape.SHIP.animate(thisGrid, 20, 100);
		Shape.SHIP.animate(thisGrid, 20, 110);
		Shape.SHIP.animate(thisGrid, 20, 120);
		
		Shape.SHIP.animate(thisGrid, 30, 20);
		Shape.SHIP.animate(thisGrid, 30, 30);
		Shape.SHIP.animate(thisGrid, 30, 40);
		Shape.SHIP.animate(thisGrid, 30, 50);
		Shape.SHIP.animate(thisGrid, 30, 60);
		Shape.SHIP.animate(thisGrid, 30, 70);
		Shape.SHIP.animate(thisGrid, 30, 80);
		Shape.SHIP.animate(thisGrid, 30, 90);
		Shape.SHIP.animate(thisGrid, 30, 100);
		Shape.SHIP.animate(thisGrid, 30, 110);
		Shape.SHIP.animate(thisGrid, 30, 120);
		
		Shape.SHIP.animate(thisGrid, 40, 20);
		Shape.SHIP.animate(thisGrid, 50, 30);
		Shape.SHIP.animate(thisGrid, 40, 40);
		Shape.SHIP.animate(thisGrid, 40, 50);
		Shape.SHIP.animate(thisGrid, 40, 60);
		Shape.SHIP.animate(thisGrid, 40, 70);
		Shape.SHIP.animate(thisGrid, 40, 80);
		Shape.SHIP.animate(thisGrid, 40, 90);
		Shape.SHIP.animate(thisGrid, 40, 100);
		Shape.SHIP.animate(thisGrid, 40, 110);
		Shape.SHIP.animate(thisGrid, 40, 120);
		
		Shape.SHIP.animate(thisGrid, 40, 30);
		Shape.SHIP.animate(thisGrid, 50, 40);
		Shape.SHIP.animate(thisGrid, 40, 50);
		Shape.SHIP.animate(thisGrid, 40, 60);
		Shape.SHIP.animate(thisGrid, 40, 70);
		Shape.SHIP.animate(thisGrid, 40, 80);
		Shape.SHIP.animate(thisGrid, 40, 90);
		Shape.SHIP.animate(thisGrid, 40, 100);
		Shape.SHIP.animate(thisGrid, 40, 120);
		Shape.SHIP.animate(thisGrid, 40, 130);
		Shape.SHIP.animate(thisGrid, 40, 140);
		
		Shape.SHIP.animate(thisGrid, 100, 30);
		Shape.SHIP.animate(thisGrid, 100, 40);
		Shape.SHIP.animate(thisGrid, 100, 50);
		Shape.SHIP.animate(thisGrid, 100, 60);
		Shape.SHIP.animate(thisGrid, 100, 70);
		Shape.SHIP.animate(thisGrid, 100, 80);
		Shape.SHIP.animate(thisGrid, 100, 90);
		Shape.SHIP.animate(thisGrid, 100, 100);
		Shape.SHIP.animate(thisGrid, 100, 120);
		Shape.SHIP.animate(thisGrid, 100, 130);
		Shape.SHIP.animate(thisGrid, 100, 140);
		
		Shape.SHIP.animate(thisGrid, 100, 130);
		Shape.SHIP.animate(thisGrid, 100, 140);
		Shape.SHIP.animate(thisGrid, 100, 150);
		Shape.SHIP.animate(thisGrid, 100, 160);
		Shape.SHIP.animate(thisGrid, 100, 170);
		Shape.SHIP.animate(thisGrid, 100, 180);
		Shape.SHIP.animate(thisGrid, 100, 190);
		Shape.SHIP.animate(thisGrid, 100, 100);
		Shape.SHIP.animate(thisGrid, 100, 120);
		Shape.SHIP.animate(thisGrid, 100, 130);
		Shape.SHIP.animate(thisGrid, 100, 140);
	}

	private void setup() {
		setupGrid(hightAndWidth);
	}
	
	private void setupGrid(int hightAndWidth) {
		thisGrid = new StringLoader(new Grid(hightAndWidth)).loadWith(DEAD);
	}
}
