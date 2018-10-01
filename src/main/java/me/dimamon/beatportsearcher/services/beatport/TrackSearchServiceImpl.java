package me.dimamon.beatportsearcher.services.beatport;

import me.dimamon.beatportsearcher.entities.Genre;
import me.dimamon.beatportsearcher.entities.Release;
import me.dimamon.beatportsearcher.entities.Track;
import me.dimamon.beatportsearcher.scrabbler.ReleasesScrapper;
import me.dimamon.beatportsearcher.scrabbler.Top100Scrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TrackSearchServiceImpl implements BeatportSearchService {

    private static final Logger log = LogManager.getLogger(TrackSearchServiceImpl.class);

    @Override
    public List<Track> retrieveTop100(Genre genre) {
        verifyParam(genre);
        List<Track> tracks = Top100Scrapper.processTOP100Page(genre);
        log.debug("{} top tracks found for genre: {}", tracks.size(), genre.getName());
        return tracks;
    }

    @Override
    public List<Release> retrieveRecentReleases(Genre genre) {
        verifyParam(genre);
        List<Release> releases = ReleasesScrapper.getLatestReleases(genre);
        log.debug("{} releases found for genre: {}", releases.size(), genre.getName());
        return releases;
    }

    private void verifyParam(Genre genre) {
        if (Objects.isNull(genre)) {
            throw new NullPointerException("genre can't be null");
        }
    }

}
