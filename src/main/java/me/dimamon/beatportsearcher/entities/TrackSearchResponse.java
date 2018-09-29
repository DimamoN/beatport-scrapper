package me.dimamon.beatportsearcher.entities;

public class TrackSearchResponse {

    private String streamUrl;
    private String albumUrl;

    public TrackSearchResponse() {
    }

    public TrackSearchResponse(String streamUrl, String albumUrl) {
        this.streamUrl = streamUrl;
        this.albumUrl = albumUrl;
    }

    public String getStreamUrl() {
        return streamUrl;
    }

    public void setStreamUrl(String streamUrl) {
        this.streamUrl = streamUrl;
    }

    public String getAlbumUrl() {
        return albumUrl;
    }

    public void setAlbumUrl(String albumUrl) {
        this.albumUrl = albumUrl;
    }

    @Override
    public String toString() {
        return "TrackSearchResponse{" +
                "streamUrl='" + streamUrl + '\'' +
                ", albumUrl='" + albumUrl + '\'' +
                '}';
    }
}
