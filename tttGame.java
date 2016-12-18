/*
 * Prateek Singh
 * This class implements the interface for the player
*/

import java.util.Scanner;

public class tttGame
{
	public static void main(String[] args)
	{
		// actual game

		Scanner scanner = new Scanner(System.in);
		tttBoard userGame = new tttBoard();

		System.out.println("Let's play tic-tac-toe! Start a game? (y/n)");
		String answer = scanner.nextLine();

		if(answer.equals("y"))
		{
			System.out.println("Great, let's start. Go first? (y/n)");
		}
		else if(answer.equals("n"))
			return;

		String goFirst = scanner.nextLine();
		userGame.displayBoard();

		if(goFirst.equals("y"))
		{
			while(!userGame.finished())
			{
				System.out.println("Enter two numbers separated by a space to specify the move.");

				int row = scanner.nextInt();
				int col = scanner.nextInt();

				// human move
				if(!userGame.moveX(row, col))
				{
					System.out.println("Sorry, that move has already been made.");
					continue;
				}

				if(userGame.finished())
				{
					System.out.println("You win!");
					return;
				}

				// computer move
				userGame.compO();

				if(userGame.finished())
				{
					System.out.println("Sorry, you lose!");
					return;
				}

				userGame.displayBoard();

				if(userGame.boardFull())
				{
					System.out.println("It's a tie!");
					return;
				}
			}
		}

		// case where user is player 2
		else if(goFirst.equals("n"))
		{
			int row;
			int col;
			while(!userGame.finished())
			{
				System.out.println("Enter two numbers separated by a space to specify the move.");

				row = scanner.nextInt();
				col = scanner.nextInt();

				// computer move
				userGame.compX();

				if(userGame.finished())
					System.out.println("Sorry, you lose!");

				// human move
				while(!userGame.moveO(row, col))
				{
					System.out.println("Sorry, that move has already been made.");
					System.out.println("Enter two numbers separated by a space to specify the move.");

					row = scanner.nextInt();
					col = scanner.nextInt();
				}

				if(userGame.finished())
					System.out.println("You win!");

				if(userGame.boardFull())
				{
					System.out.println("It's a tie!");
					return;
				}

				userGame.displayBoard();
			}
		}
	}
}
