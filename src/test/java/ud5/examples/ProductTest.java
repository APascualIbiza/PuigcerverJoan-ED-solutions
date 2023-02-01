package ud5.examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @ParameterizedTest
    @CsvSource({
            "1, 1.12, 1.12",
            "2, 1.12, 2.24",
            "3, 0.5, 1.5",
            "10, 0.5, 5",
    })
    void totalPrice(int units, double unitPrice, double expectedTotalPrice){
        Product product = new Product("Test", unitPrice, units);
        assertEquals(expectedTotalPrice, product.getTotalPrice(), 1e-5);
    }
}