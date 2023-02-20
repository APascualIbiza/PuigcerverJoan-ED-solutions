package ud6.examples.shapes.canvas;

public interface CanvasShape {
    int top();
    int bot();
    int left();
    int right();

    void paint(Canvas canvas);
}
