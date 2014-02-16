package com.pallot.gameoflife;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.pallot.gameoflife.cellfactory.CellFactoryBase;

public class CellFactoryTest {
	
	@BeforeClass
	public static void before() {
		Grid grid = new Grid(4);
		new StringLoader(grid).loadNumbers();
		System.out.println(new Printer(grid).print());
		
		grid = new Grid(5);
		new StringLoader(grid).loadNumbers();
		System.out.println(new Printer(grid).print());
	}
		
	@Test
	public void middle() {
		Grid grid = new Grid(4);
		
		CellFactoryBase cell = new CellFactory(grid, 5).getCellFactory();
		assertEquals(0, cell.nw());
		assertEquals(1, cell.n());
		assertEquals(2, cell.ne());
		assertEquals(4, cell.w());
		assertEquals(6, cell.e());
		assertEquals(8, cell.sw());
		assertEquals(9, cell.s());
		assertEquals(10, cell.se());
		
		cell = new CellFactory(grid, 10).getCellFactory();
		assertEquals(5, cell.nw());
		assertEquals(6, cell.n());
		assertEquals(7, cell.ne());
		assertEquals(9, cell.w());
		assertEquals(11, cell.e());
		assertEquals(13, cell.sw());
		assertEquals(14, cell.s());
		assertEquals(15, cell.se());
		
	}
	
	@Test
	public void southEast() {
		Grid grid = new Grid(4);
		
		CellFactoryBase cell = new CellFactory(grid, 15).getCellFactory();
		assertEquals(10, cell.nw());
		assertEquals(11, cell.n());
		assertEquals(8, cell.ne());
		assertEquals(14, cell.w());
		assertEquals(12, cell.e());
		assertEquals(2, cell.sw());
		assertEquals(3, cell.s());
		assertEquals(0, cell.se());
	}
	
	@Test
	public void southEast_5() {
		Grid grid = new Grid(5);
		
		CellFactoryBase cell = new CellFactory(grid, 24).getCellFactory();
		assertEquals(18, cell.nw());
		assertEquals(19, cell.n());
		assertEquals(15, cell.ne());
		assertEquals(23, cell.w());
		assertEquals(20, cell.e());
		assertEquals(3, cell.sw());
		assertEquals(4, cell.s());
		assertEquals(0, cell.se());
	}

	
	@Test
	public void southWest() {
		Grid grid = new Grid(4);
		
		CellFactoryBase cell = new CellFactory(grid, 12).getCellFactory();
		assertEquals(11, cell.nw());
		assertEquals(8, cell.n());
		assertEquals(9, cell.ne());
		assertEquals(15, cell.w());
		assertEquals(13, cell.e());
		assertEquals(3, cell.sw());
		assertEquals(0, cell.s());
		assertEquals(1, cell.se());
	}

	@Test
	public void southWest_5() {
		Grid grid = new Grid(5);
		
		CellFactoryBase cell = new CellFactory(grid, 20).getCellFactory();
		assertEquals(19, cell.nw());
		assertEquals(15, cell.n());
		assertEquals(16, cell.ne());
		assertEquals(24, cell.w());
		assertEquals(21, cell.e());
		assertEquals(4, cell.sw());
		assertEquals(0, cell.s());
		assertEquals(1, cell.se());
	}

	
	@Test
	public void northWest() {
		Grid grid = new Grid(4);
		
		CellFactoryBase cell = new CellFactory(grid, 0).getCellFactory();
		assertEquals(15, cell.nw());
		assertEquals(12, cell.n());
		assertEquals(13, cell.ne());
		assertEquals(3, cell.w());
		assertEquals(1, cell.e());
		assertEquals(7, cell.sw());
		assertEquals(4, cell.s());
		assertEquals(5, cell.se());
	}
	
	@Test
	public void northWest_5() {
		Grid grid = new Grid(5);
		
		CellFactoryBase cell = new CellFactory(grid, 0).getCellFactory();
		assertEquals(24, cell.nw());
		assertEquals(20, cell.n());
		assertEquals(21, cell.ne());
		assertEquals(4, cell.w());
		assertEquals(1, cell.e());
		assertEquals(9, cell.sw());
		assertEquals(5, cell.s());
		assertEquals(6, cell.se());
	}
	
