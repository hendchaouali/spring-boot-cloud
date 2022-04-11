package com.playlist.songs.client;

import com.playlist.songs.model.Details;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class DetailsClient {

    private RestTemplate restTemplate;

    public DetailsClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Details getDetailBySongId(@PathVariable Long id) {
        return restTemplate.getForObject("http://details/details/"+id, Details.class);
    }
}
