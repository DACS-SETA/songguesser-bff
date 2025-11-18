package com.songguesser.bff.service;

import com.songguesser.bff.dto.*;

import java.util.List;
import java.util.Optional;

public interface ApiBackendService {

    String ping();

    SongDto getRandomSong();

    GameStartResponseDto startGame(String keycloakId); 

    RoundResponseDto addRound(Long gameId, GuessDto guess);

    Optional<GameSummaryDto> surrender(Long gameId);

    Optional<GameSummaryDto> getSummary(Long gameId);

        Optional<GameSummaryDto> finish(Long gameId);

    List<UserRankingDto> getRanking();

    UserProfileDto getUserProfile(String keycloakId);

    void updateProfile(String keycloakId, UpdateProfileDto dto);
}
