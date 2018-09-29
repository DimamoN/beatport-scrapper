package me.dimamon.beatportsearcher.scrabbler;

import me.dimamon.beatportsearcher.entities.Genre;
import me.dimamon.beatportsearcher.entities.Track;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ProcessTop100Parametrized {

    private Genre genre;

    public ProcessTop100Parametrized(Genre genre) {
        this.genre = genre;
    }

    @Parameterized.Parameters(name = "{index}:{0}")
    public static Iterable<Genre> dataForTest() {
        return Genre.ALL;
    }

    @Test
    public void processTOP100Page() {
        List<Track> topTracks = Top100Scrabbler.processTOP100Page(genre);
        assertEquals(100, topTracks.size());
        topTracks.forEach(track -> assertTrue(track.isFilled()));
    }

}
