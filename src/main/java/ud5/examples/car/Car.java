package ud5.examples.car;

/**
 * Classe que representa un cotxe.
 * @author Joan Puigcerver
 * @version 1.1 2023-01-15
 */
public class Car {
    /**
     * Matrícula del vehicle
     */
    protected String plate;
    /**
     * Velocitat del cotxe en km/h
     */
    protected int velocity;
    /**
     * Distància total recorreguda pel cotxe en km
     */
    protected double kilometers;

    /**
     * Constructor d'un Cotxe a partir de la matrícula i els
     * kilòmetres totals recorreguts. La velocitat inicial és 0 km/h.
     * @param plate Matrícula del cotxe
     * @param kilometers Kilòmetres recorreguts
     */
    public Car(String plate, double kilometers){
        this.plate = plate;
        this.kilometers = kilometers;
        this.velocity = 0;
    }

    /**
     * Constructor d'un Cotxe a partir de la matrícula
     * Els kilòmetres totals recorreguts inicials és 0 i la velocitat inicial és 0 km/h.
     * @param plate Matrícula del cotxe
     */
    public Car(String plate){
        this(plate, 0);
    }

    /**
     * Obté la matrícula del cotxe
     * @return Matrícula del cotxe
     */
    public String getPlate() {
        return plate;
    }

    /**
     * Obté la velocitat actual del cotxe
     * @return Velocitat del cotxe
     */
    public int getVelocity() {
        return velocity;
    }

    /**
     * Obté els kilòmetres totals recorreguts pel cotxe
     * @return Kilòmetres recorreguts
     */
    public double getKilometers() {
        return kilometers;
    }

    public void setKilometers(double kilometers) {
        this.kilometers = kilometers;
    }

    /**
     * Accelera el cotxe en 5 km/h
     */
    public void accelerate(){
        accelerate(5);
    }

    /**
     * Accelera el cotxe en la velocitat especificada
     * @param velocity Velocitat que accelerarà el cotxe
     */
    public void accelerate(int velocity){
        this.velocity += velocity;
    }

    /**
     * Condueix el cotxe durant els segons especificats.
     * Aquest mètode actualitza els kilòmetres recorreguts tenint en compte
     * la velocitat actual.
     * @param seconds Segons que el cotxe serà conduit
     */
    public void drive(int seconds){
        this.kilometers += (double) velocity * seconds / 3600;
    }

    /**
     * Condueix el cotxe durant un minut.
     * Aquest mètode actualitza els kilòmetres recorreguts tenint en compte
     * la velocitat actual.
     * @see Car#drive()
     */
    public void drive(){
        drive(60);
    }

    public void decelerate(){
        decelerate(5);
    }

    public void decelerate(int velocity){
        // this.velocity = velocity > this.velocity ? 0 : this.velocity - velocity;
        this.velocity = Math.max(0, this.velocity - velocity);
    }

    /**
     * Retorna una representació de l'objecte en format String
     * @return Representació del cotxe
     */
    @Override
    public String toString() {
        return String.format("Car %s: {velocity=%d km/h, kilometers=%.2f km", plate, velocity, kilometers);
    }
}
