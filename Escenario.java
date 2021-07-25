import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Escenario extends World
{
    private Contador contador;
    private Jugador jugador;
    private Vidas vidas;
    private int contadorVidas = 3;
    private Gameover gameover;
    private GreenfootImage ceroVidas = new GreenfootImage("0lives.png");

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Escenario()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage fondo = new GreenfootImage("bg.png");
        setBackground(fondo);
        jugador = new Jugador();
        addObject(jugador,45,347);
        contador = new Contador();
        addObject(contador,87,56);
        Vidas vidas = new Vidas();
        addObject(vidas,53,17);
    }
    
    public Contador getContador()
    {
        return contador;
    }
    
    
    public Vidas getVidas()
    {
        return vidas;
    }
    
    public void quitarVida()
    {
        contadorVidas -= 1;
        if (contadorVidas == 0){
            gameover = new Gameover();
            addObject(gameover,300,200);
            contador.juegoTerminado();
            contador.setLocation(300,300);
            Greenfoot.stop();
        }
    }
    
    public int getContadorVidas()
    {
        return contadorVidas;
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void nuevoVirus(){
        Virus virus = new Virus();
        addObject(virus,Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
    }
}
    
