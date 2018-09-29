package me.dimamon.beatportsearcher.entities;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrackTest {

    @Test
    public void isFilled() {
        assertTrue(new Track("title", Collections.singletonList("artist")).isFilled());
        assertFalse(new Track("title", Collections.singletonList("")).isFilled());
        assertFalse(new Track("", Collections.singletonList("artist")).isFilled());
        assertFalse(new Track("", Collections.singletonList("")).isFilled());
    }
}