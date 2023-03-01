package ud6.exam;

public enum CoffeeType {
    ESPRESSO (50, 0, 20),
    LATTE (50, 50, 30),
    CAPPUCCINO (70, 30, 20);

    private final int waterNeeded;
    private final int milkNeeded;
    private final int beansNeeded;

    private CoffeeType(int waterNeeded, int milkNeeded, int beansNeeded) {
        this.waterNeeded = waterNeeded;
        this.milkNeeded = milkNeeded;
        this.beansNeeded = beansNeeded;
    }

    public int getWaterNeeded() {
        return waterNeeded;
    }

    public int getMilkNeeded() {
        return milkNeeded;
    }

    public int getBeansNeeded() {
        return beansNeeded;
    }
}

