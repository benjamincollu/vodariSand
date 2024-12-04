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
    private String farba;
    
    public Tryska(int polohaX, int polohaY, String farba) {
        this.polohaX = polohaX;
        this.polohaY = polohaY;
        this.farba = farba;
        this.stvorec = new Stvorec();
        this.stvorec.zmenPolohu(polohaX, polohaY);
        this.stvorec.zmenFarbu(farba);
    }
}
