package me.dimamon.beatportsearcher.controllers;

import me.dimamon.beatportsearcher.entities.Genre;
import me.dimamon.beatportsearcher.entities.Track;
import me.dimamon.beatportsearcher.services.TrackSearchService;
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

    @GetMapping(path = "/top100/{genre}")
    public List<Track> getTop100Tracks(@PathVariable String genre) {
        return trackSearchService.retrieveTop100(Genre.GENRES.get(genre));
    }

}
