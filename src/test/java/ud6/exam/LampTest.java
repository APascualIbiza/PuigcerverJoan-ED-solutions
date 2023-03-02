package ud6.exam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LampTest {

    @Nested
    class IsOnTests {
        private Lamp lamp;
        @BeforeEach
        void setup(){
            lamp = new Lamp(5.0);
        }

        @DisplayName("Encén làmpara encesa")
        @Test
        void turnOnOn(){
            lamp.turnOn();
            lamp.turnOn();
            assertTrue(lamp.isOn(), "La làmpara esta apagada quan hauria d'estar encesa.");
        }

        @DisplayName("Encén làmpara apagada")
        @Test
        void turnOnOff(){
            lamp.turnOff();
            lamp.turnOn();
            assertTrue(lamp.isOn(), "La làmpara esta apagada quan hauria d'estar encesa.");
        }

        @DisplayName("Apaga làmpara encesa")
        @Test
        void turnOffOn(){
            lamp.turnOn();
            lamp.turnOff();
            assertFalse(lamp.isOn(), "La làmpara esta encesa quan hauria d'estar apagada.");
        }

        @DisplayName("Apaga làmpara apagada")
        @Test
        void turnOffOff() {
            lamp.turnOff();
            lamp.turnOff();
            assertFalse(lamp.isOn(), "La làmpara esta encesa quan hauria d'estar apagada.");
        }

        @DisplayName("Toggle làmpara apagada")
        @Test
        void toggleOff() {
            lamp.turnOff();
            lamp.toggle();
            assertTrue(lamp.isOn(), "La làmpara esta apagada quan hauria d'estar encesa.");
        }

        @DisplayName("Toggle làmpara encesa")
        @Test
        void toggleOn() {
            lamp.turnOn();
            lamp.toggle();
            assertFalse(lamp.isOn(), "La làmpara esta encesa quan hauria d'estar apagada.");
        }
    }

    @ParameterizedTest
    @CsvSource({
            "true, 60, 60, 1",
            "true, 60, 120, 2",
            "true, 120, 60, 2",
            "true, 120, 120, 4",
            "false, 60, 60, 0",
            "false, 120, 120, 0"
    })
    void computeConsumption(boolean isOn, double consumption, double seconds, double expectedConsumption){
        Lamp lamp = new Lamp(consumption);
        if(isOn)
            lamp.turnOn();
        assertEquals(expectedConsumption, lamp.computeConsumption(seconds), 1e-5);
    }
}