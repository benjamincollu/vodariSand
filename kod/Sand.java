import fri.shapesge.Manazer;
import fri.shapesge.Obdlznik;
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
        this.manazer = new Manazer();
        this.manazer.spravujObjekt(this);
        this.menu = new Menu();
        this.manazer.spravujObjekt(this.menu);
    }
    
    public void tik() {
        if(this.menu != null) {
            switch(this.menu.getVybranaKvapalina()) {
                case 0:
                    break;
                case 1:
                    this.spustHru("piesok");
                    break;
                case 2:
                    this.spustHru("voda");
                    break;
                default:
                    break;
            }
        }
    }
    
    public void spustHru(String kvapalina) {
        this.menu = null;
        Obdlznik obdlznik = new Obdlznik(0, 0);
        obdlznik.zmenFarbu("white");
        obdlznik.zmenStrany(500, 500);
        obdlznik.zobraz();
        //this.manazerGravitacie = new ManazerGravitacie();
        this.kvapalina = new Kvapalina("voda");
        this.mapa = new Mapa();
    }
    
    public void vypniHru() {
        System.exit(0);
    }
}
