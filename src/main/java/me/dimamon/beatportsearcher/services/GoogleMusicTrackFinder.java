package me.dimamon.beatportsearcher.services;

import com.github.felixgail.gplaymusic.api.GPlayMusic;
import com.github.felixgail.gplaymusic.model.Track;
import com.github.felixgail.gplaymusic.model.enums.ResultType;
import com.github.felixgail.gplaymusic.model.enums.StreamQuality;
import com.github.felixgail.gplaymusic.model.requests.SearchTypes;
import com.github.felixgail.gplaymusic.model.responses.SearchResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service("googleTrackFinder")
public class GoogleMusicTrackFinder implements TrackFinder {

    private static final Logger log = LoggerFactory.getLogger(GoogleMusicTrackFinder.class);

    private static SearchTypes SEARCH_TRACK = new SearchTypes();

    static {
        SEARCH_TRACK.setTypes(Collections.singletonList(ResultType.TRACK));
    }

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public String findUrl(final String request) {

        GPlayMusic api = authenticationService.getApi();

        try {
            SearchResponse result = api.search(request, SEARCH_TRACK);
            List<Track> tracks = result.getTracks();
            log.debug("Request: {} -> Tracks found: {}", tracks.size());

            //dirty!!!
            if (!tracks.isEmpty()) {
                final String url = tracks.get(0)
                        .getStreamURL(StreamQuality.HIGH).toString();
                log.debug("Request: {} -> Track link: {}", url);
                return url;
            } else {
                log.debug("There no tracks found on request: {}", request);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
