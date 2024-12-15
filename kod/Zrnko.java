import fri.shapesge.Stvorec;
import java.util.Random;
/**
 * Spravuje časticu kvapaliny
 * 
 * @author Marek Kuzma 
 * @version  9.12.2024
 */
public class Zrnko {
    private static final int VELKOST_ZRNKA = 2;
    private int polohaX;
    private int polohaY;
    private int polohaYPodlahy;
    private boolean spadlo;
    private Stvorec stvorec;
    private Material material;
    private Random rand;
    private int pocitadloHustoty;
    /**
     * Vytvára grafickú reprezentáciu častice s požadovaným materiálom na zadanej pozícii
     * @param int polohaX súradnica na osi X, na ktorej chceme, aby sa častica objavila
     * @param int polohaY súradnica na osi Y, na ktorej chceme, aby sa častica objavila
     * @param Material material materiál kvapaliny
     * @param int polohaYPodlahy súradnica na osi Y, ktorá definuje úroveň podlahy pre simuláciu gravitácie
     */
    public Zrnko(int polohaX, int polohaY, Material material, int polohaYPodlahy) {
        this.polohaX = polohaX;
        this.polohaY = polohaY;
        this.polohaYPodlahy = polohaYPodlahy;
        this.spadlo = false;
        this.rand = new Random();
        this.stvorec = new Stvorec(this.polohaX, this.polohaY);
        this.stvorec.zmenStranu(VELKOST_ZRNKA);
        this.material = material;
        this.stvorec.zmenFarbu(this.material.getFarba());
        this.stvorec.zobraz();
    }
    
    /**
     * Vráti polohu častice na osi X
     * @return celé číslo
     */
    public int getPolohaX() {
        return this.polohaX;
    }
    
    /**
     * Vráti polohu častice na osi Y
     * @return celé číslo
     */
    public int getPolohaY() {
        return this.polohaY;
    }
    
    /**
     * Nastaví hodnotu boolean atribútu spadlo na nami požadovanú
     * @param boolean spadlo požadovaná hodnota
     */
    public void setSpadlo(boolean spadlo) {
        this.spadlo = spadlo;
    }
    
    /**
     * Skryje grafickú reprezentáciu častice
     */
    public void skry() {
        this.stvorec.skry();
    }
    
    /**
     * Zistí, či častica narazila a určí jej správanie na základe vstupných boolean parametrov pre jej okolie
     * @param boolean zabraneNalavo parameter odosielaný triedou Kvapalina, informuje o tom, či sa naľavo už nachádza častica 
     * @param boolean zabraneNapravo parameter odosielaný triedou Kvapalina, informuje o tom, či sa napravo už nachádza častica 
     */
    public void narazilo(boolean zabraneNalavo, boolean zabraneNapravo) {
        if (!zabraneNalavo && !zabraneNapravo) {
            if (this.rand.nextInt(2) == 0) {
                this.stvorec.posunVodorovne(-1);
                this.polohaX -= 1;
            } else {
                this.stvorec.posunVodorovne(1);
                this.polohaX += 1;
            }
        } else if (!zabraneNalavo) {
            this.stvorec.posunVodorovne(-1);
            this.polohaX -= 1;
        } else if (!zabraneNapravo) {
            this.stvorec.posunVodorovne(1);
            this.polohaX += 1;
        } else {
            this.spadlo = true;
        }
    }

    /**
     * Vráti hodnotu boolean atribútu spadlo
     * @return boolean
     */
    public boolean getSpadlo() {
        return this.spadlo;
    }
    
    /**
     * Simuluje vplyv gravitácie na časticu
     */
    public void tik() {
        this.pocitadloHustoty++;
        if (this.pocitadloHustoty >= this.material.getHustota()) {
            if (this.polohaY < this.polohaYPodlahy) {
                this.stvorec.posunZvisle(1);
                this.polohaY += 1;
            } else {
                this.spadlo = true;
            }
            this.pocitadloHustoty = 0;
        }
    }
}
