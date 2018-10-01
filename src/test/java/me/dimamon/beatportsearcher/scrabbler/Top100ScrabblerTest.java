package me.dimamon.beatportsearcher.scrabbler;

import me.dimamon.beatportsearcher.entities.beatport.Genre;
import me.dimamon.beatportsearcher.scrappers.Top100Scrapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Top100ScrabblerTest {

    @Test
    public void buildUrl() {
        assertEquals(
                "https://www.beatport.com/genre/drum-and-bass/1/top-100",
                Top100Scrapper.buildUrl(Genre.DRUM_AND_BASS));
        assertEquals(
                "https://www.beatport.com/genre/dubstep/18/top-100",
                Top100Scrapper.buildUrl(Genre.DUBSTEP));
        assertEquals(
                "https://www.beatport.com/genre/hip-hop-r-and-b/38/top-100",
                Top100Scrapper.buildUrl(Genre.HIP_HOP_RNB));
    }

}