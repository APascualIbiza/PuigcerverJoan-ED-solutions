package ud6.exam;

/**
 * Aquesta classe representa una làmpara
 * @author Joan Puigcerver
 * @version 1.1 2023-03-01
 */
public class Lamp {

    /** Representa si la làmpara està encesa (true) o està apagada (false) */
    private boolean isOn;

    /** Consumició de la làmpara en kWh */
    private final double consumption;

    /**
     * Crea una làmpara amb la consumició especificada. La làmpara està apagada per defecte.
     * @param consumption Consumició de la làmpara
     */
    public Lamp(double consumption) {
        this.consumption = consumption;
        this.isOn = false;
    }

    /**
     * Retorna si l'estat de la làmpara
     * @return true si la làmparà està encesa; false si està apagada
     */
    public boolean isOn(){
        return this.isOn;
    }

    /**
     * Encén la làmpara
     */
    public void turnOn() {
        this.isOn = true;
    }

    /**
     * Apaga la làmpara
     */
    public void turnOff() {
        this.isOn = false;
    }

    /**
     * Alterna l'estat de la làmpara.
     * Si està encesa, l'apaga. Si esta apagada, l'encén.
     */
    public void toggle() {
        this.isOn = !this.isOn;
    }

    /**
     * Calcula la consumició de la làmpara en kW durant els segons especificats.
     * Si la làmpara està apagada, no consumeix res.
     *
     * @param seconds Segons sobre els que es calcularà la consumició.
     * @return Consumició de la làmpara en kW.
     */
    public double computeConsumption(double seconds) {
        if (!this.isOn) {
            return 0.0;
        }
        double hours = seconds / 3600.0;
        return this.consumption * hours;
    }
}

