import processing.core.PApplet;

public class Fractal extends PApplet {

	int [] rule = {0,1,0,0,1,0,1,0};
	
	public void settings () {
		size(600,600); //Tamaño de pantalla
	}
	
	public void draw() {
		int [][] matrix = new int [150][150];
		int size = 4;
		background(0);
		//Retornar valores
		for (int j = 0; j< 150; j++)
			matrix [0][j] = Math.random() < 0.5 ? 0 : 1;
		
		frameRate(30);
		stroke(255);
		//Recorrer matriz
		for (int i = 1; i < 150 ; i++)
			for (int j = 0; j < 150; j++)
			{
				int index = (matrix [i - 1 ][(j - 1 + 150) % 150] * 4) + (matrix[i - 1][j] * 2) + (matrix[i - 1][(j + 1) % 150]);
				matrix[i][j] = rule[index];
			}
		
		for (int i = 0; i < 150 ; i++)
			for (int j = 0; j < 150; j++)
			{
				if (matrix [i][j] == 0)
					fill(0);
				else
					fill(255);
				
				rect(j * size, i* size, size, size);
			}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		String [] appletArgs = new String[] {"Fractal"};
		PApplet.main(appletArgs);

	}

}
