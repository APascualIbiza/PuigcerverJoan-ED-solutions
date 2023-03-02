package ud6.exam;

/**
 * Representa una làmpara
 * @author Joan Puigcerver
 * @version 1.1 2023-03-01
 */
public class Lamp {

    /** Estat de la làmpara. Indica si està encesa o apagada */
    private boolean isOn;

    /** Consum de la làmpara en kWh */
    private final double consumption;

    /**
     * Crea una làmpara amb el consum especificat.
     * Per defecte, la làmpara està apagada.
     * @param consumption Consum de la làmpara
     * @since 1.1
     */
    public Lamp(double consumption) {
        this.consumption = consumption;
        this.isOn = false;
    }

    /**
     * Retorna l'estat de la làmpara
     * @return true si la làmpara està encesa; false si està apagada
     * @since 1.1
     */
    public boolean isOn(){
        return this.isOn;
    }

    /**
     * Encén la làmpara
     * @since 1.1
     */
    public void turnOn() {
        this.isOn = true;
    }

    /**
     * Apaga la làmpara
     * @since 1.1
     */
    public void turnOff() {
        this.isOn = false;
    }

    /**
     * Alterna l'estat de la làmpara.
     * Si està encesa, l'apaga. Si està apagada, l'encén.
     * @since 1.1
     */
    public void toggle() {
        this.isOn = !this.isOn;
    }

    /**
     * Calcula el consum de la làmpara durant els segons especificats.
     * Si la làmpara està apagada, no consumeix res.
     * @param seconds Segons sobre els que es calcula el consum
     * @return Consum de la làmpara en kW
     * @since 1.1
     */
    public double computeConsumption(double seconds) {
        if (!this.isOn) {
            return 0.0;
        }
        double hours = seconds / 3600.0;
        return this.consumption * hours;
    }
}

