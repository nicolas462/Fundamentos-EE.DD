

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
	public int width = 900, height = 600, size = 100;
	public int rows = height / size, columns = width / size;
	ChaosFromFractal chaos = new ChaosFromFractal(90, rows, columns);
	GameOfLife life = new GameOfLife(rows, columns, 0.08);
	Minesweeper minas = new Minesweeper(rows, columns, 9); // Rows - Columns - numBombs
	int x, y;
	
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
				
				// Dibujar número de bombas adyacentes
				fill(100, 30, 30);
				if(minas.label[i][j] > 0)		// Imprime los valores de los vecinos
					text(minas.label[i][j], (j * size) + size/2, (i * size) + size/2);
				
				// Dibujar bandera
				fill(100, 30, 30);
				if(minas.label[i][j] == -2)		
					text("X", (j * size) + size/2, (i * size) + size/2);		
			}
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
			if(minas.matrix[y][x] == 1)		// Si selecciona una mina se muestran las demás
			{
				minas.colorRed();
			}
			if(minas.matrix[y][x] == 0)
				minas.setLabel(x, y);
			if(minas.countNeighbors(y, x) == 0)
				minas.label[y][x] = minas.visible;
		}
		if(mouseButton == RIGHT) 
		{
			// Si no está visible y no muestra vecinos
			if(minas.label[y][x] == 0) 
				minas.label[y][x] = minas.flagged;
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