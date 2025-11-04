package com.songguesser.bff.controller;

import com.songguesser.bff.dto.SongDto;
import com.songguesser.bff.service.ApiBackendService;
import com.songguesser.bff.service.ItunesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/songs")
public class SongsController {

    private final ApiBackendService backendService;
    private final ItunesService itunesService;

    public SongsController(ApiBackendService backendService, ItunesService itunesService) {
        this.backendService = backendService;
        this.itunesService = itunesService;
    }

    @GetMapping("/random")
    public SongDto getRandomSong() {
        log.info("→ BFF solicitando canción random al backend...");
        return backendService.getRandomSong();
    }

    @GetMapping(value = "/search", produces = "application/json")
    public String search(@RequestParam("term") String term) {
        log.info("→ BFF buscando canciones en iTunes para term={}", term);
        return itunesService.searchSongs(term);
    }
}
