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
			for(int j=0;j<board[i].length;j++)
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
			for(int j=0;j<board[i].length;j++)
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
