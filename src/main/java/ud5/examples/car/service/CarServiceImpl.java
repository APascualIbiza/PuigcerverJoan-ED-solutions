package ud5.examples.car.service;

import ud5.examples.car.Car;
import ud5.examples.car.exception.ResourceNotFoundException;
import ud5.examples.car.repository.CarRepository;

public class CarServiceImpl implements CarService {

    private CarRepository carRepository;
    private EmailService emailService;

    @Override
    public Car getByPlate(String plate) throws ResourceNotFoundException {
        return carRepository.getByPlate(plate);
    }

    @Override
    public void updateKilometers(Car car) {
        carRepository.updateKilometers(car);
        if(car.getKilometers() > 100000)
            emailService.sendWorkshopWarning(car);
    }
}
