package com.pallot.gameoflife.console;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.junit.Before;
import org.junit.Test;

public class ConsoleTest {
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void readFromConsoleToQueue() {
		Queue<Command> queue = new ConcurrentLinkedQueue<Command>();
		
		//Given
		String shape = "ship";
		int x = 1;
		int y = 2;
		Command expected = new Command(shape, x, y); 
		String input = shape + "\n" + x + "\n"+ y + "\nexit\n";
		ConsoleReader console = buildConsoleReader(input, queue);
		
		//When
		console.run();
		
		//Then
		assertThat(queue.size(), equalTo(1));
		assertThat(queue.poll(), equalTo(expected));
	}

	private ConsoleReader buildConsoleReader(String input, Queue<Command> queue) {
		final BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(input.getBytes())));
		ConsoleReader console = new ConsoleReader() {
			@Override
			BufferedReader getInput(){
				return reader;
			}
		};
		console.setQueue(queue);
		return console;
	}

}
