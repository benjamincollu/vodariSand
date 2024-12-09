import fri.shapesge.Obdlznik;
import java.util.ArrayList;
/**
 * Write a description of class Mapa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mapa {
    private Obdlznik podlaha;
    private ArrayList<Tryska> trysky;
    
    private static final String FARBA_PODLAHY = "#000000";
    
    // sbge.ini
    private static final int MAX_X = 400;
    private static final int MAX_Y = 300;
    
    private static final int POLOHA_Y_TRYSIEK = 50;
    /**
     * Constructor for objects of class Mapa
     */
    public Mapa() {
        // initialise instance variables
        this.trysky = new ArrayList<Tryska>();
        
        this.podlaha = new Obdlznik(0, MAX_Y-20);
        this.podlaha.zmenFarbu(FARBA_PODLAHY);
        this.podlaha.zmenStrany(MAX_X, 20);
        this.podlaha.zobraz();
        
        this.trysky.add(new Tryska(90, POLOHA_Y_TRYSIEK));
        this.trysky.add(new Tryska(190, POLOHA_Y_TRYSIEK));
        this.trysky.add(new Tryska(290, POLOHA_Y_TRYSIEK));
    }
    
    public int[] getPolohyXTrysiek() {
        int[] polohyX = new int[3];
        polohyX[0] = this.trysky.get(0).getPolohaX() + (int)(this.trysky.get(0).getVelkostTrysky() / 2);
        polohyX[1] = this.trysky.get(1).getPolohaX() + (int)(this.trysky.get(1).getVelkostTrysky() / 2);
        polohyX[2] = this.trysky.get(2).getPolohaX() + (int)(this.trysky.get(2).getVelkostTrysky() / 2);
        return polohyX;
    }
    
    public int getPolohaYPodlahy() {
        return MAX_Y-20;
    }
    
    public int getMaxX() { 
        return MAX_X;
    }
    
    public int getMaxY() { 
        return MAX_Y;
    }
}
