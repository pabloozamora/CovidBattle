import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Disparo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Disparo extends Actor
{
    private int velocidad = 6;
    private Actor virus;
    static GreenfootSound lanzar = new GreenfootSound("throw.wav");
    /**
     * Act - do whatever the Disparo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Disparo()
    {
        GreenfootImage imagenDisparo = new GreenfootImage("vacunaderecha.png");
        int nuevaAltura = imagenDisparo.getHeight()/5;
        int nuevoAncho = imagenDisparo.getWidth()/5;
        imagenDisparo.scale(nuevaAltura, nuevoAncho);
        setImage(imagenDisparo);
        lanzar.setVolume(70);
        lanzar.play();
    }
    
    public void act(){
        move(velocidad);
        
        virus = getOneObjectAtOffset(0,0,Virus.class);
        if (virus != null)
        {
            World world;
            world = getWorld();
            world.removeObject(virus);
            golpearVirus();
            world.removeObject(this);
            return;
        }
        if (getX() <= 5 || getX() >= getWorld().getWidth() - 5)
        {
            getWorld().removeObject(this);
            return;
        }
        if (getY() <= 5 || getY() >= getWorld().getHeight() - 5)
        {
            getWorld().removeObject(this);
            return;
        }
    }
    
    private void golpearVirus()
    {
        Escenario escenario = (Escenario) getWorld();
        Contador contador = escenario.getContador();
        contador.sumarPuntos(10);
    }
}
