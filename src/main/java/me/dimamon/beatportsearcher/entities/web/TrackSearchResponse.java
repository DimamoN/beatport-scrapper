package me.dimamon.beatportsearcher.entities.web;

public class TrackSearchResponse {

    private String streamUrl;
    private String albumUrl;

    private String trackName;
    private String artistName;
    private String albumName;

    public TrackSearchResponse() {
    }

    public TrackSearchResponse(String streamUrl, String albumUrl,
                               String trackName, String albumName, String artistName) {
        this.streamUrl = streamUrl;
        this.albumUrl = albumUrl;
        this.trackName = trackName;
        this.albumName = albumName;
        this.artistName = artistName;
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

    @Override
    public String toString() {
        return "TrackSearchResponse{" +
                "streamUrl='" + streamUrl + '\'' +
                ", albumUrl='" + albumUrl + '\'' +
                ", trackName='" + trackName + '\'' +
                ", albumName='" + albumName + '\'' +
                ", artistName='" + artistName + '\'' +
                '}';
    }
}
