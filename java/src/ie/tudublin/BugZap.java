package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{

    float playerX = 250;
    float playerY = 250;
    float playerWidth = 50;

    public void keyPressed()
	{
        int end = 0;
        int param1 = (int)playerX;
        int param2 = (int)playerY;
        int param3 = (int)playerX + 5;
        int param4 = (int)playerY + 5;
		if (keyCode == LEFT)
		{
			System.out.println("Left arrow pressed");
            if(playerX >=0)
            {
                playerX--;
            }
            
		}
		if (keyCode == RIGHT)
		{
			System.out.println("Right arrow pressed");
            if(playerX <= 500)
            {
                playerX++;
            }
		}
		if (key == ' ')
		{
			System.out.println("SPACE key pressed");
            stroke(0,200,50);
            line(playerX, playerY-35, playerX, 0);  
		}
	}	

    void drawPlayer(float x, float y, float w)
    {
        stroke(255,0,0);
        fill(200,20,0);
        float h = w / 2;
        float sh = w * 0.7f;
        triangle(x,y-sh,x-h,y,x+h,y);
    }

    public void settings()
	{
		size(500, 500);
	}

	public void draw()
	{	
        colorMode(RGB);
        background(0);
        drawPlayer(playerX, playerY, playerWidth);
	}
}
