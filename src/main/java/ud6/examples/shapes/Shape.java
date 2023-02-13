package ud6.examples.shapes;

/**
 * Classe que representa una figura en l'espai de coordenades.
 * @author Joan Puigcerver
 * @version 1.1 2023-01-13
 */
public class Shape implements Prototype {
    /**
     * Posició en l'eix X
     */
    protected int x;
    /**
     * Posició en l'eix Y
     */
    protected int y;

    /**
     * Constructor d'una figura en l'espai de coordenades en el punt especificat (x, y)
     * @param x Posició en l'eix X
     * @param y Posició en l'eix Y
     */
    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor d'una figura en l'espai de coordenades en el punt (0, 0)
     */
    public Shape() {
        this(0, 0);
    }

    /**
     * Constructor d'una figura en l'espai de coordenades a partir d'una altra figura
     * @param other Figura la qual serà copiada
     */
    public Shape(Shape other) {
        this.x = other.getX();
        this.y = other.getY();
    }

    /**
     * Retorna la posició de la figura en l'eix X
     * @return Posició de la figura en l'eix X
     */
    public int getX() {
        return x;
    }

    /**
     * Modifica la posició de la figura en l'eix X
     * @param x Nova posició de la figura en l'eix X
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Retorna la posició de la figura en l'eix Y
     * @return Posició de la figura en l'eix Y
     */
    public int getY() {
        return y;
    }

    /**
     * Modifica la posició de la figura en l'eix Y
     * @param y Nova posició de la figura en l'eix Y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Retorna una còpia de la figura
     * @return Còpia de la figura
     */
    @Override
    public Shape clone() {
        return new Shape(this);
    }
}
