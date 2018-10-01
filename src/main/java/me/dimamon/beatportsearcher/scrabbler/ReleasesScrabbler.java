package me.dimamon.beatportsearcher.scrabbler;

import me.dimamon.beatportsearcher.entities.Genre;
import me.dimamon.beatportsearcher.entities.Release;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ReleasesScrabbler extends AbstractBeatportScrabbler {

    private static final Logger log = LoggerFactory.getLogger(ReleasesScrabbler.class);

    //todo: add support for request with multiple genres
    private static final String GET_RELEASES_PATTERN = BASE_URL + "releases/all?genres=GENRES";

    /**
     * One record html structure:
     * <p>
     * ONE_RELEASE_CLASS
     * {
     * RELEASE_ARTWORK_CLASS
     * RELEASE_INFO_CLASS
     * {
     * RELEASE_TITLE
     * RELEASE_ARTISTS
     * RELEASE_LABELS
     * RELEASE_DATE
     * }
     * }
     */
    private static String ONE_RELEASE_CLASS = "bucket-item ec-item horz-release";

    /**
     * <img class="horz-release-artwork"
     * src="https://geo-media.beatport.com/image_size/250x250/7d3e7518-8be1-4026-a7a1-ddb467e2c0f6.jpg">
     */
    private static String RELEASE_ARTWORK_CLASS = "horz-release-artwork";
    private static String RELEASE_INFO_CLASS = "horz-release-meta";

    private static String RELEASE_TITLE = "buk-horz-release-title";
    private static String RELEASE_ARTISTS = "buk-horz-release-artists";
    private static String RELEASE_LABELS = "buk-horz-release-labels";
    private static String RELEASE_DATE = "buk-horz-release-released";

    static String buildUrl(Genre genre) {
        return GET_RELEASES_PATTERN
                .replace("GENRES", String.valueOf(genre.getId()));
    }

    public static List<Release> getLatestReleases(Genre genre) {
        log.debug("Attempting to get latest {} releases", genre.getName());
        ResponseEntity<String> response = rest.getForEntity(buildUrl(genre), String.class);

        try {
            Document doc = Jsoup.parse(Objects.requireNonNull(response.getBody()));
            Elements releases = doc.getElementsByClass(ONE_RELEASE_CLASS);

            return releases.stream().map(r -> {
                final String picture = r.getElementsByClass(RELEASE_ARTWORK_CLASS).first()
                        .attr("data-src");
                final String title = r.getElementsByClass(RELEASE_TITLE).first()
                        .getElementsByTag("a").first().html();
                final String artists = r.getElementsByClass(RELEASE_ARTISTS).first()
                        .getElementsByTag("a").first().html();
                final String labels = r.getElementsByClass(RELEASE_LABELS).first()
                        .getElementsByTag("a").first().html();
                final String date = r.getElementsByClass(RELEASE_DATE).first().html();

                return new Release(title, artists, labels, date, picture);

            }).collect(Collectors.toList());

        } catch (NullPointerException e) {
            log.error("Response is empty: {}", e.toString());
        }
        return Collections.emptyList();
    }

}
