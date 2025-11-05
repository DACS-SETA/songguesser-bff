package com.songguesser.bff.controller;

import com.songguesser.bff.api.client.ApiBackendClient;
import com.songguesser.bff.dto.GameStartResponseDto;
import com.songguesser.bff.dto.RoundResponseDto;
import com.songguesser.bff.dto.GameSummaryDto;
import com.songguesser.bff.dto.GuessDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/games")
public class GameController {

    private final ApiBackendClient backendClient;

    public GameController(ApiBackendClient backendClient) {
        this.backendClient = backendClient;
    }

    // ------------------------------
    // 🎮 Start new game
    // ------------------------------
    @PostMapping("/start")
    public GameStartResponseDto startNewGame() {
        log.info("→ BFF solicitando creación de partida al backend...");
        return backendClient.startNewGame();
    }

    // ------------------------------
    // ➕ Add new round
    // ------------------------------
    @PostMapping("/{gameId}/round")
    public RoundResponseDto addRound(@PathVariable Long gameId, @RequestBody(required = false) GuessDto guess) {
        if (guess != null && guess.getGuess() != null && !guess.getGuess().isBlank()) {
            log.info("→ BFF procesando respuesta para partida {}: {}", gameId, guess.getGuess());
            return backendClient.addRound(gameId, guess);
        } else {
            log.info("→ BFF agregando ronda a partida {}", gameId);
            return backendClient.addRound(gameId, new GuessDto());
        }
    }

    // ------------------------------
    // 🏳️ Surrender game
    // ------------------------------
    @PostMapping("/{gameId}/surrender")
    public Optional<GameSummaryDto> surrender(@PathVariable Long gameId) {
        log.info("→ BFF marcando partida {} como rendida", gameId);
        return backendClient.surrender(gameId);
    }

    // ------------------------------
    // 📊 Get game summary
    // ------------------------------
    @GetMapping("/{gameId}/summary")
    public Optional<GameSummaryDto> getSummary(@PathVariable Long gameId) {
        log.info("→ BFF obteniendo resumen de partida {}", gameId);
        return backendClient.getSummary(gameId);
    }
}
