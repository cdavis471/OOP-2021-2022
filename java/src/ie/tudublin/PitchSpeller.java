package ie.tudublin;

import processing.core.PApplet;
import java.lang.Math;

public class PitchSpeller extends PApplet
{
    //given frequencies and spellings
    float[] frequencies = {293.66f, 329.63f, 369.99f, 392.00f, 440.00f, 493.88f, 554.37f, 587.33f, 659.25f, 739.99f, 783.99f, 880.00f, 987.77f, 1108.73f, 1174.66f};
    String[] spellings = {"D,", "E,", "F,", "G,", "A,", "B,", "C", "D", "E", "F", "G", "A", "B","c", "d", "e", "f", "g", "a", "b", "c'", "d'", "e'", "f'", "g'", "a'", "b'", "c''", "d''"};
    //record index of closest frequency spelling
    int closest = 0;
    //find the closest frequency
    public String spell(float givenFrequency)
    {   
        //set the initial range for comparison
        float range = Math.abs(frequencies[0] - givenFrequency);
        //iterate through frequencies
        for(int i = 0; i < frequencies.length; i++)
        {   
            //find the closest frequency to the given one
            float findClosest = Math.abs(frequencies[i] - givenFrequency);
            if(findClosest < range)
            {
                //record index of closest frequency
                closest = i;
                //set the new shortest range for comparison with the next frequency
                range = findClosest;
            }//end if statement
        }//end for loop
        //return the closest spelling
        return spellings[closest];
    }//end spell method

}//end PitchSpeller class
