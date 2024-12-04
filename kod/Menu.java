import fri.shapesge.Obdlznik;
import fri.shapesge.Obrazok;
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
    
    public Menu(String pathToImage) {
        int pressedButton= 0;
        this.pozadie = new Obrazok(pathToImage);
        this.pozadie.zmenPolohu(0, 0);
        
        
        this.voda = new Obdlznik();
        this.voda.zmenPolohu(100, 100);
        this.voda.zmenStrany(600, 200);
        this.voda.zmenFarbu("blue");
        
        
        this.piesok = new Obdlznik();
        this.piesok.zmenPolohu(100, 500);
        this.voda.zmenStrany(600, 200);
        this.piesok.zmenFarbu("yellow");
        
        
        this.pozadie.zobraz();
        this.voda.zobraz();
        this.piesok.zobraz();
        this.vyberKvapalinu(pressedButton);
    }
    
    public void vyberKvapalinu(int pressedButton){
        switch(pressedButton){
            case 1:
            //tu musi byt metoda triedy sand ktora ukaze co dalej robit
                return;
            case 2:
            //tu musi byt metoda triedy sand ktora ukaze co dalej robit
                return;
        }
        return;
    }
}
