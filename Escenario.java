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
    private Inicio inicio;
    private Logo logo;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Escenario()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage fondo = new GreenfootImage("bginicio.jpg");
        setBackground(fondo);
        logo = new Logo();
        addObject(logo, 308, 143);
        inicio = new Inicio();
        addObject(inicio, 300, 300);
    }
    
    public void empezarJuego(){
        GreenfootImage fondo = new GreenfootImage("bg.png");
        setBackground(fondo);
        removeObject(inicio);
        removeObject(logo);
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
    
    public void sumarVida(){
        if (contadorVidas < 3){
            contadorVidas += 1;
        }
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
    
    public void aparecerMascarilla(){
        Mascarilla mascarilla = new Mascarilla();
        addObject(mascarilla,Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
    }
    
    public void aparecerAlcohol(){
        Alcohol alcohol = new Alcohol();
        addObject(alcohol,Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
    }
}
    
