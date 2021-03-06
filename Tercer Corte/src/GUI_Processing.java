

import processing.core.PApplet;

/*
# GUI for Matrix  made in Processing API.
#
# Created by Msc. Carlos Andres Sierra on April 2018.
# Copyright (c) 2018  Msc. Carlos Andres Sierra. Research Group on Artificial Life - ALIFE. All rights reserved.
#
# This file is part of DataStructuresTemplates.
#
# DataStructuresTemplates is free software: you can redistribute it and/or modify it under the terms of the
# GNU General Public License as published by the Free Software Foundation, version 3.
*/

/**
 * This class represents the behavior of a GUI made in Processing API
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class GUI_Processing extends PApplet {

	/*
	 * 
	 */
	public int width = 600, height = 600, size = 100;
	public int rows = height / size, columns = width / size;
	ChaosFromFractal chaos = new ChaosFromFractal(90, rows, columns);
	GameOfLife life = new GameOfLife(rows, columns, 0.08);
	int x, y, counter =0, bombs = 9;
	boolean inGame = true;
	Minesweeper minas = new Minesweeper(rows, columns, bombs); // Rows - Columns - numBombs
	
	
	/**
	 * 
	 */
	public void settings()
	{
		size(width, height);
	}
		
	
	/**
	 * 
	 */
	public void draw()
	{
		background(0);
		stroke(20);
		
		//For chaos 
		/*for(int i = 0; i < rows; i++)
			for(int j = 0; j < columns; j++)
			{
				if(chaos.matrix[i][j] == 0)
					fill(0);
				else
					fill(255);
				
				rect(j * size, i * size, size, size);
			}
				
		chaos.iterations();*/
		
		
		//For Game of Life
		/*for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < columns; j++)
			{
				if(life.board[i][j] == 0)
					fill(0);
				else
					fill(255);
				
				rect(j * size, i * size, size, size);
			}
		}
		
		life.iterations();*/
		
		// Buscaminas
		if(inGame == true)
		{
			for(int i = 0; i < rows; i++)
			{
				for(int j = 0; j < columns; j++)
				{
					
					if(minas.matrix[i][j] == 0 ) 
					{
						fill(255);
						if(minas.label[i][j] == -1)		// Dibujar celdas ya seleccionadas
							fill(186, 186, 186);
						if(minas.label[i][j] == -3)
							fill(255,0,0);
					}
					else		//Dibujar minas
						fill(minas.r,minas.g,minas.b);
					
					rect(j * size, i * size, size, size);
					
					// Dibujar n�mero de bombas adyacentes
					fill(100, 30, 30);
					if(minas.label[i][j] > 0)		// Imprime los valores de los vecinos
						text(minas.label[i][j], (j * size) + size/2, (i * size) + size/2);
					
					// Dibujar bandera
					fill(100, 30, 30);
					if(minas.label[i][j] == -2)		
						text("X", (j * size) + size/2, (i * size) + size/2);		
				}
			}
		}
		else
		{
			fill(0, 255, 0);
			textSize(64);
			text("You won!", 100, 100);
		}
		
		try
		{
			Thread.sleep(100);
		}
		catch(Exception ex) {}
	}
	
	/**
	 * Evento, mouse click para buscaminas
	 */
	public void mousePressed()
	{
		this.x = mouseX/size;
		this.y = mouseY/size;
		if(mouseButton == LEFT) 
		{
			if(minas.matrix[y][x] == 1)		// Si selecciona una mina se muestran las dem�s
				minas.colorRed();
			
			if(minas.matrix[y][x] == 0)		// Muestra las minas adyacentes
				minas.setLabel(x, y);
			
			if(minas.countNeighbors(y, x) == 0)		// Si no hay celdas alrededor celda = visible
				minas.label[y][x] = minas.visible;
		}
		if(mouseButton == RIGHT) 
		{
			if(minas.matrix[y][x] == 1) 
				if(minas.label[y][x] != -2) 		// Si la mina no est� marcada ya
					counter += 1;
			
			if(minas.label[y][x] == 0) 			// Si no est� visible y no muestra vecinos se puede marcar
				minas.label[y][x] = minas.flagged;
			
			if(counter == this.bombs)		// Cuando se marquen todas las minas, se ganar�
				inGame = false;
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String[] appletArgs = new String[] {"GUI_Processing"};
		PApplet.main(appletArgs);
	}
}