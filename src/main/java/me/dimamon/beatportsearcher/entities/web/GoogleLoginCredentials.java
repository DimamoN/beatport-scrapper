package me.dimamon.beatportsearcher.entities.web;

public class GoogleLoginCredentials {

    private String username;
    private String password;
    private String androidId;

    public GoogleLoginCredentials() {
    }

    public GoogleLoginCredentials(String username, String password, String androidId) {
        this.username = username;
        this.password = password;
        this.androidId = androidId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }

    @Override
    public String toString() {
        return "GoogleLoginCredentials{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", androidId='" + androidId + '\'' +
                '}';
    }
}
