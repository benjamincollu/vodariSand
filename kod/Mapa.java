import fri.shapesge.Rectangle;
/**
 * Write a description of class Mapa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mapa {
    /**
     * Constructor for objects of class Mapa
     */
    private Rectangle podlaha;
    public Mapa() {
        // initialise instance variables
        this.podlaha = new Rectangle(0,0);
        this.podlaha.changeSize(500, 50);
        this.podlaha.changeColor("#FFFFFF");
        this.podlaha.makeVisible();
    }
}
