package ud6.examples.shapes.canvas;

import ud6.examples.shapes.Color;
import ud6.examples.shapes.Rectangle;

public class RectangleCanvas extends Rectangle implements CanvasShape {
    public RectangleCanvas(int width, int height, int x, int y, Color color) {
        super(width, height, x, y, color);
    }

    public RectangleCanvas(int width, int height, Color color) {
        super(width, height, color);
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

    @Override
    public void paint(Canvas canvas) {
        for (int i = x; i < x + width ; i++) {
            for (int j = y; j < y + height; j++) {
                canvas.paint(i, j, color);
            }
        }
    }
}
