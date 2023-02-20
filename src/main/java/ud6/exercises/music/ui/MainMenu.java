package ud6.exercises.music.ui;

import ud6.exercises.music.data.BaseDeDades;
import ud6.exercises.music.models.Artista;
import ud6.exercises.music.models.Grup;

import java.util.List;
import java.util.Scanner;

/**
 * Menu principal de l'aplicació
 *
 * @author Joan Puigcerver
 * @version 1.1 2023-01-29
 */
public class MainMenu {
    /** Scanner que permet llegir les dades introduides per l'usuari */
    private final Scanner scanner;
    /** Base de dades on es guardaran i es llegiran les dades de l'aplicació */
    private final BaseDeDades dades;

    /**
     * Crea un menu principal amb el Scanner i la base de dades especificada.
     * @param scanner Scanner que permet llegir les dades introduides per l'usuari
     */
    public MainMenu(Scanner scanner){
        this.scanner = scanner;
        this.dades = BaseDeDades.getInstance();
    }

    /**
     * Demana a l'usuari que introduisca una elecció entre 0 i el nombre màxim especificat.
     * En cas que l'elecció no siga vàlida, es torna a preguntar a l'usuari.
     * @param maxim Límit superior de l'elecció permitida per l'usuari
     * @return Elecció de l'usuari
     */
    public int nextIntMaxim(int maxim){
        int eleccioUsuari;
        System.out.print("Introdueix la teua elecció: ");
        eleccioUsuari = scanner.nextInt();
        scanner.nextLine();

        while (!(eleccioUsuari >= 0 && eleccioUsuari <= maxim)) {
            System.out.println("L'elecció triada no està en les opcions disponibles.");
            System.out.print("Introdueix la teua elecció: ");
            eleccioUsuari = scanner.nextInt();
            scanner.nextLine();
        }

        return eleccioUsuari;
    }

    /**
     * Imprimeix per pantalla el menú principal
     */
    public void printMenu(){
        System.out.println("1. Afegir artista.");
        System.out.println("2. Afegir grup musical.");
        System.out.println("3. Afegir artista a grup musical.");
        System.out.println("4. Mostrar artista.");
        System.out.println("5. Mostrar grup musical.");
        System.out.println("0. Eixir.");
    }

    /**
     * Menu principal de l'aplicació.
     * <p>
     * Imprimeix el menú i permet que l'usuari seleccione l'accio que vol realitzar.
     */
    public void menu(){
        System.out.println("Benvingut a Gestió Musical.");
        int eleccioUsuari;
        do {
            printMenu();
            eleccioUsuari = nextIntMaxim(5);

            System.out.println();
            switch (eleccioUsuari) {
                case 1 -> afegirArtista();
                case 2 -> afegirGrup();
                case 3 -> afegirArtistaGrup();
                case 4 -> mostrarArtista();
                case 5 -> mostrarGrup();
            }
            System.out.println();
        } while (eleccioUsuari != 0);
        System.out.println("Adéu!");
    }

    /**
     * Permet que l'usuari puga afegir un nou artista.
     */
    public void afegirArtista(){
        System.out.println("Afegir un nou artista:");
        System.out.print("Introdueix el nom de l'artista: ");
        String nom = scanner.nextLine();
        System.out.print("Introdueix els cognoms de l'artista: ");
        String cognom = scanner.nextLine();
        System.out.print("Introdueix el país de l'artista: ");
        String pais = scanner.nextLine();
        Artista artista = new Artista(nom, cognom, pais);
        dades.addArtista(artista);
        System.out.printf("L'artista %s s'ha afegit correctament.\n", artista);
    }
    /**
     * Permet que l'usuari puga afegir un nou grup.
     */
    public void afegirGrup(){
        System.out.println("Afegir un nou grup:");
        System.out.print("Introdueix el nom del grup: ");
        String nom = scanner.nextLine();
        System.out.print("Introdueix la data de fundació del grup (yyyy-mm-dd): ");
        String date = scanner.nextLine();
        System.out.print("Introdueix el país del grup: ");
        String pais = scanner.nextLine();
        Grup grup = new Grup(nom, date, pais);
        dades.addGrup(grup);
        System.out.printf("El grup %s s'ha afegit correctament.\n", grup);
    }

    /**
     * Permet que l'usuari puga selecionar un artista dels presents en l'aplicació.
     * @return Retorna l'artista seleccionat o {@code null} si l'usuari cancela l'acció.
     */
    private Artista selectArtista(){
        System.out.println("Sel.lecciona l'artista:");
        List<Artista> artistes = dades.getArtistes();
        for (int i = 0; i < artistes.size(); i++) {
            System.out.printf("%d. %s\n", i+1, artistes.get(i));
        }
        System.out.println("0. Cancelar.");

        int eleccioUsuari = nextIntMaxim(artistes.size());

        if (eleccioUsuari == 0)
            return null;
        else
            return artistes.get(eleccioUsuari - 1);
    }

    /**
     * Permet que l'usuari puga selecionar un grup musical dels presents en l'aplicació.
     * @return Retorna el grup seleccionat o {@code null} si l'usuari cancela l'acció.
     */
    private Grup selectGrup(){
        System.out.println("Sel.lecciona el grup:");
        List<Grup> grups = dades.getGrups();
        for (int i = 0; i < grups.size(); i++) {
            System.out.printf("%d. %s\n", i+1, grups.get(i));
        }
        System.out.println("0. Cancelar.");

        int eleccioUsuari = nextIntMaxim(grups.size());

        if (eleccioUsuari == 0)
            return null;
        else
            return grups.get(eleccioUsuari - 1);
    }

    /**
     * Permet que l'usuari afegir un artista a un grup musical.
     */
    public void afegirArtistaGrup(){
        if (dades.getArtistes().size() == 0) {
            System.out.println("No hi ha artistes disponibles.");
            return;
        } else if (dades.getGrups().size() == 0) {
            System.out.println("No hi ha grups disponibles.");
            return;
        }

        Artista a = selectArtista();
        if (a == null)
            return;
        Grup g = selectGrup();
        if (g == null)
            return;
        boolean added = g.addArtista(a);
        if (added)
            System.out.printf("L'artista %s s'ha afegit al grup %s correctament\n", a, g);
        else
            System.out.printf("L'artista %s ja és membre de %s\n", a, g);
    }

    /**
     * Imprimeix per pantalla la informació d'un artista seleccionat per l'usuari.
     */
    public void mostrarArtista(){
        if (dades.getArtistes().size() == 0) {
            System.out.println("No hi ha artistes disponibles.");
        } else {
            Artista a = selectArtista();
            if(a != null) {
                System.out.printf("Nom de l'artista: %s\n", a.getNom());
                System.out.printf("Cognoms de l'artista: %s\n", a.getCognom());
                System.out.printf("País de l'artista: %s\n", a.getPais());
            }
        }
    }
    /**
     * Imprimeix per pantalla la informació d'un grup musical seleccionat per l'usuari.
     */
    public void mostrarGrup(){
        if (dades.getGrups().size() == 0) {
            System.out.println("No hi ha grups disponibles.");
        } else {
            Grup g = selectGrup();
            if(g != null) {
                System.out.printf("Nom del grup: %s\n", g.getNom());
                System.out.printf("Data de fundació: %s\n", g.getDataFundacio());
                System.out.printf("País del grup: %s\n", g.getPais());
                if(g.getArtistes().size() > 0) {
                    System.out.println("Membres:");
                    for (Artista a : g.getArtistes())
                        System.out.printf("- %s\n", a);
                } else
                    System.out.println("El grup no te membres.");
            }
        }
    }
}
