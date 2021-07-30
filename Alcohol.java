import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alcohol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alcohol extends Actor
{
    private Actor jugador;
    private int tiempoAnimacion = 0;
    
    public Alcohol(){
        GreenfootImage imagenAlcohol = new GreenfootImage("alcohol.png");
        int nuevaAltura = imagenAlcohol.getHeight()/5;
        int nuevoAncho = imagenAlcohol.getWidth()/5;
        imagenAlcohol.scale(nuevaAltura, nuevoAncho);
        setImage(imagenAlcohol);
    }
    /**
     * Act - do whatever the Alcohol wants to do. This method is called whenever
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
            Contador contador = escenario.getContador();
            contador.sumarPuntos(5);
            World world;
            world = getWorld();
            world.removeObject(this);
            return;
        }
    }
}