	@Test
	public void northEast() {
		Grid grid = new Grid(4);
		
		CellFactoryBase cell = new CellFactory(grid, 3).getCellFactory();
		assertEquals(14, cell.nw());
		assertEquals(15, cell.n());
		assertEquals(12, cell.ne());
		assertEquals(2, cell.w());
		assertEquals(0, cell.e());
		assertEquals(6, cell.sw());
		assertEquals(7, cell.s());
		assertEquals(4, cell.se());
	}
	
	@Test
	public void northEast_5() {
		Grid grid = new Grid(5);
		
		CellFactoryBase cell = new CellFactory(grid, 4).getCellFactory();
		assertEquals(23, cell.nw());
		assertEquals(24, cell.n());
		assertEquals(20, cell.ne());
		assertEquals(3, cell.w());
		assertEquals(0, cell.e());
		assertEquals(8, cell.sw());
		assertEquals(9, cell.s());
		assertEquals(5, cell.se());
	}
	
	@Test
	public void wEdge() {
		Grid grid = new Grid(4);
		
		CellFactoryBase cell = new CellFactory(grid, 4).getCellFactory();
		assertEquals(3, cell.nw());
		assertEquals(0, cell.n());
		assertEquals(1, cell.ne());
		assertEquals(7, cell.w());
		assertEquals(5, cell.e());
		assertEquals(11, cell.sw());
		assertEquals(8, cell.s());
		assertEquals(9, cell.se());
	}
	
	@Test
	public void nEdge() {
		Grid grid = new Grid(4);
		
		CellFactoryBase cell = new CellFactory(grid, 1).getCellFactory();
		assertEquals(12, cell.nw());
		assertEquals(13, cell.n());
		assertEquals(14, cell.ne());
		assertEquals(0, cell.w());
		assertEquals(2, cell.e());
		assertEquals(4, cell.sw());
		assertEquals(5, cell.s());
		assertEquals(6, cell.se());
	}
	
	@Test
	public void eEdge() {
		Grid grid = new Grid(4);
		
		CellFactoryBase cell = new CellFactory(grid, 7).getCellFactory();
		assertEquals(2, cell.nw());
		assertEquals(3, cell.n());
		assertEquals(0, cell.ne());
		assertEquals(6, cell.w());
		assertEquals(4, cell.e());
		assertEquals(10, cell.sw());
		assertEquals(11, cell.s());
		assertEquals(8, cell.se());
	}
	
	@Test
	public void sEdge() {
		Grid grid = new Grid(4);
		
		CellFactoryBase cell = new CellFactory(grid, 13).getCellFactory();
		assertEquals(8, cell.nw());
		assertEquals(9, cell.n());
		assertEquals(10, cell.ne());
		assertEquals(12, cell.w());
		assertEquals(14, cell.e());
		assertEquals(0, cell.sw());
		assertEquals(1, cell.s());
		assertEquals(2, cell.se());
	}
	
	@Test
	public void getCell() {
		Grid grid = new Grid(4);
		
		CellFactoryBase cf = new CellFactory(grid, 5).getCellFactory();
		Cell cell = cf.getCell();
		int[] indexes = cell.neighboursIndexes();
		assertEquals(0, indexes[0]);
		assertEquals(1, indexes[1]);
		assertEquals(2, indexes[2]);
		assertEquals(4, indexes[3]);
		assertEquals(6, indexes[4]);
		assertEquals(8, indexes[5]);
		assertEquals(9, indexes[6]);
		assertEquals(10, indexes[7]);
		
	}
	
	@Test
	public void coordinates() {
		Grid grid = new Grid(4);
		Cell cell = new CellFactory(grid, 0).getCellFactory().getCell();
		assertEquals(0,cell.x(grid));
		assertEquals(0,cell.y(grid));
		
		cell = new CellFactory(grid, 4).getCellFactory().getCell();
		assertEquals(0,cell.x(grid));
		assertEquals(1,cell.y(grid));
		
		cell = new CellFactory(grid, 7).getCellFactory().getCell();
		assertEquals(3,cell.x(grid));
		assertEquals(1,cell.y(grid));
		
		cell = new CellFactory(grid, 15).getCellFactory().getCell();
		assertEquals(3,cell.x(grid));
		assertEquals(3,cell.y(grid));
	}
	
	

}
