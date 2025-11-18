package com.songguesser.bff.controller;

import com.songguesser.bff.api.client.ApiBackendClient;
import com.songguesser.bff.dto.GameStartResponseDto;
import com.songguesser.bff.dto.RoundResponseDto;
import com.songguesser.bff.util.JwtUtils;
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
    public GameStartResponseDto startNewGame(@RequestHeader("Authorization") String authHeader, @RequestParam(required = false) String language) {
        String token = authHeader.replace("Bearer ", "");
        String keycloakId = JwtUtils.extractSub(token); 
        log.info("→ Creando partida para usuario {} con idioma {}", keycloakId, language);
        return backendClient.startNewGame(keycloakId, language);
    }


    // ------------------------------
    // ➕ Add new round
    // ------------------------------
    @PostMapping("/{gameId}/round")
    public RoundResponseDto addRound(@PathVariable Long gameId, @RequestBody(required = false) GuessDto guess, @RequestParam(required = false) String language) {
        if (guess != null && guess.getGuess() != null && !guess.getGuess().isBlank()) {
            log.info("→ BFF procesando respuesta para partida {}: {} con idioma {}", gameId, guess.getGuess(), language);
            return backendClient.addRound(gameId, guess, language);
        } else {
            log.info("→ BFF agregando ronda a partida {} con idioma {}", gameId, language);
            return backendClient.addRound(gameId, new GuessDto(), language);
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

        // ------------------------------
        // 🏁 Finish game
        // ------------------------------
        @PostMapping("/{gameId}/finish")
        public Optional<GameSummaryDto> finish(@PathVariable Long gameId) {
            log.info("→ BFF finalizando partida {}", gameId);
            return backendClient.finish(gameId);
        }
}
