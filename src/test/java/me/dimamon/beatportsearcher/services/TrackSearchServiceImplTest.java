package me.dimamon.beatportsearcher.services;

import me.dimamon.beatportsearcher.entities.Genre;
import me.dimamon.beatportsearcher.entities.Track;
import me.dimamon.beatportsearcher.services.beatport.TrackSearchServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TrackSearchServiceImplTest {

    @Test
    public void retrieveTop100() {
        TrackSearchServiceImpl service = new TrackSearchServiceImpl();
        List<Track> tracks = service.retrieveTop100(Genre.DUBSTEP);
        assertEquals(100, tracks.size());
    }
}