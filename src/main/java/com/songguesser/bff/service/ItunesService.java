package com.songguesser.bff.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Slf4j
@Service
public class ItunesService {

    private final RestTemplate restTemplate;

    public ItunesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String searchSongs(String term) {
        try {
            String encoded = URLEncoder.encode(term, StandardCharsets.UTF_8.toString());
            String url = "https://itunes.apple.com/search?term=" + encoded + "&entity=song&limit=10";
            log.info("Llamando a iTunes API: {}", url);
            String response = restTemplate.getForObject(url, String.class);
            return response;
        } catch (Exception e) {
            log.error("Error al buscar en iTunes", e);
            return "{\"resultCount\":0, \"results\":[]}";
        }
    }
}
