package me.dimamon.beatportsearcher.services;

import com.github.felixgail.gplaymusic.api.GPlayMusic;
import com.github.felixgail.gplaymusic.util.TokenProvider;
import org.springframework.stereotype.Service;
import svarzee.gps.gpsoauth.AuthToken;
import svarzee.gps.gpsoauth.Gpsoauth;

import java.io.IOException;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    public AuthToken token;

    @Override
    public void loginGoogleMusic(final String username, final String password, final String androidId) {

        System.out.printf("Login to GOOGLE MUSIC: username: %s, androidId %s \n", username, androidId);

        try {
            token = TokenProvider.provideToken(username, password, androidId);
            System.out.printf("Login successful for user %s \n", username);

        } catch (IOException e) {
            System.err.println("IO error while getting GoogleMusic token");
            e.printStackTrace();
        } catch (Gpsoauth.TokenRequestFailed tokenRequestFailed) {
            System.err.println("Token request failed: " + tokenRequestFailed.getMessage());
            tokenRequestFailed.printStackTrace();
        }
    }

    @Override
    public GPlayMusic getApi() {
        return new GPlayMusic.Builder()
                .setAuthToken(token)
                .build();
    }

}
