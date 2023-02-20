package ud6.exercises.music.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrupTest {
    private Grup grup;

    @BeforeEach
    void setup(){
        this.grup = new Grup("Test", "1970-01-01", "Test");
    }

    @Test
    void testClone() {
        Grup clone = grup.clone();

        assertEquals(grup, clone);
        assertNotSame(grup, clone);
        assertEquals(grup.getArtistes(), clone.getArtistes());
        assertNotSame(grup.getArtistes(), clone.getArtistes());
    }
}