package me.dimamon.beatportsearcher.services;

import me.dimamon.beatportsearcher.entities.web.TrackSearchResponse;

public interface TrackFinder {

    /**
     * @param request - string request (like: "Get Low")
     * @return search result {@link TrackSearchResponse}
     */
    TrackSearchResponse findTrack(final String request);

}
