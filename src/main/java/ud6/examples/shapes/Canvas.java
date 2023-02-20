package ud6.examples.shapes;

import java.util.ArrayList;
import java.util.List;

/**
 * Aquesta classe representa un cercle posicionat en l'espai de coordenades X i Y.
 * 
 * @author Joan Puigcerver
 * @version 1.3 2023-01-13
 */
public class Canvas {
    List<Shape> shapes;
    private int top;
    private int bot;
    private int right;
    private int left;
    private Color[][] canvas;

    public Canvas() {
        this.shapes = new ArrayList<>();
        top = Integer.MIN_VALUE;
        bot = Integer.MAX_VALUE;
        left = Integer.MAX_VALUE;
        right = Integer.MIN_VALUE;
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void addShape(Shape shape){
        shapes.add(shape);
    }

    public void paint(int x, int y, Color color){
        canvas[x - left][y - bot] = color;
    }

    public void paint(){

        for(Shape s : shapes){
            if(s.top() >= top) top = s.top();
            if(s.bot() <= bot) bot = s.bot();
            if(s.right() >= right) right = s.right();
            if(s.left() <= left) left = s.left();
        }

        canvas = new Color[right - left][top - bot];
        for(Shape s : shapes){
            s.paint(this);
        }
        this.paint(0, 0, Color.BLACK);
    }
}
