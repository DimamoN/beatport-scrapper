package me.dimamon.beatportsearcher.scrabbler;

import org.junit.Test;

import static org.junit.Assert.*;

public class Top100ScrabblerTest {

    @Test
    public void buildUrl() {
        assertEquals(
                "https://www.beatport.com/genre/drum-and-bass/1/top-100",
                Top100Scrabbler.buildUrl(Top100Scrabbler.Genre.DRUM_AND_BASS));
    }

    @Test
    public void processTOP100Page() {
        Top100Scrabbler.processTOP100Page(Top100Scrabbler.Genre.DRUM_AND_BASS);
    }
}