import fri.shapesge.Stvorec;
import java.util.Random;
/**
 * Write a description of class Zrnko here.
 * 
 * @author Marek Kuzma 
 * @version  9.12.2024
 */
public class Zrnko {
    /**
     * Constructor for objects of class Zrnko
     */
    private static final int VELKOST_ZRNKA = 2;
    private int polohaX;
    private int polohaY;
    private int polohaYPodlahy;
    private boolean spadlo;
    private Stvorec stvorec;
    private Material material;
    private Random rand;
    private int pocitadloHustoty;
    public Zrnko(int polohaX, int polohaY, Material material, int polohaYPodlahy) {
        // initialise instance variables
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
    
    public int getPolohaX() {
        return this.polohaX;
    }
    
    public int getPolohaY() {
        return this.polohaY;
    }
    
    public void setSpadlo(boolean spadlo) {
        this.spadlo = spadlo;
    }
    
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

    
    public boolean getSpadlo() {
        return this.spadlo;
    }
    
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
