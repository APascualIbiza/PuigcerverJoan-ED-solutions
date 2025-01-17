package ud6.exercises.music.models;

import java.util.Objects;

/**
 * Aquesta classe representa un Artista
 *
 * @author Joan Puigcerver
 * @version 1.1 2023-01-29
 */
public class Artista implements Prototype {
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

    public Artista(Artista other){
        this.nom = other.nom;
        this.cognom = other.cognom;
        this.pais = other.pais;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artista artista)) return false;
        return Objects.equals(nom, artista.nom) && Objects.equals(cognom, artista.cognom) && Objects.equals(pais, artista.pais);
    }

    @Override
    public Artista clone(){
        return new Artista(this);
    }
}
