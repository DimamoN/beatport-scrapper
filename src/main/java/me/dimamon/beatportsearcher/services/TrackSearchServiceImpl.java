package me.dimamon.beatportsearcher.services;

import me.dimamon.beatportsearcher.entities.Genre;
import me.dimamon.beatportsearcher.entities.Track;
import me.dimamon.beatportsearcher.scrabbler.Top100Scrabbler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TrackSearchServiceImpl implements TrackSearchService {

    @Override
    public List<Track> retrieveTop100(Genre genre) {

        if (Objects.isNull(genre)) {
            throw new NullPointerException("genre can't be null");
        }

        List<Track> tracks = Top100Scrabbler.processTOP100Page(genre);

        System.out.printf("%d top tracks found for genre: %s",
                tracks.size(), genre.getName());

        return tracks;
    }
}
