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
		colorMode(HSB);
		
	}

	public void keyPressed()
	{
		if (key >= '0' && key <='9')
		{
			mode = key - '0';
		}
		println(mode);
	}

	float offset = 0;
	
	public void draw()
	{

		switch(mode)	
		{
			case 0: {
				//rainbow bars
				background(0);
				int bars = (int)(mouseX / 20.0f);
				float w = width / (float)bars;
				for(int i = 0;i < bars;i++)
				{
					noStroke();
					fill(map(i,0,bars,0,255),255,255);
					rect(map(i,0,bars,0,500),0,w,height);
				}
			}
			case 1: {
				//rainbow diagonal squares
				background(0);
				int square = (int)(mouseX / 20.0f);
				float x = width / (float)square;
				for(int i = 0;i < square;i++)
				{
					noStroke();
					fill(map(i,0,square,0,255),255,255);
					rect(map(i,0,square,0,500),map(i,0,square,0,500),x,x);
				}
			}
			case 2: {
				//circle line
				background(0);
				int circle = (int)(mouseX / 20.0f);
				float d = width / (float)circle;
				for(int i = 0;i<circle;i++)
				{
					fill(map(i,0,circle,0,255),255,255);
					circle(map(i,0,circle-1,d / 2.0f,width - (d/2.0f)), height / 2,d);
				}
			}
			case 3: {
				//circle pattern
				background(0);
				int circle = (int)(mouseX / 20.0f);
				float d = width / (float)circle;
				for(int j = 0;j < circle;j++)
				{
					for(int i = 0;i<circle;i++)
					{
						noStroke();
						float c = map(i + j, 0, circle * 2, 0, 255);
						fill(c,255,255);
						float x = map(i,0,circle-1,d/2.0f,width-(d/2.0f));
						float y = map(j,0,circle-1,d/2.0f,width-(d/2.0f));
						circle(x,y,d);
					}
				}
			}
			case 4: {
				//circle pattern with interactive speed and colour
				background(0);
				int circle = (int)(mouseX / 20.0f);
				offset += (mouseY / 100.0f);
				float d = width / (float)circle;
				for(int j = 0;j < circle;j++)
				{
					for(int i = 0;i<circle;i++)
					{
						noStroke();
						float c = map(i + j + offset, 0, circle * 2, 0, 255) % 256;
						fill(c,255,255);
						float x = map(i,0,circle-1,d/2.0f,width-(d/2.0f));
						float y = map(j,0,circle-1,d/2.0f,width-(d/2.0f));
						circle(x,y,d);
					}
				}
			}
		}
	}
}
