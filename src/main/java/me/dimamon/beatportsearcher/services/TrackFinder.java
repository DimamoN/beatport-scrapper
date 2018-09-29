package me.dimamon.beatportsearcher.services;

public interface TrackFinder {

    /**
     * @param request - string request (like: "Get Low")
     * @return link to track
     */
    String findUrl(final String request);

}
