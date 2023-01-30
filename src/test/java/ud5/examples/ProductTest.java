package ud5.examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ud5.exercises.buylist.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Nested
    @DisplayName("Tests dels constructors")
    class ConstructorTests{

        @Test
        @DisplayName("Constructor amb tots els atributs")
        void constructorTotsAtributs(){
            Product p = new Product("Llet", 1.12, 5);
            assertAll(
                () -> assertEquals("Llet", p.getDescription()),
                () -> assertEquals(1.12, p.getPrice()),
                () -> assertEquals(5, p.getUnits())
            );
        }

        @Test
        @DisplayName("Constructor amb descripcio i preu")
        void constructorDescripcioPreu(){
            Product p = new Product("Llet", 1.12);
            assertAll(
                    () -> assertEquals("Llet", p.getDescription()),
                    () -> assertEquals(1.12, p.getPrice()),
                    () -> assertEquals(1, p.getUnits())
            );
        }
    }

    @Nested
    @DisplayName("Tests del preu total")
    class TotalPriceTests{
        Product product;

        @BeforeEach
        void setup(){
            product = new Product("Llet", 1.12, 1);
        }

        @Test
        @DisplayName("Preu total amb 1 unitat")
        void totalPrice1Unit(){
            assertEquals(1.12, product.getTotalPrice());
        }

        @Test
        @DisplayName("Preu total amb multiples unitats")
        void totalPriceMutipleUnits(){
            product.setUnits(5);
            assertEquals(6, product.getTotalPrice());
        }
    }
}