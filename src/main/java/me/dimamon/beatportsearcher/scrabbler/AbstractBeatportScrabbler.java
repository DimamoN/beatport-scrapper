package me.dimamon.beatportsearcher.scrabbler;

import org.springframework.web.client.RestTemplate;

class AbstractBeatportScrabbler {

    protected static final String BASE_URL = "https://www.beatport.com/";
    protected static RestTemplate rest = new RestTemplate();

}
