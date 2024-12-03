import fri.shapesge.Obdlznik;
public class Zrnko
{
    private Obdlznik zrnko; 
    private int polohaX;
    private int polohaY;
    private double hustota;
    private String farba;
    public Zrnko(int polohaX, int polohaY, String farba, double hustota)
    {
        this.polohaX = polohaX; 
        this.polohaY = polohaY;
        this.farba = farba;
        this.hustota = hustota;
        this.zrnko = new Obdlznik();
        this.zrnko.zmenStrany(5, 5);
        this.zrnko.zmenPolohu(polohaX, polohaY);
        this.zrnko.zmenFarbu(farba);
        this.zrnko.zobraz();
    }
    public void posunDole() {
        this.zrnko.posunZvisle(5);
        this.polohaY += 5;
    }
    public void posunDoleDoprava() {
        this.zrnko.posunZvisle(5);
        this.zrnko.posunVodorovne(5); 
        this.polohaY +=5;
        this.polohaX +=5;
    }
    public void posunDoleDolava() {
        this.zrnko.posunZvisle(5);
        this.zrnko.posunVodorovne(-5); 
        this.polohaY +=5;
        this.polohaX -=5;
    }
    public int getPolohaX() {
        return this.polohaX;
    }
    public int getPolohaY() {
        return this.polohaY;
    }
    

    
}
