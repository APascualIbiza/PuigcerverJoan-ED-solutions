package ud5.exercises.buylist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuyListTest {

    @ParameterizedTest
    @MethodSource("provideBuyLists2")
    void totalPrice(BuyList buyList, double expectedTotalPrice){
        assertEquals(expectedTotalPrice, buyList.getTotalPrice());
    }

    static List<Arguments> provideBuyLists(){
        List<Arguments> args = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        products.add(new Product("Llet", 1.12, 1));
        products.add(new Product("Pa", 0.5, 3));
        products.add(new Product("Café", 0.72, 5));
        products.add(new Product("Xocolate", 0.2, 5));

        List<Double> totalPrices = Arrays.asList( 1.12, 2.62, 6.22, 7.22 );

        for (int i = 0; i < products.size(); i++) {
            BuyList buyList = new BuyList();
            for (int j = 0; j <= i; j++) {
                buyList.addProduct(products.get(j));
            }
            args.add(arguments(buyList, totalPrices.get(i)));
        }
        return args;
    }

    static List<Arguments> provideBuyLists2(){
        Product p1 = new Product("Llet", 1.12, 1);
        Product p2 = new Product("Pa", 0.5, 3);
        Product p3 = new Product("Café", 0.72, 5);
        Product p4 = new Product("Xocolate", 0.2, 5);
        BuyList buyList1 = new BuyList();
        buyList1.addProduct(p1);
        BuyList buyList2 = new BuyList();
        buyList2.addProduct(p1);
        buyList2.addProduct(p2);
        BuyList buyList3 = new BuyList();
        buyList3.addProduct(p1);
        buyList3.addProduct(p2);
        buyList3.addProduct(p3);
        BuyList buyList4 = new BuyList();
        buyList4.addProduct(p1);
        buyList4.addProduct(p2);
        buyList4.addProduct(p3);
        buyList4.addProduct(p4);

        List<Arguments> args = new ArrayList<>();
        args.add(arguments(buyList1, 1.12));
        args.add(arguments(buyList2, 2.62));
        args.add(arguments(buyList3, 6.22));
        args.add(arguments(buyList4, 7.22));

        return args;
    }
}