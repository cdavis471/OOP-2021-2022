package ie.tudublin;

import processing.core.PApplet;

public class LifeBoard 
{
    
    //variables
    boolean[][] board;
    boolean[][] next;
    int size;
    float cellSize;
    PApplet pa;

    public LifeBoard(int size, PApplet pa)
    {
        board = new boolean[size][size];
        next = new boolean[size][size];
        this.size = size;
        this.pa = pa;
        cellSize = pa.width / (float) size;
    }//end LifeBoard

    //randomise
    public void randomise()
    {
        //iteration through rows
        for(int row = 0 ; row < size ; row ++)
        {
            //iterate through column
            for(int col = 0 ; col < size ; col ++)
            {
                //randomise
                board[row][col] = pa.random(1.0f) > 0.5f;
            }//end for loop
        }//end for loop
    }//end randomise method

    //update board
    public void update()
    {
        //If cell is alive
        //2 - 3 -> Survives
        //if a dead cell has 3 neighbours - comes to life
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                //counter
                int count = countCellsAround(row, col);
                //check if alive at current row and column
                if (isAlive(row, col))
                {
                    if (count == 2 || count == 3)
                    {
                        next[row][col] = true;
                    }//end if statement
                    else
                    {
                        next[row][col] = false;
                    }//end else statement
                }//end if statement
                else
                {
                    if (count == 3)
                    {
                        next[row][col] = true;
                    }//end if statement
                    else
                    {
                        next[row][col] = false;
                    }//end else statement
                }//end else statement
            }//end for loop
        }//end for loop
        boolean[][] temp;
        temp = board;
        board = next;
        next = temp;
    }//end update method

    //count cells around
    public int countCellsAround(int row, int col)
    {
        int count = 0;
        for(int i = row - 1 ; i <= row + 1 ; i ++)
        {
            for(int j = col -1 ; j <= col + 1; j ++)
            {
                if (! (i == row && j == col))
                {
                    if (isAlive(i, j))
                    {
                        //count this cell since alive
                        count ++;
                    }//end if statement
                }//end if statement
            }//end for loop
        }//end for loop
        return count;
    }//end countCellsAround

    //is alive
    public boolean isAlive(int row, int col)
    {
        //is alive to return location
        if (row >= 0 && row < size && col >= 0 && col < size)
        {
            return board[row][col]; 
        }//end if statement
        //not alive
        else
        {
            return false;
        }//end else statement
    }//end isAlive

    //draw cell
    public void drawCell(boolean[][] board, int row, int col)
    {
        if (row >= 0 && row < size && col >= 0 && col < size)
        {
            //set current location on board to true
            board[row][col] = true;
        }//end if statement
    }//end drawCell

    //render
    public void render()
    {
        pa.background(0);
        for(int row = 0 ; row < size ; row ++)
        {
            for(int col = 0 ; col < size ; col ++)
            {
                //calculate
                float x = PApplet.map(col, 0, size, 0, pa.width);
                float y = PApplet.map(row, 0, size, 0, pa.height);
                x = cellSize * col;
                y = cellSize * row;
                if (board[row][col])
                {
                    pa.fill(0, 255, 0);
                }//end if statement
                else
                {
                    pa.noFill();
                }//end else statement
                pa.rect(x, y, cellSize, cellSize);
            }//end for loop
        }//end for loop
    }//end render method

    //kill
    public void kill()
    {
        //iterate through rows
        for(int row = 0 ; row < size ; row ++)
        {
            //iterate through columns
            for(int col = 0 ; col < size ; col ++)
            {
                //set cell to false
                board[row][col] = false;
            }//end for loop
        }//end for loop
    }//end kill method

    //cross
    public void cross()
    {
        for(int i = 0;i < size;i++)
        {
            //draw lines top to bottom and left to right --> exactly through middle
            drawCell(board, size / 2, i);
            drawCell(board, i, size / 2);
        }//end for loop
    }//end cross method

}//end LifeBoard class
