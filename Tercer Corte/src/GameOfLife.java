

public class GameOfLife {
	
	public int rows, columns;
	public double aliveRate;
	public int[][] board = null;
	
	public GameOfLife(int rows, int columns, double aliveRate)
	{
		this.rows = rows;
		this.columns = columns;
		this.aliveRate = aliveRate;
		
		this.board = new int[rows][columns];
		this.randomInit();
	}
	

	public void randomInit()
	{
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < columns; j++)
				this.board[i][j] = Math.random() < aliveRate ? 1 : 0;
	}
	
	
	public int countNeighborsToroidal(int i, int j)
	{
		int width = board[i].length; //Columns
		int height = board.length; //Rows
		
		return  board [(i -1 + height) % height] [(j - 1 + width) %width] +board [(i -1 + height) % height] [j] 
				+board [(i -1 + height) % height] [(j + 1) %width] + board [i] [(j - 1+ width)  %width]+ board [i] [(j + 1)%width] 
				+ board [(i + 1)  % height] [(j - 1 + width) %width]	+ board [(i + 1) % height] [j] 
						+ board [(i + 1) % height] [(j + 1) %width];
	}	
	
	
	public int countNeighbors(int i, int j)
	{
		int counter = 0;
		
		if (i == 0 || i == board.length - 1) //Either first row or last row
		{
			if (i == 0) //First row
			{
				if (j == 0) //First column
					counter =  board [i] [j + 1]+ board [i + 1] [j] + board [i + 1] [j + 1];	
				else
				{
					if (j == board[i].length - 1)
						counter = board [i] [j - 1] + board [i + 1] [j - 1] +  board [i + 1] [j];
					else
						counter = board [i + 1] [j - 1] +board [i + 1] [j]+ board [i + 1] [j + 1]+ board [i] [j - 1]
								+board [i] [j + 1];
				}
			}
			if(i == board.length -1) // Last row
			{
				if (j == 0) //First column
					counter = board [i - 1][j] + board [i - 1][j + 1];
				else
				{
					if (j == board[i].length - 1)
					counter = board [i - 1][j] + board [i - 1][j - 1] + board [i][j - 1];
					else
						counter = board [i][j - 1] + board [i - 1][j - 1] + board [i - 1][j] + board [i - 1][j + 1]
							+ board [i][j + 1];
				}
			}
		}
		else
		{
			if (j == 0 && i != board.length - 1) //First column
			counter =  board [i - 1] [j]+ board [i - 1] [j + 1] + board [i] [j + 1]
					+ board [i + 1] [j] + board [i + 1] [j + 1];
			else
			{
				if (j == board[i].length - 1) // Last column
					counter = board [i - 1] [j - 1] + board [i - 1] [j] +  board [i] [j - 1]
							+ board [i + 1] [j - 1] + board [i + 1] [j];
				else
					counter = board [i -1] [j - 1] +board [i -1] [j] +board [i -1] [j + 1] 
							+  board [i] [j - 1]+ board [i] [j + 1] + board [i + 1] [j - 1]
								+ board [i + 1] [j] + board [i + 1] [j + 1];
			}
		}
		return counter;
	}
	
	
	
	public void iterations()
	{
		int[][] next_generation = this.board.clone();
		//With toroidal.
		///*
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < columns; j++)
			{
				if (this.board [i][j] ==0) { 
					if (countNeighborsToroidal(i, j) == 3) 
						next_generation[i][j] = 1;
				}
				else {
					if(countNeighborsToroidal(i, j) <=1)
						next_generation[i][j] = 0;
					if(countNeighborsToroidal(i, j) >=4)
						next_generation[i][j] = 0;
					if(countNeighborsToroidal(i, j) ==2 || countNeighborsToroidal(i, j) == 3)
						next_generation[i][j] = 1;
				}
			}
			//*/
		//Without toroidal.
		/*
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < columns; j++)
			{
				if (this.board [i][j] ==0) { 
					if (countNeighbors(i, j) == 3) 
						next_generation[i][j] = 1;
				}
				else {
					if(countNeighbors(i, j) <=1)
						next_generation[i][j] = 0;
					if(countNeighbors(i, j) >=4)
						next_generation[i][j] = 0;
					if(countNeighbors(i, j) ==2 || countNeighbors(i, j) == 3)
						next_generation[i][j] = 1;
				}
			}
		*/
		board = next_generation.clone();
	}
}