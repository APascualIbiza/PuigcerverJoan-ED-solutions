package ud4.practices.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Aquesta classe representa un Grup musical
 *
 * @author Joan Puigcerver
 * @version 1.1 2023-01-29
 */
public class Grup {
    /** Nom del grup musical */
    private final String nom;
    /** Data de fundació del grup musical */
    private final LocalDate dataFundacio;
    /** País d'orgien del grup musical */
    private final String pais;
    /** Llista de membres del grup musical */
    private final List<Artista> artistes;

    /**
     * Crea un Grup musical a partir del nom, la data de fundació i el país d'origen
     * on encara no hi ha cap membre.
     * @param nom Nom del grup musical
     * @param dataFundacio Data de fundació del grup musical
     * @param pais País d'origen del grup musical
     */
    public Grup(String nom, LocalDate dataFundacio, String pais) {
        this.nom = nom;
        this.dataFundacio = dataFundacio;
        this.pais = pais;
        this.artistes = new ArrayList<>();
    }
    /**
     * Crea un Grup musical a partir del nom, la data de fundació en format (yyyy-MM-dd) i el país d'origen
     * on encara no hi ha cap membre.
     * @param nom Nom del grup musical
     * @param dataFundacio Data de fundació del grup musical en format (yyyy-MM-dd)
     * @param pais País d'origen del grup musical
     */
    public Grup(String nom, String dataFundacio, String pais) {
        this(nom, LocalDate.parse(dataFundacio, DateTimeFormatter.ofPattern("yyyy-MM-dd")), pais);
    }

    /**
     * Obté el nom del grup musical
     * @return Nom del grup musical
     */
    public String getNom() {
        return nom;
    }

    /**
     * Obté la data de funcació del grup musical
     * @return Data de funcació del grup musical
     */
    public LocalDate getDataFundacio() {
        return dataFundacio;
    }

    /**
     * Obté el país d'origen del grup musical
     * @return País d'origen del grup musical
     */
    public String getPais() {
        return pais;
    }

    /**
     * Obté la llista de membres del grup musical
     * @return Llista de membres del grup musical
     */
    public List<Artista> getArtistes() {
        return artistes;
    }

    /**
     * Afegeix un artista a la llista de membres si aquest encara no forma part del grup musical.
     * @param artista Artista que es desitja afegir
     * @return {@code true} si l'artista s'ha afegit correctament; {@code false} en altre cas
     */
    public boolean addArtista(Artista artista){
        if (artistes.contains(artista))
            return false;
        artistes.add(artista);
        return true;
    }

    /**
     * Obté una representació del grup en un String, que conté
     * el nom i la data de fundació.
     * @return Representació en String del grup musical
     */
    @Override
    public String toString() {
        return String.format("%s (%d)", nom, dataFundacio.getYear());
    }
}
