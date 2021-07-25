import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mascarilla here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mascarilla extends Actor
{
    boolean atrapado = false;
    /**
     * Act - do whatever the Mascarilla wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(3);
        move(-3);
        }
    
}
