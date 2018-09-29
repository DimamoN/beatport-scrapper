package me.dimamon.beatportsearcher.services;

import com.github.felixgail.gplaymusic.api.GPlayMusic;
import com.github.felixgail.gplaymusic.util.TokenProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import svarzee.gps.gpsoauth.AuthToken;
import svarzee.gps.gpsoauth.Gpsoauth;

import java.io.IOException;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    //todo make private
    public AuthToken token;

    @Override
    public void loginGoogleMusic(final String username, final String password, final String androidId) {

        log.debug("Login to Google Music: username: {}, androidId: {}", username, androidId);

        try {
            token = TokenProvider.provideToken(username, password, androidId);
            log.debug("Login successful for user: {}", username);
        } catch (IOException e) {
            log.error("IO error while getting GoogleMusic token for user: {}", username);
            e.printStackTrace();
        } catch (Gpsoauth.TokenRequestFailed tokenRequestFailed) {
            log.error("Token request failed: for user: {}, message: {}",
                    username, tokenRequestFailed.getMessage());
            tokenRequestFailed.printStackTrace();
        }
    }

    @Override
    public GPlayMusic getApi() {
        if (token == null) {
            throw new RuntimeException("Authentication to Google Music is needed! Use /login");
        }
        return new GPlayMusic.Builder()
                .setAuthToken(token)
                .build();
    }

}
