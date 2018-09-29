package me.dimamon.beatportsearcher.controllers;

import me.dimamon.beatportsearcher.entities.Genre;
import me.dimamon.beatportsearcher.entities.Track;
import me.dimamon.beatportsearcher.entities.TrackSearchResponse;
import me.dimamon.beatportsearcher.services.GoogleMusicTrackFinder;
import me.dimamon.beatportsearcher.services.beatport.TrackSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class TrackSearchController {

    @Autowired
    private TrackSearchService trackSearchService;

    @Autowired
    private GoogleMusicTrackFinder trackFinder;


    @GetMapping(path = "/top/{genre}")
    public List<Track> getTop100Tracks(@PathVariable String genre) {
        return trackSearchService.retrieveTop100(Genre.GENRES.get(genre));
    }

    @GetMapping(path = "/track/{name}")
    public TrackSearchResponse searchTrack(@PathVariable String name) {
        return trackFinder.findTrack(name);
    }
}
