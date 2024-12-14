import fri.shapesge.Stvorec;
/**
 * Write a description of class Tryska here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tryska {
    
    private Stvorec stvorec;
    private int polohaX;
    private int polohaY;
    private static final String FARBA = "#8a5d04";
    private static final int VELKOST_TRYSKY = 25;
    /**
     * Constructor for objects of class Tryska
     */
    public Tryska(int polohaX, int polohaY) {
        this.polohaX = polohaX;
        this.polohaY = polohaY;
        this.stvorec = new Stvorec(this.polohaX, this.polohaY);
        this.stvorec.zmenStranu(VELKOST_TRYSKY);
        this.stvorec.zmenFarbu(FARBA);
        this.stvorec.zobraz();
    }
    
    public int getPolohaX() {
        return this.polohaX;
    }
    
    public int getPolohaY() {
        return this.polohaY + VELKOST_TRYSKY;
    }
    
    public int getVelkostTrysky() {
        return VELKOST_TRYSKY;
    }
}
