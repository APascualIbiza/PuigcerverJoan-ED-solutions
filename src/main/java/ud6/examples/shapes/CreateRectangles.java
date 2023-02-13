package ud6.examples.shapes;

public class CreateRectangles {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(3, 3, 1, 2);
        Rectangle r2 = r1;
        Rectangle r3 = r1.clone();


        System.out.printf("Són r1 i r2 el mateix objecte? %s\n", r1 == r2 ? "Sí" : "No");
        System.out.printf("Són r1 i r3 el mateix objecte? %s\n", r1 == r3 ? "Sí" : "No");
    }
}
