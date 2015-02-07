package main;

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
		for(int i=0;i<gameBoard.length;i++)
		{
			for(int j=0;j<gameBoard[i].length;j++)
			{
				gameBoard[i][j] = getPieceState(i, j);
			}
		}
	}
	
	// Get the state of piece at i,j for the next iteration of the game
	private boolean getPieceState(int i, int j)
	{
		return true;
	}
	
	private void printGameBoard()
	{ 
		for(int i=0;i<gameBoard.length;i++)
		{
			for(int j=0;j<gameBoard[i].length;j++)
			{
				System.out.print(gameBoard[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public Boolean[][] getBoard() {
		return gameBoard;
	}
}
