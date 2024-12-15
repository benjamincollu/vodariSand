import fri.shapesge.Obdlznik;
import fri.shapesge.Obrazok;
import fri.shapesge.BlokTextu;
import java.awt.geom.Rectangle2D;
import fri.shapesge.StylFontu;
/**
 * Spravuje menu
 * 
 * @author Pavlo Slobodian
 * @version 13.12.2024
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
     * Inicializuje grafické rozhranie a tlačidlá
     */
    public Menu() {
        this.vybranaKvapalina = 0;
        
        this.pozadie = new Obrazok("img/pozadie.png", 0, 0);
        this.pozadie.zobraz();
        
        this.nazovHry = new BlokTextu("SAND", 400 - 140, 125);
        this.nazovHry.zmenFont("Arial", StylFontu.BOLD, 100);
        this.nazovHry.zobraz();
        
        this.vyberteText = new BlokTextu("Vyberte materiál", 400 - 110, 225);
        this.vyberteText.zmenFont("Arial", StylFontu.BOLD, 25);
        this.vyberteText.zobraz();
        
        this.creditsText = new BlokTextu("Vodári - Benjamín Collu, Marek Kuzma, Martin Kortiš, Tomáš Kučera, Pavlo Slobodian", 5, 590);
        this.creditsText.zmenFont("Arial", StylFontu.BOLD, 15);
        this.creditsText.zobraz();
        
        this.piesok = new Obdlznik();
        this.piesok.zmenPolohu(175, 275);
        this.piesok.zmenStrany(150, 50);
        this.piesok.zmenFarbu("yellow");
        this.hitboxPiesok = new Rectangle2D.Double(175, 275, 150, 50);
        this.piesok.zobraz();
        
        this.voda = new Obdlznik();
        this.voda.zmenPolohu(475, 275);
        this.voda.zmenStrany(150, 50);
        this.voda.zmenFarbu("blue");
        this.hitboxVoda = new Rectangle2D.Double(475, 275, 150, 50);
        this.voda.zobraz();
    }
    
    /**
     * Skryje menu a vynuluje jeho prvky pre uvoľnenie pamäte
     */
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
        this.creditsText.skry();
        this.creditsText = null;
    }
    
    /**
     * Vráti vybranú kvapalinu
     * @param int celé číslo od 1-2
     */
    public int getVybranaKvapalina() {
        return this.vybranaKvapalina;
    }
    
    /**
     * Metóda spúšťaná stlačením ľavého tlačidla myši, po stlačení tlačidla v menu sa vyberie kvapalina
     * @param int x súradnica kurzora na osi X
     * @param int y súradnica kurzora na osi Y
     */
    public void stlacenieTlacidla(int x, int y) {
        if (this.vybranaKvapalina == 0) {
            if (this.hitboxPiesok.contains(x, y)) {
                this.vybranaKvapalina = 1;
            }
            if (this.hitboxVoda.contains(x, y)) {
                this.vybranaKvapalina = 2;
            }
        }
    }
}
