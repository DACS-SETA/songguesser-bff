package com.songguesser.bff.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoundResponseDto {
    private Long roundId;
    private SongDto song;
}