package ud4.practices.models;

/**
 * Aquesta classe representa un Artista
 *
 * @author Joan Puigcerver
 * @version 1.1 2023-01-29
 */
public class Artista {
    /** Nom de l'artista */
    private final String nom;
    /** Cognom de l'artista */
    private final String cognom;
    /** País d'origen de l'artista */
    private final String pais;

    /**
     * Crea un Artista a partir del seu nom, cognom i país d'origen
     * @param nom Nom de l'artista
     * @param cognom Cognom de l'artista
     * @param pais País d'origen de l'artista
     */
    public Artista(String nom, String cognom, String pais) {
        this.nom = nom;
        this.cognom = cognom;
        this.pais = pais;
    }

    /**
     * Obté el nom de l'artista
     * @return Nom de l'artista
     */
    public String getNom() {
        return nom;
    }

    /**
     * Obté el cognom de l'artista
     * @return Cognom de l'artista
     */
    public String getCognom() {
        return cognom;
    }

    /**
     * Obté el país d'origen de l'artista
     * @return País d'origen de l'artista
     */
    public String getPais() {
        return pais;
    }

    /**
     * Obté una representació de l'artista en un String, que conté
     * el nom i cognom de l'artista.
     * @return Representació en String de l'artista
     */
    @Override
    public String toString() {
        return String.format("%s %s", nom, cognom);
    }
}
