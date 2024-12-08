/**
 * Enum pre Materiál - určuje farbu a hustotu
 * 
 * @author meno
 * @version datum
 */
public enum Material {
    PIESOK("#e6d567", 1.0),
    VODA("#0394fc", 2.0);
    
    private String farba;
    private double hustota;
    Material(String farba, double hustota) {
        this.farba = farba;
        this.hustota = hustota;
    }
    
    public String getFarba() {
        return this.farba;
    }
    
    public double getHustota() {
        return this.hustota;
    }
}
