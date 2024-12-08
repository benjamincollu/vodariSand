import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Kvapalina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kvapalina {
    private ArrayList<Zrnko> zrnka;
    private Material material;
    private Random rand;
    private int[] polohyXTrysiek;
    private int polohaYPodlahy;
    private int sanca;
    /**
     * Constructor for objects of class Kvapalina
     */
    public Kvapalina(Material material, int[] polohyXTrysiek, int polohaYPodlahy) {
        // initialise instance variables
        this.material = material;
        this.polohyXTrysiek = polohyXTrysiek;
        this.rand = new Random();
        this.polohaYPodlahy = polohaYPodlahy;
        this.zrnka = new ArrayList<Zrnko>();
        
        this.sanca = 5;
    }
    
    public int getSanca() {
        return this.sanca;
    }
    
    public void setSanca(int sanca) {
        this.sanca = sanca;
    }
    
    public void vytvorZrnko() {
        int cisloTrysky = this.rand.nextInt(3);
        this.zrnka.add(new Zrnko(this.polohyXTrysiek[cisloTrysky], 60, this.material, this.polohaYPodlahy));
    }
    
    private boolean jeMiestoZabrane(int polohaX, int polohaY) {
        for (Zrnko zrnko : this.zrnka) {
            if (zrnko.getPolohaX() == polohaX && zrnko.getPolohaY() == polohaY) {
                return true;
            }
        }
        return false;
    }
    
    public void tik() {
        for (Zrnko zrnko : this.zrnka) {
            // ak už spadlo, nepohne sa
            if (zrnko.getSpadlo()) {
                continue;
            }
            // ak je zabrane miesto pod ním
            if (jeMiestoZabrane(zrnko.getPolohaX(), zrnko.getPolohaY() + 1)) {
                zrnko.narazilo(jeMiestoZabrane(zrnko.getPolohaX() - 1, zrnko.getPolohaY() + 1), jeMiestoZabrane(zrnko.getPolohaX() + 1, zrnko.getPolohaY() + 1));
            } else {
                zrnko.tik();
            }
        }

        if (this.rand.nextInt(10) < this.sanca) {
            this.vytvorZrnko();
        }
    }
}