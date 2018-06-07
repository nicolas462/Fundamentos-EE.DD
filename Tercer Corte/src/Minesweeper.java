import java.util.Random;

/**
 * 
 */

/**
 * @author Nicolás David Espejo Bernal
 *
 * 5/06/2018
 */
public class Minesweeper {
	
	int [][] matrix = null;
	int [][] label = null; // Matriz que hace visible casillas e imprime la cantidad de minas aledañas
	int rows, columns;
	int bomb = 0; // 1 = Hay bomba 		0 = No hay bomba
	int numBombs;
	int visible = -1, flagged = -2;
	int r = 255, g = 255, b = 255;
	
	/**
	 * Constructor
	 * @param rows
	 * @param columns
	 * @param numBombs
	 */
	public Minesweeper(int rows, int columns, int numBombs)
	{
		this.matrix = new int [rows][columns];
		this.label = new int [rows][columns];
		this.rows = rows;
		this.columns = columns;
		this.numBombs = numBombs;
		
		this.setBombs();
	}
	
	/**
	 * Valores R, G, B
	 */
	public void colorRed()
	{
		this.r = 255;
		this.g= 0;
		this.b = 0;
	}
	/**
	 * Establece bombas aleatoriamente
	 * @param numBombs - Cantidad de bombas
	 */
	public void setBombs()
	{
		Random rd = new Random();
		int x, y;
		for(int i = 0; i < this.numBombs; i++) 
		{
			while (true)
			{
				x = rd.nextInt(this.rows);
				y = rd.nextInt(this.columns);
				if (this.matrix[x][y] == 0)
				{
					this.matrix[x][y] = 1;
					break;
				}	
			}
		}
	}
	
	/**
	 * Pone cantidad de bobas adyacentes
	 * @param x
	 * @param y
	 */
	public void setLabel(int x, int y)
	{
		if(this.countNeighbors(y, x) > 0)
			this.label[y][x] = this.countNeighbors(y, x);
	}
	

	
	/**
	 * Contar celdas aledañas
	 * @param i
	 * @param j
	 * @return - Cantidad de bombas
	 */
	public int countNeighbors(int i, int j)
	{
		int counter = 0;
		
		if (i == 0 || i == this.matrix.length - 1) //Either first row or last row
		{
			if (i == 0) //First row
			{
				if (j == 0) //First column
					counter =  this.matrix [i] [j + 1]+ this.matrix [i + 1] [j] + this.matrix [i + 1] [j + 1];	
				else
				{
					if (j == this.matrix[i].length - 1)
						counter = this.matrix [i] [j - 1] + this.matrix [i + 1] [j - 1] +  this.matrix [i + 1] [j];
					else
						counter = this.matrix [i + 1] [j - 1] +this.matrix [i + 1] [j]+ this.matrix [i + 1] [j + 1]+ this.matrix [i] [j - 1]
								+this.matrix [i] [j + 1];
				}
			}
			if(i == this.matrix.length -1) // Last row
			{
				if (j == 0) //First column
					counter = this.matrix [i - 1][j] + this.matrix [i - 1][j + 1];
				else
				{
					if (j == this.matrix[i].length - 1)
					counter = this.matrix [i - 1][j] + this.matrix [i - 1][j - 1] + this.matrix [i][j - 1];
					else
						counter = this.matrix [i][j - 1] + this.matrix [i - 1][j - 1] + this.matrix [i - 1][j] + this.matrix [i - 1][j + 1]
							+ this.matrix [i][j + 1];
				}
			}
		}
		else
		{
			if (j == 0 && i != this.matrix.length - 1) //First column
			counter =  this.matrix [i - 1] [j]+ this.matrix [i - 1] [j + 1] + this.matrix [i] [j + 1]
					+ this.matrix [i + 1] [j] + this.matrix [i + 1] [j + 1];
			else
			{
				if (j == this.matrix[i].length - 1) // Last column
					counter = this.matrix [i - 1] [j - 1] + this.matrix [i - 1] [j] +  this.matrix [i] [j - 1]
							+ this.matrix [i + 1] [j - 1] + this.matrix [i + 1] [j];
				else
					counter = this.matrix [i -1] [j - 1] +this.matrix [i -1] [j] +this.matrix [i -1] [j + 1] 
							+  this.matrix [i] [j - 1]+ this.matrix [i] [j + 1] + this.matrix [i + 1] [j - 1]
								+ this.matrix [i + 1] [j] + this.matrix [i + 1] [j + 1];
			}
		}
		return counter;
	}
	
	/**
	 * Si está dentro de los límites = True
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean inBounds(int i, int j)
	{
		if (i == 0 || i == this.matrix.length - 1) //Either first row or last row
		{
			if (i == 0) //First row
			{
				if (j == 0) //First column
					return true;	
				else
				{
					if (j == this.matrix[i].length - 1)
						return true;
					else
						return true;
				}
			}
			if(i == this.matrix.length -1) // Last row
			{
				if (j == 0) //First column
					return true;
				else
				{
					if (j == this.matrix[i].length - 1)
						return true;
					else
						return true;
				}
			}
		}
		else
		{
			if (j == 0 && i != this.matrix.length - 1) //First column
				return true;
			else
			{
				if (j == this.matrix[i].length - 1) // Last column
					return true;
				else
					return false;
			}
		}
		return false;	
	}
}
