package ud6.examples.shapes.canvas;

import ud6.examples.shapes.Cercle;
import ud6.examples.shapes.Color;

public class CercleCanvas extends Cercle implements CanvasShape {
    public CercleCanvas(int radius, Color color) {
        super(radius, color);
    }

    public CercleCanvas(int radius, int x, int y, Color color) {
        super(radius, x, y, color);
    }

    @Override
    public void paint(Canvas canvas) {
        for (int i = x - radius; i < x + radius; i++) {
            for (int j = y - radius; j < y + radius; j++) {
                double puntX = i + 0.5;
                double puntY = j + 0.5;
                boolean draw = contains(puntX, puntY);
                if(draw){
                    canvas.paint(i, j, color);
                }
            }
        }
    }

    public int top(){
        return this.y + radius;
    }
    public int bot(){
        return this.y - radius;
    }
    public int left(){
        return this.x - radius;
    }
    public int right(){
        return this.x + radius;
    }
}
