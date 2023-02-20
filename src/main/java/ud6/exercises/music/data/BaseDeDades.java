package ud6.exercises.music.data;

import ud6.exercises.music.models.Artista;
import ud6.exercises.music.models.Grup;

import java.util.ArrayList;
import java.util.List;

/**
 * Aquesta classe simula una base de dades on es poden accedir a la llista
 * de artistes i grups disponibles.
 * <p>
 * Aquesta classe no segueix cap tipus de patró de disseny ni
 * és un bon exemple de com funciona una aplicació real.
 *
 * @author Joan Puigcerver
 * @version 1.1 2022-12-14
 */
public class BaseDeDades {

    private static BaseDeDades instance;

    public static BaseDeDades getInstance(){
        if(instance == null)
            instance = new BaseDeDades();
        return instance;
    }

    /**
     * Llista d'artistes en la base de dades
     */
    private final List<Artista> artistes;
    /**
     * Llista de grups en la base de dades
     */
    private final List<Grup> grups;

    /**
     * Crea i inicialitza la base de dades en valors predefinits.
     */
    private BaseDeDades() {
        artistes = new ArrayList<>();
        grups = new ArrayList<>();

        Grup rolling = new Grup("Rolling", "1994-11-28", "València");
        Grup u2 = new Grup("U2","1977-01-01","England");
        Grup simpleMinds = new Grup("Simple Minds","1979-02-09","England");
        Grup theMechanics = new Grup("Mike + The Mechanics","1988-04-06","England");
        Grup genesis = new Grup("Genesis","1975-10-10","England");
        Grup presuntosImplicados = new Grup("Presuntos Implicados","1985-11-01","Spain");
        Grup radioFutura = new Grup("Radio Futura","1980-01-07","Spain");

        Artista adamClayton = new Artista("Adam", "Clayton", "England");
        Artista bono = new Artista("Paul David", "Bono", "Ireland");
        Artista edge = new Artista("Dave Howell", "Edge", "Ireland");
        Artista larry = new Artista("Larry",  "Mullen Jr.", "Ireland");
        Artista burchill = new Artista("Charlie", "Burchill", "England");
        Artista jimKerr = new Artista("Jim", "Kerr", "England");
        Artista adrianLee = new Artista("Adrian", "Lee", "England");
        Artista paulYoung = new Artista("Paul", "Young", "England");
        Artista pVanHooke = new Artista("Peter", "Van Hooke", "England");
        Artista mRutherford = new Artista("Mike", "Rutherford", "England");
        Artista philCollins = new Artista("Phil", "Collins", "England");
        Artista tonyBanks = new Artista("Tony", "Banks", "England");
        Artista jlGimenez = new Artista("Juan Luís", "Giménez", "Spain");
        Artista soledadGimenez = new Artista("Soledad", "Giménez", "Spain");
        Artista nachoMano = new Artista("Nacho" , "Maño", "Spain");
        Artista carlosTorero = new Artista("Carlos", "Torero", "Spain");
        Artista santiagoAuseron = new Artista("Santiago", "Auserón", "Spain");
        Artista luisAuseron = new Artista("Luis", "Auserón", "Spain");
        Artista enriqueSierra = new Artista("Enrique", "Sierra", "Spain");

        u2.addArtista(adamClayton);
        u2.addArtista(bono);
        u2.addArtista(edge);
        u2.addArtista(larry);
        simpleMinds.addArtista(burchill);
        simpleMinds.addArtista(jimKerr);
        theMechanics.addArtista(adrianLee);
        theMechanics.addArtista(paulYoung);
        theMechanics.addArtista(pVanHooke);
        theMechanics.addArtista(mRutherford);
        genesis.addArtista(philCollins);
        genesis.addArtista(tonyBanks);
        genesis.addArtista(mRutherford);
        presuntosImplicados.addArtista(jlGimenez);
        presuntosImplicados.addArtista(soledadGimenez);
        presuntosImplicados.addArtista(nachoMano);
        radioFutura.addArtista(carlosTorero);
        radioFutura.addArtista(santiagoAuseron);
        radioFutura.addArtista(luisAuseron);
        radioFutura.addArtista(enriqueSierra);

        addGrup(rolling);
        addGrup(u2);
        addGrup(simpleMinds);
        addGrup(theMechanics);
        addGrup(genesis);
        addGrup(presuntosImplicados);
        addGrup(radioFutura);

        addArtista(adamClayton);
        addArtista(bono);
        addArtista(edge);
        addArtista(larry);
        addArtista(burchill);
        addArtista(jimKerr);
        addArtista(adrianLee);
        addArtista(paulYoung);
        addArtista(pVanHooke);
        addArtista(mRutherford);
        addArtista(philCollins);
        addArtista(tonyBanks);
        addArtista(jlGimenez);
        addArtista(soledadGimenez);
        addArtista(nachoMano);
        addArtista(carlosTorero);
        addArtista(santiagoAuseron);
        addArtista(luisAuseron);
        addArtista(enriqueSierra);
    }

    /**
     * Retorna la llista d'artistes de la base de dades
     * @return Llista d'artistes
     */
    public List<Artista> getArtistes() {
        return artistes;
    }

    /**
     * Retorna la llista de grups de la base de dades
     * @return Llista de grups
     */
    public List<Grup> getGrups() {
        return grups;
    }

    /**
     * Afegeix un artista a la base de dades
     * @param artista Artista que s'afegirà a la base de dades
     */
    public void addArtista(Artista artista){
        artistes.add(artista);
    }
    /**
     * Afegeix un grup a la base de dades
     * @param grup Grup que s'afegirà a la base de dades
     */
    public void addGrup(Grup grup){
        grups.add(grup);
    }
}
