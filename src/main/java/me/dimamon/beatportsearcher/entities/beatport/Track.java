package me.dimamon.beatportsearcher.entities.beatport;

import java.beans.Transient;
import java.util.List;
import java.util.Objects;

/**
 * Representation of track entity on BeatPort
 */
public class Track {

    private String title;

    private List<String> artists;

    //todo: add genre

    public Track(String title, List<String> artists) {
        this.title = title;
        this.artists = artists;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getArtists() {
        return artists;
    }

    /**
     * @return {@code true} if all fields has values, otherwise {@code false}
     */
    @Transient
    public boolean isFilled() {

        if (title.isEmpty() || artists.isEmpty()) {
            return false;
        }

        // check if there no empty record in artists list
        if (artists.size() == 1 && artists.get(0).isEmpty()) {
            return false;
        }

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return Objects.equals(title, track.title) &&
                Objects.equals(artists, track.artists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artists);
    }

    @Override
    public String toString() {
        return "Track{" +
                "title='" + title + '\'' +
                ", artists=" + artists +
                '}';
    }
}
