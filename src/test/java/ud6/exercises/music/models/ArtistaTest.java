package ud6.exercises.music.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtistaTest {

    @Test
    void checkConstructor(){
        String nomTest = "NomTest";
        String cognomTest = "CognomTest";
        String paisTest = "PaisTest";
        Artista a = new Artista(nomTest, cognomTest, paisTest);
        assertAll(
            () -> assertEquals(nomTest, a.getNom()),
            () -> assertEquals(cognomTest, a.getCognom()),
            () -> assertEquals(paisTest, a.getPais())
        );
    }
}