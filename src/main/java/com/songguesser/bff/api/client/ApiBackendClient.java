package com.songguesser.bff.api.client;

import com.songguesser.bff.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(
    name = "apiBackendClient",
    url = "${feign.client.config.apiBackendClient.url}"
)
public interface ApiBackendClient {

	// Check end points
	
    @GetMapping("/ping")
    String ping();

    @GetMapping("/version")
    BuildInfoDTO version();

    @GetMapping("/songs/random")
    SongDto getRandomSong();

    // Game end points
    
    @PostMapping("/games/start")
    GameStartResponseDto startNewGame(@RequestParam("keycloakId") String keycloakId);


    @PostMapping("/games/{gameId}/round")
    RoundResponseDto addRound(@PathVariable("gameId") Long gameId, @RequestBody(required = false) GuessDto guess);

    @PostMapping("/games/{gameId}/surrender")
    Optional<GameSummaryDto> surrender(@PathVariable("gameId") Long gameId);

    @GetMapping("/games/{gameId}/summary")
    Optional<GameSummaryDto> getSummary(@PathVariable("gameId") Long gameId);
    
    
    // User end points
    
    @PostMapping("/users/sync")
    void syncUser(@RequestBody UserDto userDto);

    @GetMapping("/users/ranking")
    List<UserRankingDto> getRanking();


    
    
}

