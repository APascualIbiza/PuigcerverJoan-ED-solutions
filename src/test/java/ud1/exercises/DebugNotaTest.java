package ud1.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DebugNotaTest {

    @Test
    void gradeAllNoSuperat() {
        assertEquals("No superat", DebugNota.grade(3, 3));
    }
    @Test
    void gradePracticesNoSuperat() {
        assertEquals("No superat", DebugNota.grade(3, 10));
    }
    @Test
    void gradePracticesNoSuperat2() {
        assertEquals("No superat", DebugNota.grade(4, 6));
    }
    @Test
    void gradeExamNoSuperat () {
        assertEquals("No superat", DebugNota.grade(10, 3));
    }
    @Test
    void gradeExamLlindarNoSuperat () {
        assertEquals("No superat", DebugNota.grade(6.1, 3.9));
    }
    @Test
    void gradeTotalLlindarSuperat () {
        assertEquals("Suficient", DebugNota.grade(5.1, 4.9));
    }
    @Test
    void gradeExamLlindarSuperat () {
        assertEquals("Suficient", DebugNota.grade(7, 3.9));
    }
    @Test
    void gradePracticesLlindarSuperat () {
        assertEquals("Bé", DebugNota.grade(4.75, 8));
    }
    @Test
    void gradeExamSuperat () {
        assertEquals("Suficient", DebugNota.grade(7, 4));
    }
    @Test
    void gradeExcelent () {
        assertEquals("Excel·lent", DebugNota.grade(10, 10));
    }
    @Test
    void gradeNotable () {
        assertEquals("Notable", DebugNota.grade(8, 8));
    }
}