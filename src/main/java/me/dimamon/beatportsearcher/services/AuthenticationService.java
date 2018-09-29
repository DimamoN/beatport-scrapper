package me.dimamon.beatportsearcher.services;

import com.github.felixgail.gplaymusic.api.GPlayMusic;

public interface AuthenticationService {

    void loginGoogleMusic(final String username, final String password, final String androidId);

    GPlayMusic getApi();

}
