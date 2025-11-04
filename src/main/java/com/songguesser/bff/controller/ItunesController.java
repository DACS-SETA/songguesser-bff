package com.songguesser.bff.controller;

import com.songguesser.bff.service.ItunesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/itunes")
public class ItunesController {

    private final ItunesService itunesService;

    public ItunesController(ItunesService itunesService) {
        this.itunesService = itunesService;
    }

    @GetMapping("/search")
    public ResponseEntity<String> searchItunes(@RequestParam String term) {
        log.info("BFF: proxy search to iTunes for term={}", term);
        String results = itunesService.searchSongs(term);
        return ResponseEntity.ok(results);
    }
}
