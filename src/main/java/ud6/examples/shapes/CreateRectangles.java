package ud6.examples.shapes;

import java.util.ArrayList;
import java.util.List;

public class CreateRectangles {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(3, 3, Color.RED);
        Rectangle r2 = r1;
        Rectangle r3 = r1.clone();


        System.out.printf("Són r1 i r2 el mateix objecte? %s\n", r1 == r2 ? "Sí" : "No");
        System.out.printf("Són r1 i r3 el mateix objecte? %s\n", r1 == r3 ? "Sí" : "No");

        List<Shape> shapes = new ArrayList<>();

        shapes.add(r1);
        shapes.add(new Cercle(1, Color.GREEN));
        shapes.add(new Cercle(2, Color.BLUE));
        shapes.add(new Cercle(4, Color.CYAN));
        shapes.add(new Cercle(8, Color.MAGENTA));

        for(Shape s : shapes)
            s.paint();
    }
}
