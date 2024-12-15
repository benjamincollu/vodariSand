import fri.shapesge.Stvorec;
/**
 * Vytvára grafickú reprezentáciu trysky
 * 
 * @author Pavlo Slobodian
 * @version 13.12.2024
 */
public class Tryska {
    private Stvorec stvorec;
    private int polohaX;
    private int polohaY;
    private static final String FARBA = "#8a5d04";
    private static final int VELKOST_TRYSKY = 25;
    /**
     * Inicializuje štvorec na zadanej pozícii podľa parametrov
     * @param int polohaX pozícia na osi X
     * @param int polohaY pozícia na osi Y
     */
    public Tryska(int polohaX, int polohaY) {
        this.polohaX = polohaX;
        this.polohaY = polohaY;
        this.stvorec = new Stvorec(this.polohaX, this.polohaY);
        this.stvorec.zmenStranu(VELKOST_TRYSKY);
        this.stvorec.zmenFarbu(FARBA);
        this.stvorec.zobraz();
    }
    
    /**
     * Skryje štvorec
     */
    public void skry() {
        this.stvorec.skry();
    }
    
    /**
     * Vráti pozíciu na osi X
     * @return celé číslo
     */
    public int getPolohaX() {
        return this.polohaX;
    }
    
    /**
     * Vráti pozíciu na osi Y
     * @return celé číslo
     */
    public int getPolohaY() {
        return this.polohaY + VELKOST_TRYSKY;
    }
    
    /**
     * Vráti konštantu veľkosť trysky
     * @return celé číslo
     */
    public int getVelkostTrysky() {
        return VELKOST_TRYSKY;
    }
}
