import fri.shapesge.Obdlznik;
import fri.shapesge.BlokTextu;
import javafx.geometry.Rectangle2D;
import fri.shapesge.StylFontu;
/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu {
    
    private Obdlznik piesok;
    private Obdlznik voda;
    private Rectangle2D hitboxPiesok;
    private Rectangle2D hitboxVoda;
    private int vybranaKvapalina;
    private BlokTextu nazovHry;
    /**
     * Constructor for objects of class Menu
     */
    public Menu() {
        // initialise instance variables
        this.vybranaKvapalina = 0;
        
        this.nazovHry = new BlokTextu("SAND", 125, 100);
        this.nazovHry.zmenFont("Arial", StylFontu.BOLD, 50);
        this.nazovHry.zobraz();
        
        this.piesok = new Obdlznik();
        this.piesok.zmenPolohu(100, 200);
        this.piesok.zmenStrany(50, 20);
        this.piesok.zmenFarbu("yellow");
        this.hitboxPiesok = new Rectangle2D(100, 200, 50, 20);
        this.piesok.zobraz();
        
        this.voda = new Obdlznik();
        this.voda.zmenPolohu(250, 200);
        this.voda.zmenStrany(50, 20);
        this.voda.zmenFarbu("blue");
        this.hitboxVoda = new Rectangle2D(250, 200, 50, 20);
        this.voda.zobraz();
    }
    
    public void skry() {
        this.nazovHry.skry();
        this.nazovHry = null;
        this.voda.skry();
        this.hitboxVoda = null;
        this.voda = null;
        this.piesok.skry();
        this.hitboxPiesok = null;
        this.piesok = null;
    }
    
    public int getVybranaKvapalina() {
        return this.vybranaKvapalina;
    }
    
    public void stlacenieTlacidla(int x, int y) {
        if(this.hitboxPiesok.contains(x,y)) {
            this.vybranaKvapalina = 1;
        }
        if(this.hitboxVoda.contains(x,y)) {
            this.vybranaKvapalina = 2;
        }
    }
}
