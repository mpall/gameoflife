package com.pallot.gameoflife;

import static com.pallot.gameoflife.Cell.ALIVE;

public enum Shape {
	SHIP("ship", new ShapeAnimator() {
		@Override
		public void animate(Grid thisGrid, int x, int y) {
			thisGrid.set(shift(thisGrid, x, y) + 1, ALIVE);
			thisGrid.set(shift(thisGrid, x, y) + 2, ALIVE);
			thisGrid.set(shift(thisGrid, x, y) + 3, ALIVE);
			thisGrid.set(shift(thisGrid, x, y) + 4, ALIVE);
			thisGrid.set(shift(thisGrid, x, y) + thisGrid.getHightAndWidth(),
					ALIVE);
			thisGrid.set(shift(thisGrid, x, y) + thisGrid.getHightAndWidth()
					+ 4, ALIVE);
			thisGrid.set(shift(thisGrid, x, y) + thisGrid.getHightAndWidth()
					* 2 + 4, ALIVE);
			thisGrid.set(shift(thisGrid, x, y) + thisGrid.getHightAndWidth()
					* 3 + 3, ALIVE);
			thisGrid.set(shift(thisGrid, x, y) + thisGrid.getHightAndWidth()
					* 3, ALIVE);
		}
	}), GLIDER("glider", new ShapeAnimator() {
		@Override
		public void animate(Grid thisGrid, int x, int y) {
			thisGrid.set(shift(thisGrid, x, y) + thisGrid.getHightAndWidth(),
					ALIVE);
			thisGrid.set(shift(thisGrid, x, y)
					+ (thisGrid.getHightAndWidth() * 2) + 1, ALIVE);
			thisGrid.set(shift(thisGrid, x, y) + 2, ALIVE);
			thisGrid.set(shift(thisGrid, x, y) + thisGrid.getHightAndWidth()
					+ 2, ALIVE);
			thisGrid.set(shift(thisGrid, x, y)
					+ (thisGrid.getHightAndWidth() * 2) + 2, ALIVE);
		}
	}), BLINKER("blinker", new ShapeAnimator() {
		@Override
		public void animate(Grid thisGrid, int x, int y) {
				thisGrid.set(shift(thisGrid, x, y) + 5, ALIVE);
				thisGrid.set(shift(thisGrid, x, y) + 11, ALIVE);
				thisGrid.set(shift(thisGrid, x, y) + 12, ALIVE);
				thisGrid.set(shift(thisGrid, x, y) + 13, ALIVE);
		}
	}), BLOCK("block", new ShapeAnimator() {
		@Override
		public void animate(Grid thisGrid, int x, int y) {
				thisGrid.set(shift(thisGrid, x, y) + 4, ALIVE);
				thisGrid.set(shift(thisGrid, x, y) + 5, ALIVE);
				thisGrid.set(shift(thisGrid, x, y) + 6, ALIVE);
				thisGrid.set(shift(thisGrid, x, y) + 9, ALIVE);
				thisGrid.set(shift(thisGrid, x, y) + 10, ALIVE);
		}
	});

	private String command;
	private ShapeAnimator shapeAnimator;

	Shape(String command, ShapeAnimator shapeAnimator) {
		this.command = command;
		this.shapeAnimator = shapeAnimator;
	}

	public String getCommand() {
		return command;
	}

	public static Shape getShapeFromCommand(String command) {
		for (Shape shape : values()) {
			if (command.equalsIgnoreCase(shape.getCommand())) {
				return shape;
			}
		}
		return null;
	}
	
	public static boolean isValid(String command) {
		return getShapeFromCommand(command) != null;
	}
	
	public void animate(Grid grid, int x, int y) {
		shapeAnimator.animate(grid, x, y);
	}

	private static int shift(Grid thisGrid, int x, int y) {
		return (thisGrid.getHightAndWidth() * y) + x;
	}

}
