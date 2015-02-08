package test;

import main.GameOfLife;

import org.junit.Assert;
import org.junit.Test;

public class GameOfLifeTest {
	
	@Test
	public void startAllTrue()
	{		
		Boolean[][] board = new Boolean[5][5];
		
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				board[i][j] = true;
			}
		}
		
		GameOfLife game = new GameOfLife(5, board);
		game.run();
		
		assertAllFalse(game.getBoard());
	}
	
	@Test
	public void startAllFalse()
	{		
		Boolean[][] board = new Boolean[5][5];
		
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[0].length;j++)
			{
				board[i][j] = false;
			}
		}
		
		GameOfLife game = new GameOfLife(5, board);
		game.run();
		
		assertAllFalse(game.getBoard());
	}
	
	@Test
	public void simpleCase()
	{		
		Boolean[][] board = new Boolean[3][3];
		
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[0].length;j++)
			{
				if(i == 1 && j == 1)
				{
					board[i][j] = true;
				}
				else
				{
					board[i][j] = false;
				}
			}
		}
		
		GameOfLife game = new GameOfLife(13, board);
		game.run();
		
		assertAllFalse(game.getBoard());
	}
	
	@Test
	public void moderateCase()
	{
		Boolean[][] board = new Boolean[3][3];
		board[0][0] = true;
		board[0][1] = true;
		board[0][2] = true;
		board[1][0] = false;
		board[1][1] = false;
		board[1][2] = false;
		board[2][0] = true;
		board[2][1] = true;
		board[2][2] = true;
		
		GameOfLife game = new GameOfLife(5, board);
		game.run();
		
		assertAllFalse(game.getBoard());
	}
	
	
	public void moderateCase2()
	{
		Boolean[][] board = new Boolean[3][3];
		board[0][0] = false;
		board[0][1] = false;
		board[0][2] = false;
		board[1][0] = true;
		board[1][1] = true;
		board[1][2] = true;
		board[2][0] = false;
		board[2][1] = false;
		board[2][2] = false;
		
		GameOfLife game = new GameOfLife(1, board);
		game.run();
		
		assertAllTrue(game.getBoard());
	}
	
	@Test
	public void stableCase()
	{
		Boolean[][] board = new Boolean[4][4];
		board[0][0] = false;
		board[0][1] = false;
		board[0][2] = false;
		board[0][3] = false;
		
		board[1][0] = false;
		board[1][1] = true;
		board[1][2] = true;
		board[1][3] = false;
		
		board[2][0] = false;
		board[2][1] = true;
		board[2][2] = true;
		board[2][3] = false;
		
		board[3][0] = false;
		board[3][1] = false;
		board[3][2] = false;
		board[3][3] = false;
		
		GameOfLife game = new GameOfLife(3, board);
		game.run();
		
		assertBoardsEqual(board, game.getBoard());
		
		game = new GameOfLife(14, board);
		game.run();
		
		assertBoardsEqual(board, game.getBoard());
	}
	
	@Test
	public void stableCase2()
	{
		Boolean[][] board = new Boolean[5][5];
		board[0][0] = false;
		board[0][1] = false;
		board[0][2] = false;
		board[0][3] = false;
		board[0][4] = false;
		
		board[1][0] = false;
		board[1][1] = false;
		board[1][2] = false;
		board[1][3] = false;
		board[1][4] = false;
		
		board[2][0] = true;
		board[2][1] = true;
		board[2][2] = true;
		board[2][3] = true;
		board[2][4] = false;
		
		board[3][0] = false;
		board[3][1] = false;
		board[3][2] = false;
		board[3][3] = false;
		board[3][4] = false;
		
		board[4][0] = false;
		board[4][1] = false;
		board[4][2] = false;
		board[4][3] = false;
		board[4][4] = false;
		
		GameOfLife game = new GameOfLife(1, board);
		game.run();
		
		Boolean[][] expectedBoard = new Boolean[5][5];
		expectedBoard[0][0] = false;
		expectedBoard[0][1] = false;
		expectedBoard[0][2] = false;
		expectedBoard[0][3] = false;
		expectedBoard[0][4] = false;
		
		expectedBoard[1][0] = false;
		expectedBoard[1][1] = true;
		expectedBoard[1][2] = true;
		expectedBoard[1][3] = false;
		expectedBoard[1][4] = false;
		
		expectedBoard[2][0] = false;
		expectedBoard[2][1] = true;
		expectedBoard[2][2] = true;
		expectedBoard[2][3] = false;
		expectedBoard[2][4] = false;
		
		expectedBoard[3][0] = false;
		expectedBoard[3][1] = true;
		expectedBoard[3][2] = true;
		expectedBoard[3][3] = false;
		expectedBoard[3][4] = false;
		
		expectedBoard[4][0] = false;
		expectedBoard[4][1] = false;
		expectedBoard[4][2] = false;
		expectedBoard[4][3] = false;
		expectedBoard[4][4] = false;
		
		assertBoardsEqual(expectedBoard, game.getBoard());
	}
	
	private void assertBoardsEqual(Boolean[][] expected, Boolean[][] actual)
	{
		for(int i=0;i<actual.length;i++)
		{
			for(int j=0;j<actual[i].length;j++)
			{
				Assert.assertEquals(expected[i][j], actual[i][j]);
			}
		}
	}
	
	private void assertAllFalse(Boolean[][] board)
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				Assert.assertFalse(board[i][j]);
			}
		}
	}
	
	private void assertAllTrue(Boolean[][] board)
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				Assert.assertTrue(board[i][j]);
			}
		}
	}
}
