package me.dimamon.beatportsearcher.controllers;

import me.dimamon.beatportsearcher.entities.TrackSearchResponse;
import me.dimamon.beatportsearcher.services.GoogleMusicTrackFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/google_music")
public class GoogleMusicController {

    @Autowired
    private GoogleMusicTrackFinder trackFinder;

    @GetMapping(path = "/search/{name}")
    public TrackSearchResponse searchTrack(@PathVariable String name) {
        return trackFinder.findTrack(name);
    }

}
