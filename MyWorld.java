import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{

    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    private void prepare()
    {
        BlueBall blueBall = new BlueBall();
        addObject(blueBall,99,89);
        RedBall redBall = new RedBall();
        addObject(redBall,476,302);
    }
    
}
