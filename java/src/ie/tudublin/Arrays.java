package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {

    float[] rainfall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58};
    String[] months = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
    //float[] a1 = new float[100];
    //float[] a2;
    
    public void settings () 
    {
        size(500,500);
    }
    public void setup () 
    {
        //for loop
        for(int i = 0;i < rainfall.length;i++)
        {
            println(rainfall[i] + "\t" + months[i]);
        }
        //enhanced for loop --> not that useful
        for(float r:rainfall)
        {
            println(r);
        }
        //another enchanced for loop
        int ii = 0;
        for(float r:rainfall)
        {
            println(r + "\t" + months[ii]);
            ii++;
        }
        //backwards
        for(int i = rainfall.length - 1;i >=0;i--)
        {
            println(rainfall[i] + "\t" + months[i]);
        }
        //exercise - least and most amount of rainfall
        int minI = 0;
        int maxI = 0;
        for(int i = 1;i < rainfall.length;i++)
        {
            if(rainfall[i] < rainfall[minI])
            {
                minI = i;
            }
            if(rainfall[i] > rainfall[maxI])
            {
                maxI = i;
            }
            if(i == rainfall.length - 1)
            {
                println("Min: " + rainfall[minI] + "\t" + months[minI]);
                println("Max: " + rainfall[maxI] + "\t" + months[maxI]);
            }
        }
        //exercise - average and total amount of rainfall
        float total = 0;
        for(int i = 0;i < rainfall.length;i++)
        {
            total = total + rainfall[i];
            if(i == rainfall.length - 1)
            {
                println("Total: " + total + " / Average: " + total / rainfall.length);
            }
        }
    }
    public void draw () 
    {
        //barchart
        background(0);
		float gap = width / (float)rainfall.length;
		for(int i = 0; i < rainfall.length; i++)
		{
				fill(255);
				rect(gap * i, height, gap, -rainfall[i] *3);
		}
    }
    
}
