package ud6.examples.shapes.canvas;

import ud6.examples.shapes.Color;
import ud6.examples.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Aquesta classe representa un cercle posicionat en l'espai de coordenades X i Y.
 * 
 * @author Joan Puigcerver
 * @version 1.3 2023-01-13
 */
public class Canvas {
    List<CanvasShape> shapes;
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

    public List<CanvasShape> getShapes() {
        return shapes;
    }

    public void addShape(CanvasShape shape){
        shapes.add(shape);
    }

    public void paint(int x, int y, Color color){
        canvas[y - bot][x - left] = color;
    }

    public void paint(){

        for(CanvasShape s : shapes){
            if(s.top() >= top) top = s.top();
            if(s.bot() <= bot) bot = s.bot();
            if(s.right() >= right) right = s.right();
            if(s.left() <= left) left = s.left();
        }

        canvas = new Color[top - bot][right - left];
        for(CanvasShape s : shapes){
            s.paint(this);
        }
        this.paint(0, 0, Color.BLACK);

        for (int i = canvas.length - 1; i >= 0; i--) {
            for (int j = 0; j < canvas[0].length; j++) {
                System.out.print(canvas[i][j] == null ? " " : canvas[i][j] + "█");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Canvas c = new Canvas();
        c.addShape(new CercleCanvas(4, 2, 2, Color.MAGENTA));
        c.addShape(new RectangleCanvas(6, 3, 0, 0, Color.RED));
        c.addShape(new RectangleCanvas(2, 4, -1, 0, Color.BLUE));
        c.addShape(new RectangleCanvas(3, 3, -3, -2, Color.GREEN));
        c.paint();
    }
}
