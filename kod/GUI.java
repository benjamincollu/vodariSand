import fri.shapesge.BlokTextu;
import fri.shapesge.StylFontu;
import fri.shapesge.Obdlznik;
import java.awt.geom.Rectangle2D;
/**
 * Vykresľuje interaktívne grafické rozhranie
 * 
 * @author Martin Kortiš
 * @version 13.12.2024
 */
public class GUI {
    private Obdlznik meter;
    private BlokTextu sekundy;
    private BlokTextu materialNazov;
    private BlokTextu materialHustota;
    private Obdlznik vysypTlacidlo;
    private Obdlznik zmenRychlostTlacidlo;
    private Obdlznik zmenSancuTlacidlo;
    private BlokTextu vysypText;
    private BlokTextu zmenRychlostText;
    private BlokTextu rychlostText;
    private BlokTextu zmenSancuText;
    private BlokTextu sancaText;
    private float cas;
    private int rychlost;
    private int sanca;
    /**
     * Inicializuje všetky grafické prvky
     * @param Material material vstupný druh materiálu, aký vypísať
     */
    public GUI(Material material) {
        // initialise instance variables
        this.rychlost = 1;
        this.sanca = 50;
        
        this.meter = new Obdlznik(500, 0);
        this.meter.zmenFarbu("black");
        this.meter.zmenStrany(5, 600);
        this.meter.zobraz();
        this.sekundy = new BlokTextu("0", 2, 20);
        this.sekundy.zmenFont("Arial", StylFontu.BOLD, 20);
        this.sekundy.zobraz();
        
        this.materialNazov = new BlokTextu(String.format("Materiál: %s", material.toString()), 515, 25);
        this.materialNazov.zmenFont("Arial", StylFontu.BOLD, 20);
        this.materialNazov.zobraz();
        
        this.materialHustota = new BlokTextu(String.format("hustota: %#.2f", material.getHustota()), 515, 50);
        this.materialHustota.zmenFont("Arial", StylFontu.BOLD, 20);
        this.materialHustota.zobraz();
        
        this.rychlostText = new BlokTextu(String.format("rychlosť: %d", this.rychlost), 515, 75);
        this.rychlostText.zmenFont("Arial", StylFontu.BOLD, 20);
        this.rychlostText.zobraz();
        
        this.sancaText = new BlokTextu(String.format("šanca: %d%%", 50), 515, 100);
        this.sancaText.zmenFont("Arial", StylFontu.BOLD, 20);
        this.sancaText.zobraz();
        
        // tlacidla
        this.vysypTlacidlo = new Obdlznik(550, 250);
        this.vysypTlacidlo.zmenStrany(200, 50);
        this.vysypTlacidlo.zobraz();
        
        this.vysypText = new BlokTextu("Vysyp", 605, 285);
        this.vysypText.zmenFont("Arial", StylFontu.BOLD, 30);
        this.vysypText.zmenFarbu("#FFFFFFF");
        this.vysypText.zobraz();
        
        this.zmenRychlostTlacidlo = new Obdlznik(550, 350);
        this.zmenRychlostTlacidlo.zmenStrany(200, 50);
        this.zmenRychlostTlacidlo.zobraz();
        
        this.zmenRychlostText = new BlokTextu("Zmeniť rýchlosť", 575, 380);
        this.zmenRychlostText.zmenFont("Arial", StylFontu.BOLD, 20);
        this.zmenRychlostText.zmenFarbu("#FFFFFFF");
        this.zmenRychlostText.zobraz();
        
        this.zmenSancuTlacidlo = new Obdlznik(550, 450);
        this.zmenSancuTlacidlo.zmenStrany(200, 50);
        this.zmenSancuTlacidlo.zobraz();
        
        this.zmenSancuText = new BlokTextu("Zmeniť šancu", 585, 480);
        this.zmenSancuText.zmenFont("Arial", StylFontu.BOLD, 20);
        this.zmenSancuText.zmenFarbu("#FFFFFFF");
        this.zmenSancuText.zobraz();
    }

    
    /**
     * Aktualizuje rýchlosť na základe parametra
     * @param int novaRychlost celočíselná nová rýchlosť
     */
    public void setRychlost(int novaRychlost) {
        this.rychlost = novaRychlost;
    }
    
    /**
     * Aktualizuje šancu na základe parametra
     * @param int novaSanca celočíselná nová šanca
     */
    public void setSanca(int novaSanca) {
        this.sanca = novaSanca;
    }
    
    /**
     * Vráti Rectangle2D s hranicou tlačidla Vysyp
     * @return Rectangle2D hranica
     */
    public Rectangle2D getVysypHitbox() {
        return new Rectangle2D.Double(550, 250, 200, 50);
    }
    
    /**
     * Vráti Rectangle2D s hranicou tlačidla Zmeniť rýchlosť
     * @return Rectangle2D hranica
     */
    public Rectangle2D getZmenRychlostHitbox() {
        return new Rectangle2D.Double(550, 350, 200, 50);
    }
    
    /**
     * Vráti Rectangle2D s hranicou tlačidla Zmeniť šancu
     * @return Rectangle2D hranica
     */
    public Rectangle2D getSancaHitbox() {
        return new Rectangle2D.Double(550, 450, 200, 50);
    }
    
    /**
     * Skryje a vynuluje všetky prvky pre šetrenie pamäte
     */
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
        this.rychlostText.skry();
        this.rychlostText = null;
        this.zmenRychlostText.skry();
        this.zmenRychlostText = null;
        this.zmenRychlostTlacidlo.skry();
        this.zmenRychlostTlacidlo = null;
        this.zmenSancuText.skry();
        this.zmenSancuText = null;
        this.zmenSancuTlacidlo.skry();
        this.zmenSancuTlacidlo = null;
        this.sancaText.skry();
        this.sancaText = null;
    }
    
    /**
     * Aktualizuje grafické prvky
     */
    public void tik() {
        this.cas += 0.05;
        this.sekundy.zmenText(String.format("%d", (int)this.cas));
        this.rychlostText.zmenText(String.format("rychlosť: %d", this.rychlost));
        this.sancaText.zmenText(String.format("šanca: %d%%", this.sanca));
    }
}