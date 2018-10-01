package me.dimamon.beatportsearcher.entities.beatport;

/**
 * Representation of release entity from Releases page:
 * https://www.beatport.com/releases/all
 */
public class Release {

    private String title;
    private String artists;
    private String label;
    private String date;
    private String pictureUrl;

    public Release(String title, String artists, String label, String date, String pictureUrl) {
        this.title = title;
        this.artists = artists;
        this.label = label;
        this.date = date;
        this.pictureUrl = pictureUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getArtists() {
        return artists;
    }

    public String getLabel() {
        return label;
    }

    public String getDate() {
        return date;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    @Override
    public String toString() {
        return "Release{" +
                "title='" + title + '\'' +
                ", artists='" + artists + '\'' +
                ", label='" + label + '\'' +
                ", date='" + date + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}
