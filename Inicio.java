import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inicio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inicio extends Actor
{
    private GreenfootImage botonInicio = new GreenfootImage("startgame.png");
    private int nuevaAltura = botonInicio.getHeight()/4;
    private int nuevoAncho = botonInicio.getWidth()/4;
    static GreenfootSound pantallaInicio = new GreenfootSound("startscreen.mp3");
    public Inicio(){
        //botonInicio.scale(nuevaAltura, nuevoAncho);
        setImage(botonInicio);
    }
    /**
     * Act - do whatever the Inicio wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        pantallaInicio.setVolume(30);
        pantallaInicio.play();
        if (Greenfoot.mouseClicked(this)){
            pantallaInicio.stop();
            Escenario escenario = (Escenario) getWorld();
            escenario.empezarJuego();
        }
    }
}
