import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
/**
 * Spravuje častice nami požadovaného materiálu
 * 
 * @author Tomáš Kučera
 * @version 13.12.2024
 */
public class Kvapalina {
    private ArrayList<Zrnko> zrnka;
    private Material material;
    private Random rand;
    private int[] polohyXTrysiek;
    private int polohaYTrysiek;
    private int polohaYPodlahy;
    private int sanca;
    private int rychlost;
    private JOptionPane dialog;
    /**
     * Inicializuje zoznam častíc/zrniek a zadefinuje pozície, z ktorých
     * sa majú objavovať
     * @param Material material nami požadovaný materiál
     * @param int[] polohyXTrysiek celočíselné pole s polohami trysiek na osi X
     * @param int polohaYTrysiek celé číslo vyjadrujúce polohu trysiek na osi Y
     * @param int polohaYPodlahy celé číslo vyjadrujúce polohu podlahy na osi Y
     */
    public Kvapalina(Material material, int[] polohyXTrysiek, int polohaYTrysiek, int polohaYPodlahy) {
        // initialise instance variables
        this.material = material;
        this.polohyXTrysiek = polohyXTrysiek;
        this.polohaYTrysiek = polohaYTrysiek;
        this.rand = new Random();
        this.polohaYPodlahy = polohaYPodlahy;
        this.zrnka = new ArrayList<Zrnko>();
        
        this.dialog = new JOptionPane();
        
        this.rychlost = 1;
        
        this.sanca = 50;
    }
    
    /**
     * Vráti šancu na objavenie častice
     * @return celé číslo
     */
    public int getSanca() {
        return this.sanca;
    }
    
    /**
     * Vráti rýchlosť padania častice
     * @return celé číslo
     */
    public int getRychlost() {
        return this.rychlost;
    }
    
    /**
     * Vytvorí časticu na náhodnej tryske
     */
    public void vytvorZrnko() {
        int cisloTrysky = this.rand.nextInt(3);
        this.zrnka.add(new Zrnko(this.polohyXTrysiek[cisloTrysky], this.polohaYTrysiek, this.material, this.polohaYPodlahy));
    }
    
    /**
     * Vytvorí náhodné množstvo častíc naraz
     */
    public void vysypPiesok() {
        for (int i = 0; i < 125; i++) {
            int cisloTrysky = this.rand.nextInt(3);
            this.zrnka.add(new Zrnko(this.polohyXTrysiek[cisloTrysky], this.polohaYTrysiek + this.rand.nextInt(125) + 300 + this.rand.nextInt(12), this.material, this.polohaYPodlahy));
        }
    }
    
    /**
     * Zmení rýchlosť padania častíc prostredníctvom dialógového okna
     */
    public void zmenRychlost() {
        int docasRychlost = 1;
        do {
            docasRychlost = Integer.parseInt(this.dialog.showInputDialog("Zadajte rýchlosť padania: "));
        } while (docasRychlost <= 0);
        
        this.rychlost = docasRychlost;
    }
    
    /**
     * Zmení šancu objavenia častice prostredníctvom dialógového okna
     */
    public void zmenSancu() {
        int docasSanca = 50;
        do {
            docasSanca = Integer.parseInt(this.dialog.showInputDialog("Zadajte šancu objavovania častíc: "));
        } while (docasSanca <= 0 || docasSanca > 100);
        
        this.sanca = docasSanca;
    }
    
    /**
     * Vráti boolean, ktorý hovorí o tom, či je políčko na zadanej pozícii zabrané inou časticou
     * @param int polohaX pozícia na osi X
     * @param int polohaY pozícia na osi Y
     */
    private boolean jeMiestoZabrane(int polohaX, int polohaY) {
        for (Zrnko zrnko : this.zrnka) {
            if (zrnko.getPolohaX() == polohaX && zrnko.getPolohaY() == polohaY) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Skryje všetky častice a vymaže ich pre šetrenie pamäte
     */
    public void skry() {
        for (int i = this.zrnka.size() - 1; i >= 0; i--) {
            this.zrnka.get(i).skry();
            this.zrnka.remove(i);
        }
        this.zrnka = null;
        this.material = null;
        this.rand = null;
        this.polohyXTrysiek = null;
        this.dialog = null;
    }

    
    /**
     * Aplikuje gravitačnú silu na častice a vytvára nové
     */
    public void tik() {
        for (int i = 0; i <= this.rychlost; i++) {
            for (Zrnko zrnko : this.zrnka) {
                // ak už spadlo, nepohne sa
                if (zrnko.getSpadlo()) {
                    continue;
                }
                // ak je zabrane miesto pod ním
                if (this.jeMiestoZabrane(zrnko.getPolohaX(), zrnko.getPolohaY() + 1)) {
                    zrnko.narazilo(this.jeMiestoZabrane(zrnko.getPolohaX() - 1, zrnko.getPolohaY() + 1), this.jeMiestoZabrane(zrnko.getPolohaX() + 1, zrnko.getPolohaY() + 1));
                } else {
                    zrnko.tik();
                }
            }

            if (this.rand.nextInt(100) < this.sanca) {
                this.vytvorZrnko();
            }
        }
    }
}