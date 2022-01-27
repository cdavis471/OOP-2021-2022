package ie.tudublin;

public class Cat extends Animal
{

    private int numLives;

    public int getNumLives()
    {
        return numLives;
    }

    public int setNumLives()
    {
        this.numLives = 9;
        return this.numLives;
    }

    public Cat(String name)
    {
        super(name);
    }

    public int Kill()
    {
        if(this.numLives > 0)
        {
            this.numLives = this.numLives - 1;
            System.out.println("Ouch!");
        }
        else if(this.numLives == 0)
        {
            System.out.println("Dead");
            return -1;
        }
        return 0;
    }

}