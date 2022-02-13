package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{


	int mode = 0;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(RGB);
		background(0,0,0);
		
	}

	public void keyPressed()
	{
		if (key >= '0' && key <='9')
		{
			mode = key - '0';
		}
		println(mode);
	}

	
	public void draw()
	{
		//lab 3
		switch(mode)	
		{
			/*
			//Box Exercise 1
			case 0:
				//hovering over left box
				if(mouseX >= 100 && mouseX <= 100 + 150 && mouseY >= 0 && mouseY <= 0 + 500)
				{
					//fill cyan
					fill(0,255,255);
				}
				//not hovering over left box
				else
				{
					//fill black
					fill(0,0,0);
				}
				//draw rectangle
				rect(100,0,150,500);
				//hovering over right box
				if(mouseX >= 250 && mouseX <= 250 + 150 && mouseY >= 0 && mouseY <= 0 + 500)
				{
					//fill cyan
					fill(0,255,255);
				}
				//not hovering over right box
				else
				{
					//fill black
					fill(0,0,0);
				}
				//draw rectangle
				rect(250,0,150,500);
			//Box Exercise 2
			case 1:
				//hovering over left top box
				if(mouseX >= 100 && mouseX <= 100 + 150 && mouseY >= 0 && mouseY <= 0 + 250)
				{
					//fill cyan
					fill(0,255,255);
				}
				//not hovering over left top box
				else
				{
					//fill black
					fill(0,0,0);
				}
				//draw rectangle
				rect(100,0,150,250);
				//hovering over right top box
				if(mouseX >= 250 && mouseX <= 250 + 150 && mouseY >= 0 && mouseY <= 0 + 250)
				{
					//fill cyan
					fill(0,255,255);
				}
				//not hovering over right top box
				else
				{
					//fill black
					fill(0,0,0);
				}
				//draw rectangle
				rect(250,0,150,250);
				//hovering over left bottom box
				if(mouseX >= 100 && mouseX <= 100 + 150 && mouseY >= 250 && mouseY <= 250 + 250)
				{
					//fill cyan
					fill(0,255,255);
				}
				//not hovering over left bottom box
				else
				{
					//fill black
					fill(0,0,0);
				}
				//draw rectangle
				rect(100,250,150,250);
				//hovering over right bottom box
				if(mouseX >= 250 && mouseX <= 250 + 150 && mouseY >= 250 && mouseY <= 250 + 250)
				{
					//fill cyan
					fill(0,255,255);
				}
				//not hovering over right bottom box
				else
				{
					//fill black
					fill(0,0,0);
				}
				//draw rectangle
				rect(250,250,150,250);
			//Box Exercise 3
			case 2:
				//hovering over middle
				if(mouseX >= 150 && mouseX <= 175 + 175 && mouseY >= 200 && mouseY <= 200 + 100)
				{
					//fill cyan
					fill(255,0,0);
				}
				//not hovering over middle
				else
				{
					//fill cyan
					fill(0,255,255);
				}
				//draw rectangle
				rect(150,200,175,100);
			//For Loop Exercise 1
			case 3:
				colorMode(HSB,500);
				noStroke();
				int i = 0;
				while(i <= 500)
				{
					rect(i, 0, 100, 500);
					i = i + 50;
					fill(i,500,500);
				}
			//For Loop Exercise 2
			case 4:
				colorMode(HSB,500);
				noStroke();
				int i = 0;
				while(i <= 500)
				{
					rect(i, i, 50, 50);
					i = i + 50;
					fill(i,500,500);
				}
			//For Loop Exercise 3
			case 5:
				colorMode(HSB,500);
				noStroke();
				int i = 0;
				while(i <= 500)
				{
					rect(450-i, i, 50, 50);
					rect(i, i, 50, 50);
					i = i + 50;
					fill(i,500,500);
				}
			//For Loop Exercise 4
			case 6:
				colorMode(HSB,680);
				noStroke();
				for(int j = 500;j >= 50; j -= 50)
				{
					fill(j,680,680);
					circle(250,250,j);
				}
			//For Loop Exercise 5
			case 7:
				colorMode(HSB,700);
				noStroke();
				for(int j = 0;j <= 500; j += 50)
				{
					fill(j,700,700);
					circle(25+j,25,50);
				}
			//For Loop Exercise 6
			case 8:
				colorMode(HSB,1350);
				noStroke();
				for(int j = 0;j <= 500; j += 50)
				{
					for(int x = 0;x <= 500; x += 50)
					{
						fill(j+x,1350,1350);
						circle(25+j,25+x,50);
					}
				}
			//For Loop Exercise 7
			case 9:
				colorMode(RGB);
				int i = -5;
				for(int j = 50;j <= 450; j += 40)
				{
					line(50,j,450,j);
					line(j,50,j,450);
					fill(0,255,0);
					stroke(0,255,0);
					textSize(12);
					fill(255,255,255);
					text(i, j, 40);
					text(i, 30, j);  
					i = i + 1;
				}
			//Chess Board Exercise
			case 0:
				colorMode(RGB);
				noStroke();
				for(int x = 0;x <= 500; x += 50)
				{
					for(int j = 0;j <= 500; j += 25)
					{
						fill(0,0,200);
						rect(x+j+25, 0+j, 25, 25);
						rect(500-x-j+25, 500-j, 25, 25);
						fill(0,0,100);
						rect(x+j, 0+j, 25, 25);
						rect(500-x-j, 500-j, 25, 25);
					}
				}
			//Procedural Star Exercise
			case 1:
				//remember sin and cos for polygons, stars etc.
			*/
		}
	}
}
