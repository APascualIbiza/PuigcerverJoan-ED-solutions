package ud6.exercises.music.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Album {
    private String title;
    private LocalDate releaseDate;
    private Grup group;

    private List<Song> songs;

    public Album(String title, LocalDate releaseDate, Grup group) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.group = group;
        this.songs = new ArrayList<>();
    }
    public Album(String title, String releaseDate, Grup group) {
        this.title = title;
        this.releaseDate = LocalDate.parse(releaseDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.group = group;
        this.songs = new ArrayList<>();
    }

    private Album(Album other){
        this.title = other.title;
        this.releaseDate = other.releaseDate;
        this.group = other.group;

        this.songs = new ArrayList<>();
        for(Song s : other.songs){
            this.songs.add(s);
        }
    }

    public void addSong(Song song){
        this.songs.add(song);
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Grup getGroup() {
        return group;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setGroup(Grup group) {
        this.group = group;
    }

    public Album clone(){
        return new Album(this);
    }

    public List<Song> getSongs() {
        return songs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album album)) return false;
        return Objects.equals(title, album.title) && Objects.equals(releaseDate, album.releaseDate) && Objects.equals(group, album.group) && Objects.equals(songs, album.songs);
    }
}
