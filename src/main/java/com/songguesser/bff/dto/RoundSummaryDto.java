package com.songguesser.bff.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoundSummaryDto {
    private String songName;
    private boolean correct;
    private int scoreObtained;
}