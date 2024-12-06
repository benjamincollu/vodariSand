import fri.shapesge.Obdlznik;
import fri.shapesge.Obrazok;
import javafx.geometry.Rectangle2D;
/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu {
    private Obdlznik piesok;
    private Obdlznik voda;
    private Obrazok pozadie;
    private Rectangle2D hitboxPiesok;
    private Rectangle2D hitboxVoda;
    private int vybranaKvapalina;
    
    public Menu() {
        this.vybranaKvapalina = 0;
        this.pozadie = new Obrazok("img/pozadie.png");
        this.pozadie.zmenPolohu(0, 0);

        this.voda = new Obdlznik();
        this.voda.zmenPolohu(100, 100);
        this.voda.zmenStrany(50, 20);
        this.voda.zmenFarbu("blue");
        this.hitboxVoda = new Rectangle2D(100, 10, 50, 20);
        
        this.piesok = new Obdlznik();
        this.piesok.zmenPolohu(300, 100);
        this.piesok.zmenStrany(50, 20);
        this.piesok.zmenFarbu("yellow");
        this.hitboxVoda = new Rectangle2D(300, 100, 50, 20);
        
        this.pozadie.zobraz();
    }
    
    public int getVybranaKvapalina() {
        return this.vybranaKvapalina;
    }
    
    public void stlacenieTlacidla(int x, int y) {
        Rectangle2D mys = new Rectangle2D(x, y, 1, 1);
        if(mys.intersects(this.hitboxPiesok)) {
            this.vybranaKvapalina = 1;
        }
        if(mys.intersects(this.hitboxVoda)) {
            this.vybranaKvapalina = 2;
        }
    }
}
