package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet {
	
	LifeBoard board;

	//declare variables
	int mode = 0;
	int pause = 0;

	//key pressed
	public void keyPressed() 
	{
		//check key pressed
		if (key >= '0' && key <= '9') 
		{
			mode = key - '0';
		}//end if statement
		//spacebar pressed
		if (keyCode == ' ') 
		{
			//pause if not paused
            if(pause == 0)
			{
				pause = 1;
			}//end if statement
			//unpause if paused
			else
			{
				pause = 0;
			}//end else statement
        }//end if statement
		//1 pressed
		if(keyCode == '1')
		{
			//randomise board
			board.randomise();
		}//end if statement
		//2 pressed
		if(keyCode == '2')
		{
			//kill everything to clear board
			board.kill();
		}//end if statement
		//3 is pressed
		if(keyCode == '3')
		{
			//draw cross right across and top / bottom
			board.cross();
		}//end if statement
	}//end keyPressed method

	//settings
	public void settings() 
	{
		size(1000, 1000);
		board = new LifeBoard(200, this);
		board.randomise();
		println(board.countCellsAround(1, 1));
	}//end settings method

	//setup
	public void setup() 
	{
		colorMode(RGB);
	}//end setup method
	
	//draw
	public void draw() 
	{
		//render board
		board.render();
		//check if paused
		if(pause != 1)
		{
			board.update();
		}//end if statement
	}//end draw method

}
