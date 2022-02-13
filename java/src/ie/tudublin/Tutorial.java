package ie.tudublin;

import processing.core.PApplet;

public class Tutorial extends PApplet
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

	public float magicMap(float p1,float p2,float p3,float p4,float p5)
	{
		float num = p1 - p2;
		float denom = p3 - p2;

		float ans = (p5 - p4) * (num/denom);
		return ans;
		//System.out.println(ans);
	}


	public void draw()
	{
		//magicMap(458, 450, 470, 1000, 3000);
		switch(mode)	
		{
			case 0:
			
				background(0);
				int bars = 10;
				//int bars = mouseX;
				float w = width / bars;
				float colorgap = 255 / bars;
				for(int i = 0; i < bars; i++)
				{
					noStroke();
					fill(magicMap(i, 0, bars, 0, 255), 255, 255);
					rect(magicMap(i, 0, bars, 0, 500), 0, w, height);
				}

                /* ALTERNATE
				for(float x = 0; x <width; x+=w) 
				{
				    rect(x, 0, w, height);
				}
                */

				break;
			case 1:

				//magicMap(458, 450, 470, 1000, 3000);
				break;
		}
	}
}