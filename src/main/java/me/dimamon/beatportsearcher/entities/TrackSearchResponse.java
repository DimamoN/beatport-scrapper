package me.dimamon.beatportsearcher.entities;

public class TrackSearchResponse {

    private String streamUrl;
    private String albumUrl;
    private String trackName;
    private String albumName;

    public TrackSearchResponse() {
    }

    public TrackSearchResponse(String streamUrl, String albumUrl, String trackName, String albumName) {
        this.streamUrl = streamUrl;
        this.albumUrl = albumUrl;
        this.trackName = trackName;
        this.albumName = albumName;
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

    @Override
    public String toString() {
        return "TrackSearchResponse{" +
                "streamUrl='" + streamUrl + '\'' +
                ", albumUrl='" + albumUrl + '\'' +
                ", trackName='" + trackName + '\'' +
                ", albumName='" + albumName + '\'' +
                '}';
    }
}
