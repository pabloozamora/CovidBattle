import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Virus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Virus extends Actor
{
    private Actor jugador;
    public Virus()
    {
        GreenfootImage imagenVirus = new GreenfootImage("virus.png");
        int nuevaAltura = imagenVirus.getHeight()/6;
        int nuevoAncho = imagenVirus.getWidth()/6;
        imagenVirus.scale(nuevaAltura, nuevoAncho);
        setImage(imagenVirus);
    }
    
    /**
     * Act - do whatever the Virus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {  
        jugador = getOneIntersectingObject(Jugador.class);
        moverse();
        if (jugador != null)
        {
            World world;
            world = getWorld();
            golpearJugador();
            world.removeObject(this);
            return;
        }
    }
    
    private void moverse()
    {
        move(4);
        if (Greenfoot.getRandomNumber(100) < 10)
        {
            turn(Greenfoot.getRandomNumber(90)-45);
        }
        if (getX() <= 5 || getX() >= getWorld().getWidth() - 5)
        {
            turn(180);
        }
        if (getY() <= 5 || getY() >= getWorld().getHeight() - 5)
        {
            turn(180);
        }
    }
    private void golpearJugador()
    {
        Escenario escenario = (Escenario) getWorld();
        escenario.quitarVida();
    }
}
