package ud6.exercises;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static ud6.exercises.CalculNota.calcularNota;

class CalculNotaTest {

    @ParameterizedTest
    @CsvSource({
            "0, 0, No superat",
            "3, 3, No superat",
            "3, 10, No superat",
            "4, 6, No superat",
            "10, 3, No superat",
            "6.1, 3.9, No superat",
            "5.1, 4.9, Suficient",
            "7, 3.9, Suficient",
            "4.75, 8, Bé",
            "7, 4, Suficient",
            "6, 6, Bé",
            "7, 7, Notable",
            "8, 8, Notable",
            "9, 9, Excel·lent",
            "10, 10, Excel·lent",
            "4.75, 4.75, No superat",
    })
    void calcularNotaTest(double practices, double exam, String expectedGrade) {
        assertEquals(expectedGrade, calcularNota(practices, exam));
    }
}