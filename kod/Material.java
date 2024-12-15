/**
 * Enum pre Materiál - určuje farbu a hustotu
 * 
 * @author Benjamín Collu
 * @version 13.12.2024
 */
public enum Material {
    /**
     * Piesok
     */
    PIESOK("#e6d567", 1.0),
    /**
     * Voda
     */
    VODA("#0394fc", 2.0);
    
    private String farba;
    private double hustota;
    /**
     * Inicializuje atribúty podľa zadaných parametrov
     * @param String farba požadovaná farba v hex tvare
     * @param double hustota požadovaná hustota v tvare desatinného čísla
     */
    Material(String farba, double hustota) {
        this.farba = farba;
        this.hustota = hustota;
    }
    
    /**
     * Vráti hodnotu pre farbu
     * @return reťazec v hex tvare
     */
    public String getFarba() {
        return this.farba;
    }
    
    /**
     * Vráti hodnotu pre hustotu
     * @return desatinné číslo
     */
    public double getHustota() {
        return this.hustota;
    }
}
