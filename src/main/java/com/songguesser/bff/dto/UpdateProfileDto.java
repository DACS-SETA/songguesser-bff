package com.songguesser.bff.dto;

import lombok.Data;

@Data
public class UpdateProfileDto {
    private String username;
    private String avatarUrl;
}