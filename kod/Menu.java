import fri.shapesge.Obdlznik;
import fri.shapesge.Obrazok;
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
    private Obrazok pozadie;
    private Obdlznik piesok;
    private Obdlznik voda;
    private Rectangle2D hitboxPiesok;
    private Rectangle2D hitboxVoda;
    private int vybranaKvapalina;
    private BlokTextu nazovHry;
    private BlokTextu vyberteText;
    private BlokTextu creditsText;
    /**
     * Constructor for objects of class Menu
     */
    public Menu() {
        // initialise instance variables
        this.vybranaKvapalina = 0;
        
        this.pozadie = new Obrazok("img/pozadie.png", 0, 0);
        this.pozadie.zobraz();
        
        this.nazovHry = new BlokTextu("SAND", 400 - 140, 125);
        this.nazovHry.zmenFont("Arial", StylFontu.BOLD, 100);
        this.nazovHry.zobraz();
        
        this.vyberteText = new BlokTextu("Vyberte kvapalinu", 400 - 110, 225);
        this.vyberteText.zmenFont("Arial", StylFontu.BOLD, 25);
        this.vyberteText.zobraz();
        
        this.creditsText = new BlokTextu("Vodári - Benjamín Collu, Marek Kuzma, Martin Kortiš, Tomáš Kučera, Pavlo Slobodian", 5, 590);
        this.creditsText.zmenFont("Arial", StylFontu.BOLD, 15);
        this.creditsText.zobraz();
        
        this.piesok = new Obdlznik();
        this.piesok.zmenPolohu(400 - 25 - 200, 200);
        this.piesok.zmenStrany(50, 20);
        this.piesok.zmenFarbu("yellow");
        this.hitboxPiesok = new Rectangle2D(400 - 25 - 200, 200, 50, 20);
        this.piesok.zobraz();
        
        this.voda = new Obdlznik();
        this.voda.zmenPolohu(400 + 25 + 100, 200);
        this.voda.zmenStrany(50, 20);
        this.voda.zmenFarbu("blue");
        this.hitboxVoda = new Rectangle2D(400 + 25 + 100, 200, 50, 20);
        this.voda.zobraz();
    }
    
    public void skry() {
        this.pozadie.skry();
        this.pozadie = null;
        this.nazovHry.skry();
        this.nazovHry = null;
        this.vyberteText.skry();
        this.vyberteText = null;
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
        if(this.vybranaKvapalina == 0) {
            if (this.hitboxPiesok.contains(x,y)) {
                this.vybranaKvapalina = 1;
            }
            if (this.hitboxVoda.contains(x,y)) {
                this.vybranaKvapalina = 2;
            }
        }
    }
}
