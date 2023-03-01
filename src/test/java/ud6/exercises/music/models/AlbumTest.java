package ud6.exercises.music.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlbumTest {

    @TestFactory
    @DisplayName("Dynamic Test")
    Collection<DynamicTest> testClone() {
        List<DynamicTest> tests = new ArrayList<>();
        Grup g = new Grup("Name", "2023-02-23", "Country");
        Album a = new Album("Title", "2023-02-23", g);
        a.addSong(new Song("Song1", 100));
        a.addSong(new Song("Song2", 200));
        a.addSong(new Song("Song3", 300));

        Album clone = a.clone();
        tests.add(DynamicTest.dynamicTest("Album not same objects", () -> assertNotSame(a, clone, "Els dos objectes són el mateix objecte")));
        tests.add(DynamicTest.dynamicTest("Album equal objects", () -> assertEquals(a, clone, "Els dos objectes no són iguals")));
        for (int i = 0; i < a.getSongs().size(); i++) {
            Song song = a.getSongs().get(i);
            Song otherSong = clone.getSongs().get(i);
            tests.add(DynamicTest.dynamicTest("Song same objects: " + song.getTitle(), () -> assertSame(song, otherSong, "Les dos cançons no són el mateix objecte")));
            tests.add(DynamicTest.dynamicTest("Song equal objects: " + song.getTitle(), () -> assertEquals(song, otherSong, "Les dons cançons no són iguals")));
        }
        return tests;
    }
}