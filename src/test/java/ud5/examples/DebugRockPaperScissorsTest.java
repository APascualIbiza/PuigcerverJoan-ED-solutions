package ud5.examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests de la classe DebugRockPaperScissors")
class DebugRockPaperScissorsTest {

    @Test
    @DisplayName("Guanya jugador1")
    void guanyaJugador1() {
        assertAll(
                () -> assertEquals(1, DebugRockPaperScissors.guanya("pedra", "tisores"),
                        "Falla quan J1{pedra} J2{tisores}"),
                () -> assertEquals(1, DebugRockPaperScissors.guanya("paper", "pedra"),
                        "Falla quan J1{paper} J2{pedra}"),
                () -> assertEquals(1, DebugRockPaperScissors.guanya("tisores", "paper"),
                        "Falla quan J1{tisores} J2{paper}")
        );
    }

    @Test
    @DisplayName("Guanya jugador2")
    void guanyaJugador2() {
        assertAll(
                () -> assertEquals(2, DebugRockPaperScissors.guanya("pedra", "paper"),
                    "Falla quan J1{pedra} i J2{paper}"),
                () -> assertEquals(2, DebugRockPaperScissors.guanya("paper", "tisores"),
                    "Falla quan J1{paper} i J2{tisores}"),
                () -> assertEquals(2, DebugRockPaperScissors.guanya("tisores", "pedra"),
                    "Falla quan J1{tisores} i J2{pedra}")
        );
    }

    @Test
    @DisplayName("Empats")
    void empats(){
        assertAll(
                () -> assertEquals(0, DebugRockPaperScissors.guanya("pedra", "pedra"),
                    "Falla quan J1{pedra} i J2{pedra}"),
                () -> assertEquals(0, DebugRockPaperScissors.guanya("paper", "paper"),
                    "Falla quan J1{paper} i J2{paper}"),
                () -> assertEquals(0, DebugRockPaperScissors.guanya("tisores", "tisores"),
                    "Falla quan J1{tisores} i J2{tisores}")
        );
    }
}