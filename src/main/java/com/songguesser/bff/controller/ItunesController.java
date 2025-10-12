package com.songguesser.bff.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.songguesser.bff.dto.SongDto;
import com.songguesser.bff.service.ApiConectorService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/itunes")
public class ItunesController {

    private final ApiConectorService apiConectorService;

    public ItunesController(ApiConectorService apiConectorService) {
        this.apiConectorService = apiConectorService;
    }

    @GetMapping("/random")
    public SongDto random() {
        log.info("Obteniendo canción aleatoria desde conector");
        return apiConectorService.getRandomSong();
    }

    @GetMapping("/artist/{artist}")
    public List<SongDto> byArtist(@PathVariable String artist) {
        log.info("Obteniendo canciones por artista {}", artist);
        return apiConectorService.getSongsByArtist(artist);
    }

    @GetMapping("/genre/{genre}")
    public SongDto randomByGenre(@PathVariable String genre) {
        log.info("Obteniendo canción aleatoria por género {}", genre);
        return apiConectorService.getRandomByGenre(genre);
    }

    @GetMapping("/search")
    public List<SongDto> searchSongs(@RequestParam("term") String term) {
        log.info("Buscando canciones en iTunes con term='{}'", term);
        return apiConectorService.searchSongs(term);
    }
}
