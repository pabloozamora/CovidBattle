import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mascarilla here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mascarilla extends Actor
{
    private Actor jugador;
    private int tiempoAnimacion = 0;
    static GreenfootSound powerup = new GreenfootSound("powerup2.mp3");
    /**
     * Act - do whatever the Mascarilla wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        tiempoAnimacion += 1;
        if(tiempoAnimacion==50)
        {
            setLocation(getX(),getY()+10);
        }
        else if(tiempoAnimacion==100){
            setLocation(getX(),getY()-10);
            tiempoAnimacion = 0;
        }
        jugador = getOneObjectAtOffset(0,0,Jugador.class);
        if (jugador != null)
        {
            Escenario escenario = (Escenario) getWorld();
            escenario.sumarVida();
            World world;
            world = getWorld();
            powerup.setVolume(20);
            powerup.play();
            world.removeObject(this);
            return;
        }
        }
    
}
