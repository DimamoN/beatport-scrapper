package me.dimamon.beatportsearcher.services;

import com.github.felixgail.gplaymusic.api.GPlayMusic;
import com.github.felixgail.gplaymusic.model.Album;
import com.github.felixgail.gplaymusic.model.Track;
import com.github.felixgail.gplaymusic.model.enums.ResultType;
import com.github.felixgail.gplaymusic.model.enums.StreamQuality;
import com.github.felixgail.gplaymusic.model.requests.SearchTypes;
import com.github.felixgail.gplaymusic.model.responses.SearchResponse;
import me.dimamon.beatportsearcher.entities.TrackSearchResponse;
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

    /**
     * Concatenate with album id to make valid url
     */
    private static final String GOOGLE_PLAY_ALBUM_LINK = "https://play.google.com/music/m/";

    private static SearchTypes SEARCH_TRACK = new SearchTypes();

    static {
        SEARCH_TRACK.setTypes(Collections.singletonList(ResultType.TRACK));
    }

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public TrackSearchResponse findTrack(final String request) {

        GPlayMusic api = authenticationService.getApi();

        try {
            SearchResponse result = api.search(request, SEARCH_TRACK);
            List<Track> tracks = result.getTracks();
            log.debug("Request: {} -> Tracks found: {}", request, tracks.size());

            // maybe should get more than one response
            if (!tracks.isEmpty()) {
                Track track = tracks.get(0);
                log.debug("Request: {} -> Found first track: {} by {}",
                        request, track.getTitle(), track.getArtist());

                Album album = api.getAlbum(track.getAlbumId(), false);
                final String albumUrl = GOOGLE_PLAY_ALBUM_LINK + album.getAlbumId();
                final String trackStreamUrl = track.getStreamURL(StreamQuality.HIGH).toString();

                TrackSearchResponse response = new TrackSearchResponse(
                        trackStreamUrl, albumUrl,
                        track.getTitle(), album.getName(), track.getArtist());
                log.debug("Request: {} -> from album {}", request, response.getAlbumUrl());
                return response;
            } else {
                log.debug("There no tracks found on request: {}", request);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
