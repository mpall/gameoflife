package com.pallot.gameoflife.console;

public class Command {

	private String shape;
	private int x;
	private int y;
	private boolean exit = false;

	public Command(String shape, int x, int y) {
		this.shape = shape;
		this.x = x;
		this.y = y;
	}
	
	public Command(boolean exit) {
		this.exit = exit;
	}

	public String getShape() {
		return shape;
	}
	
	public int x() {
		return x;
	}
	
	public int y() {
		return y;
	}
	
	public boolean exit() {
		return exit;
	}
	
	public void exit(boolean exit) {
		this.exit = exit;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shape == null) ? 0 : shape.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Command other = (Command) obj;
		if (shape == null) {
			if (other.shape != null)
				return false;
		} else if (!shape.equals(other.shape))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	

}
