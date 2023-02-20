package ud6.examples.shapes;

/**
 * Aquesta classe representa un Rectangle.
 *
 * @author Joan Puigcerver
 * @version 1.3 2023-01-13
 */
public class Rectangle extends Shape {
    /**
     * Amplada del rectangle.
     */
    private int width;
    /**
     * Altura del rectangle.
     */
    private int height;

    /**
     * Crea un Rectangle especificant tots els atributs.
     *
     * @param width Amplada del Rectaqngle
     * @param height Altura del Rectaqngle
     * @param x Posició del rectangle en l'eix X
     * @param y Posició del rectangle en l'eix Y
     */
    public Rectangle(int width, int height, int x, int y) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    /**
     * Crea un Rectangle a partir de l'amplada i l'altura.
     * Aquest rectangle està posicionat en l'origen de coordenades (0, 0).
     *
     * @param width Amplada del Rectangle.
     * @param height Alçada del Rectangle.
     */
    public Rectangle(int width, int height) {
        super();
        this.width = width;
        this.height = height;
    }

    /**
     * Crea un Rectangle a partir de l'amplada i l'altura.
     * Aquest rectangle està posicionat en l'origen de coordenades (0, 0).
     *
     * @param width Amplada del Rectangle.
     * @param height Alçada del Rectangle.
     */
    public Rectangle(int width, int height, Color color) {
        super(color);
        this.width = width;
        this.height = height;
    }

    /**
     * Crea un Rectangle a partir d'un altre Rectangle
     * @param other Rectangle que serà copiat
     */
    public Rectangle(Rectangle other) {
        super(other);
        this.width = other.getWidth();
        this.height = other.getHeight();
    }

    /**
     * Retorna l'amplada del rectangle
     * @return Amplada del rectangle
     */
    public int getWidth() {
        return width;
    }

    /**
     * Modifica l'amplada del rectangle
     * @param width Amplada del rectangle
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Retorna l'alçada del rectangle
     * @return Alçada del rectangle
     */
    public int getHeight() {
        return height;
    }

    /**
     * Modifica l'alçada del rectangle
     * @param height Alçada del rectangle
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Calcula l'àrea del rectangle.
     *
     * @return Àrea del rectangle
     * @since 1.1
     */
    public int area(){
        // AREA = BASE * ALTURA
        return this.width * this.height;
    }

    /**
     * Comprova si el punt especificat (x, y) està dins del rectangle.
     *
     * @param x Coordenada del punt en l'eix X
     * @param y Coordenada del punt en l'eix Y
     * @return true si el punt (x, y) està dins del rectangle; false en altre cas.
     * @since 1.2
     */
    public boolean contains(int x, int y){
        boolean insideX = (x >= this.x) && (x <= (this.x + width));
        boolean insideY = (y >= this.y) && (y <= (this.y + height));
        return insideX && insideY;
    }

    /**
     * Retorna una còpia del rectangle
     * @return Còpia del rectangle
     */
    @Override
    public Rectangle clone() {
        return new Rectangle(this);
    }

    public void draw(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("█");
            }
            System.out.println();
        }
    }
    public void draw(Canvas canvas){
        for (int i = x; i < width; i++) {
            for (int j = y; j < height; j++) {
                System.out.print("█");
            }
            System.out.println();
        }
    }

    public int top(){
        return this.y + height;
    }
    public int bot(){
        return this.y;
    }
    public int left(){
        return this.x;
    }
    public int right(){
        return this.x + width;
    }
}
