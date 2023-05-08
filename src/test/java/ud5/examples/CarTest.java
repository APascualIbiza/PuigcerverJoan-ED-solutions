package ud5.examples;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ud5.examples.car.Car;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("Constructor amb kilòmetres")
    void constructorAmbKilometres(){
        Car car = new Car("0000 BBB", 1234.56);
        assertAll(
            () -> assertEquals("0000 BBB", car.getPlate()),
            () -> assertEquals(1234.56, car.getKilometers()),
            () -> assertEquals(0, car.getVelocity())
        );
    }

    @Test
    @DisplayName("Constructor sense kilòmetres")
    void constructorSenseKilometres(){
        Car car = new Car("0000 BBB" );
        assertAll(
                () -> assertEquals("0000 BBB", car.getPlate()),
                () -> assertEquals(0, car.getKilometers()),
                () -> assertEquals(0, car.getVelocity())
        );
    }

    @Nested
    @DisplayName("Accelerate tests")
    class AccelerateTest {
        private Car car;

        @BeforeEach
        void setup() {
            car = new Car("0000 BBB");
        }

        @Test
        @DisplayName("Comprova la velocitat inicial")
        void testInitialVelocity() {
            assertEquals(0, car.getVelocity());
        }

        @Test
        @DisplayName("Accelera una única vegada")
        void singleAccelerate() {
            car.accelerate();
            assertEquals(5, car.getVelocity());
        }

        @Test
        @DisplayName("Accelera multiple vegades")
        void multipleAccelerate() {
            car.accelerate();
            car.accelerate();
            car.accelerate();
            assertEquals(15, car.getVelocity());
        }

        @Test
        @DisplayName("Accelera una velocitat determinada")
        void specificAccelerate() {
            car.accelerate(13);
            car.accelerate(14);
            assertEquals(27, car.getVelocity());
        }
    }

    @Nested
    @DisplayName("Drive tests")
    class DriveTest {
        private Car car;

        @BeforeEach
        void setup(){
            this.car = new Car("0000 BBB");
        }


        @ParameterizedTest(name = "Condueix {0}s a velocitat {1} km/h")
        @CsvSource({
                "120, 0, 0",
                "1200, 0, 0",
                "60, 60, 1",
                "120, 60, 2",
                "120, 120, 4",
                "120, 120, 4"
        })
        @DisplayName("Drive")
        void drive(int seconds, int velocity, double expectedKilometers){
            this.car.accelerate(velocity);
            this.car.drive(seconds);
            assertEquals(expectedKilometers, car.getKilometers());
        }

        @Test
        @DisplayName("Condueix a velocitat 0 km/h")
        void driveNoVelocity(){
            car.drive(120);
            assertEquals(0, car.getKilometers());
        }

        @Test
        @DisplayName("Condueix a velocitat 60 km/h durant 1 minut")
        void drive1a60(){
            car.accelerate(60);
            car.drive();
            assertEquals(1, car.getKilometers());
        }

        @Test
        @DisplayName("Condueix a velocitat 60 km/h durant 2 minuts")
        void drive2a60(){
            car.accelerate(60);
            car.drive();
            car.drive();
            assertEquals(2, car.getKilometers());
        }

        @Test
        @DisplayName("Condueix a velocitat 120 km/h durant 1 minut")
        void drive1a120(){
            car.accelerate(120);
            car.drive(60);
            assertEquals(2, car.getKilometers());
        }

        @Test
        @DisplayName("Condueix a velocitat 120 km/h durant 2 minuts")
        void drive2a120(){
            car.accelerate(120);
            car.drive(120);
            assertEquals(4, car.getKilometers());
        }

        @Test
        @DisplayName("Condueix a velocitat 30 km/h durant 1 minuts i 2 minuts a 120 km/h")
        void drive1a30i2a120(){
            car.accelerate(30);
            car.drive();
            car.accelerate(90);
            car.drive(120);
            assertEquals(4.5, car.getKilometers());
        }
    }

    @Nested
    @DisplayName("Decelerate tests")
    class DecelerateTests {
        private Car car;

        @BeforeEach
        void setup(){
            this.car = new Car("0000 BBB");
        }

        @Test
        @DisplayName("Frena sense accelerar")
        void decelerateOnce(){
            car.decelerate();
            assertEquals(0, car.getVelocity());
        }

        @Test
        @DisplayName("Accelera i frena el mateix")
        void decelerateSameAccelerate(){
            car.accelerate();
            car.decelerate();
            assertEquals(0, car.getVelocity());
        }

        @Test
        @DisplayName("Accelera menys que frena")
        void decelerateAccelerateLess(){
            car.accelerate(30);
            car.decelerate(120);
            assertEquals(0, car.getVelocity());
        }

        @Test
        @DisplayName("Accelera més que frena")
        void decelerateAccelerateMore(){
            car.accelerate(120);
            car.decelerate(30);
            assertEquals(90, car.getVelocity());
        }

        @Test
        @DisplayName("Frena dues vegades")
        void decelerateTwoTimes(){
            car.accelerate(120);
            car.decelerate(20);
            assertEquals(100, car.getVelocity());
            car.decelerate(30);
            assertEquals(70, car.getVelocity());
        }
    }
}