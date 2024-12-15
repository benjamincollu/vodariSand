import fri.shapesge.Obdlznik;
import java.util.ArrayList;
/**
 * Vytvára grafickú aj fyzikálnu vizualizáciu mapy
 * 
 * @author Martin Kortiš
 * @version 13.12.2024
 */
public class Mapa {
    private Obdlznik podlaha;
    private ArrayList<Tryska> trysky;
    
    private static final String FARBA_PODLAHY = "#000000";
    
    // sbge.ini
    private static final int MAX_X = 800;
    private static final int MAX_X_PODLAHA = 500;
    private static final int MAX_Y = 600;
    
    private static final int VELKOST_PODLAHY = 75;
    
    private static final int POLOHA_Y_TRYSIEK = 50;
    /**
     * Vytvorí podlahu a inicializuje trysky
     */
    public Mapa() {
        // initialise instance variables
        this.trysky = new ArrayList<Tryska>();
        
        this.podlaha = new Obdlznik(0, MAX_Y - VELKOST_PODLAHY);
        this.podlaha.zmenFarbu(FARBA_PODLAHY);
        this.podlaha.zmenStrany(MAX_X_PODLAHA, VELKOST_PODLAHY);
        this.podlaha.zobraz();
        
        this.trysky.add(new Tryska(100, POLOHA_Y_TRYSIEK));
        this.trysky.add(new Tryska(225, POLOHA_Y_TRYSIEK));
        this.trysky.add(new Tryska(350, POLOHA_Y_TRYSIEK));
    }
    
    /**
     * Skryje všetky trysky a odstráni ich pre prečistenie pamäte
     */
    public void skry() {
        for (int i = this.trysky.size() - 1; i >= 0; i--) {
            this.trysky.get(i).skry();
            this.trysky.remove(i);
        }
    }
    
    /**
     * Vráti pole s polohami trysiek na osi X
     * @return int[] pole celých čísel
     */
    public int[] getPolohyXTrysiek() {
        int[] polohyX = new int[3];
        polohyX[0] = this.trysky.get(0).getPolohaX() + (int)(this.trysky.get(0).getVelkostTrysky() / 2);
        polohyX[1] = this.trysky.get(1).getPolohaX() + (int)(this.trysky.get(1).getVelkostTrysky() / 2);
        polohyX[2] = this.trysky.get(2).getPolohaX() + (int)(this.trysky.get(2).getVelkostTrysky() / 2);
        return polohyX;
    }
    
    /**
     * Vráti polohu všetkých trysiek na osi Y.
     * @return celé číslo
     */
    public int getPolohaYTrysiek() {
        return this.trysky.get(0).getPolohaY();
    }
    
    /**
     * Vráti polohu podlahy na osi X
     * @return celé číslo
     */
    public int getPolohaYPodlahy() {
        return MAX_Y - VELKOST_PODLAHY - 1;
    }
    
    /**
     * Vráti rozlíšenie obrazovky na osi X
     * @return celé číslo
     */
    public int getMaxX() { 
        return MAX_X;
    }
    
    /**
     * Vráti rozlíšenie obrazovky na osi Y
     * @return celé číslo
     */
    public int getMaxY() { 
        return MAX_Y;
    }
}
