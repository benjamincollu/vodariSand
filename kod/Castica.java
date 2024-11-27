import fri.shapesge.Rectangle;
/**
 * Write a description of class Castica here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Castica {
    /**
     * Constructor for objects of class Castica
     */
    private Rectangle obdlznik;
    private int poziciaX, poziciaY;
    public Castica(int x, int y) {
        // initialise instance variables
        this.poziciaX = x;
        this.poziciaY = y;
        this.obdlznik = new Rectangle(this.poziciaX, this.poziciaY);
        this.obdlznik.makeVisible();
    }
}
