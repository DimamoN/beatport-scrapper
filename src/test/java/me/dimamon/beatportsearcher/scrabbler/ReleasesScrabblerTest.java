package me.dimamon.beatportsearcher.scrabbler;

import me.dimamon.beatportsearcher.entities.Genre;
import me.dimamon.beatportsearcher.entities.Release;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.*;

public class ReleasesScrabblerTest {

    private static final Logger log = LoggerFactory.getLogger(ReleasesScrabblerTest.class);

    @Test
    public void buildUrl() {
        assertEquals(
                "https://www.beatport.com/releases/all?genres=1",
                ReleasesScrabbler.buildUrl(Genre.DRUM_AND_BASS));
    }

    @Test
    public void getLatestReleases() {
        List<Release> releases = ReleasesScrabbler.getLatestReleases(Genre.DRUM_AND_BASS);
        log.debug(releases.toString());
    }
}