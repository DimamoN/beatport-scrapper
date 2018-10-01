package me.dimamon.beatportsearcher.services.beatport;

import me.dimamon.beatportsearcher.entities.Genre;
import me.dimamon.beatportsearcher.entities.Track;
import me.dimamon.beatportsearcher.scrabbler.Top100Scrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TrackSearchServiceImpl implements TrackSearchService {

    private static final Logger log = LogManager.getLogger(TrackSearchServiceImpl.class);

    @Override
    public List<Track> retrieveTop100(Genre genre) {

        if (Objects.isNull(genre)) {
            throw new NullPointerException("genre can't be null");
        }

        List<Track> tracks = Top100Scrapper.processTOP100Page(genre);
        log.debug("{} top tracks found for genre: {}", tracks.size(), genre.getName());
        return tracks;
    }

}
