package com.pallot.gameoflife;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CoreControl {
	public static final int pixelSize = 2;
	private final Grid thisGrid;
	
	public CoreControl(Grid thisGrid) {
		this.thisGrid = thisGrid;
	}

	public class JPanelGrid extends JPanel {

		private List<Cell> fillCells;

		public JPanelGrid() {
			fillCells = new ArrayList<Cell>();
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (Cell fillCell : fillCells) {
				int cellX = 10 + (fillCell.x(thisGrid) * pixelSize);
				int cellY = 10 + (fillCell.y(thisGrid) * pixelSize);
				g.setColor(Color.RED);
				g.fillRect(cellX, cellY, pixelSize, pixelSize);
			}
			g.setColor(Color.BLACK);
			g.drawRect(10, 10, (thisGrid.getHightAndWidth() * pixelSize),
					(thisGrid.getHightAndWidth() * pixelSize));
		}

		public void fillCell(Cell cell) {
			fillCells.add(cell);
			
		}
		
		public void clear() {
			fillCells.clear();
		}
		
	}

	public static void main(String[] a) {
		//new CoreControl().run();
	}

	public JPanelGrid setUp() {
		final JPanelGrid grid = new JPanelGrid();
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException ex) {
				}

				JFrame window = new JFrame();
				window.setSize((thisGrid.getHightAndWidth() * pixelSize) + 40,
						(thisGrid.getHightAndWidth() * pixelSize) + 60);
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.add(grid);
				window.setVisible(true);
			}
		});
		return grid;
	}
}