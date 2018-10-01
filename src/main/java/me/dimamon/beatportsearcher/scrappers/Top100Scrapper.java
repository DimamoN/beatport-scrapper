package me.dimamon.beatportsearcher.scrappers;

import me.dimamon.beatportsearcher.entities.beatport.Genre;
import me.dimamon.beatportsearcher.entities.beatport.Track;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Scrabbler for retrieving top100 tracks.
 * Target page example: https://www.beatport.com/genre/house/5/top-100
 */
public class Top100Scrapper extends AbstractBeatportScrapper {

    private static final Logger log = LoggerFactory.getLogger(Top100Scrapper.class);

    private static final String TOP_100_PATTERN = BASE_URL + "genre/GENRE_NAME/GENRE_ID/top-100";

    // classes
    private static final String TRACK_ELEMENT = "buk-track-meta-parent";
    private static final String TRACK_ARTIST = "buk-track-artists";
    private static final String TRACK_TITLE = "buk-track-primary-title";


    static String buildUrl(Genre genre) {
        return TOP_100_PATTERN
                .replace("GENRE_NAME", genre.getName())
                .replace("GENRE_ID", String.valueOf(genre.getId()));
    }

    static List<String> parseArtists(final String artists) {
        return Arrays.asList(artists.split("\n"));
    }

    public static List<Track> processTOP100Page(Genre genre) {
        log.debug("Attempting to get TOP100 {} tracks", genre.getName());
        ResponseEntity<String> response = rest.getForEntity(buildUrl(genre), String.class);

        try {
            Document doc = Jsoup.parse(Objects.requireNonNull(response.getBody()));
            Elements tracks = doc.getElementsByClass(TRACK_ELEMENT);
            List<Track> trackList = tracks.stream().map(el -> {
                final String title = el.getElementsByClass(TRACK_TITLE).first().attr("title");
                final String artists = el.getElementsByClass(TRACK_ARTIST).first()
                        .getElementsByAttribute("data-artist").html();
                return new Track(title, parseArtists(artists));
            }).collect(Collectors.toList());

            return trackList;

        } catch (NullPointerException e) {
            log.error("Response is empty: {}", e.toString());
        }
        return Collections.emptyList();
    }

}
