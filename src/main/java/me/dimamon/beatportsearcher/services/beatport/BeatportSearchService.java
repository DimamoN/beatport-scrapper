package me.dimamon.beatportsearcher.services.beatport;

import me.dimamon.beatportsearcher.entities.Genre;
import me.dimamon.beatportsearcher.entities.Release;
import me.dimamon.beatportsearcher.entities.Track;

import java.util.List;

/**
 * Searching for:
 *  - top tracks by genre (TOP100 page)
 *  - recent releases by genre (Releases page)
 */
public interface BeatportSearchService {

    /**
     * @param genre target genre
     * @return list with top 100 tracks of target genre
     */
    List<Track> retrieveTop100(Genre genre);

    /**
     * @param genre target genre
     * @return list with recent 100 releases of target genre
     */
    List<Release> retrieveRecentReleases(Genre genre);

}
