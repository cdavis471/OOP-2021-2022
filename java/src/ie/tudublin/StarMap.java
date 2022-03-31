package ie.tudublin;

import java.util.ArrayList;

import javax.lang.model.util.ElementScanner14;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet {

    ArrayList<Star> stars = new ArrayList<Star>();
    
    public float border;

    void drawGrid()
    {
        stroke(255, 0, 255);
        textAlign(CENTER, CENTER);
        textSize(20);
        for(int i = -5; i <=5; i ++)
        {
            float x = map(i, -5, 5, border, width - border);
            line(x, border, x, height - border);
            line(border, x, width - border, x);
            fill(255);
            text(i, x, border * 0.5f);
            text(i, border * 0.5f, x);
        }
    }

    void printStars()
    {
        for(Star s:stars)
        {
            System.out.println(s);
        }
    }

    void loadStars()
    {
        Table table = loadTable("HabHYG15ly.csv", "header");
        for(TableRow r:table.rows())
        {
            Star s = new Star(r);
            stars.add(s);
        }
    }

    public void settings() {
        size(500,500);
    }

    Star first = null;
    Star second = null;

    public void mouseClicked()
    {
        for(Star s:stars)
        {
            //assign first, x and y
            float x = map(s.getxG(), -5, 5, border, width - border);
            float y = map(s.getyG(), -5, 5, border, height - border);
            if (dist(mouseX, mouseY, x, y) < 20)
            {
                if(first == null)
                {
                    first = s;
                    break;
                }//end if statement
                else if(second == null)
                {
                    second = s;
                    break;
                }//end else if
                else
                {
                    first = s;
                    second = null;
                    break;
                }
            }//end if statement
        }//end for loop
        if(first == null)
        {

        }
    }

    public void setup() {
        colorMode(RGB);
        loadStars();
        printStars();

        border = width * 0.1f;
    }

    public void drawStars()
    {
        for(Star s:stars)
        {
            s.render(this);
        }
    }

    public void draw() 
    {
        background(0);
        drawGrid();
        drawStars();
        if(first != null)
        {

            float x = map(first.getxG(), -5, 5, border, width - border);
            float y = map(first.getyG(), -5, 5, border, height - border);
            if(second != null)
            {
                float x2 = map(second.getxG(), -5, 5, border, width - border);
                float y2 = map(second.getyG(), -5, 5, border, height - border); 
                stroke(255,255,0);
                line(x,y,x2,y2);
                float dist = dist(first.getxG(),first.getyG(),first.getzG(),second.getxG(), second.getyG(), second.getzG());
                fill(255);
                textAlign(CENTER, CENTER);
                text("Distance between: " + first.getDisplayName() + " and " + second.getDisplayName() + " is " + dist + " parsecs.", width / 2, height - (border * 0.5f));
            }//end if statement
            else
            {
                stroke(255,255,0);
                line(x,y,mouseX,mouseY);
            }//end else statement

        }
    }
}