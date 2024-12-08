import fri.shapesge.Manazer;
/**
 * Write a description of class Sand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sand {
    private Manazer manazer;
    private Mapa mapa;
    private Kvapalina kvapalina;
    private Menu menu;
    /**
     * Constructor for objects of class Sand
     */
    public Sand() {
        // initialise instance variables
        this.manazer = new Manazer();
        this.menu = new Menu();
        this.manazer.spravujObjekt(this);
        this.manazer.spravujObjekt(this.menu);
    }
    
    public void tik() {
        if(this.menu != null) {
            switch(this.menu.getVybranaKvapalina()) {
                case 0:
                    break;
                case 1:
                    this.spustHru(Material.PIESOK);
                    break;
                case 2:
                    this.spustHru(Material.VODA);
                    break;
                default:
                    break;
            }
        }
    }
    
    public void spustHru(Material material) {
        this.menu.skry();
        this.menu = null;
        this.mapa = new Mapa();
        this.kvapalina = new Kvapalina(material, this.mapa.getPolohyXTrysiek(), this.mapa.getPolohaYPodlahy());
        this.manazer.spravujObjekt(this.mapa);
        this.manazer.spravujObjekt(this.kvapalina);
    }
}
