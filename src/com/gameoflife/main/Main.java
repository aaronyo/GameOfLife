package com.gameoflife.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.gameoflife.game.GameOfLife;

public class Main {
	
	public static void main(String[] args) {
		int iterations;
		String[] widthAndHeight;
		int width;
		int height;
		Boolean[][] gameBoard;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// Get our game iterations and width and height
		iterations = Integer.parseInt(readNextLine(reader, "How many iterations?"));
		widthAndHeight = readNextLine(reader, "Width and height?").split(" ");
		
		if(widthAndHeight.length < 2 || widthAndHeight.length > 2) {
			System.out.println("Invalid format for width and height. Please split them with a space.");
			System.exit(1);
		}
		
		// Extract width and height, initialize game board
		width = Integer.parseInt(widthAndHeight[0]);
		height = Integer.parseInt(widthAndHeight[1]);
		gameBoard = new Boolean[width][height];
		
		// Populate the game board
		int i = 0;
		while(i < height) {
			String[] currentLine = readNextLine(reader, "").split(" ");
			if(currentLine.length != width) {
				System.out.println("Invalid row specified. Make sure it is " + width + " characters long and space separated.");
				System.exit(1);
			}
			for(int j=0;j<width;j++) {
				System.out.println(currentLine[j]);
				gameBoard[j][i] = currentLine[j] == "1" ? true : false;
			}
			
			i++;
		}
		
		// Run the game of life!
		GameOfLife game = new GameOfLife(iterations, gameBoard);
		game.run();
	}
	
	private static String readNextLine(BufferedReader reader, String message) {
		String result = null;
		
		try {
			if(message != "") {
				System.out.print(message);
			}
			result = reader.readLine();
		} catch (IOException ioe) {
			System.out.println("Failed to read input!");
			System.exit(1);
		}
		
		return result;
	}
	
}
