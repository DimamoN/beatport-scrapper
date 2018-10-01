package me.dimamon.beatportsearcher.controllers;

import me.dimamon.beatportsearcher.entities.Genre;
import me.dimamon.beatportsearcher.entities.Release;
import me.dimamon.beatportsearcher.entities.Track;
import me.dimamon.beatportsearcher.services.beatport.BeatportSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/beatport/")
public class BeatportSearchController {

    @Autowired
    private BeatportSearchService beatportSearchService;

    @GetMapping(path = "/top/{genre}")
    public List<Track> getTop100Tracks(@PathVariable String genre) {
        return beatportSearchService.retrieveTop100(Genre.GENRES.get(genre));
    }

    @GetMapping(path = "/releases/{genre}")
    public List<Release> getRecentReleases(@PathVariable String genre) {
        return beatportSearchService.retrieveRecentReleases(Genre.GENRES.get(genre));
    }

}
