import fri.shapesge.Manazer;
/**
 * Write a description of class Sand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sand {
    /**
     * Constructor for objects of class Sand
     */
    private Kvapalina kvapalina;
    private ManazerGravitacie manazerGravitacie;
    private Mapa mapa;
    private Manazer manazer;
    private Menu menu;
    public Sand() {
        // initialise instance variables
        this.spustMenu();
    }
    
    public void spustMenu() {
        this.menu = new Menu();
    }
    
    public void spustHru() {
        this.manazerGravitacie = new ManazerGravitacie();
        this.mapa = new Mapa();
    }
    
    public void vypniHru() {
        System.exit(0);
    }
}
