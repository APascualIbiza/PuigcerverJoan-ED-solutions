package ud6.exam;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeMachineTest {

    @ParameterizedTest
    @CsvSource({
            "LATTE, 10, 0, 100, 100, 100, 100, false",
            "LATTE, 10, 1,   0, 100, 100, 100, false",
            "LATTE, 10, 1, 100,   0, 100, 100, false",
            "LATTE, 10, 1, 100, 100,   0, 100, false",
            "LATTE, 10, 1, 100, 100, 100,   0, false",
            "LATTE, 10, 1, 100, 100, 100, 100, true",
            "ESPRESSO, 10, 0, 100, 100, 100, 100, false",
            "ESPRESSO, 10, 1,   0, 100, 100, 100, false",
            "ESPRESSO, 10, 1, 100,   0, 100, 100, false",
            "ESPRESSO, 10, 1, 100, 100,   0, 100, true",
            "ESPRESSO, 10, 1, 100, 100, 100,   0, false",
            "ESPRESSO, 10, 1, 100, 100, 100, 100, true"
    })
    void makeCoffee(String coffeeType, int coffeeSugar, int machineCups, int machineSugar, int machineWater, int machineMilk, int machineCoffeeBeans, boolean made) {
        CoffeeType type = CoffeeType.valueOf(coffeeType);
        CoffeeMachine machine = new CoffeeMachine(machineWater, machineMilk, machineCups, machineCoffeeBeans, machineSugar);
        assertEquals(made, machine.makeCoffee(type, coffeeSugar));
    }
}

