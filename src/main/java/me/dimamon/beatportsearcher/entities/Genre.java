package me.dimamon.beatportsearcher.entities;

import java.util.*;

/**
 * Representation of genre from BeatPort
 * Each genre has a name and an id.
 * Note, that not all genres are supported for now.
 */
public class Genre {

    public static Genre DRUM_AND_BASS = new Genre("drum-and-bass", 1);
    public static Genre BREAKS = new Genre("breaks", 9);
    public static Genre DUBSTEP = new Genre("dubstep", 18);
    public static Genre HIP_HOP_RNB = new Genre("hip-hop-r-and-b", 38);
    public static Genre TECHNO = new Genre("techno", 6);
    public static Genre TRANCE = new Genre("trance", 7);
    public static Genre TRAP_FUTURE_BASS = new Genre("trap-future-bass", 87);
    public static Genre HOUSE = new Genre("house", 5);

    // All supported genres
    public static Set<Genre> ALL;
    static
    {
        ALL = new HashSet<>();
        ALL.add(Genre.DRUM_AND_BASS);
        ALL.add(Genre.BREAKS);
        ALL.add(Genre.DUBSTEP);
        ALL.add(Genre.HIP_HOP_RNB);
        ALL.add(Genre.TECHNO);
        ALL.add(Genre.TRANCE);
        ALL.add(Genre.TRAP_FUTURE_BASS);
        ALL.add(Genre.HOUSE);
    }

    private String name;
    private int id;

    public Genre(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre_ = (Genre) o;
        return id == genre_.id &&
                Objects.equals(name, genre_.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Genre{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

}