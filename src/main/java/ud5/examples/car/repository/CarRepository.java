package ud5.examples.car.repository;

import ud5.examples.car.Car;
import ud5.examples.car.exception.ResourceNotFoundException;

public interface CarRepository {
    Car getByPlate(String plate) throws ResourceNotFoundException;

    void updateKilometers(Car car);
}
