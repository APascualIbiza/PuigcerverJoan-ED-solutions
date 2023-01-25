package ud5.examples;

import java.util.ArrayList;

public class BuyList {
    private ArrayList<Product> products;

    public BuyList(){
        products = new ArrayList<>();
    }

    public void addProduct(Product p){
        products.add(p);
    }

    public double getTotalPrice(){
        double totalPrice = 0;
        for(Product p : products)
            totalPrice += p.getTotalPrice();
        return totalPrice;
    }

    public void printTicket(){
        System.out.println("------ Ticket ------");
        for(Product p : products)
            System.out.println(p);
        System.out.println("--------------------");
        System.out.printf("Total: %.2f€\n", this.getTotalPrice());
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        BuyList buyList = new BuyList();
        buyList.printTicket();
        System.out.println();
        buyList.addProduct(new Product("Llet", 1.12));
        buyList.printTicket();
        System.out.println();
        buyList.addProduct(new Product("Barra de pa", 0.5, 3));
        buyList.printTicket();
    }
}
