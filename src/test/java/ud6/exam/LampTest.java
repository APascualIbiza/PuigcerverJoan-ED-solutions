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
            this.lamp = new Lamp(0.5);
        }

        @DisplayName("turnOn apagada")
        @Test
        void testOffTurnOn(){
            this.lamp.turnOff();
            this.lamp.turnOn();
            assertTrue(lamp.isOn());
        }
        @DisplayName("turnOn encesa")
        @Test
        void testOnTurnOn(){
            this.lamp.turnOn();
            this.lamp.turnOn();
            assertTrue(lamp.isOn());
        }

        @DisplayName("turnOff apagada")
        @Test
        void testOffTurnOff(){
            this.lamp.turnOff();
            this.lamp.turnOff();
            assertFalse(lamp.isOn());
        }
        @DisplayName("turnOn encesa")
        @Test
        void testOnTurnOff(){
            this.lamp.turnOn();
            this.lamp.turnOff();
            assertFalse(lamp.isOn());
        }

        @DisplayName("toggle apagada")
        @Test
        void testOffTogggle(){
            this.lamp.turnOff();
            this.lamp.toggle();
            assertTrue(lamp.isOn());
        }
        @DisplayName("toggle encesa")
        @Test
        void testOnToggle(){
            this.lamp.turnOn();
            this.lamp.toggle();
            assertFalse(lamp.isOn());
        }
    }

    @ParameterizedTest
    @CsvSource({
            "true, 60, 60, 1",
            "true, 60, 120, 2",
            "true, 120, 60, 2",
            "true, 120, 120, 4",
            "true, 120, 0, 0",
            "false, 120, 60, 0",
    })
    void computeConsumption(boolean isOn, double consumption, double seconds, double expectedConsumption) {
        Lamp lamp = new Lamp(consumption);
        if(isOn)
            lamp.turnOn();
        assertEquals(expectedConsumption, lamp.computeConsumption(seconds), 1e-5);
    }
}