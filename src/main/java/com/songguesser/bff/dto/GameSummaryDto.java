package com.songguesser.bff.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class GameSummaryDto {
    private Long gameId;
    private int totalRounds;
    private int correctRounds;
    private int totalScore;
    private List<RoundSummaryDto> rounds;
}
