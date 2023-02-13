package ud6.examples.shapes;

/**
 * Aquesta classe representa un cercle posicionat en l'espai de coordenades X i Y.
 * 
 * @author Joan Puigcerver
 * @version 1.3 2023-01-13
 */
public class Cercle extends Shape {
    /**
     * El radi del Cercle.
     */
    private double radius;
    /**
     * Crea un Cercle a partir del radi i la posició del centre.
     * @param radius Radi del Cercle
     * @param x Posició del centre del Cercle en l'eix X
     * @param y Posició del centre del Cercle en l'eix Y
     */
    public Cercle(double radius, int x, int y) {
        super(x, y);
        this.radius = radius;
    }

    /**
     * Crea un Cercle en l'origen de coordenades (0, 0) amb el radi especificat
     * @param radius Radi del Cercle
     */
    public Cercle(double radius) {
        super();
        this.radius = radius;
    }

    /**
     * Crea un Cercle a partir d'un altre Cercle
     * @param other Cercle que serà copiat
     */
    public Cercle(Cercle other) {
        super(other);
        this.radius = other.getRadius();
    }

    /**
     * Obté el radi del Cercle
     * @return Radi del cercle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Estableix el radi del Cercle
     * @param radius Nou radi del Cercle
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Calcula el àrea del Cercle
     * @return Àrea del cercle
     * @since 1.1
     */
    public double area(){
        return Math.PI * Math.pow(this.radius, 2);
    }

    /**
     * Comprova si el punt especificat (x, y) està dins del Cercle.
     * @param x Coordeneda del punt especificat en l'eix X.
     * @param y Coordeneda del punt especificat en l'eix Y.
     * @return True si el punt (x, y) està dins del Cercle, False en altre cas.
     * @since 1.2
     */
    public boolean contains(double x, double y){
        double distance = Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
        return distance <= radius;
    }

    /**
     * Retorna una còpia del cercle
     * @return Còpia del cercle
     */
    public Cercle clone(){
        return new Cercle(this);
    }
}
