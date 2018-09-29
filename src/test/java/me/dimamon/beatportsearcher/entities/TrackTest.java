package me.dimamon.beatportsearcher.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackTest {

    @Test
    public void isFilled() {
        assertTrue(new Track("title", "artist").isFilled());
        assertFalse(new Track("title", "").isFilled());
        assertFalse(new Track("", "artist").isFilled());
        assertFalse(new Track("", "").isFilled());
    }
}