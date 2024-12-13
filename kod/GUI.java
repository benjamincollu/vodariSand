import fri.shapesge.Obrazok;
import fri.shapesge.BlokTextu;
import fri.shapesge.StylFontu;
import fri.shapesge.Obdlznik;
import javafx.geometry.Rectangle2D;
/**
 * Write a description of class GUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GUI {
    private Obrazok meter;
    private BlokTextu sekundy;
    private BlokTextu materialNazov;
    private BlokTextu materialHustota;
    private Obdlznik vysypTlacidlo;
    private BlokTextu vysypText;
    private float cas;
    /**
     * Constructor for objects of class GUI
     */
    public GUI(Material material) {
        // initialise instance variables
        this.meter = new Obrazok("img/meter.png", 0, 0);
        this.meter.zobraz();
        this.sekundy = new BlokTextu("0", 2, 20);
        this.sekundy.zmenFont("Arial", StylFontu.BOLD, 20);
        this.sekundy.zobraz();
        
        this.materialNazov = new BlokTextu(String.format("Materiál: %s", material.toString()), 505, 25);
        this.materialNazov.zmenFont("Arial", StylFontu.BOLD, 20);
        this.materialNazov.zobraz();
        
        this.materialHustota = new BlokTextu(String.format("hustota: %#.2f", material.getHustota()), 505, 50);
        this.materialHustota.zmenFont("Arial", StylFontu.BOLD, 20);
        this.materialHustota.zobraz();
        
        this.vysypTlacidlo = new Obdlznik(550, 125);
        this.vysypTlacidlo.zmenStrany(200, 50);
        this.vysypTlacidlo.zobraz();
        
        this.vysypText = new BlokTextu("Vysyp", 595, 160);
        this.vysypText.zmenFont("Arial", StylFontu.BOLD, 35);
        this.vysypText.zmenFarbu("#FFFFFFF");
        this.vysypText.zobraz();
    }
    
    public Rectangle2D getVysypHitbox() {
        return new Rectangle2D(550, 125, 200, 50);
    }
    
    public void skry() {
        this.meter.skry();
        this.meter = null;
        this.sekundy.skry();
        this.sekundy = null;
        this.materialNazov.skry();
        this.materialNazov = null;
        this.materialHustota.skry();
        this.materialHustota = null;
        this.vysypTlacidlo.skry();
        this.vysypTlacidlo = null;
    }
    
    public void tik() {
        this.cas += 0.05;
        this.sekundy.zmenText(String.format("%d", (int)this.cas));
    }
}