package com.songguesser.bff.api.client;

import com.songguesser.bff.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(
    name = "apiBackendClient",
    url = "${feign.client.config.apiBackendClient.url}"
)
public interface ApiBackendClient {

    @GetMapping("/ping")
    String ping();

    @GetMapping("/version")
    BuildInfoDTO version();

    @GetMapping("/songs/random")
    SongDto getRandomSong();

    // ------------------------------
    // 🎮 Game management
    // ------------------------------

    @PostMapping("/games/start")
    GameStartResponseDto startNewGame();

    @PostMapping("/games/{gameId}/round")
    RoundResponseDto addRound(@PathVariable("gameId") Long gameId, @RequestBody(required = false) GuessDto guess);

    @PostMapping("/games/{gameId}/surrender")
    Optional<GameSummaryDto> surrender(@PathVariable("gameId") Long gameId);

    @GetMapping("/games/{gameId}/summary")
    Optional<GameSummaryDto> getSummary(@PathVariable("gameId") Long gameId);
}
