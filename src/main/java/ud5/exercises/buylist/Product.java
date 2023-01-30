package ud5.exercises.buylist;

public class Product {
    private String description;
    private double price;
    private int units;

    public Product(String description, double price) {
        this(description, price, 1);
    }

    public Product(String description, double price, int units) {
        this.description = description;
        this.price = price;
        this.units = units;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    @Override
    public String toString(){
        return String.format("%d %s (%.2f€) - %.2f€", units, description, price, getTotalPrice());
    }

    public double getTotalPrice(){
        return units * price;
        // return getUnits() * getPrice();
    }

    public static void main(String[] args) {
        Product p1 = new Product("Llet", 1.12);
        System.out.println(p1);
        Product p2 = new Product("Barra de pa", 0.5, 3);
        System.out.println(p2);
        p2.setPrice(0.7);
        System.out.println(p2);
    }
}
