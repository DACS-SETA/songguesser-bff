package com.songguesser.bff.service;

import com.songguesser.bff.dto.*;

import java.util.Optional;

public interface ApiBackendService {

    String ping();

    SongDto getRandomSong();

    GameStartResponseDto startGame();

    RoundResponseDto addRound(Long gameId);

    void surrender(Long gameId);

    Optional<GameSummaryDto> getSummary(Long gameId);
}
