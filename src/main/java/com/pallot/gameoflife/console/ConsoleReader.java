package com.pallot.gameoflife.console;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;

import com.pallot.gameoflife.Shape;

public class ConsoleReader implements Runnable {
	Queue<Command> queue;
	String[] commands = { "ship" };

	public Queue getQueue() {
		return queue;
	}

	public void setQueue(Queue<Command> queue) {
		this.queue = queue;
	}

	public void run() {
		BufferedReader fromConsole = getInput();
		String commandString = null;
		while (true) {
			System.out.println("Enter command:");
			commandString = readLine(fromConsole);
			if ("exit".equalsIgnoreCase(commandString)) {
				queue.add(new Command(true));
				break;
			}
			
			if (!Shape.isValid(commandString)) {
				System.out.println("ERROR: [" + commandString
						+ "]Not valid command. Start again or type exit.");
				continue;
			}
			String shape = commandString;
			commandString = null;
			System.out.println("Enter X cood:");
			commandString = readLine(fromConsole);
			if (isNotANumber(commandString)) {
				System.out.println("ERROR: " + "[" + commandString
						+ "] Not a number. Start again or type exit.");
				continue;
			}
			int x = Integer.parseInt(commandString);

			System.out.println("Enter Y cood:");
			commandString = readLine(fromConsole);
			if (isNotANumber(commandString)) {
				System.out.println("ERROR: " + "[" + commandString
						+ "] Not a number. Start again or type exit.");
				continue;
			}
			int y = Integer.parseInt(commandString);
			
			Command command = new Command(shape, x, y);
			queue.add(command);
			
		}

	}

	private boolean isNotANumber(String commandString) {
		try {
			Integer.parseInt(commandString);
			return false;
		}catch(NumberFormatException e) {
			return true;
		}
	}

	private String readLine(BufferedReader fromConsole) {
		String commandString = null;
		try {
			commandString = fromConsole.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return commandString;
	}

	BufferedReader getInput() {
		return new BufferedReader(new InputStreamReader(System.in));
	}

}
