import java.util.ArrayList;
import fri.shapesge.Obdlznik;
import java.util.Random;
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
        this.castice = new ArrayList<Zrnko>();
    }
    
    public void vytvorZrnko(int polohaX) {
        if (this.material.equals("voda")){
            this.castice.add(new Zrnko(polohaX, 0, "#00a1d1", 2));
        } else if (this.material.equals("piesok")) {
            this.castice.add(new Zrnko(polohaX, 0, "#c06805", 1));
        }
    }
    
    public String zistiFarbu() {
        if (this.material.equals("voda")) {
            return "#00a1d1";
        }
        return "#c06805";
    }
    
    public int zistiHustotu() {
        if (this.material.equals("voda")) {
            return 2;
        }
        return 1;
    }
    
    public void vysypPiesok(int density) {
        Random r = new Random();
        for (int i = 0; i < density; i++) {
            this.castice.add(new Zrnko(r.nextInt(400), r.nextInt(300), zistiFarbu(), zistiHustotu()));
        }
    }
    
    public void tik() {
        for (int i = 0; i < this.castice.size(); i++) {
            this.castice.get(i).tik();
        }
    }
    
    public int getSanca() {
        return this.sanca;
    }
    
    public void setSanca(int sanca) {
        this.sanca = sanca;
    }
}
