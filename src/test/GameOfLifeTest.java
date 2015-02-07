package test;

import org.junit.Assert;
import org.junit.Test;

public class GameOfLifeTest {
	Boolean[][] board;
	
	@Test
	public void allTrue()
	{		
		board = new Boolean[5][5];
		
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				board[i][j] = true;
			}
		}
		
		assertAllTrue();
	}
	
	@Test
	public void allFalse()
	{		
		board = new Boolean[5][5];
		
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				board[i][j] = false;
			}
		}
		
		assertAllFalse();
	}
	
	@Test
	public void simpleCase()
	{		
		board = new Boolean[3][3];
		
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
		
		assertAllFalse();
	}
	
	
	private void assertAllFalse()
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				Assert.assertFalse(board[i][j]);
			}
		}
	}
	
	private void assertAllTrue()
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
