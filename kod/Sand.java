import fri.shapesge.Manazer;
import java.awt.geom.Rectangle2D;
/**
 * Trieda celku Sand
 * 
 * @author Benjamín Collu
 * @version 13.12.2024
 */
public class Sand {
    private Manazer manazer;
    private Mapa mapa;
    private Kvapalina kvapalina;
    private Menu menu;
    private GUI gui;
    /**
     * Inicializuje manažéra a spustí menu
     */
    public Sand() {
        // initialise instance variables
        this.manazer = new Manazer();
        this.menu = new Menu();
        this.manazer.spravujObjekt(this);
        this.manazer.spravujObjekt(this.menu);
        this.gui = null;
        this.kvapalina = null;
    }
    
    /**
     * Každú sekundu kontroluje, či bola prostredníctvom tlačidiel
     * už vybraná kvapalina
     */
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
        if (this.gui != null) {
            this.gui.setSanca(this.kvapalina.getSanca());
            this.gui.setRychlost(this.kvapalina.getRychlost());
        }
    }
    
    /**
     * Metóda spúšťaná stlačením ľavého tlačidla myši, po stlačení tlačidla v menu sa buď vysype piesok,
     * zmení rýchlosť padania alebo sa vráti do menu
     * @param int x súradnica kurzora na osi X
     * @param int y súradnica kurzora na osi Y
     */
    public void stlacenieTlacidla(int x, int y) {
        if (this.gui != null) {
            if(new Rectangle2D.Double(x, y, 2, 2).intersects(this.gui.getVysypHitbox())) {
                this.kvapalina.vysypPiesok();
            }
            if(new Rectangle2D.Double(x, y, 2, 2).intersects(this.gui.getZmenRychlostHitbox())) {
                this.kvapalina.zmenRychlost();
            }
            if(new Rectangle2D.Double(x, y, 2, 2).intersects(this.gui.getSancaHitbox())) {
                this.kvapalina.zmenSancu();
            }
        }
    }

    /**
     * Spustí hru s požadovaným materiálom, vybraným v menu
     * @param Material material materiál kvapaliny, vybraný v menu
     */
    public void spustHru(Material material) {
        this.menu.skry();
        this.menu = null;
        this.mapa = new Mapa();
        this.kvapalina = new Kvapalina(material, this.mapa.getPolohyXTrysiek(), this.mapa.getPolohaYTrysiek(), this.mapa.getPolohaYPodlahy());
        this.gui = new GUI(material);
        this.manazer.spravujObjekt(this.mapa);
        this.manazer.spravujObjekt(this.kvapalina);
        this.manazer.spravujObjekt(this.gui);
    }
}
