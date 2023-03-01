package ud6.exercises.music.models;

public class Song implements Prototype {
    private String title;
    private int length;

    public Song(String title, int length) {
        this.title = title;
        this.length = length;
    }

    private Song(Song other) {
        this.title = other.title;
        this.length = other.length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Song clone(){
        return new Song(this);
    }
}
