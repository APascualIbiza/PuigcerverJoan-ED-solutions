package ud5.examples.car.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ud5.examples.car.Car;
import ud5.examples.car.exception.ResourceNotFoundException;
import ud5.examples.car.repository.CarRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarServiceImplTest {
    // Creem els mocks objects de utilitzarem en els tests
    @Mock
    private CarRepository carRepository;

    @Mock
    private EmailService emailService;

    // Indiquem que s'utilitzaran els mocks en la classe CarServiceImpl
    @InjectMocks
    private CarServiceImpl carService;

    private Car expectedCar;
    @BeforeEach
    void setup(){
        expectedCar = new Car("0000-BBB");
    }

    @Test
    void getByPlate_givenExistingCar_shouldReturnCar() throws ResourceNotFoundException {
        /* Configurem les accions del objecte Mock.
           En aquest cas:
            - Quan (when) al repositori li preguntem per la matricula del cotxe
            - Aleshores (then), ens retornarà l'objecte cotxe
         */
        when(carRepository.getByPlate(expectedCar.getPlate())).thenReturn(expectedCar);

        // Llancem el mètode que volem provar.
        Car actualCar = carService.getByPlate(expectedCar.getPlate());

        assertSame(expectedCar, actualCar);
    }

    @Test
    void getByPlate_givenNonExistingCar_shouldThrowException() throws ResourceNotFoundException {
        String plate = "9999 ZZZ";
        /* Configurem les accions del objecte Mock.
           En aquest cas:
            - Quan (when) al repositori li preguntem per la matricula del cotxe que no existeix
            - Aleshores (then), llançarà una excepció
         */
        when(carRepository.getByPlate(plate)).thenThrow(
            ResourceNotFoundException.class
        );

        // Llancem el mètode que volem provar.
        assertThrows(
                ResourceNotFoundException.class,
                () -> carService.getByPlate(plate),
                "Expected ResourceNotFound exception, but it was not thrown."
        );
    }

    @Test
    void updateKilometers_givenCarLessKilometers_shouldUpdateAndNotSendEmail() {
        expectedCar.setKilometers(5000);

        carService.updateKilometers(expectedCar);

        assertAll(
            () -> verify(carRepository).updateKilometers(expectedCar),
            () -> verify(emailService, never()).sendWorkshopWarning(expectedCar)
        );
    }

    @Test
    void updateKilometers_givenCarMoreKilometers_shouldUpdateAndSendEmail() {
        expectedCar.setKilometers(200000);

        carService.updateKilometers(expectedCar);

        assertAll(
                () -> verify(carRepository).updateKilometers(expectedCar),
                () -> verify(emailService).sendWorkshopWarning(expectedCar)
        );
    }
}