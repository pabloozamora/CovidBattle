import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vidas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vidas extends Actor
{
    private GreenfootImage tresVidas = new GreenfootImage("3lives.png");
    private GreenfootImage dosVidas = new GreenfootImage("2lives.png");
    private GreenfootImage unaVida = new GreenfootImage("1life.png");
    private GreenfootImage ceroVidas = new GreenfootImage("0lives.png");
    int nuevaAltura = tresVidas.getHeight()/4;
    int nuevoAncho = tresVidas.getWidth()/4;
    private int vidas;
    public Vidas()
    {
        tresVidas.scale(nuevaAltura, nuevoAncho);
        setImage(tresVidas);
        dosVidas.scale(nuevaAltura, nuevoAncho);
        unaVida.scale(nuevaAltura, nuevoAncho);
        ceroVidas.scale(nuevaAltura, nuevoAncho);
    }
    /**
     * Act - do whatever the Vidas wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        Escenario escenario = (Escenario) getWorld();
        vidas = escenario.getContadorVidas();
        
        if (vidas == 3)
        {
            setImage(tresVidas);
        }
        else if (vidas == 2)
        {
            setImage(dosVidas);
        }
        else if (vidas == 1)
        {
            setImage(unaVida);
        }
        else if (vidas == 0)
        {
            setImage(ceroVidas);
        }
    }
}
