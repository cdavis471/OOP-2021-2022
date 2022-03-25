package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet 
{

    //declare variables
    //rainfall
    float[] rainfall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58};
    //months
    String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    //arrays
    float[] a1 = new float[100];
    float[] a2;
    //indexing
    int minIndex = 0;
    int maxIndex  = 0;
    //graph mode
    int mode = 0;

    //swap between graphs
    public void keyPressed() 
    {
		if (key >= '0' && key <= '9') 
        {
			mode = key - '0';
		}//end if statement
		println(mode);
	}//end keyPressed method
        
    //settings
    public void settings()
    {
        size(500, 500);
    }//end settings method

    //setup method
    public void setup()
    {
        //various ways to print rainfall and months
        for(int i = 0 ; i < rainfall.length ; i ++)
        {
            println(rainfall[i] + "\t" + months[i]);
        }//end for loop
        for(float r:rainfall)
        {
            println(r);
        }//end for loop
        int j = 0;
        for(float r:rainfall)
        {
            println(r + "\t" + months[j]);
            j ++;
        }//end for loop
        for(int i = rainfall.length - 1; i >= 0 ; i -- )
        {
            println(rainfall[i] + "\t" + months[i]);
        }//end for loop
        for(int i = 1 ; i < rainfall.length ; i ++)
        {
            if (rainfall[i] < rainfall[minIndex])
            {
                minIndex = i;
            }//end if statement
            else if (rainfall[i] > rainfall[maxIndex])
            {
                maxIndex = i;
            }//end else if statement
        }//end for loop
        //print max and min rainfall
        println("Max rainfall: " + rainfall[maxIndex] + " in month " + months[maxIndex]);
        println("Min rainfall: " + rainfall[minIndex] + " in month " + months[minIndex]);
    }//end setup method

    //draw method
    public void draw()
    {
        //switch between graphs
        switch (mode) 
        {
            //0: Bar Chart
			case 0:
            {
                background(0);
                colorMode(HSB);
                float w = width / (float)rainfall.length;
                noStroke();
                //display bars
                for(int i = 0 ; i < rainfall.length ; i ++)
                {
                    float x = map(i, 0, rainfall.length, 0, width);
                    int c = (int)map(i, 0, rainfall.length, 0, 255);
                    fill(c, 255, 255);
                    float h = map(rainfall[i], 0, rainfall[maxIndex], 0, -height);
                    rect(x, height, w, h);
                    fill(255);
                    textAlign(CENTER, CENTER);
                    text(months[i], x + (w / 2), height - 50);
                }//end for loop
                break;
            }//end case 0
            //1: Bar Chart Improved
            case 1:
            {
                background(0);
                float border = width * 0.1f;
                //draw axis
                stroke(255);
                line(border, border, border, height - border);
                line(border, height - border, width - border, height - border);
                for(int i = 0 ; i <= 120; i += 10)
                {
                    float y = map(i, 0, 120, height - border, border);
                    line(border - 5, y, border, y);
                    fill(255);
                    textAlign(CENTER, CENTER);
                    text(i, border / 2, y);
                }//end for loop
                float w = (width - (border * 2.0f)) / (float)rainfall.length;
                //display bars for graph and relevant month
                for(int i = 0 ; i < rainfall.length; i ++)
                {
                    float x = map(i, 0, rainfall.length, border, width-border);
                    float c = map(i, 0, rainfall.length, 0, 255);
                    stroke(255);
                    fill(c, 255, 255);
                    float h = map(rainfall[i], 0, 120, 0, -height + (border * 2.0f)); 
                    rect(x, height-border, w, h);
                    fill(255);
                    text(months[i], x + (w / 2), height - (border / 2));
                }//end for loop
                break;
            }//end case 1
            //2: Trend Line
            case 2:
            {
                background(0);
                float border = width * 0.1f;
                //draw axis
                stroke(255);
                line(border, border, border, height - border);
                line(border, height - border, width - border, height - border);
                for(int i = 0 ; i <= 120; i += 10)
                {
                    float y = map(i, 0, 120, height - border, border);
                    line(border - 5, y, border, y);
                    fill(255);
                    textAlign(CENTER, CENTER);
                    text(i, border / 2, y);
                }//end for loop
                float w = (width - (border * 2.0f)) / (float)rainfall.length;
                //calculate trend line
                for(int i = 1 ; i < rainfall.length; i ++)
                {
                    float x = map(i, 0, rainfall.length, border, width-border);
                    float h = map(rainfall[i], 0, 120, border, height-border );
                    float y = map(rainfall[i-1], 0, 120, border, height-border );
                    line(x + (w/2), height-h, x- (w/2), height-y);
                }//end for loop
                //display the months
                for(int i = 0; i < rainfall.length; i++)
                {
                    float x = map(i, 0, rainfall.length, border, width-border);
                    fill(255);
                    text(months[i], x + (w / 2), height - (border / 2));
                }//end for loop
                break;
            }//end case 2
            //3: Pie Chart
            case 3:
            {
                background(0);
                float r = width * 0.3f;
                float cx = width / 2;
                float cy = height / 2;
                noFill();
                stroke(255);
                //ring of the chart
                circle(cx, cy, r * 2.0f);
                //calculate sum of rainfall
                float sum = 0f;
                for(int i = 0; i < rainfall.length; i++)
                {
                    sum = (float)sum + (float)rainfall[i];
                }//end for loop
                //use for calculation for arc and theta
                float init = 0;
                for(int i = 0; i <rainfall.length; i++)
                {
                    //calculate the arc for each month
                    float val = map(rainfall[i], 0, sum, 0, TWO_PI);
                    float c = map(i, 0, rainfall.length, 0, 255);
                    stroke(255);
                    fill(c, 255, 255);
                    arc(cx, cy, r * 2,r * 2, init, init + val, PIE);
                    float theta = init + (val * 0.5f);
                    float x = cx + cos(theta) * (r * 1.2f);
                    float y = cy + sin(theta) * (r * 1.2f);
                    fill(255);
                    //display text
                    text(months[i], x, y);
                    init = init + val;
                }//end for loop
            }//end case 3
        }//end switch statements
    }//end draw method    
}//end Arrays class
