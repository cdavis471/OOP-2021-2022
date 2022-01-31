package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		//colorMode(HSB);
		background(0);
	}
	
	public void draw()
	{	
		/* basics of drawing in processing
		stroke(255);
		//background(200);//single parameter - grayscale
		background(255,255,0);
		fill(0,0,255);
		//noFill();
		//noStroke();
		line(10,10,200,200);//x1, y1, x2, y2
		circle(200,250, 50);//cx, cy, r
		ellipse(50,200,90,200);//cx, cy, w, h
		rectMode(CENTER);//first two param - center of rectangle
		rect(300,20,100,20);//tlx, tly, w, h
		rectMode(CORNER);//first two param - corner of rectangle
		rect(200,20,100,20);//tlx, tly, w, h
		point(20,300);
		triangle(10, 400, 50, 450, 300, 200);//x1, y1, x2, y2, x3, y3
		*/

		//exercise
		colorMode(RGB);
		noStroke();
		background(255,0,0);
		fill(255,255,0);
		circle(250,250,400);
		fill(0,255,255);
		triangle(250,10,40,390,460,390);
		fill(200,200,200);
		ellipse(250,200,187,90);
		fill(0,0,0);
		circle(250,200,75);
	}
}
