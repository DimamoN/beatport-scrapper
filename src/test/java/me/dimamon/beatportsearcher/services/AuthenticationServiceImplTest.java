package me.dimamon.beatportsearcher.services;

import com.github.felixgail.gplaymusic.api.GPlayMusic;
import com.github.felixgail.gplaymusic.model.enums.ResultType;
import com.github.felixgail.gplaymusic.model.requests.SearchTypes;
import com.github.felixgail.gplaymusic.model.responses.SearchResponse;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;

import static org.junit.Assert.assertNotNull;

public class AuthenticationServiceImplTest {

    private String username = "";
    private String password = "";
    private String androidId = "";

    @Ignore
    @Test
    public void loginGoogleMusic() {
        // login
        AuthenticationServiceImpl service = new AuthenticationServiceImpl();
        service.loginGoogleMusic(username, password, androidId);
        assertNotNull(service.token);
        GPlayMusic api = new GPlayMusic.Builder()
                .setAuthToken(service.token)
                .build();
    }

    @Ignore
    @Test
    public void searchTrack() throws IOException {
        // login
        AuthenticationServiceImpl service = new AuthenticationServiceImpl();
        service.loginGoogleMusic(username, password, androidId);
        assertNotNull(service.token);
        GPlayMusic api = new GPlayMusic.Builder()
                .setAuthToken(service.token)
                .build();

        SearchTypes searchTypes = new SearchTypes();
        searchTypes.setTypes(Collections.singletonList(ResultType.TRACK));
        SearchResponse result = api.search("right here", searchTypes);

        System.out.println("Tracks found: " + result.getTracks().size());
    }
}