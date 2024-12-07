import fri.shapesge.Obdlznik;
public class Zrnko {
    private Obdlznik zrnko; 
    private int polohaX;
    private int polohaY;
    private int hustota;
    private String farba;
    private boolean spadla;
    public Zrnko(int polohaX, int polohaY, String farba, int hustota) {
        this.polohaX = polohaX; 
        this.polohaY = polohaY;
        this.farba = farba;
        this.hustota = hustota;
        this.zrnko = new Obdlznik();
        this.zrnko.zmenStrany(5, 5);
        this.zrnko.zmenPolohu(polohaX, polohaY);
        this.zrnko.zmenFarbu(farba);
        this.zrnko.zobraz();
        this.spadla = false;
    }
    public void posunDole() {
        this.zrnko.posunZvisle(this.hustota);
        this.polohaY += this.hustota;
    }
    public void posunDoleDoprava() {
        this.zrnko.posunZvisle(this.hustota);
        this.zrnko.posunVodorovne(this.hustota); 
        this.polohaY += this.hustota;
        this.polohaX += this.hustota;
    }
    public void posunDoleDolava() {
        this.zrnko.posunZvisle(this.hustota);
        this.zrnko.posunVodorovne(this.hustota); 
        this.polohaY += this.hustota;
        this.polohaX -= this.hustota;
    }
    public int getPolohaX() {
        return this.polohaX;
    }
    public int getPolohaY() {
        return this.polohaY;
    }
    public void setSpadla(boolean spadla) {
        this.spadla = spadla;
    }
    public void tik() {
        if(!spadla) {
            this.posunDole();
        }
    }
    

    
}
