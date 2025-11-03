package com.songguesser.bff.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameStartResponseDto {
    private Long gameId;
    private Long roundId;
    private SongDto song;
}