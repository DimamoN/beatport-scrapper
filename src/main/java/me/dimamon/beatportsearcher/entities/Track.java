package me.dimamon.beatportsearcher.entities;

import java.util.Objects;

/**
 * Representation of track entity on BeatPort
 */
public class Track {

    private String title, artists;
    //todo: add genre

    public Track(String title, String artists) {
        this.title = title;
        this.artists = artists;
    }

    public String getTitle() {
        return title;
    }

    public String getArtists() {
        return artists;
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
                ", artists='" + artists + '\'' +
                '}';
    }
}
