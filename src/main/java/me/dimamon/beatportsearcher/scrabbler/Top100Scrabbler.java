package me.dimamon.beatportsearcher.scrabbler;

import me.dimamon.beatportsearcher.entities.Genre;
import me.dimamon.beatportsearcher.entities.Track;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Scrabbler for retrieving top100 tracks.
 * Target page example: https://www.beatport.com/genre/house/5/top-100
 */
public class Top100Scrabbler {

    private static RestTemplate rest = new RestTemplate();

    private static final String TRACK_ELEMENT = "buk-track-meta-parent";
    private static final String TRACK_ARTIST = "buk-track-artists";
    private static final String TRACK_TITLE = "buk-track-primary-title";

    private static String BASE_URL = "https://www.beatport.com/";
    private static String TOP_100_PATTERN = BASE_URL + "genre/GENRE_NAME/GENRE_ID/top-100";

    static String buildUrl(Genre genre) {
        return TOP_100_PATTERN
                .replace("GENRE_NAME", genre.getName())
                .replace("GENRE_ID", String.valueOf(genre.getId()));
    }

    static List<String> parseArtists(String artists) {
        return Arrays.asList(artists.split("\n"));
    }

    public static List<Track> processTOP100Page(Genre genre) {

        System.out.printf("Attempting to get TOP100 %s tracks", genre.getName());
        ResponseEntity<String> response = rest.getForEntity(buildUrl(genre), String.class);

        try {
            Document doc = Jsoup.parse(Objects.requireNonNull(response.getBody()));
            Elements tracks = doc.getElementsByClass(TRACK_ELEMENT);
            List<Track> trackList = tracks.stream().map(el -> {
                final String title = el.getElementsByClass(TRACK_TITLE).get(0).attr("title");
                final String artists = el.getElementsByClass(TRACK_ARTIST).get(0)
                        .getElementsByAttribute("data-artist").html();
                return new Track(title, parseArtists(artists));
            }).collect(Collectors.toList());

            System.out.println(trackList);

            return trackList;

        } catch (NullPointerException e) {
            System.err.println("Response is empty:" + e.toString());
        }
        return Collections.emptyList();
    }

}
