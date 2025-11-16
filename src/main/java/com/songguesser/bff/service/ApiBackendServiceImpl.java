package com.songguesser.bff.service;


import com.songguesser.bff.api.client.ApiBackendClient;
import com.songguesser.bff.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApiBackendServiceImpl implements ApiBackendService {

    @Autowired
    private ApiBackendClient apiBackendClient;

    @Override
    public String ping() {
        return apiBackendClient.ping();
    }

    @Override
    public SongDto getRandomSong() {
        return apiBackendClient.getRandomSong();
    }

    @Override
    public GameStartResponseDto startGame(String keycloakId) {
        return apiBackendClient.startNewGame(keycloakId);
    }


    @Override
    public RoundResponseDto addRound(Long gameId, GuessDto guess) {
        return apiBackendClient.addRound(gameId, guess);
    }

    @Override
    public Optional<GameSummaryDto> surrender(Long gameId) {
        return apiBackendClient.surrender(gameId);
    }

    @Override
    public Optional<GameSummaryDto> getSummary(Long gameId) {
        return apiBackendClient.getSummary(gameId);
    }
    
    public List<UserRankingDto> getRanking() {
        return apiBackendClient.getRanking();
    }
}
