package me.dimamon.beatportsearcher.controllers;

import me.dimamon.beatportsearcher.entities.web.GoogleLoginCredentials;
import me.dimamon.beatportsearcher.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/login")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping
    ResponseEntity login(@RequestBody GoogleLoginCredentials credentials) {

        //todo: improve
        String username = credentials.getUsername();
        String password = credentials.getPassword();
        String androidId = credentials.getAndroidId();

        authenticationService.loginGoogleMusic(username, password, androidId);
        return ResponseEntity.ok().body(null);
    }
}
