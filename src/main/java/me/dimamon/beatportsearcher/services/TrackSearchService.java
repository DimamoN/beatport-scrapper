package me.dimamon.beatportsearcher.services;

import me.dimamon.beatportsearcher.entities.Genre;
import me.dimamon.beatportsearcher.entities.Track;

import java.util.List;

/**
 * Searching tracks
 * Access to TOP tracks
 */
public interface TrackSearchService {

    /**
     * @param genre target genre
     * @return list with top 100 tracks of target genre
     */
    List<Track> retrieveTop100(Genre genre);
}
