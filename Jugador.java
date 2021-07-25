import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador extends Actor
{
    private int velocidad = 3;
    private GreenfootImage arriba = new GreenfootImage("arriba.png");
    private GreenfootImage abajo = new GreenfootImage("abajo.png");
    private GreenfootImage derecha = new GreenfootImage("derecha.png");
    private GreenfootImage izquierda = new GreenfootImage("izquierda.png");
    private GreenfootImage frente = new GreenfootImage("frente.png");
    private int vista;
    private int direccion;
    private int tiempoEspera = 0;
    private int tiempoNuevoVirus = 0;
    int nuevaAltura = frente.getHeight()/5;
    int nuevoAncho = frente.getWidth()/5;
    private Actor virus;
    
    public Jugador()
    {
        frente.scale(nuevaAltura, nuevoAncho);
        setImage(frente);
        arriba.scale(nuevaAltura, nuevoAncho);
        abajo.scale(nuevaAltura, nuevoAncho);
        izquierda.scale(nuevaAltura, nuevoAncho);
        derecha.scale(nuevaAltura, nuevoAncho);
    }
    
    /**
     * Act - do whatever the Jugador wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moverJugador();
        disparar();
        if(tiempoNuevoVirus>0)
        {
            tiempoNuevoVirus = tiempoNuevoVirus -1;
        }
        else{
            Escenario escenario = (Escenario) getWorld();
            escenario.nuevoVirus();
            tiempoNuevoVirus = 200;
        }
    }
    
    
    public void moverJugador()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            setImage(arriba);
            setLocation(getX(),getY()-velocidad);
            direccion = 270;
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setImage(abajo);
            setLocation(getX(),getY()+velocidad);
            direccion = 90;
        }
        if(Greenfoot.isKeyDown("right"))
        {
            setImage(derecha);
            setLocation(getX()+velocidad,getY());
            direccion = 0;
        }
        if(Greenfoot.isKeyDown("left"))
        {
            setImage(izquierda);
            setLocation(getX()-velocidad,getY());
            direccion = 180;
        }
    }
    
    public void disparar()
    {
        if(tiempoEspera>0)
        {
            tiempoEspera = tiempoEspera -1;
        }
        else if (Greenfoot.isKeyDown("space"))
        {
           Actor disparo = new Disparo();
           getWorld().addObject(disparo, getX(), getY());
           disparo.setRotation(direccion);
           tiempoEspera = 100;
        }
    }
    
}