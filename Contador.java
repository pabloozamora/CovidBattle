import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Contador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Contador extends Actor
{
    private int puntaje = 0;
    static GreenfootSound pop = new GreenfootSound("point.wav");
    
    public Contador()
    {
        setImage(new GreenfootImage("" + puntaje, 20, Color.WHITE,null));
    }
    /**
     * Act - do whatever the Contador wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void sumarPuntos(int puntos)
    {
        puntaje += puntos;
        pop.setVolume(70);
        pop.play();
        setImage(new GreenfootImage("" + puntaje, 20, Color.WHITE,null));
    }
    
    public void juegoTerminado(){
        setImage(new GreenfootImage("Puntaje final: " + puntaje, 20, Color.WHITE, Color.BLACK));
    }
}
