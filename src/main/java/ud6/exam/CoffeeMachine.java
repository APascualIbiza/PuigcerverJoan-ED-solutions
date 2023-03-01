package ud6.exam;


/*
    TODO: Explica en aquesta secció els code smells identificats i el procés de refactorització realitzat

    S'ha identificat el code smell "Long Method" en el mètode makeCoffee(). Aquest mètode
    és molt llarg i fa dues coses diferents: Comprovar si hi ha prou ingredients i actualitzar
    els ingredients que queden a la màquina.

    S'ha realitzat el següent procediment per fer la refactorització:
    - S'han llançat els tests per comprovar que el programa funciona correctament abans de fer canvis.
    - S'ha extret el mètode enoughIngredients(), que retorna true o false en cas si hi ha prou ingredients o no.
    - S´ha tornat a provar que el codi funciona correctament en els tests.
    - S'ha extret el mètode updateIngredients(), que actualitza els nivells de la màquina.
    - Finalment, s'ha tornat a provar que funciona correctament.
 */
public class CoffeeMachine {
    private int water;
    private int milk;
    private int cups;
    private int coffeBeans;
    private int sugar;

    public CoffeeMachine(int water, int milk, int cups, int coffeBeans, int sugar) {
        this.water = water;
        this.milk = milk;
        this.cups = cups;
        this.coffeBeans = coffeBeans;
        this.sugar = sugar;
    }

    @Override
    public String toString() {
        return "CoffeeMachine{" +
                "water=" + water +
                ", milk=" + milk +
                ", cups=" + cups +
                ", coffeBeans=" + coffeBeans +
                ", sugar=" + sugar +
                "}";
    }

    private boolean enoughIngredients(CoffeeType coffeeType, int sugar){
        if(cups == 0) {
            System.out.println("Not enough cups to make a " + coffeeType);
            return false;
        } else if (this.sugar < sugar) {
            System.out.println("Not enough sugar to make a " + coffeeType);
            return false;
        } else if (this.water < coffeeType.getWaterNeeded()) {
            System.out.println("Not enough water to make a " + coffeeType);
            return false;
        } else if (this.milk < coffeeType.getMilkNeeded()) {
            System.out.println("Not enough milk to make a " + coffeeType);
            return false;
        } else if (this.coffeBeans < coffeeType.getBeansNeeded()) {
            System.out.println("Not enough coffeBeans to make a " + coffeeType);
            return false;
        }
        return true;
    }

    private void updateIngredients(CoffeeType coffeeType, int sugar) {
        this.cups--;
        this.sugar -= sugar;
        this.water -= coffeeType.getWaterNeeded();
        this.milk -= coffeeType.getMilkNeeded();
        this.coffeBeans -= coffeeType.getBeansNeeded();
    }

    public boolean makeCoffee(CoffeeType coffeeType, int sugar){
        if(enoughIngredients(coffeeType, sugar)) {
            System.out.println(coffeeType + " made!");
            updateIngredients(coffeeType, sugar);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(200, 200, 3, 100, 100);
        coffeeMachine.makeCoffee(CoffeeType.ESPRESSO, 10);
        System.out.println(coffeeMachine);
        coffeeMachine.makeCoffee(CoffeeType.LATTE, 10);
        System.out.println(coffeeMachine);
        coffeeMachine.makeCoffee(CoffeeType.CAPPUCCINO, 10);
        System.out.println(coffeeMachine);
        coffeeMachine.makeCoffee(CoffeeType.CAPPUCCINO, 10);
        System.out.println(coffeeMachine);
    }
}

