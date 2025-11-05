package com.songguesser.bff.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GuessDto {
    private String guess;
    private Integer time;
}
