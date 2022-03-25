package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;
import java.lang.Math;

public class PitchSpeller extends PApplet 
{

    /*
    //variables
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;
    */

    //given freq and spellings
    float[] frequencies = {261.63f,293.66f,329.63f,391.99f,440.00f,493.88f,1174.66f};
    String[] spellings = {"C,", "D,", "E,", "G,", "A,", "B,","b"};

    /*
    public void settings()
    {
        //size(1024, 1000, P3D);
        fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        
    }

    public void draw()
    {
        

    }
    */
    
    public String spell(float frequency)
    {

        //variables for checking
        String correctNote = "";
        int index = 0;
        float result = 0;
        float currFreq = frequencies[0];
        //for loop to check for closer frequency
        for(int i = 0;i < frequencies.length;i++)
        {
            if(i == frequencies.length - 1)
            {
                correctNote = spellings[index];
            }//end if statement
        }//end for loop
        return correctNote;
    }//end spell method
    
}//end PitchSpeller class
