package com.songguesser.bff.controller;

import com.songguesser.bff.dto.SongDto;
import com.songguesser.bff.service.ApiBackendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/songs")
public class SongsController {

    private final ApiBackendService backendService;

    public SongsController(ApiBackendService backendService) {
        this.backendService = backendService;
    }

    @GetMapping("/random")
    public SongDto getRandomSong() {
        log.info("→ BFF solicitando canción random al backend...");
        return backendService.getRandomSong();
    }
}
