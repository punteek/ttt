/*
 * Prateek Singh
 * Tic-tac-toe player (makes random moves)
 * This class implements the board and basic moves
*/

import java.util.Random;

public class tttBoard
{
	// 2D array to represent board
	private int[][] m_board;

	// constructor
	public tttBoard ()
	{
		m_board = new int[3][3];
	}

	// print current board position
	public void displayBoard()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				System.out.print(m_board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	// make a move with X at specified positon
	public boolean moveX(int row, int col)
	{
		if(m_board[row][col] == 0)
		{
			m_board[row][col] = 1;
			return true;
		}
		else
			return false;
	}

	// computer makes a random move with X at specified position
	public void compX()
	{
		boolean madeMove = false;
		Random position = new Random();
		int row, col;

		while(!madeMove)
		{
			row = position.nextInt(3);
			col = position.nextInt(3);

			if (m_board[row][col] == 0)
			{
				moveX(row, col);
				madeMove = true;
			}
		}
	}

	// make a move with O at specified position
	public boolean moveO(int row, int col)
	{
		if(m_board[row][col] == 0)
		{
			m_board[row][col] = 2;
			return true;
		}
		else
			return false;
	}

	// computer makes a random move with O at specified position
	public void compO()
	{
		boolean madeMove = false;
		Random position = new Random();
		int row, col;

		while(!madeMove)
		{
			row = position.nextInt(3);
			col = position.nextInt(3);

			if (m_board[row][col] == 0)
			{
				moveO(row, col);
				madeMove = true;
			}
		}
	}

	// resets the board (I will use this later to implement
	// a feature where the user can play many rounds in one run
	// of the program)
	public void clearBoard()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				m_board[i][j] = 0;
			}
		}
	}

	// checks if the board is full (all possible moves have been made)
	public boolean boardFull()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(m_board[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	// checks if either the player or computer has won
	public boolean finished()
	{
		if((m_board[0][0] == 1 && m_board[0][1] == 1 && m_board[0][2] == 1) ||
		   (m_board[0][0] == 1 && m_board[1][0] == 1 && m_board[2][0] == 1) ||
		   (m_board[0][0] == 1 && m_board[1][1] == 1 && m_board[2][2] == 1) ||
		   (m_board[2][0] == 1 && m_board[2][1] == 1 && m_board[2][2] == 1) ||
		   (m_board[0][2] == 1 && m_board[1][2] == 1 && m_board[2][2] == 1) ||

		   (m_board[0][0] == 2 && m_board[0][1] == 2 && m_board[0][2] == 2) ||
		   (m_board[0][0] == 2 && m_board[1][0] == 2 && m_board[2][0] == 2) ||
		   (m_board[0][0] == 2 && m_board[1][1] == 2 && m_board[2][2] == 2) ||
		   (m_board[2][0] == 2 && m_board[2][1] == 2 && m_board[2][2] == 2) ||
		   (m_board[0][2] == 2 && m_board[1][2] == 2 && m_board[2][2] == 2))
		   	return true;
		else
			return false;
	}
}