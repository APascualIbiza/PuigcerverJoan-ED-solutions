package ud5.examples.car.service;

import ud5.examples.car.Car;
import ud5.examples.car.exception.ResourceNotFoundException;

public interface CarService {
    Car getByPlate(String plate) throws ResourceNotFoundException;

    void updateKilometers(Car car);
}
