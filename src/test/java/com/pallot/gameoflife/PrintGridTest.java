package com.pallot.gameoflife;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrintGridTest {
	@Test
	public void printPlainGrid() {
		Grid grid = new Grid(2);
		StringLoader loader = new StringLoader(grid);
		loader.loadNumbers();
		
		Printer printer = new Printer(grid);
		System.out.println(printer.print());
		assertEquals(" 0| 1\n 2| 3\n", printer.print());
		
	}
	
	@Test
	public void printPlainGrid_3_by_3() {
		Grid grid = new Grid(3);
		StringLoader loader = new StringLoader(grid);
		loader.loadNumbers();
		
		Printer printer = new Printer(grid);
		System.out.println(printer.print());
		assertEquals(" 0| 1| 2\n 3| 4| 5\n 6| 7| 8\n", printer.print());
		
	}
	
	@Test
	public void printPlainGrid_4_by_4() {
		Grid grid = new Grid(4);
		StringLoader loader = new StringLoader(grid);
		loader.loadNumbers();
		
		Printer printer = new Printer(grid);
		System.out.println(printer.print());
	}

	

}
