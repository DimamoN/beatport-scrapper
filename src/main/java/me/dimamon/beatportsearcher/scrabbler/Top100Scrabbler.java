package me.dimamon.beatportsearcher.scrabbler;

import me.dimamon.beatportsearcher.entities.Track;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class Top100Scrabbler {

    enum Genre {
        DRUM_AND_BASS("drum-and-bass"),
        TECHNO("techno");
        //TODO: ADD GENRES

        private String string;

        Genre(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }

    private static String BASE_URL = "https://www.beatport.com/";
    private static String TOP_100_PATTERN = BASE_URL + "genre/GENRE/PAGE_NUM/top-100";

    static String buildUrl(Genre genre) {
        return TOP_100_PATTERN
                .replace("GENRE", genre.toString())
                .replace("PAGE_NUM", "1");
    }

    static void processTOP100Page(Genre genre) {
        final String TRACK_ELEMENT = "buk-track-meta-parent";
        final String TRACK_ARTIST = "buk-track-artists";
        final String TRACK_TITLE = "buk-track-primary-title";

        RestTemplate rest = new RestTemplate();
        ResponseEntity<String> response = rest.getForEntity(buildUrl(genre), String.class);

        try {
            Document doc = Jsoup.parse(Objects.requireNonNull(response.getBody()));
            Elements tracks = doc.getElementsByClass(TRACK_ELEMENT);
            List<Track> trackList = tracks.stream().map(el -> {
                final String title = el.getElementsByClass(TRACK_TITLE).get(0).attr("title");
                final String artists = el.getElementsByClass(TRACK_ARTIST).get(0)
                        .getElementsByAttribute("data-artist").html();
                return new Track(title, artists);
            }).collect(Collectors.toList());

            //todo: return tracks?
            System.out.println(trackList);

        } catch (NullPointerException e) {
            System.err.println("Response is empty:" + e.toString());
        }
    }

}
