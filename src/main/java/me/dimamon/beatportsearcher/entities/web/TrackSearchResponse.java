package me.dimamon.beatportsearcher.entities.web;

public class TrackSearchResponse {

    private String streamUrl;
    private String albumUrl;

    private String trackName;
    private String artistName;
    private String albumName;
    private String albumArtUrl;

    public TrackSearchResponse() {
    }

    public TrackSearchResponse(String streamUrl, String albumUrl,
                               String trackName, String artistName,
                               String albumName, String albumArtUrl) {
        this.streamUrl = streamUrl;
        this.albumUrl = albumUrl;
        this.trackName = trackName;
        this.artistName = artistName;
        this.albumName = albumName;
        this.albumArtUrl = albumArtUrl;
    }

    public String getStreamUrl() {
        return streamUrl;
    }

    public String getAlbumUrl() {
        return albumUrl;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getAlbumArtUrl() {
        return albumArtUrl;
    }

    @Override
    public String toString() {
        return "TrackSearchResponse{" +
                "streamUrl='" + streamUrl + '\'' +
                ", albumUrl='" + albumUrl + '\'' +
                ", trackName='" + trackName + '\'' +
                ", artistName='" + artistName + '\'' +
                ", albumName='" + albumName + '\'' +
                ", albumArtUrl='" + albumArtUrl + '\'' +
                '}';
    }
}
