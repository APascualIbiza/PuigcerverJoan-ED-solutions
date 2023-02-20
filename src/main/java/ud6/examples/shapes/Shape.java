package ud6.examples.shapes;

import ud6.examples.shapes.canvas.Canvas;

/**
 * Classe que representa una figura en l'espai de coordenades.
 * @author Joan Puigcerver
 * @version 1.1 2023-01-13
 */
public abstract class Shape implements Prototype {
    /**
     * Posició en l'eix X
     */
    protected int x;
    /**
     * Posició en l'eix Y
     */
    protected int y;

    protected Color color;

    /**
     * Constructor d'una figura en l'espai de coordenades en el punt especificat (x, y)
     * @param x Posició en l'eix X
     * @param y Posició en l'eix Y
     */
    public Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Shape(int x, int y) {
        this(x, y, Color.RESET);
    }

    public Shape(Color color) {
        this(0, 0, color);
    }

    /**
     * Constructor d'una figura en l'espai de coordenades en el punt (0, 0)
     */
    public Shape() {
        this(0, 0, Color.RESET);
    }

    /**
     * Constructor d'una figura en l'espai de coordenades a partir d'una altra figura
     * @param other Figura la qual serà copiada
     */
    public Shape(Shape other) {
        this.x = other.getX();
        this.y = other.getY();
        this.color = other.getColor();
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Retorna una còpia de la figura
     * @return Còpia de la figura
     */
    @Override
    public abstract Shape clone();

    public void paint(){
        System.out.print(color);
        draw();
        System.out.print(Color.RESET);
    }
    public abstract void draw();
}
