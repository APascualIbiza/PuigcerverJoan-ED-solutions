package ud5.examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class DynamicParameterizedTest {

    @TestFactory
    @DisplayName("Dynamic Test")
    Collection<DynamicTest> dynamicTest() {
        return Arrays.asList(
                DynamicTest.dynamicTest("1, 1, 2", () -> assertEquals(2, Math.addExact(1, 1))),
                DynamicTest.dynamicTest("2, 2, 4", () -> assertEquals(4, Math.addExact(2, 2))),
                DynamicTest.dynamicTest("3, 3, 6", () -> assertEquals(6, Math.addExact(3, 3))),
                DynamicTest.dynamicTest("4, 4, 8", () -> assertEquals(8, Math.addExact(4, 4))),
                DynamicTest.dynamicTest("5, 5, 10", () -> assertEquals(10, Math.addExact(5, 5))),
                DynamicTest.dynamicTest("6, 6, 12", () -> assertEquals(12, Math.addExact(6, 6))),
                DynamicTest.dynamicTest("7, 7, 14", () -> assertEquals(14, Math.addExact(7, 7))),
                DynamicTest.dynamicTest("10, 90, 100", () -> assertEquals(100, Math.addExact(10, 90))));
    }

    @ParameterizedTest(name="{0} + {1} = {2}")
    @CsvSource({ "1,1,2", "2,2,4", "3,3,6",
            "4,4,8", "5,5,10", "6,6,12",
            "7,7,14", "10,90,100" })
    @DisplayName("Parameterized Test with CsvSource")
    public void parameterizedCsvSourceTest(int left, int right, int expected) {
        assertEquals(expected, Math.addExact(left, right));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    @DisplayName("Parameterized Test with ValueSource")
    public void parameterizedValueSourceTest(int number) {
        assertEquals(0, number % 2);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = { " " })
    void nullEmptyAndBlankStrings(String text) {
        assertTrue(text == null || text.trim().isEmpty());
    }

    @ParameterizedTest(name="[{index}] {0} + {1} = {2}")
    @MethodSource("numberToSum")
    @DisplayName("Parameterized Test with MehodSource")
    public void parameterizedMehodSourceTest(int left, int right, int expected) {
        assertEquals(expected, Math.addExact(left, right));
    }

    private static List<Arguments> numberToSum() {
        return Arrays.asList(
                arguments(1, 1, 2),
                arguments(2, 2, 4),
                arguments(3, 3, 6),
                arguments(4, 4, 8),
                arguments(5, 5, 10),
                arguments(6, 6, 12),
                arguments(7, 7, 14),
                arguments(10, 90, 100)
        );
    }
}
