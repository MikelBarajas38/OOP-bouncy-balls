import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.Random;

/**
 * BlueBall
 **/
 
public class BlueBall extends Actor
{
    
    private Random random = new Random();
    
    private static final int width = 56;
    private static final int height = 56; //will be useful for non-square objects
    
    //private World world; it may be useful as a attribute
    
    private int initialSpeed = 5;
    private int offsetX;
    private int offsetY;
    
    private static final int frameRate = 60;
    private int collisionTimeout;
    
    public BlueBall(){
        offsetX = initialSpeed * (random.nextBoolean()? -1 : 1);
        offsetY = initialSpeed * (random.nextBoolean()? -1 : 1);;
    }
    
    /**
     * Act - do whatever the BlueBall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        World world = getWorld();
        
        int x = getX();
        int y = getY();
        
        //world collision
        
        int closeEdgeX = width / 2;
        int closeEdgeY = height / 2;
        int farEdgeX = world.getWidth() - width / 2;
        int farEdgeY = world.getHeight() - height / 2;
        
        if(x <= closeEdgeX || x >= farEdgeX) {
            offsetX *= -1;
        }
        
        if(y <= closeEdgeY || y >= farEdgeY) {
            offsetY *= -1;
        }
        
        //object collision
        
        RedBall redBall = (RedBall)getOneIntersectingObject(RedBall.class);
        
        if(redBall != null && collisionTimeout == 0) {
            
            world.addObject(new Bomb(), x, y);
            collisionTimeout = frameRate;
            
            offsetX *= -1;
            offsetY *= -1;
            
        }
        
        if(collisionTimeout > 0) {
            collisionTimeout--;
        }
        
        //movement
        
        setLocation(x + offsetX, y + offsetY);
        
    }
}
