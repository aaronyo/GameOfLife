package com.gameoflife.game;

public class GameOfLife {
	private Boolean[][] gameBoard;
	private int iterations;
	
	public GameOfLife(int iterations, Boolean[][] gameBoard) {
		this.iterations = iterations;
		this.gameBoard = gameBoard;
	}
	
	public void run() {
		for(int i=0;i<gameBoard.length;i++) {
			for(int j=0;j<gameBoard[i].length;j++) {
				System.out.print(gameBoard[i][j] + " ");
			}
			System.out.println();
		}
	}
}
