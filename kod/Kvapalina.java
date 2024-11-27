import java.util.ArrayList;
import fri.shapesge.Obdlznik;
/**
 * Write a description of class Kvapalina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kvapalina {
    private ArrayList<Zrnko> castice;
    private String material;
    private int sanca;
    
    public Kvapalina(String material) {
        this.material = material;
        this.sanca = 50;
    }
    
    public void vytvorZrnko(int polohaX) {
        
    }
    
    public void dumpSand(int density) {
        
    }
    
    public void tik() {
        
    }
    
    public int getSanca() {
        return this.sanca;
    }
    
    public void setSanca(int sanca) {
        this.sanca = sanca;
    }
}
