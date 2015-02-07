package main;

import java.util.ArrayList;

public class GameOfLife
{
	private Boolean[][] gameBoard;
	private int iterations;
	
	public GameOfLife(int iterations, Boolean[][] gameBoard)
	{
		this.iterations = iterations;
		this.gameBoard = gameBoard;
	}
	
	public void run()
	{
		// Main game loop. Run for specified iteration count.
		for(int iteration=0;iteration<iterations;iteration++)
		{
			updateGameBoard();	
		}
		
		printGameBoard();
	}
	
	// Gets the state of each piece for the next iteration
	// Mutates the gameBoard
	private void updateGameBoard()
	{
		Boolean[][] nextGameBoard = new Boolean[gameBoard.length][gameBoard[0].length];
		
		for(int i=0;i<gameBoard.length;i++)
		{
			for(int j=0;j<gameBoard[i].length;j++)
			{
				nextGameBoard[i][j] = getPieceState(i, j);
			}
		}
		
		gameBoard = nextGameBoard;
	}
	
	// Get the state of piece at i,j for the next iteration of the game
	private boolean getPieceState(int i, int j)
	{
		if(gameBoard[i][j])
		{
			return getAliveNeighborCount(i, j) == 2 ||
					getAliveNeighborCount(i, j) == 3;
		}
		else
		{
			return getAliveNeighborCount(i, j) == 3;
		}
	}
	
	private int getAliveNeighborCount(int i, int j) {
		ArrayList<String> neighborIndices = new ArrayList<String>();
		int aliveCount = 0;
		
		// Just add all neighbor indices, we will clean them up right after
		neighborIndices.add((i-1) + "," + (j-1));
		neighborIndices.add((i-1) + "," + j);
		neighborIndices.add((i-1) + "," + (j+1));
		neighborIndices.add(i + "," + (j-1));
		neighborIndices.add(i + "," + (j+1));
		neighborIndices.add((i+1) + "," + (j-1));
		neighborIndices.add((i+1) + "," + j);
		neighborIndices.add((i+1) + "," + (j+1));
		
		// Now process all the neighbors, wrapping any indices that
		// are out of bounds
		for(int index=0;index<neighborIndices.size();index++)
		{
			String[] curPoint = neighborIndices.get(index).split(",");
			int x = Integer.parseInt(curPoint[0]);
			int y = Integer.parseInt(curPoint[1]);
			
			// Wrap our x coordinate
			if(x < 0)
			{
				x = gameBoard.length - 1;
			}
			else if(x > gameBoard.length - 1)
			{
				x = 0;
			}
			
			// Wrap our y coordinate
			if(y < 0) 
			{
				y = gameBoard[0].length - 1;
			}
			else if(y > gameBoard[0].length - 1)
			{
				y = 0;
			}
			
			// Add to the alive count
			if(gameBoard[x][y])
			{
				aliveCount++;
			}
		}
		
		return aliveCount;
	}
	
	private void printGameBoard()
	{ 
		for(int i=0;i<gameBoard.length;i++)
		{
			for(int j=0;j<gameBoard[i].length;j++)
			{
				System.out.print((gameBoard[i][j] ? 1 : 0) + " ");
			}
			System.out.println();
		}
	}
	
	public Boolean[][] getBoard() {
		return gameBoard;
	}
}
