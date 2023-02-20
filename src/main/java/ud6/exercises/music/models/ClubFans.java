package ud6.exercises.music.models;

public class ClubFans {
    private String nom;
    private String adreça;
    private int membres;
    private Grup grup;

    public ClubFans(String nom, String adreça, int membres, Grup grup) {
        this.nom = nom;
        this.adreça = adreça;
        this.membres = membres;
        this.grup = grup;
    }

    public String getNom() {
        return nom;
    }

    public String getAdreça() {
        return adreça;
    }

    public int getMembres() {
        return membres;
    }

    public Grup getGrup() {
        return grup;
    }

    public void setMembres(int membres) {
        this.membres = membres;
    }
}
