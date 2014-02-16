package com.pallot.gameoflife;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainGUI {
	JFrame frame=new JFrame(); //creates frame
    JButton[][] grid; //names the grid of buttons

    public MainGUI(int width, int length){ //constructor
            frame.setLayout(new GridLayout(width,length)); //set layout
            grid=new JButton[width][length]; //allocate the size of grid
            for(int y=0; y<length; y++){
                    for(int x=0; x<width; x++){
                            grid[x][y]=new JButton("("+x+","+y+")"); //creates new button    
                            frame.add(grid[x][y]); //adds button to grid
                    }
            }
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack(); //sets appropriate size for frame
            frame.setVisible(true); //makes frame visible
    }
    public static void main(String[] args) {
            new MainGUI(3,3);//makes new ButtonGrid with 2 parameters
    }
}
