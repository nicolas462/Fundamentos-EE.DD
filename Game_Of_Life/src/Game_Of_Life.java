/**
 * 
 */

/**
 * @author Nicolás David Espejo Bernal
 *
 * 22/05/2018
 */
public class Game_Of_Life {
	
byte [][] board = null;
	
	public Game_Of_Life(int rows, int columns) {
		board = new byte [rows][columns];
	}
	
	public int countNeighbours(int i, int j) {
		int counter = 0;
		
		if (i == 0) //First row
		{
			if (j == 0) //First column
			{
			counter =  board [i] [j + 1]+ board [i + 1] [j] + board [i + 1] [j + 1];
			}
			else
			{
				if (j == board[i].length - 1)
				{
					counter = board [i] [j - 1] + board [i + 1] [j - 1] +  board [i + 1] [j];
				}
				else
				{
					counter = board [i -1] [j - 1] +board [i -1] [j]+ board [i -1] [j + 1]+ board [i] [j - 1]
									  +board [i] [j + 1];
				}
			}
		}
		else
		{
				if (j == 0) //First column
				{
				counter =  board [i - 1] [j]+ board [i - 1] [j + 1] + board [i] [j + 1]
						+ board [i + 1] [j] + board [i + 1] [j + 1];
				}
				else
				{
					if (j == board[i].length - 1) // Last column
					{
						counter = board [i - 1] [j - 1] + board [i - 1] [j] +  board [i] [j - 1]
								+ board [i + 1] [j - 1] + board [i + 1] [j];
					}
					else
					{
						counter = board [i -1] [j - 1] +board [i -1] [j] +board [i -1] [j + 1] 
								+  board [i] [j - 1]+ board [i] [j + 1] + board [i + 1] [j - 1]
									+ board [i + 1] [j] + board [i + 1] [j + 1];
					}
				}
		}
		return counter;
		/*
		  board [i -1] [j - 1]
		  board [i -1] [j]
		  board [i -1] [j + 1]
		  
		  board [i] [j - 1]
		  board [i] [j + 1]
		  
		  board [i + 1] [j - 1]
		  board [i + 1] [j]
		  board [i + 1] [j + 1]
		 */
	}
	
	public int conterNeighbors_toroide (int i, int j) {
		
		int width = board[i].length; //Columns
		int height = board.length; //Rows
		
		return  board [(i -1 + height) % height] [(j - 1 + width) %width] +board [(i -1 + height) % height] [j] 
				+board [(i -1 + height) % height] [(j + 1) %width] + board [i] [j - 1+ width]+ board [i] [(j + 1)%width] 
				+ board [(i + 1)  % height] [j - 1 + width] %width	+ board [(i + 1) % height] [j] 
						+ board [(i + 1) % height] [(j + 1)%width];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
