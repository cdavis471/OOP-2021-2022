package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{

    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    //mode variable
    int mode = 0;

    //variables
    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    //key pressed
    public void keyPressed() 
    {
		if (key >= '0' && key <= '9') 
        {
			mode = key - '0';
		}//end if statement
        //spacebar
		if (keyCode == ' ') 
        {
            //if it is playing
            if (ap.isPlaying()) 
            {
                ap.pause();
            }//end if statement
            //if it is paused
            else 
            {
                ap.rewind();
                ap.play();
            }//end else statement
        }//end if statement
	}//end keyPressed method

    //settings
    public void settings()
    {
        size(1024, 1000, P3D);
        //fullScreen(P3D, SPAN);
    }//end settings method

    //setup
    public void setup()
    {
        minim = new Minim(this);
        // Uncomment this to use the microphone
        // ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        // ab = ai.mix; 
        ap = minim.loadFile("heroplanet.mp3", 1024);
        ap.play();
        ab = ap.mix;
        colorMode(HSB);
        y = height / 2;
        smoothedY = y;
        lerpedBuffer = new float[width];
    }//end setup method

    //off var
    float off = 0;

    //draw
    public void draw()
    {
        //background(0);
        float halfH = height / 2;
        float average = 0;
        float sum = 0;
        off += 1;
        //also lerp each element of buffer;
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            float c = map(ab.get(i), -1, 1, 0, 255);
            sum += abs(ab.get(i));
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.05f);
        }//end for loop
        average = sum / (float) ab.size();
        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);
        //center x and y variables
        float cx = width / 2;
        float cy = height / 2;
        //switch statement
        switch (mode) 
        {
            //Normal Visualizer
			case 0:
            {
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++)
                {
                    //float c = map(ab.get(i), -1, 1, 0, 255);
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = lerpedBuffer[i] * halfH * 4.0f;
                    line(i, halfH + f, i, halfH - f);                    
                }//end for loop
                break;
            }//end case 0
            //Wavy Lines Visualizer
            case 1:
            {
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++)
                {
                    //float c = map(ab.get(i), -1, 1, 0, 255);
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = lerpedBuffer[i] * halfH * 4.0f;
                    line(i, halfH + f, halfH - f, i);                    
                }//end for loop
                break;
            }//end case 1
            //Circle Topped Line Visualizer Variant
            case 2:
            {
                float c = map(smoothedAmplitude, 0, 0.5f, 0, 255);
                background(0, 0, 0, 10);
                stroke(c, 255, 255);	
                float radius = map(smoothedAmplitude, 0, 0.1f, 50, 300);		
                int points = (int)map(mouseX, 0, 255, 3, 10);
                int sides = points * 2;
                float px = cx;
                float py = cy - radius; 
                for(int i = 0 ; i <= sides ; i ++)
                {
                    float r = (i % 2 == 0) ? radius : radius / 2; 
                    // float r = radius;
                    float theta = map(i, 0, sides, 0, TWO_PI);
                    float x = cx + sin(theta) * r;
                    float y = cy - cos(theta) * r;
                    //circle(x, y, 20);
                    line(px, py, x, y);
                    px = x;
                    py = y;
                }//end for loop
            }//end case 2
            //Circle Topped Line Visualizer Variant
            case 3:
            {
                background(0);
                strokeWeight(2);
                noFill();
                float r = map(smoothedAmplitude, 0, 0.5f, 100, 2000);
                float c = map(smoothedAmplitude, 0, 0.5f, 0, 255);
                stroke(c, 255, 255);
                circle(cx, cy, r);
            }//end case 3
            //Circle Topped Line Visualizer Variant
            case 4:
            {
                background(0);
                strokeWeight(2);
                for(int i = 0 ; i < ab.size() ; i +=10)
                {
                    //float c = map(ab.get(i), -1, 1, 0, 255);
                    float cc = map(i, 0, ab.size(), 0, 255);
                    stroke(cc, 255, 255);
                    float f = lerpedBuffer[i] * halfH * 4.0f;
                    line(i, halfH + f, i, halfH - f);
                    fill(cc);
                    circle(i, halfH + f, 5);                    
                    circle(i, halfH - f, 5);                    
                }//end for loop
                break;
            }//end case 4
            //Circle Visualizer
            case 5:
            {
                float c = map(smoothedAmplitude, 0, 0.5f, 0, 255);
                background(0);
                c = map(average, 0, 1, 0, 255);
                stroke(c, 255, 255);
                strokeWeight(2);
                noFill();
                ellipse(width / 2, height / 2, 50 + (smoothedAmplitude * 500), 50 + (smoothedAmplitude * 500));
                break;
            }//end case 5
            //Square Visualizer
            case 6:
            {
                float c = map(smoothedAmplitude, 0, 0.5f, 0, 255);
                background(0);
                c = map(average, 0, 1, 0, 255);
                stroke(c, 255, 255);
                strokeWeight(2);
                noFill();
                rectMode(CENTER);
                square(width / 2, height / 2, 50 + (smoothedAmplitude * 500));
                break;
            }//end case 6
            //All Sides Visualizer
            case 7:
            {
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++)
                {
                    //float c = map(ab.get(i), -1, 1, 0, 255);
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = lerpedBuffer[i] * halfH * 8.0f;
                    line(i, 0 + f, i, 0 - f);
                    line(i, height + f, i, height - f);
                    line(0 + f, i, 0 - f, i);
                    line(width + f, i, width - f, i);                  
                }//end for loop
                break;
            }//end case 7
            /*0 Pressed
            case 0:
            {
                background(0);
                strokeWeight(2);
                for(int i = 0 ; i < ab.size() ; i +=10)
                {
                    stroke(255);
                    fill(100, 255, 255);        
                    circle(width / 2, halfH, lerpedBuffer[i] * 100);
                    circle(100, y, 50);
                    y += random(-10, 10);
                    smoothedY = lerp(smoothedY, y, 0.1f);        
                    circle(200, smoothedY, 50);
                }//end for loop
            }//end case 0
            */
            /*5 Pressed
            case 5:
            {
                background(0);
                strokeWeight(2);
                for(int i = 0 ; i < ab.size() ; i +=10)
                {
                    //float c = map(ab.get(i), -1, 1, 0, 255);
                    float cc = map(i, 0, ab.size(), 0, 255);
                    stroke(cc, 255, 255);
                    float f = lerpedBuffer[i] * halfH * 4.0f;
                    fill(cc);
                    circle(width / 2, halfH, 100 + f);                                       
                }//end for loop
                break;
            }//end case 5
            */
        }//end switch statement
    }//end draw class

}//end Audio1 class
